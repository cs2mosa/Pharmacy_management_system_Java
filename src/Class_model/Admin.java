/**
 * The Admin class extends the User class and represents an administrator in the system.
 * It provides functionality specific to administrators, such as setting the salary for employees.
 * 
 * Constructor:
 * - Admin(String Username, String Password, String User_Email, String PhoneNumber, Set<Role> Roles):
 *   Initializes an Admin object with the provided username, password, email, phone number, and roles.
 * 
 * Methods:
 * - setSalary(User user, double salary, Role role):
 *   Allows the admin to set the salary for an employee (Pharmacist or Casher) in the pharmacy.
 *   This method ensures that only users with the "ADMIN" role can set salaries.
 *   It checks if the provided user is an instance of Pharmacist or Casher and if the role is "ADMIN".
 *   If the conditions are met, the salary is set for the respective employee and the method returns true.
 *   Otherwise, it returns false.
 * 
 * Note:
 * - The setSalary method is the only way to set the salary for any employee in the pharmacy.
 * - Consider implementing additional security measures to prevent unauthorized access to this method.
 * @author mosa abdulaziz
 * @version 1.0
 */ 
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