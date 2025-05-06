package Service_Interfaces;
import java.util.ArrayList;
import java.util.List;

import Class_model.Item;
import Class_model.Admin;
/**
 * InventoryServiceInterface defines the contract for managing inventory operations.
 * It provides methods to add, remove, update, and retrieve items, as well as manage stock levels.
 */
abstract interface InventoryServiceInterface {

    /**
     * Adds a new item to the inventory.
     * @param item The item to be added.
     * @return 0 if the item is added successfully, -1 if the item already exists or is not authorized.
     */
    int AddNewItem(Item item);

    /**
     * Removes an item from the inventory by its name.
     * @param Itemname The name of the item to be removed.
     */
    void RemoveItemByName(String Itemname);

    /**
     * Updates the details of an existing item in the inventory.
     * @param item The item with updated details.
     * @param value The new price of the item.
     */
    void UpdateItemPrice(String itemName, int value);

    /**
     * Retrieves an item from the inventory by its name.
     * @param ItemName The name of the item to retrieve.
     * @return The item with the specified name, or null if not found.
     */
    Item GetItemByName(String ItemName);

    /**
     * Retrieves a list of items belonging to a specific category.
     * @param category The category of items to retrieve.
     * @return A list of items in the specified category.
     */
    List<Item> GetItemsByCategory(String category);

    /**
     * Updates the stock quantity of a specific item.
     * @param item The name of the item to update.
     * @param quantityChange The change in quantity (positive or negative).
     */
    void updateStock(String item, int quantityChange);

    /**
     * Retrieves a list of items that are low in stock.
     * @return A list of items with low stock levels.
     */
    List<String> getLowStockItems();

    /**
     * Retrieves a list of items that have expired.
     * @return A list of expired items.
     */
    //void RemoveExpiredItems(); to be added later.
}

public class Inventory_service implements InventoryServiceInterface{

    /**
     * singleton design for less memory usage, only 1 object is needed.
     */
    private static Inventory_service instance;

    private Inventory_service() {
        // private constructor to prevent instantiation
    }

    public static Inventory_service getInstance() {
        if (instance == null) {
            instance = new Inventory_service();
        }
        return instance;
    }
    @Override
    public int AddNewItem(Item item){
        if(Admin.authorizeItem(item) && Items_Repository.GetInstance().GetItemByName(item.getMedicName()) == null){
            Items_Repository.GetInstance().AddNewItem(item);
            return 0;
        }
        return -1; // Item already exists or not authorized.
    }

    @Override
    public void RemoveItemByName(String Itemname){
        if(Items_Repository.GetInstance().GetItemByName(Itemname) != null){
            Items_Repository.GetInstance().RemoveItemByName(Itemname);
            //other functionalites to be added.
        }
    }

    @Override
    public void UpdateItemPrice(String itemName, int value){
        Items_Repository.GetInstance().GetItemByName(itemName).setPrice(value);
    }

    @Override
    public Item GetItemByName(String ItemName){
        //other functionalities to be added here.
        return Items_Repository.GetInstance().GetItemByName(ItemName);
    }

    @Override
    public List<Item> GetItemsByCategory(String category){
        //other functionalities to be added here.
        return Items_Repository.GetInstance().GetItemsByCategory(category);
    }

    @Override
    public void updateStock(String item, int quantityChange){
        //other functionalities to be added here.
        Items_Repository.GetInstance().GetItemByName(item).setQuantity(quantityChange);
    }    

    @Override
    public List<String> getLowStockItems(){
        List<Item> temp = Items_Repository.GetInstance().GetAllItems();
        List<String> lowstocks = new ArrayList<>();
        for(Item item : temp){
            //5 is the bare minimum for an item (for now).
            if(item.getQuantity() <= 5){
                lowstocks.add(item.getMedicName());
            }
        }
        return lowstocks;
    }
}