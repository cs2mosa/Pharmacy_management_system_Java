package Service_Interfaces;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import Class_model.Patient;

/**
 * The PatientRepository interface defines the contract for managing patient records.
 * It provides methods to add, remove, update, retrieve, Get, and list patients.
 */
abstract interface PatientRepository {

    /**
     * Adds a new patient to the repository.
     * @param patient The Patient object to be added.
     */
    int AddPatient(Patient patient);

    /**
     * Removes a patient from the repository based on their unique ID.
     * @param PatientID The unique identifier of the patient to be removed.
     */
    void RemovePatient(int PatientID);

    /**
     * Updates a specific attribute of a patient in the repository.
     * @param PatientID The unique identifier of the patient to be updated.
     * @param Newpatient The patient to update.
     * @return The status of the update operation. -1 if failed, 0 if successful.
     */
    int UpdatePatient(int PatientID, Patient Newpatient);

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
    Set<Patient> GetAllPatients();
}

public class Patient_Repository implements PatientRepository {
    // Singleton instance of Patient_Repository
    private static Patient_Repository instance = null;
    // Set to store patients
    private Set<Patient> PATIENTS; // Using Set for better search complexity

    // Private constructor to prevent instantiation from outside
    private Patient_Repository() {
        PATIENTS = new HashSet<>(); 
    }

    // Method to get the singleton instance of Patient_Repository
    public static Patient_Repository getInstance() {
        if (instance == null) {
            instance = new Patient_Repository();
        }
        return instance;
    }

    @Override
    public int AddPatient(Patient patient) {
        if(!PATIENTS.contains(patient)){
            PATIENTS.add(patient);
            patient.setID(new Random().nextInt(50000)); // Set the ID to the size of the set
            return patient.getID();
        }else{
            return -1;
        }
    }

    @Override
    public void RemovePatient(int PatientID) {
        if(PATIENTS.contains(GetPatient(PatientID)) && GetPatient(PatientID) != null){
            PATIENTS.remove(GetPatient(PatientID));
        }
    }

    @Override
    public int UpdatePatient(int PatientID, Patient Newpatient) {
        RemovePatient(PatientID);
        return AddPatient(Newpatient);
    }

    @Override
    public Patient GetPatient(int PatientID) {
        //implementation for getting a patient by ID
        for(Patient p : PATIENTS){
            if(p.getID() == PatientID){
                return p;
            }
        }
        return null; // Return null if not found
    }
    @Override
    public Set<Patient> GetAllPatients() {
        // Convert the Set to a List and return it.
        return PATIENTS;
    }
    
}