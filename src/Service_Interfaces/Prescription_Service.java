package Service_Interfaces;

import java.util.List;

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
     */
    void AddPrescription(int UserId, Prescription prescription);

    /**
     * Deletes a prescription from the system based on its ID.
     * 
     * @param preID The ID of the prescription to be deleted.
     */
    void DeletePrescription(int preID);

    /**
     * Updates a specific field of a prescription identified by its ID.
     * 
     * @param PreID The ID of the prescription to be updated.
     * @param query The name of the field to be updated.
     * @param value The new value to be set for the specified field.
     */
    void UpdatePrescription(int PreID, String query, Object value);

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
     */
    void FillPrescription(int preID);

    /**
     * Issues a prescription to a patient, associating it with a pharmacist.
     * @param pharmacist The pharmacist who is issuing the prescription.
     * @param patientId The ID of the patient to whom the prescription is issued.
     * @param PreID The ID of the prescription being issued.
     * @return The ID of the issued prescription.
     */
    int IssuePrescription(Pharmacist pharmacist, int patientId , int PreID);

    /**
     * Retrieves a prescription by its unique ID.
     * @param preID
     * @return
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
    public void AddPrescription(int UserId, Prescription prescription) {
        // Implementation for adding a prescription
        
    }

    @Override
    public void DeletePrescription(int preID) {
        // Implementation for deleting a prescription
    }

    @Override
    public void UpdatePrescription(int PreID, String query, Object value) {
        // Implementation for updating a prescription
    }
    
    @Override
    public List<Prescription> GetPrescriptionByName(String patientName) {
        // Implementation for retrieving prescriptions by patient ID
        return null;
    }

    @Override
    public List<Prescription> GetAllPrescriptions() {
        // Implementation for retrieving all prescriptions
        return null;
    }

    @Override
    public void FillPrescription(int preID) {
        // Implementation for filling a prescription
    }

    @Override
    public int IssuePrescription(Pharmacist pharmacist, int patientId , int PreID){
        //implementation 
        return 0;
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