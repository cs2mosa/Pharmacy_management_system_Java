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
     * @return prescription id on success.
     */
    int Add(int userId, Prescription prescription);    

    /**
     * Deletes a prescription from the repository based on its unique ID.
     * @param ID The unique identifier of the prescription to be deleted.
     * @return status code of 0 on success , -1 else.
     */
    int Delete(int userId, int ID);

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
    List<Prescription> findAll();

    /**
     * Retrieves a prescription by its unique ID.
     * @param preID
     * @return
     */
    public Prescription getPreById(int preID);
}
public class Prescription_Repository implements PrescriptionRepository {
    
    //Map to store payments:-> Integer : UserId.
    private static Map<Integer, List<Prescription>> PRESCRIPTIONS;
    // Singleton instance of Prescription_Repository
    private static Prescription_Repository instance = null;

    private Prescription_Repository(){
       // Private constructor to prevent instantiation from outside.
       PRESCRIPTIONS = new HashMap<>();
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
    public int Add(int userId, Prescription prescription) {
        // Implementation for adding a prescription
        List<Prescription> temp = PRESCRIPTIONS.get(userId);
        if(temp == null){
            temp = new ArrayList<>();
            temp.add(prescription);
            PRESCRIPTIONS.put(userId,temp);
            return prescription.getId();
        }
        PRESCRIPTIONS.get(userId).add(prescription);
        return prescription.getId();
    }

    @Override
    public int Delete(int userId, int ID) {
        // Implementation for deleting a prescription
        List<Prescription> prescriptions = PRESCRIPTIONS.get(userId);
        for(Prescription prescription : prescriptions){
            if(prescription.getId() == ID){
                prescriptions.remove(prescription);
                return 0;
            }
        }
        return -1;
    }

    @Override
    public List<Prescription> findByPatientID(int patientId) {
        // Implementation for finding prescriptions by patient ID
        return PRESCRIPTIONS.get(patientId);
    }

    @Override
    public List<Prescription> findAll() {
        // Implementation for finding all prescriptions
        return (List<Prescription>)PRESCRIPTIONS.values().stream().flatMap(List::stream).toList();
    }

    @Override
    public Prescription getPreById(int preID){
        return PRESCRIPTIONS.values()
                .stream()
                .flatMap(List::stream)
                .filter(prescription -> prescription.getId() == preID)
                .findFirst()
                .orElse(null);
    }
}