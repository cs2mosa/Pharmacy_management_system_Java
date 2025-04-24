package Service_Interfaces;

import java.util.List;
import Class_model.*;

public abstract interface PatientInterface {
    public abstract void addPatient(Patient patient);
    public abstract void removePatient(String Patientname);
    public abstract void updatePatient(Patient patient);
    public abstract Patient getPatient(String Patientname);
    public abstract List<Patient> getAllPatients();
} 