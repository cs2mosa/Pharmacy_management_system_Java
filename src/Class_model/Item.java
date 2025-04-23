package Class_model;

import java.util.HashSet;
import java.util.Set;

public class Item{
    private int quantity;
    private double price;
    private String medic_name;
    private String expire_date;
    private String usage;
    private boolean is_refundable;
    private Set<String> healing_effects = new HashSet<>();
    private Set<String> side_effects = new HashSet<>();

    public Item(String medic_name, String expire_date, int quantity, String usage,double price, Set<String> side_effects, Set<String> healing_effects) {
        this.medic_name = medic_name;
        this.expire_date = expire_date;
        this.quantity = quantity;
        this.usage = usage;
        this.side_effects = side_effects;
        this.price = price;
        this.healing_effects = healing_effects;
    }
    
    public void set_refundable(boolean refundable){
        this.is_refundable = refundable;
    }
    public boolean is_Refundable(){
        return this.is_refundable;
    }
    public double getPrice(){
        return price;
    }
    public String getMedicName() {
        return medic_name;
    }
    
    public String getExpireDate() {
        return expire_date;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public String getUsage() {
        return usage;
    }

    public Set<String> getSideEffects() {
        return side_effects;
    }
    public Set<String> getHealingEffects() {
        return healing_effects;
    }
    public void setMedicName(String medic_name) {
        this.medic_name = medic_name;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public void setExpireDate(String expire_date) {
        this.expire_date = expire_date;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
    public void setSideEffects(Set<String> side_effects) {
        this.side_effects = side_effects;
    }
    public void setHealingEffects(Set<String> healing_effects) {
        this.healing_effects = healing_effects;
    }
    
}