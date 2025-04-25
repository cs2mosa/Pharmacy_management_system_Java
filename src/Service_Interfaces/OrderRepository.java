package Service_Interfaces;

import java.util.List;
import java.util.Queue;

import Class_model.Order;

/**
 * orders memory interface should be a queue.
 * The OrderRepository interface defines the contract for managing orders in the system.
 * It provides methods for adding, deleting, updating, and retrieving orders, as well as
 * accessing order history.
 */
public abstract interface OrderRepository {

    /**
     * Adds a new order to the repository.
     * @param order The order to be added.
     */
    void AddOrder(Order order); // Adds an order to the repository.

    /**
     * Deletes an existing order from the repository.
     * @param order The order to be deleted.
     */
    void DeleteOrder(Order order); // Removes an order from the repository.

    /**
     * Updates an existing order in the repository.
     * @param orderId The ID of the order to be updated.
     * @param query The field or property to be updated.
     * @param value The new value to be set.
     * @return The updated order.
     */
    Order UpdateOrder(int orderId, String query, Object value); // Updates an order's details.

    /**
     * Retrieves a list of orders by the patient's name.
     * @param PatientName The name of the patient associated with the orders.
     * @return A list of orders matching the given patient name.
     */
    List<Order> GetByName(String PatientName); // Fetches orders by patient name.

    /**
     * Retrieves an order by its unique ID.
     * @param orderId The ID of the order to retrieve.
     * @return The order with the specified ID.
     */
    Order GetById(int orderId); // Fetches an order by its ID.

    /**
     * Retrieves the history of all orders.
     * @return A list of all past orders.
     */
    List<Order> GetHistory(); // Retrieves the order history.
}
 