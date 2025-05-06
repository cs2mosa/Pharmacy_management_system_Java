package Service_Interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Class_model.Order;
/**
 * orders memory interface should be a queue.
 * The OrderRepository interface defines the contract for managing orders in the system.
 * It provides methods for adding, deleting, updating, and retrieving orders, as well as
 * accessing order history.
 * when creating Orders, User should be infromed with quantity of Items, and preveted from adding a non existed Item.
 */
abstract interface OrderRepository {

    /**
     * Adds a new order to the repository.
     * @param order The order to be added.
     * @return patient id on success , -1 else.
     */
    int AddOrder(int patientId, Order order); // Adds an order to the repository.

    /**
     * Deletes an existing order from the repository.
     * @param orderId The ID of the order to be deleted.
     * @param patientId The ID of the patient associated with the order.
     * @return 0 on success, -1 if order not found.
     */
    int DeleteOrder(int patientId,int orderId); // Removes an order from the repository.

    /**
     * Updates an existing order in the repository.
     * @param orderId The ID of the order to be updated.
     * @param Neworder The field or property to be updated.
     * @return 0 on success, -1 if order not found.
     */
    int UpdateOrder(int orderId, Order Neworder); // Updates an order's details.

    /**
     * Retrieves a list of orders by the patient's name.
     * @param PatientName The name of the patient associated with the orders.
     * @return A list of orders matching the given patient name.
     */
    List<Order> GetByName(String PatientName); // Fetches orders by patient name.

    /**
     * Retrieves an order by its unique ID.
     * @param orderId The ID of the order to retrieve.
     * @return The order with the specified ID or null if not found.
     */
    Order GetById(int orderId); // Fetches an order by its ID.

    /**
     * Retrieves the history of all orders.
     * @return A list of all past orders.
     */
    List<Order> GetHistory(); // Retrieves the order history.
}
class Order_Repository implements OrderRepository{
    // Singleton instance of Order_Repository
    private static Order_Repository instance = null;
    
    // Map to store orders ::-> Integer represents patientId associated with Order.
    private static Map<Integer,List<Order>> ORDERS;

    // Private constructor to prevent instantiation from outside
    private Order_Repository() {
        // Initialize the orders queue here (e.g., using a LinkedList or another implementation)
        ORDERS = new HashMap<>();
    }

    // Method to get the singleton instance of Order_Repository
    public static Order_Repository getInstance() {
        if (instance == null) {
            instance = new Order_Repository();
        }
        return instance;
    }

    @Override
    public int AddOrder(int patientId, Order order) {
        // Implementation for adding an order to the queue
        if(ORDERS.get(patientId) == null || order == null) return -1; // Patient not found or order is null
        List<Order> orders = ORDERS.get(patientId);
        for(Order o : orders){
            if(o.getOrderId() == order.getOrderId()){
                return -1; // Order already exists
            }
        }
        orders.add(order);
        order.setOrderId(new Random().nextInt(50000));
        ORDERS.put(patientId, orders); // Update the map with the new order
        return patientId;
    }

    @Override
    public int DeleteOrder(int patientId,int orderId) {
        // Implementation for deleting an order from the Map
        List<Order> orders = ORDERS.get(patientId);
        if (!orders.isEmpty()) {
            orders.removeIf(order -> order.getOrderId() == orderId);
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public int UpdateOrder(int patientId, Order Neworder) {
        // Implementation for updating an order in the Map
        if(DeleteOrder( patientId,Neworder.getOrderId()) == -1){
            return -1; // Order not found
        } 
        return  AddOrder(patientId, Neworder);
    }

    @Override
    public List<Order> GetByName(String PatientName) {
        // Implementation for retrieving orders by patient name
        for (Map.Entry<Integer, List<Order>> entry : ORDERS.entrySet()) {
            if (Patient_Repository.getInstance().GetPatient(entry.getKey()).getUsername() == PatientName) {
                return entry.getValue(); // Return the list of orders for the matching patient
            }
        }
        return null; // Placeholder return statement, implement logic as needed
    }

    @Override
    public Order GetById(int orderId) {
        // Implementation for retrieving an order by its ID
        for (Map.Entry<Integer, List<Order>> entry : ORDERS.entrySet()) {
            for (Order order : entry.getValue()) {
                if (order.getOrderId() == orderId) {
                    return order; // Return the matching order
                }
            }
        }
        // Return null if no matching order is found
        return null;
    }

    @Override
    public List<Order> GetHistory() {
        // Implementation for retrieving the history of all orders
        return (List<Order>) ORDERS.values().stream().flatMap(List::stream).toList();//flattening the List of lists of orders to a list of orders
    }   
}