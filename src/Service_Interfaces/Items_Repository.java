package Service_Interfaces;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * we need to implement singleton design pattern in every repository here.
 */
import Class_model.Item;

//item repo is a Set of Items, used Set for better complexity in searching.
/**
 * The ItemsRepository interface defines the contract for managing a collection of items.
 * It provides methods to add, remove, update, and retrieve items, as well as query items by category
 * and get the total number of items.
 */
abstract interface ItemsRepository {
    
    /**
     * retrives item based on its name.
     * @param ItemName
     * @return 
     */
    Item GetItemByName(String ItemName);
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

public class Items_Repository implements ItemsRepository{

    // Singleton instance of Items_Repository
    private static Items_Repository instance = null;

    // Set to store items
    private Set<Item> allItems = new HashSet<>();

    private Items_Repository(){
        // Private constructor to prevent instantiation from outside
    }
    
    public static Items_Repository GetInstance(){
        if(instance == null){
            instance = new Items_Repository();
            return instance;
        }
        else{
            return instance;
        }
    }


    @Override
    public Item GetItemByName(String ItemName){
        return null;
    }

    @Override
    public void AddNewItem(Item item){
        
    }

    @Override
    public void RemoveItemByName(String Itemname){

    }

    @Override
    public void UpdateItem(Item item, String query, Object value){

    }

    @Override
    public List<Item> GetAllItems(){
        return null; // Placeholder return value, should return a list of all items

    }

    @Override
    public long GetNumberOfItems(){
        return allItems.size(); // Returns the number of items in the repository
    }

    @Override
    public List<Item> GetItemsByCategory(String category){
        return null; // Placeholder return value, should return a list of items in the specified category
    }
    
}