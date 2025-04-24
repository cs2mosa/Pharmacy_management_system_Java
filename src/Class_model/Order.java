/**
 * Represents an order in the system.
 * An order contains details such as order ID, order date, cashier who checked it,
 * total price, status, and a list of items in the order.
 * The status of the order can be "Pending", "Completed", or "Cancelled".
 * note: class needs exception handling for invalid inputs and edge cases.
 * The class provides methods to add and remove items from the order.
 */
package Class_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order with details such as items, total price, and status.
 */
public class Order {

    /** Unique identifier for the order. */
    private int orderId;

    /** Date when the order was placed. */
    private String orderDate;

    /** The cashier who checked the order. */
    private Casher checkedBy;

    /** Total price of the order. */
    private double totalPrice;

    /** Current status of the order ("Pending", "Completed", "Cancelled"). */
    private String status;

    /** List of items in the order. */
    private List<Item> orderItems = new ArrayList<>();

    /**
     * Constructs an Order with the given details.
     * @param orderId Unique identifier for the order.
     * @param orderDate Date of the order.
     * @param checkedBy Cashier who checked the order.
     * @param orderItems List of items in the order.
     * @param totalPrice Total price of the order.
     */
    public Order(int orderId, String orderDate, Casher checkedBy, List<Item> orderItems, double totalPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.checkedBy = checkedBy;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.status = "Pending";
    }

    /** @return The unique identifier of the order. */
    public int getOrderId() {
        return orderId;
    }

    /** @return The date of the order. */
    public String getOrderDate() {
        return orderDate;
    }

    /** @return The cashier who checked the order. */
    public Casher getCheckedBy() {
        return checkedBy;
    }

    /** @return The list of items in the order. */
    public List<Item> getOrderItems() {
        return orderItems;
    }

    /** @return The total price of the order. */
    public double getTotalPrice() {
        return totalPrice;
    }

    /** @return The current status of the order. */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the unique identifier for the order.
     * @param orderId The new order ID.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Sets the date of the order.
     * @param orderDate The new order date.
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Sets the cashier who checked the order.
     * @param checkedBy The new cashier.
     */
    public void setCheckedBy(Casher checkedBy) {
        this.checkedBy = checkedBy;
    }

    /**
     * Sets the list of items in the order.
     * @param orderItems The new list of items.
     */
    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * Sets the total price of the order.
     * @param totalPrice The new total price.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Sets the status of the order.
     * @param status The new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Adds an item to the order and updates the total price.
     * @param item The item to add.
     */
    public void addItem(Item item) {
        orderItems.add(item);
        totalPrice += item.getPrice();
    }

    /**
     * Removes an item from the order and updates the total price.
     * @param item The item to remove.
     */
    public void removeItem(Item item) {
        if (orderItems.remove(item)) {
            totalPrice -= item.getPrice();
        }
    }

    /**
     * Clears all items from the order and resets the total price.
     */
    public void clearOrder() {
        orderItems.clear();
        totalPrice = 0.0;
    }

    /**
     * Marks the order as completed.
     */
    public void completeOrder() {
        status = "Completed";
    }

    /**
     * Cancels the order and updates its status.
     */
    public void cancelOrder() {
        status = "Cancelled";
    }
}
