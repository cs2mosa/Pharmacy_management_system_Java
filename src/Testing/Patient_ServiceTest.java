package Testing;

import Service_Interfaces.Inventory_service;
import Service_Interfaces.Patient_Service;
import Service_Interfaces.Prescription_Service;
import Class_model.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class Patient_ServiceTest {
    private Patient_Service patientService;
    private Patient testPatient;
    private Pharmacist testPharmacist;
    private Map<String, Integer> testItems;
    private Set<Role> testRoles;
    private Prescription testPrescription;
    private Set<Item> prescriptionItems;

    @Before
    public void setUp() {
        patientService = Patient_Service.getInstance();
        testRoles = new HashSet<>();
        testRoles.add(new Role("1", "PATIENT", 1, "Patient role"));
        
        // Create a test patient with proper constructor
        testPatient = new Patient(1, "testUser", "testPass", "test@email.com", 
            "1234567890", 25.0f, "123 Test St", new HashSet<>(), new ArrayList<>(), testRoles);
        
        // Create a test pharmacist with proper constructor
        testPharmacist = new Pharmacist(1, "pharmUser", "pharmPass", "pharm@email.com", 
            "1234567890", testRoles);
        
        /*_____________________________________________________________________________________________________ */
        Set<String> paracetamolSideEffects = new HashSet<>();
        paracetamolSideEffects.add("Nausea");
        paracetamolSideEffects.add("Allergic reactions");
        
        Set<String> paracetamolHealingEffects = new HashSet<>();
        paracetamolHealingEffects.add("Pain relief");
        paracetamolHealingEffects.add("Fever reduction");
        
        // Item 1: Paracetamol
        Item paracetamol = new Item.builder()
            .setMedicName("Paracetamol_500mg")
            .setExpireDate("2025-12-31")
            .setCategory("Pain Relief")
            .setQuantity(100)
            .setUsage("Take 1-2 tablets every 4-6 hours as needed")
            .setPrice(5.99)
            .set_Refundable(true)
            .setSideEffects(paracetamolSideEffects)
            .setHealingEffects(paracetamolHealingEffects)
            .build();
            
        // Item 2: Amoxicillin
        Set<String> amoxicillinSideEffects = new HashSet<>();
        amoxicillinSideEffects.add("Diarrhea");
        amoxicillinSideEffects.add("Rash");
        
        Set<String> amoxicillinHealingEffects = new HashSet<>();
        amoxicillinHealingEffects.add("Bacterial infection treatment");
        amoxicillinHealingEffects.add("Antibiotic action");
        
        Item amoxicillin = new Item.builder()
            .setMedicName("Amoxicillin_250mg")
            .setExpireDate("2024-06-30")
            .setCategory("Antibiotics")
            .setQuantity(50)
            .setUsage("Take 1 capsule three times daily")
            .setPrice(15.99)
            .set_Refundable(false)
            .setSideEffects(amoxicillinSideEffects)
            .setHealingEffects(amoxicillinHealingEffects)
            .build();
            
        // Item 3: Vitamin D
        Set<String> vitaminDSideEffects = new HashSet<>();
        vitaminDSideEffects.add("Hypercalcemia");
        vitaminDSideEffects.add("Kidney stones");
        
        Set<String> vitaminDHealingEffects = new HashSet<>();
        vitaminDHealingEffects.add("Bone health");
        vitaminDHealingEffects.add("Immune system support");
        
        Item vitaminD = new Item.builder()
            .setMedicName("Vitamin_D3_1000IU")
            .setExpireDate("2025-03-31")
            .setCategory("Supplements")
            .setQuantity(200)
            .setUsage("Take 1 tablet daily with food")
            .setPrice(12.99)
            .set_Refundable(true)
            .setSideEffects(vitaminDSideEffects)
            .setHealingEffects(vitaminDHealingEffects)
            .build();

        Inventory_service.getInstance().AddNewItem(vitaminD);
        Inventory_service.getInstance().AddNewItem(amoxicillin);
        Inventory_service.getInstance().AddNewItem(paracetamol);

        // Create prescription items set
        prescriptionItems = new HashSet<>();
        prescriptionItems.add(paracetamol);
        prescriptionItems.add(amoxicillin);

        // Create test prescription
        testPrescription = new Prescription(1, testPatient.getUsername(), testPharmacist, prescriptionItems);
        testPrescription.setStatus("Active");

        // Add prescription to the service
        Prescription_Service.getInstance().AddPrescription(testPatient.getID(), testPrescription);
        /*________________________________________________________________________________ */
        // Create test items
        testItems = new HashMap<>();
        testItems.put("Vitamin_D3_1000IU", 2);
        testItems.put("Amoxicillin_250mg", 1);
        testItems.put("Paracetamol_500mg", 4);
    }

    @After
    public void tearDown() {
        // Clean up any test data
        if (testPatient != null) {
            patientService.RemovePatient(testPatient.getUsername());
        }
    }

    @Test
    public void testSingletonInstance() {
        Patient_Service instance1 = Patient_Service.getInstance();
        Patient_Service instance2 = Patient_Service.getInstance();
        assertSame("Singleton instances should be the same", instance1, instance2);
    }

    @Test
    public void testAddPatient_Success() {
        int result = patientService.AddPatient(testPatient);
        assertTrue("Patient should be added successfully", result > 0);
        
        Patient retrievedPatient = patientService.GetPatient(testPatient.getUsername());
        assertNotNull("Retrieved patient should not be null", retrievedPatient);
        assertEquals("Username should match", testPatient.getUsername(), retrievedPatient.getUsername());
    }

    @Test
    public void testAddPatient_Duplicate() {
        patientService.AddPatient(testPatient);
        int result = patientService.AddPatient(testPatient);
        assertEquals("Adding duplicate patient should fail", -1, result);
    }

    @Test
    public void testRemovePatient_Success() {
        patientService.AddPatient(testPatient);
        int result = patientService.RemovePatient(testPatient.getUsername());
        assertEquals("Patient should be removed successfully", 0, result);
        assertNull("Patient should no longer exist", patientService.GetPatient(testPatient.getUsername()));
    }

    @Test
    public void testUpdatePatient_Success() {
        patientService.AddPatient(testPatient);
        int result = patientService.UpdatePatient(testPatient.getUsername(), testPatient.getPassword(), "age", 30);
        assertTrue("Update should be successful", result > 0);
        
        Patient updatedPatient = patientService.GetPatient(testPatient.getUsername());
        assertEquals( 30, updatedPatient.getAge(),0.001f);
    }

    @Test
    public void testUpdatePatient_InvalidAuth() {
        patientService.AddPatient(testPatient);
        int result = patientService.UpdatePatient(testPatient.getUsername(), "wrongpass", "age", 30);
        assertEquals("Update should fail with wrong password", -1, result);
    }

    @Test
    public void testGetAllPatients() {
        patientService.AddPatient(testPatient);
        List<Patient> patients = patientService.GetAllPatients();
        assertNotNull("Patient list should not be null", patients);
        assertFalse("Patient list should not be empty", patients.isEmpty());
        assertTrue("Should contain test patient", patients.stream()
            .anyMatch(p -> p.getUsername().equals(testPatient.getUsername())));
    }

    @Test
    public void testGetPatientBalance() {
        patientService.AddPatient(testPatient);
        double initialBalance = patientService.GetPatientBalance(testPatient.getUsername());
        assertTrue("Initial balance should be valid", initialBalance >= 0);
        
        // Update balance
        patientService.UpdatePatient(testPatient.getUsername(), testPatient.getPassword(), 
            "PatientBalance", 100.0);
        double newBalance = patientService.GetPatientBalance(testPatient.getUsername());
        assertEquals("Balance should be updated", 100.0, newBalance, 0.001);
    }

    @Test
    public void testAuthenticatePatient_Success() {
        patientService.AddPatient(testPatient);
        boolean result = patientService.AuthenticatePatient(testPatient.getUsername(), testPatient.getPassword());
        assertTrue("Authentication should succeed with correct credentials", result);
    }

    @Test
    public void testAuthenticatePatient_Failure() {
        patientService.AddPatient(testPatient);
        boolean result = patientService.AuthenticatePatient(testPatient.getUsername(), "wrongpass");
        assertFalse("Authentication should fail with wrong password", result);
    }

    @Test
    public void testPlaceOrder_Success() {
        patientService.AddPatient(testPatient);
        int result = patientService.PlaceOrder(testItems, testPatient.getID(), testPharmacist);
        assertTrue("Order should be placed successfully", result > 0);
        
        List<Order> orders = patientService.GetPatientOrders(testPatient.getID());
        assertNotNull("Orders should not be null", orders);
        assertFalse("Orders should not be empty", orders.isEmpty());
    }

    @Test
    public void testPlaceOrder_InvalidPatient() {
        int result = patientService.PlaceOrder(testItems, -1, testPharmacist);
        assertEquals("Order should fail with invalid patient", -1, result);
    }

    @Test
    public void testPlaceOrderByPrescription_Success() {
        // Create a fresh patient for this test
        Patient isolatedPatient = new Patient(999, "isolatedUser", "testPass", "test@email.com", 
            "1234567890", 25.0f, "123 Test St", new HashSet<>(), new ArrayList<>(), testRoles);
        
        // Add the patient first
        int patientResult = patientService.AddPatient(isolatedPatient);
        assertEquals("Patient should be added successfully", 999, patientResult);
        Item newitem = new Item.builder()
            .setMedicName("TestMed_500mg")
            .setExpireDate("2025-12-31")
            .setCategory("Test Category")
            .setQuantity(10)
            .setUsage("Test usage")
            .setPrice(9.99)
            .set_Refundable(true)
            .setSideEffects(new HashSet<>())
            .setHealingEffects(new HashSet<>())
            .build();
        // Create a fresh prescription for this test
        Set<Item> isolatedItems = new HashSet<>();
        isolatedItems.add(newitem);
        
        assertEquals(0, Inventory_service.getInstance().AddNewItem(newitem));
        Prescription isolatedPrescription = new Prescription(999, isolatedPatient.getUsername(), testPharmacist, isolatedItems);
        isolatedPrescription.setStatus("Active");
        
        // Add the prescription
        int prescriptionResult = Prescription_Service.getInstance().AddPrescription(isolatedPatient.getID(), isolatedPrescription);
        assertEquals("Prescription should be added successfully", 999, prescriptionResult);
        
        // Test the order placement
        int orderResult = patientService.PlaceOrderByPrescription(isolatedPatient.getID(), 999);
        assertTrue("Order should be placed successfully", orderResult > 0);
        
        // Clean up
        patientService.RemovePatient(isolatedPatient.getUsername());
    }

    @Test
    public void testPlaceOrderByPrescription_InvalidPrescription() {
        patientService.AddPatient(testPatient);
        int result = patientService.PlaceOrderByPrescription(testPatient.getID(), -1);
        assertEquals("Order should fail with invalid prescription", -1, result);
    }

    @Test
    public void testGetPatient_NullName() {
        Patient result = patientService.GetPatient(null);
        assertNull("Getting patient with null name should return null", result);
    }

    @Test
    public void testGetPatient_NonExistent() {
        Patient result = patientService.GetPatient("NonExistentPatient");
        assertNull("Getting non-existent patient should return null", result);
    }

    @Test
    public void testUpdatePatient_InvalidField() {
        patientService.AddPatient(testPatient);
        int result = patientService.UpdatePatient(testPatient.getUsername(), testPatient.getPassword(), 
            "invalidField", "value");
        assertEquals("Update should fail with invalid field", -1, result);
    }

    @Test
    public void testUpdatePatient_InvalidValueType() {
        patientService.AddPatient(testPatient);
        int result = patientService.UpdatePatient(testPatient.getUsername(), testPatient.getPassword(), 
            "age", "notANumber");
        assertEquals("Update should fail with invalid value type", -1, result);
    }
}