package Service_Interfaces;

import java.util.List;
import Class_model.Order;
import Class_model.Item;


/**
 * This interface defines the contract for order-related operations.
 * It provides methods for placing, deleting, updating, retrieving, and calculating orders.
 */
abstract interface OrderServiceInterface {

    /**
     * Deletes an order by its ID.
     * 
     * @param orderId The ID of the order to be deleted.
     */
    void DeleteOrder(int patientId,int orderId); // can be void

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
     * @return The total income as a long value.
     */
    long CalcTotalIncome();

    /**
     * Handles the return of an item.
     * 
     * @param orderId The ID of the order containing the item to be returned.
     * @param itemName The Name of the item to be returned.
     * @param reason The reason for the return.
     */
    void HandleReturn(int orderId, String ItemName, String reason);
}
public class Order_Service implements OrderServiceInterface {

    /**
     * singleton design for less memory usage, only 1 object is needed.
     */
    private static Order_Service instance;

    private Order_Service() {
        // private constructor to prevent instantiation
    }

    public static Order_Service getInstance() {
        if (instance == null) {
            instance = new Order_Service();
        }
        return instance;
    }


    @Override
    public void DeleteOrder(int patientId,int orderId){
        // Implementation for deleting an order
        Order_Repository.getInstance().DeleteOrder(patientId, orderId);
    }

    @Override
    public void UpdateOrderItems(int orderId, boolean query, Item item) {
        // Implementation for updating order items
        if(query){
            GetById(orderId).addItem(item);
        }else{
            GetById(orderId).removeItem(item);
        }
    }

    @Override
    public Order GetById(int orderId) {
        // Implementation for retrieving an order by ID
        // other functionalities to be added here.
        return Order_Repository.getInstance().GetById(orderId);
    }

    @Override
    public List<Order> GetByCustomer(String CustomerName) {
        // Implementation for retrieving orders by customer name
        // other functionalities to be added here.
        return Order_Repository.getInstance().GetByName(CustomerName);
    }

    @Override
    public long CalcTotalIncome() {
        // Implementation for calculating total income from orders
        long x = 0;
        for(Order o : Order_Repository.getInstance().GetHistory()){
            if(o.getStatus() == "Paid"){
                x += o.getTotalPrice();
            }
        }
        return x; 
    }

    @Override
    public void HandleReturn(int orderId, String ItemName, String reason){

    }
}