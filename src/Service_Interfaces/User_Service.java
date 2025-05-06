package Service_Interfaces;

import Class_model.User;

/**
 * UserServiceInterface defines the contract for user-related operations.
 * This interface provides methods for adding, updating, deleting, authenticating,
 * deactivating, activating users, changing passwords, and checking access permissions.
 * NOTE: Patient services are extending this service, please make sure to think about that.
 */
interface UserServiceInterface {

    /**
     * Adds a new user to the system, For every user except Patients
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
    void activateUser(int userId);

    /**
     * Changes the password for a user.
     * @param user The identifier of the user.
     * @param oldPassword The current password of the user.
     * @param NewPassword The new password to be set.
     * @return true if the password is successfully changed, false otherwise.
     */
    boolean ChangePassword(String username, String oldPassword, String NewPassword);

    /**
     * Checks if a user has access permissions.
     * @param user The User object to check access for.
     * @return true if the user has access, false otherwise.
     */
    boolean CheckAccess(User user);
}

public class User_Service implements UserServiceInterface {

    /**
     * singleton design for less memory usage, only 1 object is needed.
     */
    private static User_Service instance;

    private User_Service() {
        // Private constructor to prevent instantiation
    }

    public static User_Service getInstance() {
        if (instance == null) {
            instance = new User_Service();
        }
        return instance;
    }

    @Override
    public void AddUser(User user) {
        // Implementation for adding a user
    }

    @Override
    public void UpdateUser(String user, String query, Object value) {
        // Implementation for updating a user
    }

    @Override
    public void DeleteUser(String user) {
        // Implementation for deleting a user
    }

    @Override
    public boolean AuthenticateUser(User user) {
        // Implementation for authenticating a user
        return false;
    }

    @Override
    public void DeactivateUser(String user) {
        // Implementation for deactivating a user
    }
    
    @Override
    public void activateUser(int userId) {
        // Implementation for activating a user
    }

    @Override
    public boolean ChangePassword(String username, String oldPassword, String NewPassword) {
        // Implementation for changing a user's password
        return false;
    }

    @Override
    public boolean CheckAccess(User user) {
        // Implementation for checking user access permissions
        return false;
    }
}