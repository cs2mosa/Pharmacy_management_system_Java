package Service_Interfaces;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Class_model.Patient;

/**
 * The PatientRepository interface defines the contract for managing patient records.
 * It provides methods to add, remove, update, retrieve, and list patients.
 */
abstract interface PatientRepository {

    /**
     * Adds a new patient to the repository.
     * @param patient The Patient object to be added.
     */
    void AddPatient(Patient patient);

    /**
     * Removes a patient from the repository based on their unique ID.
     * @param PatientID The unique identifier of the patient to be removed.
     */
    void RemovePatient(int PatientID);

    /**
     * Updates a specific attribute of a patient in the repository.
     * @param PatientID The unique identifier of the patient to be updated.
     * @param query The name of the attribute to be updated.
     * @param value The new value to set for the specified attribute.
     */
    void UpdatePatient(int PatientID, String query, Object value);

    /**
     * Retrieves a patient from the repository based on their unique ID.
     * @param PatientID The unique identifier of the patient to retrieve.
     * @return The Patient object corresponding to the given ID, or null if not found.
     */
    Patient GetPatient(int PatientID);

    /**
     * Retrieves a list of all patients in the repository.
     * @return A List containing all Patient objects in the repository.
     */
    List<Patient> GetAllPatients();
}
public class Patient_Repository implements PatientRepository {
    // Singleton instance of Patient_Repository
    private static Patient_Repository instance = null;
    // Set to store patients
    private Set<Patient> patients = new HashSet<>(); // Using Set for better search complexity

    // Private constructor to prevent instantiation from outside
    private Patient_Repository() {

    }

    // Method to get the singleton instance of Patient_Repository
    public static Patient_Repository getInstance() {
        if (instance == null) {
            instance = new Patient_Repository();
        }
        return instance;
    }

    @Override
    public void AddPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void RemovePatient(int PatientID) {
        
    }
    @Override
    public void UpdatePatient(int PatientID, String query, Object value) {
        
    }
    @Override
    public Patient GetPatient(int PatientID) {
        //implementation for getting a patient by ID
        return null; // Return null if not found
    }
    @Override
    public List<Patient> GetAllPatients() {
        // Convert the Set to a List and return it
        return null;
    }
    
}