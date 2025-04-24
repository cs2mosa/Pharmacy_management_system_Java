package Service_Interfaces;

import Class_model.Patient;

public abstract interface PatientRepository {
    // Method to add a new patient to the repository
    // Takes a Patient object as a parameter
    void AddPatient(Patient patient);

    // Method to remove a patient from the repository
    // Takes the patient's name as a parameter
    void RemovePatient(String Patientname);

    // Method to update a specific attribute of a patient
    // Takes the patient's name, a query index (0-9), and the new value as parameters
    void UpdatePatient(String PatientName, int query, Object value);

    // Method to retrieve a patient's details from the repository
    // Takes the patient's name as a parameter and returns a Patient object
    Patient GetPatient(String Patientname);
}