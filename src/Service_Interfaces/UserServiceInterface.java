package Service_Interfaces;

import Class_model.User;

/**
 * UserServiceInterface defines the contract for user-related operations.
 * This interface provides methods for adding, updating, deleting, authenticating,
 * deactivating, activating users, changing passwords, and checking access permissions.
 */
public interface UserServiceInterface {

    /**
     * Adds a new user to the system.
     * @param user The User object to be added.
     */
    void AddUser(User user);

    /**
     * Updates a specific field of a user in the system.
     * @param user The identifier of the user to be updated.
     * @param query The field to be updated.
     * @param value The new value for the specified field.
     */
    void UpdateUser(String user, String query, Object value);

    /**
     * Deletes a user from the system.
     * @param user The identifier of the user to be deleted.
     */
    void DeleteUser(String user);

    /**
     * Authenticates a user based on their credentials.
     * @param user The User object containing authentication details.
     * @return true if authentication is successful, false otherwise.
     */
    boolean AuthenticateUser(User user);

    /**
     * Deactivates a user account in the system.
     * @param user The identifier of the user to be deactivated.
     */
    void DeactivateUser(String user);

    /**
     * Activates a user account in the system.
     * @param userId The unique identifier of the user to be activated.
     */
    void activateUser(Long userId);

    /**
     * Changes the password for a user.
     * @param user The identifier of the user.
     * @param oldPassword The current password of the user.
     * @param NewPassword The new password to be set.
     * @return true if the password is successfully changed, false otherwise.
     */
    boolean ChangePassword(String user, String oldPassword, String NewPassword);

    /**
     * Checks if a user has access permissions.
     * @param user The User object to check access for.
     * @return true if the user has access, false otherwise.
     */
    boolean CheckAccess(User user);
}