package Class_model;

public class Payment {
    private int ID;
    private double amount;
    private String payday;
    private String Paymethod;
    private String status;

    public Payment(int ID, double amount, String payday, String Paymethod) {
        this.ID = ID;
        this.amount = amount;
        this.payday = payday;
        this.Paymethod = Paymethod;
        this.status = "Pending";
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getPayday() {
        return payday;
    }
    public void setPayday(String payday) {
        this.payday = payday;
    }
    public String getPaymethod() {
        return Paymethod;
    }
    public void setPaymethod(String paymethod) {
        Paymethod = paymethod;
    }
    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + ID +
                ", amount=" + amount +
                ", payday='" + payday + '\'' +
                ", Paymethod='" + Paymethod + '\'' +
                '}';
    }
}
