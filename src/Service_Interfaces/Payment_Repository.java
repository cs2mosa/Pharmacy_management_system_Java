package Service_Interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Class_model.*;

/**
 * PaymentRepository is an abstract interface that defines the contract for managing payment operations.
 * It provides methods to add, withdraw, update, and retrieve payment details.
 */
abstract interface PaymentRepository {

    /**
     * Adds a new payment to the repository.
     * @param payment The Payment object to be added.
     * @return payment id on successs, -1 else
     */
    int AddPayment(int PatientId, Payment payment); 

    /**
     * Withdraws a payment from the repository using its unique identifier.
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param PaymentId The unique identifier of the payment to be withdrawn.
     * @return The status of the withdrawal operation. -1 if failed mostly because patient not found, 0 if successful.
     */
    int DeletePayment(int PatientId, int PaymentId); 

    /**
     * Updates a specific field of a payment record in the repository.
     * 
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param Newpayment The new payment to be updated.
     * @return status code of payment id on success, and -1 else.
     */
    int UpdatePayment(int PatientId, Payment Newpayment); 

    /**
     * Retrieves a payment from the repository by its unique identifier.
     * 
     * @param PaymentId The unique identifier of the payment to be retrieved.
     * @return The Payment object corresponding to the given PaymentId.
     */
    List<Payment> GetById(int PatientId); 

    /**
     * Retrieves a list of all payments in the repository.
     * 
     * @return A list of all Payment objects.
     */
    List<Payment> GetAllPayments();
    
    /**
     * Retrieves a payment from the repository by its unique identifier.
     * 
     * @param PaymentId The unique identifier of the payment to be retrieved.
     * @return The Payment object corresponding to the given PaymentId. null if not found.
     */
    Payment GetPayment(int PaymentId); 
}

class Payment_Repository implements PaymentRepository {
    // Singleton instance of Payment_Repository
    private static Payment_Repository instance = null;
    // Map to store payments:-> Integer : UserId.
    private static Map<Integer,List<Payment>> PAYMENTS; // Using Set for better search complexity

    // Private constructor to prevent instantiation from outside
    private Payment_Repository() {
        //private constructor for singleton design.
        PAYMENTS = new HashMap<>(); 
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
    public int AddPayment(int PatientId, Payment payment) {
        // Implementation to add a payment
        // Check if the payment already exists in the repository
        if (payment == null) return -1;
        if(PAYMENTS.containsKey(PatientId)){
            List<Payment> payments = PAYMENTS.get(PatientId);
            for(Payment p : payments){
                if(p.getID() == payment.getID()){
                    return -1; // Payment already exists, return -1
                }
            }
            payments.add(payment);
        }else{
            List<Payment> payments = new ArrayList<>();
            payments.add(payment);
            PAYMENTS.put(PatientId, payments);
        }
        // Set the payment ID and status
        payment.setID(new Random().nextInt(50000)); // Generate a random ID for the payment
        payment.setStatus("Pending");
        return payment.getID();
    }

    @Override
    public int DeletePayment(int PatientId, int PaymentId) {
        // Implementation to withdraw a payment by ID
        if(PAYMENTS.containsKey(PatientId)){
            List<Payment> payments =  PAYMENTS.get(PatientId);
            payments.removeIf(payment -> payment.getID() == PaymentId);
            return 0;
        }
        else{
            return -1; // Payment not found, return -1
        }
    }

    @Override
    public int UpdatePayment(int PatientId, Payment Newpayment) {
        // Implementation to update payment details
        DeletePayment(PatientId, Newpayment.getID());
        return AddPayment(PatientId, Newpayment);
    }

    @Override
    public List<Payment> GetById(int PatientId) {
        // Implementation to get a payment by ID
        return PAYMENTS.get(PatientId); 
    }

    @Override  
    public List<Payment> GetAllPayments() {
        // Implementation to get all payments
        List<Payment> allPayments = new ArrayList<>();
        for(List<Payment> paymentList : PAYMENTS.values()){
            allPayments.addAll(paymentList);
        }
        return allPayments;
    }

    @Override
    public Payment GetPayment(int PaymentId) {
        // Implementation to get a payment by ID
        for(List<Payment> paymentList : PAYMENTS.values()){
            for(Payment payment : paymentList){
                if(payment.getID() == PaymentId){
                    return payment;
                }
            }
        }
        return null; // Placeholder return statement if not found
    }
}