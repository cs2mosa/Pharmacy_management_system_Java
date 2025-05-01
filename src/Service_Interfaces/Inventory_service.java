package Service_Interfaces;
import java.util.List;

import Class_model.Item;

/**
 * InventoryServiceInterface defines the contract for managing inventory operations.
 * It provides methods to add, remove, update, and retrieve items, as well as manage stock levels.
 */
abstract interface InventoryServiceInterface {

    /**
     * Adds a new item to the inventory.
     * @param item The item to be added.
     */
    void AddNewItem(Item item);

    /**
     * Removes an item from the inventory by its name.
     * @param Itemname The name of the item to be removed.
     */
    void RemoveItemByName(String Itemname);

    /**
     * Updates the details of an existing item in the inventory.
     * @param item The item with updated details.
     */
    void UpdateItem(Item item);

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
    List<Item> getLowStockItems();
}

public class Inventory_service implements InventoryServiceInterface{

    
    @Override
    public void AddNewItem(Item item){

    }

    @Override
    public void RemoveItemByName(String Itemname){

    }

    @Override
    public void UpdateItem(Item item){

    }

    @Override
    public Item GetItemByName(String ItemName){
        return null;
    }

    @Override
    public List<Item> GetItemsByCategory(String category){
        return null;
    }

    @Override
    public void updateStock(String item, int quantityChange){

    }    

    @Override
    public List<Item> getLowStockItems(){
        return null;
    }

}