package Service_Interfaces;

import Class_model.*;

/**
 * The PaymentServiceInterface defines the contract for payment processing services.
 * It includes methods for processing payments and generating receipts.
 */
abstract interface PaymentServiceInterface {

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
}