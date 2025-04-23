package Class_model;

import java.util.HashSet;
import java.util.Set;

public class Prescription {
    private String PatientName;
    private Pharmacist issuedBy;
    private String status; //Pending    Expired    Filled
    private Set<Item> items = new HashSet<>();
    
    public Prescription(String PatientName, Pharmacist issuedBy, Set<Item> items){
        this.PatientName = PatientName;
        this.issuedBy = issuedBy;
        this.items = items;
        status = "Pending";
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getPatientName() {
        return PatientName;
    }
    public void setPatientName(String patientName) {
        PatientName = patientName;
    }
    public Pharmacist getIssuedBy() {
        return issuedBy;
    }
    public void setIssuedBy(Pharmacist issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Set<Item> getItems() {
        return items;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    public void Add_Item(Item item){
        items.add(item);
    }
    public boolean Remove_Item(Item item){
        return items.remove(item);
    }
    
}
