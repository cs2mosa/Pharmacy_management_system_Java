package Service_Interfaces;

import java.util.List;
import Class_model.Order;

public abstract interface OrderRepository {
    // Method to add a new order
    void AddOrder(Order order);

    // Method to delete an existing order
    void DeleteOrder(Order order);

    // Method to find orders by the patient's name
    List<Order> FindByName(String PatientName);

    // Method to retrieve an order by its unique ID
    Order GetOrderById(int orderId);

    // Method to get the history of all orders
    List<Order> GetHistory();
}