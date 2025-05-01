package Service_Interfaces;

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
    void AddPayment(Payment payment); // Method to add a payment

    /**
     * Withdraws a payment from the repository using its unique identifier.
     * 
     * @param PaymentId The unique identifier of the payment to be withdrawn.
     */
    void WithdrawPayment(int PaymentId); // Method to withdraw a payment by ID

    /**
     * Updates a specific field of a payment record in the repository.
     * 
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param query The field to be updated.
     * @param value The new value to be set for the specified field.
     */
    void UpdatePayment(int PatientId, String query, Object value); // Method to update payment details

    /**
     * Retrieves a payment from the repository by its unique identifier.
     * 
     * @param PaymentId The unique identifier of the payment to be retrieved.
     * @return The Payment object corresponding to the given PaymentId.
     */
    Payment GetById(int PaymentId); // Method to get a payment by ID
}

public class Payment_Repository implements PaymentRepository {
    // Singleton instance of Payment_Repository
    private static Payment_Repository instance = null;
    // Map to store payments:-> Integer : UserId.
    private Map<Integer,List<Payment>> payments = new HashMap<>(); // Using Set for better search complexity

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
    public void AddPayment(Payment payment) {
        // Implementation to add a payment
    }
    @Override
    public void WithdrawPayment(int PaymentId) {
        // Implementation to withdraw a payment by ID
    }
    @Override
    public void UpdatePayment(int PatientId, String query, Object value) {
        // Implementation to update payment details
    }
    @Override
    public Payment GetById(int PaymentId) {
        // Implementation to get a payment by ID
        return null; // Placeholder return statement
    }
}