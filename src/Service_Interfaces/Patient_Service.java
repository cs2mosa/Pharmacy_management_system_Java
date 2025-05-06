package Service_Interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import Class_model.Patient;
import Class_model.Pharmacist;
import Class_model.Prescription;
import Class_model.Item;
import Class_model.Order;

/**
 * This interface defines the contract for patient-related services.
 * It provides methods to add, remove, update, and retrieve patient information,
 * as well as manage patient balances and orders.
 */
abstract interface PatientServiceInterface {

    /**
     * Adds a new patient to the system.
     * @param patient The patient object to be added.
     * @return integer number represnets Patient id, -1 else
     */
    int AddPatient(Patient patient);

    /**
     * Removes a patient from the system by their name.
     * @param Patientname The name of the patient to be removed.
     */
    void RemovePatient(String Patientname);

    /**
     * Authenticate, then Update a specific attribute of a patient, can change Password too.
     * @param PatientName The name of the patient to be updated.
     * @param query The attribute to be updated.
     * @param value The new value for the specified attribute.
     * @param Password The password of the patient to be updated.
     * @return status code of 0 on success , and -1 else.
     */
    int UpdatePatient(String PatientName,String Password, String query, Object value);

    /**
     * Retrieves a patient by their name.
     * @param Patientname The name of the patient to retrieve.
     * @return The patient object corresponding to the given name.
     */
    Patient GetPatient(String Patientname);

    /**
     * Retrieves a list of all patients in the system.
     * @return A list of all patient objects.
     */
    List<Patient> GetAllPatients();

    /**
     * Retrieves the balance of a specific patient.
     * @param PatientName The name of the patient whose balance is to be retrieved.
     * @return The balance of the specified patient.
     */
    double GetPatientBalance(String PatientName);

    /**
     * Retrieves a list of orders associated with a specific patient.
     * @param PatientId The ID of the patient whose orders are to be retrieved.
     * @return A list of orders for the specified patient.
     */
    List<Order> GetPatientOrders(int PatientId);

    /**
     * Places an order with the specified items.
     * 
     * @param items A map where the key is the item name and the value is the quantity.
     * @return The ID of the placed order if placed correctly, -1 else.
     */
    int PlaceOrder(Map<String, Integer> items, int PatientId, Pharmacist pharmacist);

    /**
     * Authenticates a patient based on their username and password.
     * @param PatientName  The username of the patient to authenticate.
     * @param Password The password of the patient to authenticate.
     * @return true if authentication is successful, false otherwise.
     */
    boolean AuthenticatePatient(String PatientName, String Password);

    /**
     * Places an order based on a prescription.
     * @param PatientId The ID of the patient placing the order.
     * @param PreID The ID of the prescription.
     * @return The ID of the placed order if placed correctly, -1 else.
     */
    int PlaceOrderByPrescription(int PatientId, int PreID);
}

public class Patient_Service implements PatientServiceInterface {

    /**
     * singleton design for less memory usage, only 1 object is needed.
    */
    private static Patient_Service instance;

    private Patient_Service() {
        // private constructor to prevent instantiation
    }

    public static synchronized Patient_Service getInstance() {
        if (instance == null) {
            instance = new Patient_Service();
        }
        return instance;
    }

    @Override
    public int AddPatient(Patient patient) {
        // Implementation for adding a patient
        return Patient_Repository.getInstance().AddPatient(patient);
    }

    @Override
    public void RemovePatient(String Patientname) {
        // Implementation for removing a patient
        Patient_Repository.getInstance().RemovePatient(GetPatient(Patientname).getID());
    }

    @Override
    public Patient GetPatient(String Patientname) {
        // Implementation for retrieving a patient
        Set<Patient> temp = Patient_Repository.getInstance().GetAllPatients();
        Iterator<Patient> value = temp.iterator();
        while(value.hasNext()){
            Patient temppPatient = (Patient)value.next();
            if(temppPatient.getUsername() == Patientname ){
                return temppPatient;
            }
        }
        return null; 
    }
    @Override
    public List<Patient> GetAllPatients() {
        // Implementation for retrieving all patients
        return new ArrayList<>(Patient_Repository.getInstance().GetAllPatients()); 
    }

    @Override
    public double GetPatientBalance(String PatientName) {
        // Implementation for retrieving a patient's balance
        return GetPatient(PatientName).GetBalance(); // Placeholder return value
    }

    @Override
    public List<Order> GetPatientOrders(int PatientId) {
        // Implementation for retrieving a patient's orders
        return Patient_Repository.getInstance().GetPatient(PatientId).getOrders();
    }

    @Override
    public int UpdatePatient(String PatientName,String Password, String query, Object value) {
        // Implementation for updating a patient
        Patient temp =  GetPatient(PatientName);
        if(temp == null){
            return -1;
        }
        if(!AuthenticatePatient(PatientName, Password)){
            return -1;
        }
        switch (query) {
            case "age":
                if(value instanceof Float){
                    temp.setAge((Float)value);
                }
                break;
            case "address":
                if(value instanceof String){
                    temp.setAddress((String)value);
                }
                break;
            case "PatientBalance":
                if(value instanceof Double){
                    temp.SetBalance((Double)value);
                }
                break;

            case "Password":
                if(value instanceof String){
                    temp.setPassword(query);
                }
                break;
            
            default:
                return -1;
        }
        Patient_Repository.getInstance().UpdatePatient(temp.getID(), temp);
        return 0;
    }

    @Override
    public boolean AuthenticatePatient(String PatientName, String Password){
        //implementation  here.
        return GetPatient(PatientName).getPassword().equals(Password);
    }

    @Override
    public int PlaceOrderByPrescription(int PatientId, int PreID){
        //implementation here.
        Prescription temp1 = Prescription_Service.getInstance().getPreById(PreID);
        Patient temp2 = Patient_Repository.getInstance().GetPatient(PatientId);
        if(temp1 != null && temp2 != null){
            Order order = new Order.builder()
                            .setOrderItems(new ArrayList<>(temp1.getItems()))
                            .setOrderId(new Random().nextInt(50000))
                            .setStatus("Pending")
                            .build();
            if(Order_Repository.getInstance().AddOrder(PatientId, order) > 0){
                temp2.Add_order(order);
            }
            return order.getOrderId();
        }
        return -1;
    }

    @Override
    public int PlaceOrder(Map<String, Integer> items, int PatientId, Pharmacist pharmacist){
        Iterator <Map.Entry<String,Integer>> it = items.entrySet().iterator();
        List<Item> tempitems = new ArrayList<>();
        while(it.hasNext()){
            Map.Entry<String,Integer> temp = it.next();
            Item tempitem = Inventory_service.getInstance().GetItemByName(temp.getKey());
            if(tempitem == null)
                return -1;
            if(tempitem.getQuantity() < temp.getValue())
                return -1;
            if(pharmacist.is_safe(tempitem, Patient_Repository.getInstance().GetPatient(PatientId)))
                tempitems.add(tempitem);
        }
        Order order =new Order.builder()
                              .setOrderId(new Random().nextInt(50000))
                              .setStatus("Pending")
                              .setOrderItems(tempitems)
                              .build();

        if(Order_Repository.getInstance().AddOrder(PatientId, order) > 0){
            Patient_Repository.getInstance().GetPatient(PatientId).Add_order(order);
            Prescription_Service.getInstance().IssuePrescription(pharmacist,PatientId,new Random().nextInt(50000));
        }
        return order.getOrderId();
    }
}