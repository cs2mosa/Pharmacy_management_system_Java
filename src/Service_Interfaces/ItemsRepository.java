package Service_Interfaces;

import java.util.List;
import Class_model.Item;

//item repo is a Set of Items, used Set for better complexity in searching.
public abstract interface ItemsRepository {
    // Adds a new item to the repository
    void AddNewItem(Item item);

    // Removes an item from the repository by its name
    void RemoveItemByName(String Itemname);

    // Updates the details of an existing item
    void UpdateItem(Item item);

    // Retrieves all items in the repository
    List<Item> GetAllItems();

    // Gets the total number of items in the repository
    long GetNumberOfItems();

    // Retrieves items belonging to a specific category
    List<Item> GetItemsByCategory(String category);

    // Processes a refund for a specific item
    void RefundItem(Item item);
    
}