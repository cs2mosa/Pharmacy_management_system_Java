package Service_Interfaces;

import Class_model.*;

/**
 * The PaymentServiceInterface defines the contract for payment processing services.
 * It includes methods for processing payments and generating receipts.
 */
abstract interface PaymentServiceInterface {

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
    void WithdrawPayment(int PatientId,int PaymentId); 
    
    /**
     * Processes a payment based on the provided payment ID.
     *
     * @param PaymentId The unique identifier of the payment to be processed.
     */
    void ProcessPayment(int PaymentId);

    /**
     * Generates a receipt for a given payment ID.
     *
     * @param paymentId The unique identifier of the payment for which the receipt is generated.
     * @return A string representation of the receipt.
     */
    String generateReceipt(int paymentId);

    /**
     * Updates a specific field of a payment record in the repository.
     * 
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param query The field to be updated.
     * @param value The new value to be set for the specified field.
     */
    void UpdatePayment(int PatientId, String query, Object value);
}

public class Payment_service implements PaymentServiceInterface{

    @Override
    public void AddPayment(int PatientId, Payment payment) {
        // Implementation for adding a payment
    }

    @Override
    public void WithdrawPayment(int PatientId, int PaymentId) {
        // Implementation for withdrawing a payment
    }
    
    @Override
    public void ProcessPayment(int PaymentId) {
        // Implementation for processing a payment
    }

    @Override
    public String generateReceipt(int paymentId) {
        // Implementation for generating a receipt
        return null;
    }

    @Override
    public void UpdatePayment(int PatientId, String query, Object value) {
        // Implementation for updating a payment
    }
}