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
     * 
     * @param prescription The Prescription object to be added.
     */
    void AddPrescription(Prescription prescription);

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
    List<Prescription> GetPrescriptionByID(int PatientId);

    /**
     * Retrieves a list of all prescriptions in the system.
     * 
     * @return A list of all Prescription objects.
     */
    List<Prescription> GetAllPrescriptions();

    /**
     * Fills a prescription, marking it as completed or dispensed.
     */
    void FillPrescription();
}

public class Prescription_ServiceInterface implements PrescriptionServiceInterface {

    @Override
    public void AddPrescription(Prescription prescription) {
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
    public List<Prescription> GetPrescriptionByID(int PatientId) {
        // Implementation for retrieving prescriptions by patient ID
        return null;
    }

    @Override
    public List<Prescription> GetAllPrescriptions() {
        // Implementation for retrieving all prescriptions
        return null;
    }

    @Override
    public void FillPrescription() {
        // Implementation for filling a prescription
    }

}