package Class_model;

import java.util.HashSet;
import java.util.Set;

public abstract class User {
    private String Username;
    private String Password;
    private String UserEmail;
    private String PhoneNumber;
    protected Set<Role> Roles = new HashSet<>();
    
    //contructors , setters , getters and other functionalities
    public User(String Username, String Password, String User_Email,String PhoneNumber,Set<Role> Roles){
        this.Username = Username;
        this.Password = Password;
        this.UserEmail = User_Email;
        this.Roles = Roles;
        this.PhoneNumber = PhoneNumber;
    }
    void setUsername(String Username){
        this.Username = Username;
    }
    String getUsername(){
        return Username;
    }
    void setPassword(String Password){
        this.Password = Password;
    }
    String getPassword(){
        return Password;
    }
    void setUserEmail(String UserEmail){
        this.UserEmail = UserEmail;
    }
    String getUserEmail(){
        return UserEmail;
    }
    void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }
    String getPhoneNumber(){
        return PhoneNumber;
    }
    public String toString(){
        return "UserID: " + Username + "\nPassword: " + Password + "\nUserEmail: " + UserEmail + "\nPhoneNumber: " + PhoneNumber;
    }
    public boolean CheckRole(Role role){
        return Roles.contains(role);
    }
    public void setRoles(Set<Role> Roles){
        this.Roles = Roles;
    }
    public Set<Role> getRoles(){
        return Roles;
    }
    public void Add_Role(Role role){
        Roles.add(role);
    }
    public boolean Remove_Role(Role role){
        return Roles.remove(role);
    }

}
