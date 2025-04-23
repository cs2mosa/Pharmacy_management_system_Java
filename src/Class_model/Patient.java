package Class_model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Patient extends User{
    private float Age;
    private String address;
    private Set<String> allergies = new HashSet<>();
    private List<Order> orders = new ArrayList<>();
    
    //contructors , setters , getters and other functionalities
    public Patient(String Username, String Password, String User_Email, String PhoneNumber, float Age, String address, Set<String> allergies, List<Order> orders, Set<Role> Roles) {
        super(Username, Password, User_Email, PhoneNumber,Roles);
        this.Age = Age;
        this.address = address;
        this.allergies = allergies;
        this.orders = orders;
    }
    
    public float getAge() {
        return Age;
    }

    public void setAge(float Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<String> allergies) {
        this.allergies = allergies;
    }

    public void Add_allergy(String allergy){
        this.allergies.add(allergy);
    }
    public boolean Remove_allergy(String allergy){
        return this.allergies.remove(allergy);
    }
    public void Add_order(Order order){
        this.orders.add(order);
    }
    public boolean Remove_order(Order order){
        return this.orders.remove(order);
    }
    
}