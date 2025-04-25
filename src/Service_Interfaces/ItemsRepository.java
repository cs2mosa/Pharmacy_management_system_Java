package Service_Interfaces;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Class_model.Item;

//item repo is a Set of Items, used Set for better complexity in searching.
/**
 * The ItemsRepository interface defines the contract for managing a collection of items.
 * It provides methods to add, remove, update, and retrieve items, as well as query items by category
 * and get the total number of items.
 */
public abstract interface ItemsRepository {

    /**
     * Adds a new item to the repository.
     * @param item The item to be added.
     */
    void AddNewItem(Item item);

    /**
     * Removes an item from the repository by its name.
     * @param Itemname The name of the item to be removed.
     */
    void RemoveItemByName(String Itemname);

    /**
     * Updates an existing item in the repository based on a query and a new value.
     * @param item The item to be updated.
     * @param query The query specifying the field to be updated.
     * @param value The new value to be set for the specified field.
     */
    void UpdateItem(Item item, String query, Object value);

    /**
     * Retrieves all items from the repository.
     * @return A list of all items.
     */
    List<Item> GetAllItems();

    /**
     * Gets the total number of items in the repository.
     * @return The number of items.
     */
    long GetNumberOfItems();

    /**
     * Retrieves a list of items that belong to a specific category.
     * @param category The category to filter items by.
     * @return A list of items in the specified category.
     */
    List<Item> GetItemsByCategory(String category);
}