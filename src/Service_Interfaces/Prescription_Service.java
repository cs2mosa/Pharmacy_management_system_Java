package Service_Interfaces;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Class_model.*;

/**
 * This interface defines the contract for managing prescriptions in the system.
 * It provides methods for adding, deleting, updating, retrieving, and filling prescriptions.
 */
abstract interface PrescriptionServiceInterface {

    /**
     * Adds a new prescription to the system.
     * @param UserId The ID of the user associated with the prescription.
     * @param prescription The Prescription object to be added.
     * @return The ID of the added prescription. -1 if the prescription is invalid.
     */
    int AddPrescription(int UserId, Prescription prescription);

    /**
     * Deletes a prescription from the system based on its ID.
     * @param UserId The ID of the user associated with the prescription.
     * @param preID The ID of the prescription to be deleted.
     * @return status code of 0 on success , -1 else.
     */
    int DeletePrescription(int UserId,int preID);

    /**
     * Updates a specific field of a prescription identified by its ID.
     * 
     * @param PreID The ID of the prescription to be updated.
     * @param query The name of the field to be updated, valid queries -> ("status" , "Items").
     * @param value The new value to be set for the specified field.
     * @return The ID of the updated prescription. -1 if the prescription is invalid.
     */
    int UpdatePrescription(int PreID, String query, Object value);

    /**
     * Retrieves a list of prescriptions associated with a specific patient ID.
     * 
     * @param PatientId The ID of the patient whose prescriptions are to be retrieved.
     * @return A list of Prescription objects for the specified patient.
     */
    List<Prescription> GetPrescriptionByName(String patientName);

    /**
     * Retrieves a list of all prescriptions in the system.
     * 
     * @return A list of all Prescription objects.
     */
    List<Prescription> GetAllPrescriptions();

    /**
     * Fills a prescription, marking it as completed or dispensed.
     * @param preID The ID of the prescription to be filled.
     * @return The ID of the filled prescription. -1 if the prescription is invalid.
     */
    int FillPrescription(int preID);

    /**
     * Issues a prescription to a patient, associating it with a pharmacist.
     * @param pharmacist The pharmacist who is issuing the prescription.
     * @param patientId The ID of the patient to whom the prescription is issued.
     * @param PreID The ID of the prescription being issued.
     * @param OrderId The ID of the order associated with the prescription.
     * @return The ID of the issued prescription. -1 else.
     */
    int IssuePrescription(Pharmacist pharmacist, int patientId ,int OrderId);

    /**
     * Retrieves a prescription by its unique ID.
     * @param preID The unique identifier of the prescription to be retrieved.
     * @return The Prescription object corresponding to the given ID, or null if not found.
     */
    public Prescription getPreById(int preID);

    /**
     * Checks the validity of a prescription.
     * @param prescriptionId The ID of the prescription to check.
     * @param pharmacist The pharmacist who is checking the prescription.
     * @return True if the prescription is valid, false otherwise.
     */
    boolean CheckPrescriptionValidity(int prescriptionId, Pharmacist pharmacist);
}

public class Prescription_Service implements PrescriptionServiceInterface {

    /**
     * singleton design for less memory usage, only 1 object is needed.
     */
    private static Prescription_Service instance = null;
    
    private Prescription_Service(){

    }
    public static Prescription_Service getInstance(){
        if(instance == null){
            return new Prescription_Service();
        }
        else{
            return instance;
        }
    }

    @Override
    public Prescription getPreById(int preID){
        //adding more freatures here.
        return Prescription_Repository.GetInstance().getPreById(preID);
    }

    @Override
    public int AddPrescription(int UserId, Prescription prescription) {
        // Implementation for adding a prescription
        return Prescription_Repository.GetInstance().Add(UserId, prescription);
    }

    @Override
    public int DeletePrescription(int UserId, int preID) {
        // Implementation for deleting a prescription
        return Prescription_Repository.GetInstance().Delete(preID, preID);
    }

    @Override
    public int UpdatePrescription(int PreID, String query, Object value) {
        // Implementation for updating a prescription
        Prescription prescription = Prescription_Repository.GetInstance().getPreById(PreID);
        if (prescription == null) return -1; 
        switch (query) {
            case "status":
                if(value instanceof String){
                    prescription.setStatus(query);
                }
                break;
            case "Items":
                if(value instanceof Set<?>) {
                    @SuppressWarnings("unchecked")//suppressing warning as the object will always be a set of items.
                    Set<Item> items = new HashSet<>((Set<Item>) value);
                    prescription.setItems(items);
                }
                break;
            default:
                return -1;
        }
        return prescription.getId(); // Return the ID of the updated prescription
    }
    
    @Override
    public List<Prescription> GetPrescriptionByName(String patientName) {
        // Implementation for retrieving prescriptions by patient ID
        return Prescription_Repository.GetInstance().findByPatientID(Patient_Repository.getInstance().GetPatient(0).getID());
    }

    @Override
    public List<Prescription> GetAllPrescriptions() {
        // Implementation for retrieving all prescriptions
        return Prescription_Repository.GetInstance().findAll();
    }

    @Override
    public int FillPrescription(int preID) {
        // Implementation for filling a prescription
        if(Prescription_Repository.GetInstance().getPreById(preID) == null){
            return -1;
        }
        Prescription_Repository.GetInstance().getPreById(preID).setStatus("Filled");
        return preID; // Return the ID of the filled prescription
    }

    @Override
    public int IssuePrescription(Pharmacist pharmacist, int patientId ,int OrderId){
        //implementation                                      
        @SuppressWarnings("unchecked")
        Set<Item> orderItems = (Set<Item>) Order_Service.getInstance().GetById(OrderId).getOrderItems();
        for(Item item : Order_Service.getInstance().GetById(OrderId).getOrderItems()){
            if(!pharmacist.is_safe(item, Patient_Repository.getInstance().GetPatient(patientId))){
                return -1;
            }
        }
        Prescription prescription = new Prescription(new Random().nextInt(50000),Patient_Repository.getInstance().GetPatient(patientId).getUsername(), pharmacist, orderItems);
        prescription.setStatus("Pending");
        return AddPrescription(patientId,prescription);
    }

    @Override
    public boolean CheckPrescriptionValidity(int prescriptionId, Pharmacist pharmacist) {
        // Implementation for checking prescription validity
        Prescription prescription = Prescription_Repository.GetInstance().getPreById(prescriptionId);
        if (prescription != null) {
            Patient temp = Patient_Service.getInstance().GetPatient(prescription.getPatientName());
            for(Item item : prescription.getItems()) {
                if(!pharmacist.is_safe(item, temp)){
                    return false;
                }
            }
        }
        return true;
    }
}