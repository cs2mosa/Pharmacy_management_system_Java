package Class_model;

import java.util.Set;

public class Pharmacist extends User{
    private double salary;
    public Pharmacist(String Username, String Password, String User_Email, String PhoneNumber, Set<Role> Roles) {
        super(Username,  Password, User_Email, PhoneNumber,Roles);
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }
    //check if the medic is safe to the given patient
    public boolean is_safe(Item item, Patient patient){
        Set<String> side_effects = item.getSideEffects();
        Set<String> allergies = patient.getAllergies();
        for (String s : side_effects){
            if(allergies.contains(s)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this==obj && obj !=null && this.getClass() == obj.getClass()){
            return true;
        }
        else{
            return false;
        }
    }
}