package Service_Interfaces;

import java.util.List;
import Class_model.Patient;
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
     */
    void AddPatient(Patient patient);

    /**
     * Removes a patient from the system by their name.
     * @param Patientname The name of the patient to be removed.
     */
    void RemovePatient(String Patientname);

    /**
     * Updates a specific attribute of a patient.
     * @param PatientName The name of the patient to be updated.
     * @param query The attribute to be updated.
     * @param value The new value for the specified attribute.
     */
    void UpdatePatient(String PatientName, String query, Object value);

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
}

public class Patient_Service implements PatientServiceInterface {

    @Override
    public void AddPatient(Patient patient) {
        // Implementation for adding a patient
    }
    @Override
    public void RemovePatient(String Patientname) {
        // Implementation for removing a patient
    }
    @Override
    public void UpdatePatient(String PatientName, String query, Object value) {
        // Implementation for updating a patient
    }
    @Override
    public Patient GetPatient(String Patientname) {
        // Implementation for retrieving a patient
        return null; // Placeholder return value
    }
    @Override
    public List<Patient> GetAllPatients() {
        // Implementation for retrieving all patients
        return null; // Placeholder return value
    }
    @Override
    public double GetPatientBalance(String PatientName) {
        // Implementation for retrieving a patient's balance
        return 0.0; // Placeholder return value
    }
    @Override
    public List<Order> GetPatientOrders(int PatientId) {
        // Implementation for retrieving a patient's orders
        return null; // Placeholder return value
    }
    // Additional methods and logic can be added here as needed
    // For example, you might want to implement methods for managing patient prescriptions or other related functionalities.
}