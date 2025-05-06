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
     * @return The unique identifier of the newly added user. -1 if the user already exists.
     */
    int AddUser(User user);

    /**
     * Updates a specific field of a user in the system.
     * @param user The identifier of the user to be updated.
     * @param query The field to be updated.
     * @param value The new value for the specified field.
     * @return The unique identifier of the updated user.
     */
    int UpdateUser(String user, String query, Object value);

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
    public int AddUser(User user) {
        // Implementation for adding a user
        return User_Repository.GetInstance().Add(user);
    }

    @Override
    public int UpdateUser(String user, String query, Object value) {
        // Implementation for updating a user
        User temp = User_Repository.GetInstance().GetByUsername(user);
        if(temp == null) return -1;
        switch (query) {
            case "username":
                if(value instanceof String){
                    temp.setUsername((String)value);
                }
                break;
            case "password":
                if(value instanceof String){
                    temp.setPassword((String)value);
                }
                break;
            
            case "email":
                if(value instanceof String){
                    temp.setUserEmail((String)value);
                }
                break;
            case "phone":
                if(value instanceof String){
                    temp.setPhoneNumber((String)value);
                }
                break;
            case "activate":
                if(value instanceof Boolean){
                    temp.setactive((Boolean)value);
                }
                break;
            default:
                return -1;
        }
        return temp.getID();
    }

    @Override
    public void DeleteUser(String user) {
        // Implementation for deleting a user
        User_Repository.GetInstance().Delete(User_Repository.GetInstance().GetByUsername(user).getID());
    }

    @Override
    public boolean AuthenticateUser(User user) {
        // Implementation for authenticating a user
        User temp = User_Repository.GetInstance().GetByUsername(user.getUsername());
        if(temp == null || !temp.getPassword().equals(user.getPassword())){
            return false;
        }else{
            return true;
        }
    }
}