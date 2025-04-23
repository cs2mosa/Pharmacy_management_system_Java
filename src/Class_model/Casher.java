package Class_model;

import java.util.Set;

public class Casher extends User{
    private double salary;
    public Casher(String Username, String Password, String User_Email, String PhoneNumber,double salary, Set<Role> Roles) {
        super(Username, Password, User_Email, PhoneNumber,Roles);
        this.salary = salary;
    }

    /**
     * this function should only be used with restricted access
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Casher)) return false;
        Casher other = (Casher) obj;
        return Double.compare(other.salary, salary) == 0 && super.equals(obj);
    }
}