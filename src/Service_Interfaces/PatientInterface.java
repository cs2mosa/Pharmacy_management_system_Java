package Service_Interfaces;

import java.util.List;
import Class_model.Patient;
//Patient memory must be a Set
public abstract interface PatientInterface {
    // Method to add a new patient to the system
    void AddPatient(Patient patient);

    // Method to remove a patient from the system by their name
    void RemovePatient(String Patientname);

    // Method to update a specific attribute of a patient based on a query index
    void UpdatePatient(String PatientName, int query, Object value);

    // Method to retrieve a patient by their name
    Patient GetPatient(String Patientname);

    // Method to retrieve a list of all patients
    List<Patient> GetAllPatients();
} 