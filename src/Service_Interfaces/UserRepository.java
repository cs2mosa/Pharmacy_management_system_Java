package Service_Interfaces;

import java.util.HashSet;
import java.util.Set;

import Class_model.User;

/**
 * UserRepository is an interface that defines the contract for managing User entities.
 * It provides methods to add, update, delete, and retrieve users by their username or ID.
 */
public abstract interface UserRepository {

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
