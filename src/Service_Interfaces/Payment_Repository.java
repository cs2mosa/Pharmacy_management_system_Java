package Service_Interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Class_model.*;

/**
 * PaymentRepository is an abstract interface that defines the contract for managing payment operations.
 * It provides methods to add, withdraw, update, and retrieve payment details.
 */
abstract interface PaymentRepository {

    /**
     * Adds a new payment to the repository.
     * 
     * @param payment The Payment object to be added.
     */
    void AddPayment(int PatientId, Payment payment); 

    /**
     * Withdraws a payment from the repository using its unique identifier.
     * 
     * @param PaymentId The unique identifier of the payment to be withdrawn.
     */
    void DeletePayment(int PatientId, int PaymentId); 

    /**
     * Updates a specific field of a payment record in the repository.
     * 
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param query The field to be updated.
     * @param value The new value to be set for the specified field.
     */
    void UpdatePayment(int PatientId, Payment Newpayment); 

    /**
     * Retrieves a payment from the repository by its unique identifier.
     * 
     * @param PaymentId The unique identifier of the payment to be retrieved.
     * @return The Payment object corresponding to the given PaymentId.
     */
    List<Payment> GetById(int PatientId); 
}

public class Payment_Repository implements PaymentRepository {
    // Singleton instance of Payment_Repository
    private static Payment_Repository instance = null;
    // Map to store payments:-> Integer : UserId.
    private static Map<Integer,List<Payment>> PAYMENTS = new HashMap<>(); // Using Set for better search complexity

    // Private constructor to prevent instantiation from outside
    private Payment_Repository() {
        //private constructor for singleton design.
    }

    // Method to get the singleton instance of Payment_Repository
    public static PaymentRepository GetInstance(){
        if(instance ==null){
            instance  =  new Payment_Repository();
            return instance;
        }
        else{
            return instance;
        }
    }

    @Override
    public void AddPayment(int PatientId, Payment payment) {
        // Implementation to add a payment
        List<Payment> payments = new ArrayList<>();
        if(!PAYMENTS.containsKey(PatientId)){
            payments = PAYMENTS.get(PatientId);
            PAYMENTS.remove(PatientId);
        }
        payments.add(payment);
        PAYMENTS.put(PatientId, payments);
    }

    @Override
    public void DeletePayment(int PatientId, int PaymentId) {
        // Implementation to withdraw a payment by ID
        if(PAYMENTS.containsKey(PatientId)){
            List<Payment> payments =  PAYMENTS.get(PatientId);
            for(Payment pay : payments){
                if(pay.getID() == PaymentId){
                    payments.remove(pay);
                    break;
                }
            }
            PAYMENTS.remove(PatientId);
            PAYMENTS.put(PatientId, payments);
        }
    }

    @Override
    public void UpdatePayment(int PatientId, Payment Newpayment) {
        // Implementation to update payment details
        DeletePayment(PatientId, Newpayment.getID());
        AddPayment(PatientId, Newpayment);
    }

    @Override
    public List<Payment> GetById(int PatientId) {
        // Implementation to get a payment by ID
        return PAYMENTS.get(PatientId); // Placeholder return statement
    }
}