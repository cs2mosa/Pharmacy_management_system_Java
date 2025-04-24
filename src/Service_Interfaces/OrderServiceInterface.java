package Service_Interfaces;

import java.util.Map;
import java.util.Queue;
import Class_model.Order;
import Class_model.Item;

//orders memory interface should be a queue.
public abstract interface OrderServiceInterface {
    // Places an order with the given items and returns the created Order object.
    Order PlaceOrder(Map<String,Integer> items);

    // Retrieves an order by its unique ID.
    Order GetOrderById(int orderId);

    // Deletes an order by its unique ID and returns a boolean indicating success.
    boolean DeleteOrder(int orderId);//can be void

    // Updates the items in an order based on the query type (add or remove) and the item details.
    boolean UpdateOrderItems(int orderId, boolean query, Item item);//query(0) represents adding , query(1) represents removing

    // Calculates the total price of all orders in the given queue.
    long CalcTotalPrice(Queue<Order> orders);
}