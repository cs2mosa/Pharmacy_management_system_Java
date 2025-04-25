package Service_Interfaces;

import java.util.List;

import Class_model.*;

/**
 * PrescriptionRepository is an interface that defines the contract for managing prescriptions.
 * It provides methods to add, delete, and retrieve prescriptions based on specific criteria.
 */
public abstract interface PrescriptionRepository {

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