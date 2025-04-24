package Service_Interfaces;
import java.util.List;

import Class_model.Item;

public abstract interface InventoryServiceInterface {
    // Method to add a new item to the inventory
    void AddNewItem(Item item);

    // Method to remove an item from the inventory by its name
    void RemoveItemByName(String Itemname);

    // Method to update the details of an existing item
    void UpdateItem(Item item);

    // Method to retrieve a list of items based on their category
    List<Item> GetItemsByCategory(String category);

    // Method to process a refund for a specific item
    void RefundItem(Item item);
}