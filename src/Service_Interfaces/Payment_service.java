package Service_Interfaces;

import Class_model.*;

/**
 * The PaymentServiceInterface defines the contract for payment processing services.
 * It includes methods for processing payments and generating receipts.
 * NOTE: Cancelled payments are not removed from the repository, but their status is updated, and their ID is set to -1. 
 * withdrawal is differnt from deletion in Payment_Repository.
 */
abstract interface PaymentServiceInterface {

    /**
     * Adds a new payment to the repository.
     * 
     * @param payment The Payment object to be added.
     * @return payment id on success, -1 else.
     */
    int AddPayment(int PatientId, Payment payment, int OrderId); 

    /**
     * Withdraws a payment from the repository using its unique identifier.
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param PaymentId The unique identifier of the payment to be withdrawn.
     * @return The status of the withdrawal operation. -1 if failed, 0 if successful.
     */
    int WithdrawPayment(int PatientId,int PaymentId); 
    
    /**
     * Processes a payment based on the provided payment ID.
     * @param PatientId The unique identifier of the patient making the payment.
     * @param OrderId The unique identifier of the order associated with the payment.PaymentId is the same as OrderId.
     */
    int ProcessPayment(int PatientId, int OrderId);

    /**
     * Generates a receipt for a given payment ID.
     *
     * @param paymentId The unique identifier of the payment for which the receipt is generated.
     * @return A string representation of the receipt on success , null on fail.
     */
    String generateReceipt(int paymentId);

    /**
     * Updates a specific field of a payment record in the repository.
     * 
     * @param PatientId The unique identifier of the patient associated with the payment.
     * @param query The field to be updated.
     * @param value The new value to be set for the specified field, only 3 queries are supported for now -> "amount" , "payday", "paymethod".
     * @return status code of 0 on success , and -1 else.
     */
    int UpdatePayment(int PatientId, String query, Object value);
}

public class Payment_service implements PaymentServiceInterface{

    /**
     * singleton design for less memory usage, only 1 object is needed.
     */
    private static Payment_service instance;

    private Payment_service() {
        // private constructor to prevent instantiation
    }

    public static Payment_service getInstance() {
        if (instance == null) {
            instance = new Payment_service();
        }
        return instance;
    }

    @Override
    public int AddPayment(int PatientId, Payment payment, int OrderId) {
        // Implementation for adding a payment
        payment.setID(OrderId);
        payment.setStatus("Pending");
        payment.setOrder(Order_Repository.getInstance().GetById(OrderId));
        payment.setAmount(Order_Repository.getInstance().GetById(OrderId).getTotalPrice());
        Payment_Repository.GetInstance().AddPayment(PatientId, payment);
        Order_Repository.getInstance().GetById(OrderId).setStatus("Pending");

        return payment.getID();
    }

    @Override
    public int WithdrawPayment(int PatientId, int PaymentId) {
        // Implementation for withdrawing a payment
        Payment temp = Payment_Repository.GetInstance().GetPayment(PaymentId);
        for(Item itm : temp.getOrder().getOrderItems()){
            if (!itm.is_Refundable()){
                return -1; // Item is not refundable
            }
        }
        temp.setStatus("Cancelled");
        temp.setID(-1);
        return 0; // Payment successfully withdrawn
    }

    @Override
    public String generateReceipt(int paymentId) {
        // Implementation for generating a receipt
        Payment payment = Payment_Repository.GetInstance().GetPayment(paymentId);
        if(payment != null) {
            return payment.toString();
        }
        return null;
    }

    @Override
    public int UpdatePayment(int PatientId, String query, Object value) {
        // Implementation for updating a payment
        Payment payment = Payment_Repository.GetInstance().GetPayment(PatientId);
        if (payment == null) return -1;
        switch (query) {
            case "amount":
                if (value instanceof Double) {
                    payment.setAmount((Double) value);
                }
                break;
            case "payday":
                if (value instanceof String) {
                    payment.setPayday((String) value);
                }
                break;
            case "paymethod":
                if (value instanceof String) {
                    payment.setPaymethod((String) value);
                }
                break;
            default:
                return -1;
        }
        Payment_Repository.GetInstance().UpdatePayment(PatientId, payment);
        return 0;
    }

    //order id is the payment id
    public int ProcessPayment(int PatientId, int PaymentId){
        Payment temppay = Payment_Repository.GetInstance().GetPayment(PaymentId);
        Patient tempPatient = Patient_Repository.getInstance().GetPatient(PatientId);
        if(tempPatient.GetBalance() >= temppay.getOrder().getTotalPrice()){
            //check if the payment is already paid
            if(temppay.getStatus() == "Paid" || temppay.getStatus() == "Cancelled"){
                return -1;//already paid
            }
            temppay.setStatus("Paid");//update the payment status to paid
            tempPatient.SetBalance(tempPatient.GetBalance() - temppay.getOrder().getTotalPrice());
            Order_Repository.getInstance().GetById(PaymentId).setCheckedBy("Casher");
            Payment_Repository.GetInstance().UpdatePayment(PatientId, temppay);
            Patient_Repository.getInstance().UpdatePatient(PatientId, tempPatient);
            Order_Repository.getInstance().GetById(PaymentId).setStatus("Paid");
            Admin.setTotalIncome(Admin.gettotalIncome() + (tempPatient.GetBalance() - temppay.getOrder().getTotalPrice()));
            return 1;
        }
        else{
            return -1;
        }
    }
}