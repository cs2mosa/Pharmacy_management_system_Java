import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Map;

import Class_model.*;
import Service_Interfaces.*;

public class Tutorial {
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
    }
}
