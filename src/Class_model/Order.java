package Class_model;

import java.util.ArrayList;
import java.util.List;

public class Order{
    private int orderId;
    private String orderDate;
    private Casher checkedBy;
    private double totalPrice;
    private String status; // "Pending", "Completed", "Cancelled"
    private List<Item> orderItems = new ArrayList<>();

    public Order(int orderId, String orderDate, Casher checkedBy, List<Item> orderItems, double totalPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.checkedBy = checkedBy;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.status = "Pending";
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public String getOrderDate() {
        return orderDate;
    }

    public Casher getCheckedBy() {
        return checkedBy;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setCheckedBy(Casher checkedBy) {
        this.checkedBy = checkedBy;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(Item item) {
        orderItems.add(item);
        totalPrice += item.getPrice();
    }
    
    public void removeItem(Item item) {
        if (orderItems.remove(item)) {
            totalPrice -= item.getPrice();
        }
    }

    public void clearOrder() {
        orderItems.clear();
        totalPrice = 0.0;
    }

    public void completeOrder() {
        status = "Completed";
    }

    public void cancelOrder() {
        status = "Cancelled";
    }
}