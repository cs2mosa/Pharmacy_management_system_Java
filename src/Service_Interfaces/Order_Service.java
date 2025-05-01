package Service_Interfaces;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import Class_model.Order;
import Class_model.Item;


/**
 * This interface defines the contract for order-related operations.
 * It provides methods for placing, deleting, updating, retrieving, and calculating orders.
 */
abstract interface OrderServiceInterface {

    /**
     * Places an order with the specified items.
     * 
     * @param items A map where the key is the item name and the value is the quantity.
     * @return The ID of the placed order.
     */
    int PlaceOrder(Map<String, Integer> items);

    /**
     * Deletes an order by its ID.
     * 
     * @param orderId The ID of the order to be deleted.
     */
    void DeleteOrder(int orderId); // can be void

    /**
     * Updates the items of an existing order.
     * 
     * @param orderId The ID of the order to be updated.
     * @param query A boolean flag where true represents adding an item and false represents removing an item.
     * @param item The item to be added or removed.
     */
    void UpdateOrderItems(int orderId, boolean query, Item item); // query(0) represents adding, query(1) represents removing

    /**
     * Retrieves an order by its ID.
     * 
     * @param orderId The ID of the order to retrieve.
     * @return The order with the specified ID.
     */
    Order GetById(int orderId);

    /**
     * Retrieves a list of orders placed by a specific customer.
     * 
     * @param CustomerName The name of the customer whose orders are to be retrieved.
     * @return A list of orders associated with the specified customer.
     */
    List<Order> GetByCustomer(String CustomerName);

    /**
     * Calculates the total income from a queue of orders.
     * 
     * @param orders A queue of orders to calculate the total income from.
     * @return The total income as a long value.
     */
    long CalcTotalIncome(Queue<Order> orders);
}
public class Order_Service implements OrderServiceInterface {

    @Override
    public int PlaceOrder(Map<String, Integer> items) {
        // Implementation for placing an order
        return 0; // Placeholder return value
    }

    @Override
    public void DeleteOrder(int orderId) {
        // Implementation for deleting an order
    }

    @Override
    public void UpdateOrderItems(int orderId, boolean query, Item item) {
        // Implementation for updating order items
    }

    @Override
    public Order GetById(int orderId) {
        // Implementation for retrieving an order by ID
        return null; // Placeholder return value
    }

    @Override
    public List<Order> GetByCustomer(String CustomerName) {
        // Implementation for retrieving orders by customer name
        return null; // Placeholder return value
    }

    @Override
    public long CalcTotalIncome(Queue<Order> orders) {
        // Implementation for calculating total income from orders
        return 0; // Placeholder return value
    }
}