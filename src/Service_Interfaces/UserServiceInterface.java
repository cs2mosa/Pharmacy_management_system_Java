package Service_Interfaces;
import Class_model.*;

public interface UserServiceInterface {
    boolean SaveUser(User user);
    boolean AddUser(User user);
    boolean UpdateUser(User user);
    boolean DeleteUser(User user);
    boolean AuthenticateUser(User user);
    void DeactivateUser(User user);
    void ChangePassword(User user);
}