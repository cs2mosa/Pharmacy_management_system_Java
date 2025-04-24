package Service_Interfaces;

import java.util.List;
import Class_model.*;

//item repo is a Set of Items, used Set for better complexity in searching.
public abstract interface ItemsRepository {
    void AddNewItem(Item item);
    void RemoveItemByName(String Itemname);
    void UpdateItem(Item item);
    List<Item> GetAllItems();
    List<Item> GetItemsByCategory(String category);
    void RefundItem(Item item);
}