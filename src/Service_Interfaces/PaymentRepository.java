package Service_Interfaces;

import Class_model.*;

/**
 * PaymentRepository is an abstract interface that defines the contract for managing payment operations.
 * It provides methods to add, withdraw, update, and retrieve payment details.
 */
public abstract interface PaymentRepository {

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
    