package Service_Interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Class_model.*;

/**
 * PrescriptionRepository is an interface that defines the contract for managing prescriptions.
 * It provides methods to add, delete, and retrieve prescriptions based on specific criteria.
 */
abstract interface PrescriptionRepository {

    /**
     * Adds a new prescription to the repository.
     * @param prescription The Prescription object to be added.
     */
    void Add(Prescription prescription);

    /**
     * Deletes a prescription from the repository based on its unique ID.
     * @param ID The unique identifier of the prescription to be deleted.
     */
    void Delete(int ID);

    /**
     * Finds and retrieves a list of prescriptions associated with a specific patient's name.
     * @param patientName The name of the patient whose prescriptions are to be retrieved.
     * @return A list of prescriptions matching the given patient name.
     */
    List<Prescription> findByPatientName(String patientName);

    /**
     * Retrieves all prescriptions from the repository.
     * @return A list of all prescriptions.
     */
    List<Prescription> findAll();
}
public class Prescription_Repository implements PrescriptionRepository {
    
    //Map to store payments:-> Integer : UserId.
    private Map<Integer, List<Prescription>> prescriptions = new HashMap<>();

    // Singleton instance of Prescription_Repository
    private static Prescription_Repository instance = null;

    private Prescription_Repository(){
       // Private constructor to prevent instantiation from outside.
    }

    public static Prescription_Repository GetInstance(){
        if (instance == null) {
            instance = new Prescription_Repository();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    @Override
    public void Add(Prescription prescription) {
        // Implementation for adding a prescription
    }
    @Override
    public void Delete(int ID) {
        // Implementation for deleting a prescription
    }
    @Override
    public List<Prescription> findByPatientName(String patientName) {
        // Implementation for finding prescriptions by patient name
        return null;
    }
    @Override
    public List<Prescription> findAll() {
        // Implementation for finding all prescriptions
        return null;
    }
}