package Class_model;

import java.util.Set;

public class Admin extends User{
    public Admin(String Username, String Password, String User_Email, String PhoneNumber, Set<Role> Roles) {
        super(Username, Password, User_Email, PhoneNumber,Roles);
    }
    /**
     * this function is the only way to set salary for any Employee in the pharmacy, need to think about preventing other's access
     */
    public boolean setSalary(User user, double salary, Role role){
        boolean isADMIN = role.getRoleName().equals("ADMIN");
        if(user instanceof Pharmacist && isADMIN){
            ((Pharmacist) user).setSalary(salary);
            return true;
        }else if(user instanceof Casher &&isADMIN){
            ((Casher) user).setSalary(salary);
            return true;
        }else{
            return false;
        }
    }

}