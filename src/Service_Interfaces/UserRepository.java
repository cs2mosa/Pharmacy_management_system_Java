package Service_Interfaces;

import Class_model.User;

public abstract interface UserRepository {
    // Method to save a user
    boolean Save(User user);

    // Method to add a new user
    boolean Add(User user);

    // Method to update an existing user
    boolean Update(User user);

    // Method to delete a user
    boolean Delete(User user);

    // Method to authenticate a user
    boolean Authenticate(User user);

    // Method to deactivate a user
    void Deactivate(User user);

    // Method to change the password of a user
    void ChangePassword(User user);
}
