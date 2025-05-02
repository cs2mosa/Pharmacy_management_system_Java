package Service_Interfaces;

import java.util.ArrayList;
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
    void Add(int userId, Prescription prescription);    

    /**
     * Deletes a prescription from the repository based on its unique ID.
     * @param ID The unique identifier of the prescription to be deleted.
     */
    void Delete(int userId, int ID);

    /**
     * Finds and retrieves a list of prescriptions associated with a specific patient's name.
     * @param patientName The name of the patient whose prescriptions are to be retrieved.
     * @return A list of prescriptions matching the given patient name.
     */
    List<Prescription> findByPatientID(int patientId);

    /**
     * Retrieves all prescriptions from the repository.
     * @return A list of all prescriptions.
     */
    List<List<Prescription>> findAll();
}
public class Prescription_Repository implements PrescriptionRepository {
    
    //Map to store payments:-> Integer : UserId.
    private static Map<Integer, List<Prescription>> PRESCRIPTIONS = new HashMap<>();

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
    public void Add(int userId, Prescription prescription) {
        // Implementation for adding a prescription
        // Check if the userId exists in the map, if not create a new list for that userId
        List<Prescription> prescriptions = new ArrayList<>();
        if (PRESCRIPTIONS.containsKey(userId)) {
            prescriptions = PRESCRIPTIONS.get(userId);
            PRESCRIPTIONS.remove(userId);
        }
        prescriptions.add(prescription);
        PRESCRIPTIONS.put(userId, prescriptions);
    }

    @Override
    public void Delete(int userId, int ID) {
        // Implementation for deleting a prescription
        List<Prescription> prescriptions = PRESCRIPTIONS.get(userId);
        for(Prescription prescription : prescriptions){
            if(prescription.getId() == ID){
                prescriptions.remove(prescription);
                break;
            }
        }
        PRESCRIPTIONS.remove(userId);
        PRESCRIPTIONS.put(userId, prescriptions);//not so effecient but it works i think.
    }

    @Override
    public List<Prescription> findByPatientID(int patientId) {
        // Implementation for finding prescriptions by patient ID
        return PRESCRIPTIONS.get(patientId);
    }

    @Override
    public List<List<Prescription>> findAll() {
        // Implementation for finding all prescriptions
        return (List<List<Prescription>>) PRESCRIPTIONS.values();
    }
}