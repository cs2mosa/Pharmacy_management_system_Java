package Service_Interfaces;

import java.util.List;
import Class_model.Patient;
import Class_model.Order;

/**
 * This interface defines the contract for patient-related services.
 * It provides methods to add, remove, update, and retrieve patient information,
 * as well as manage patient balances and orders.
 */
public abstract interface PatientServiceInterface {

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