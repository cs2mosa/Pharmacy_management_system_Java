package Service_Interfaces;

import java.util.HashSet;
import java.util.Set;

import Class_model.User;

/**
 * UserRepository is an interface that defines the contract for managing User entities.
 * It provides methods to add, update, delete, and retrieve users by their username or ID.
 */
abstract interface UserRepository {

    /**
     * Adds a new user to the repository.
     * @param user The User object to be added.
     */
    void Add(User user);

    /**
     * Updates an existing user in the repository.
     * @param user The User object with updated information.
     */
    void Update(User user);

    /**
     * Deletes a user from the repository.
     * @param user The User object to be removed.
     */
    void Delete(User user);

    /**
     * Retrieves a user by their username.
     * @param username The username of the user to retrieve.
     * @return The User object corresponding to the given username, or null if not found.
     */
    User GetByUsername(String username);

    /**
     * Retrieves a user by their unique ID.
     * @param ID The unique identifier of the user to retrieve.
     * @return The User object corresponding to the given ID, or null if not found.
     */
    User GetByID(int ID);
}
public class User_Repository implements UserRepository {

    private static User_Repository instance = null;
    private Set<User> users = new HashSet<>(); // Using Set for better search complexity

    private User_Repository(){
        // Private constructor to prevent instantiation from outside
    }

    public static User_Repository GetInstance(){
        if (instance == null) {
            instance = new User_Repository();
            return instance;
        } else {
            return instance;
        }
    }

    @Override
    public void Add(User user) {
        // Implementation to add a user
    }

    @Override
    public void Update(User user) {
        // Implementation to update a user
    }

    @Override
    public void Delete(User user) {
        // Implementation to delete a user
    }

    @Override
    public User GetByUsername(String username) {
        // Implementation to get a user by username
        return null;
    }

    @Override
    public User GetByID(int ID) {
        // Implementation to get a user by ID
        return null;
    }

}