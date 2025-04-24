/**
 * The Item class represents a medical item with various attributes such as
 * name, expiration date, category, quantity, usage, price, side effects, 
 * healing effects, and refundability status.
 * 
 * This class provides getter and setter methods to access and modify the 
 * attributes of the item.
 * note: class need exeption handling for the setters and getters.
 * 
 */
package Class_model;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an item with details such as name, category, price, quantity, and effects.
 */
public class Item {
    // The quantity of the item in stock.
    private int quantity;

    // The price of the item.
    private double price;

    // The category of the item.
    private String category;

    // The name of the medicine.
    private String medic_name;

    // The expiration date of the item.
    private String expire_date;

    // The usage instructions for the item.
    private String usage;

    // Indicates whether the item is refundable.
    private boolean is_refundable;

    // The healing effects of the item.
    private Set<String> healing_effects = new HashSet<>();

    // The side effects of the item.
    private Set<String> side_effects = new HashSet<>();

    /**
     * Constructs an Item with the specified details.
     *
     * @param medic_name     The name of the medicine.
     * @param expire_date    The expiration date of the item.
     * @param category       The category of the item.
     * @param quantity       The quantity of the item.
     * @param usage          The usage instructions for the item.
     * @param price          The price of the item.
     * @param side_effects   The side effects of the item.
     * @param healing_effects The healing effects of the item.
     */
    public Item(String medic_name, String expire_date, String category, int quantity, String usage, double price, Set<String> side_effects, Set<String> healing_effects) {
        this.medic_name = medic_name;
        this.expire_date = expire_date;
        this.quantity = quantity;
        this.usage = usage;
        this.side_effects = side_effects;
        this.price = price;
        this.healing_effects = healing_effects;
        this.category = category;
    }

    /**
     * Sets whether the item is refundable.
     *
     * @param refundable True if the item is refundable, false otherwise.
     */
    public void set_refundable(boolean refundable) {
        this.is_refundable = refundable;
    }

    /**
     * Checks if the item is refundable.
     *
     * @return True if the item is refundable, false otherwise.
     */
    public boolean is_Refundable() {
        return this.is_refundable;
    }

    /**
     * Gets the price of the item.
     *
     * @return The price of the item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the name of the medicine.
     *
     * @return The name of the medicine.
     */
    public String getMedicName() {
        return medic_name;
    }

    /**
     * Gets the category of the item.
     *
     * @return The category of the item.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the expiration date of the item.
     *
     * @return The expiration date of the item.
     */
    public String getExpireDate() {
        return expire_date;
    }

    /**
     * Gets the quantity of the item.
     *
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the usage instructions for the item.
     *
     * @return The usage instructions for the item.
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Gets the side effects of the item.
     *
     * @return A set of side effects of the item.
     */
    public Set<String> getSideEffects() {
        return side_effects;
    }

    /**
     * Gets the healing effects of the item.
     *
     * @return A set of healing effects of the item.
     */
    public Set<String> getHealingEffects() {
        return healing_effects;
    }

    /**
     * Sets the name of the medicine.
     *
     * @param medic_name The name of the medicine.
     */
    public void setMedicName(String medic_name) {
        this.medic_name = medic_name;
    }

    /**
     * Sets the price of the item.
     *
     * @param price The price of the item.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the expiration date of the item.
     *
     * @param expire_date The expiration date of the item.
     */
    public void setExpireDate(String expire_date) {
        this.expire_date = expire_date;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param quantity The quantity of the item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the usage instructions for the item.
     *
     * @param usage The usage instructions for the item.
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * Sets the side effects of the item.
     *
     * @param side_effects A set of side effects of the item.
     */
    public void setSideEffects(Set<String> side_effects) {
        this.side_effects = side_effects;
    }

    /**
     * Sets the healing effects of the item.
     *
     * @param healing_effects A set of healing effects of the item.
     */
    public void setHealingEffects(Set<String> healing_effects) {
        this.healing_effects = healing_effects;
    }
}