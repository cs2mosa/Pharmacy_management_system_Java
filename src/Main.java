import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Map;

import Class_model.*;
import Service_Interfaces.*;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        Patient_Service patientService = Patient_Service.getInstance();
        Order_Service orderService = Order_Service.getInstance();
        Prescription_Service prescriptionService = Prescription_Service.getInstance();
        Payment_service paymentService = Payment_service.getInstance();
        Inventory_service inventoryService = Inventory_service.getInstance();
        User_Service userService = User_Service.getInstance();

        Map<String, Integer> items = new HashMap<>();
        items.put("Paracetamol", 2);
        Patient patient = new Patient(10000, "JohnDoe", "password", "john@example.com", "1234567890", 30, "123 Street", new HashSet<>(), new ArrayList<>(), new HashSet<>());
        patient.Add_allergy("x");
        patientService.AddPatient(patient);
        Set<String> x = new HashSet<>();
        x.add("x");
        Item item = new Item.builder()
                .setMedicName("Paracetamol")
                .setPrice(10.0)
                .setExpireDate("31/12/2025")
                .setQuantity(10)
                .setUsage("Take 1 tablet every 6 hours")
                .setSideEffects(x)
                .setHealingEffects(new HashSet<>())
                .setCategory("cats")
                .build();
        
                inventoryService.AddNewItem(item);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Order order = new Order.builder()
                .setOrderId(new Random().nextInt(50000))
                .setOrderItems(itemList)
                .setTotalPrice(20.0)
                .setStatus("Pending")
                .build();
                orderService.AddOrder(10000, order);
        Map<String,Integer>  itemmap = new HashMap<>();
        itemmap.put( "Paracetamol",5);
        Set<Item> itemset = new HashSet<>();
        itemset.add(item);

        Payment payment = new Payment();
        payment.setID(order.getOrderId());
        payment.setStatus("Pending");
        payment.setOrder(order);
        payment.setAmount(order.getTotalPrice());
        payment.setPaymethod("Cash");
        payment.setPayday("2023-10-01");
        paymentService.AddPayment(10000, payment);

        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setID(new Random().nextInt(50000));
        pharmacist.setUsername("pharmacist1");
        pharmacist.setPassword("password123");
        pharmacist.setUserEmail("john@example.com");
        pharmacist.setPhoneNumber("1234567890");
        Prescription prescription = new Prescription(new Random().nextInt(50000), "JohnDoe", pharmacist, itemset);
        //System.out.println(orderService.GetById(patientService.PlaceOrder(itemmap,patient.getID(),pharmacist)));
        //System.out.println(Inventory_service.getInstance().GetItemByName("Paracetamol"));
        //System.out.println(prescriptionService.AddPrescription(10000, prescription));
        //System.out.println(userService.AddUser(pharmacist));
        //System.out.println(userService.UpdateUser("pharmacist1", "username", "new user"));
        //System.out.println(userService.GetByUsername("new user"));
        //System.out.println(userService.GetByID(0));
        //System.out.println(userService.DeleteUser("alo"));
        //System.out.println(prescriptionService.CheckPrescriptionValidity(prescription.getId(), pharmacist));
        //System.out.println(prescriptionService.IssuePrescription(pharmacist,10000,order.getOrderId()));
        //System.out.println(prescriptionService.GetAllPrescriptions());
        //System.out.println(prescriptionService.FillPrescription(0));
        //System.out.println(prescriptionService.UpdatePrescription(prescription.getId(), "status", "filled"));
        //System.out.println(prescriptionService.GetPrescriptionsByName("JohnDoe"));
        //System.out.println(prescriptionService.DeletePrescription(10000, prescription.getId()));
        //System.out.println(prescriptionService.getPreById());
        //System.out.println("place order by prescription : " + patientService.PlaceOrderByPrescription(10000,prescription.getId()));
        //System.out.println(orderService.GetById(patientService.PlaceOrderByPrescription(10000,prescription.getId())));
        //System.out.println(orderService.AddOrder(10000, order));
        //System.out.println(paymentService.AddPayment(10000, payment));
        //System.out.println(patientService.GetAllPatients());
        //System.out.println(patientService.AuthenticatePatient("JohnDoe", "password"));
        //System.out.println(patientService.GetPatientOrders((patient.getID())));
        //System.out.println(patientService.UpdatePatient("JohnDoe", "password", "age", 540f));
        //System.out.println(patientService.GetPatient("JohnDoe"));
        //System.out.println(patientService.GetPatientBalance("ohnDoe"));
        //System.out.println(patientService.RemovePatient("JohnDoe"));
        //System.out.println(paymentService.ProcessPayment(10000, order.getOrderId()));
        //System.out.println(paymentService.UpdatePayment(order.getOrderId(), "amount", 50.54));
        //System.out.println(paymentService.WithdrawPayment(10000, order.getOrderId()));
        //System.out.println(paymentService.generateReceipt(order.getOrderId()));
        //System.out.println(orderService.GetById(order.getOrderId()));
        //System.out.println(orderService.DeleteOrder(10000, order.getOrderId()));
        //System.out.println(orderService.UpdateOrderItems(order.getOrderId(),true,item2));
        //System.out.println(orderService.GetByCustomer("JohnDoe"));
        //System.out.println(orderService.GetById(0));
        //System.out.println(orderService.CalcTotalIncome());
        //System.out.println(orderService.HandleReturn(order.getOrderId(), "Paracetamol"));
        //System.out.println(orderService.GetById(order.getOrderId()));//System.out.println(inventoryService.RemoveItemByName("Paracetamol"));
        //System.out.println("place order by prescription : " + patientService.PlaceOrderByPrescription(10000,15000));
        //System.out.println("Patient details: " + patientService.GetPatient(patient.getUsername()));
        //System.out.println("remove patinet: " +  patientService.RemovePatient(patient.getUsername()));
        //System.out.println("all patients: " + patientService.GetAllPatients());
        //System.out.println("orders :" + patientService.GetPatientOrders(patientId));

    }
}
