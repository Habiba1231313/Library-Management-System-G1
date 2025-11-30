package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Applicant;
import Model.MembershipApplication;

public class ApplicantTest {
    
    // Test Case 1: Testing with valid name and address
    private Applicant applicantCase1;
    
    // Test Case 2: Testing with empty/null values
    private Applicant applicantCase2;
    
    @BeforeEach
    public void setUp() {
        // Test Case 1: Valid applicant
        applicantCase1 = new Applicant("Habiba", "123 aspire park");
        
        // Test Case 2: Empty values (simulating no-arg constructor behavior)
        applicantCase2 = new Applicant("", "");
    }
    
    // ========== TEST CASE 1: Valid Applicant ==========
    
    @Test
    public void testGetNameCase1() {
        assertEquals("Habiba", applicantCase1.getName());
    }
    
    @Test
    public void testGetAddressCase1() {
        assertEquals("123 aspire park", applicantCase1.getAddress());
    }
    
    @Test
    public void testSubmitApplicationCase1() {
        MembershipApplication app = applicantCase1.submitApplication();
        assertNotNull(app, "Application should not be null");
    }
    
    @Test
    public void testSetNameCase1() {
        applicantCase1.setName("Ahmed");
        assertEquals("Ahmed", applicantCase1.getName());
    }
    
    @Test
    public void testSetAddressCase1() {
        applicantCase1.setAddress("456 westbay");
        assertEquals("456 westbay", applicantCase1.getAddress());
    }
    
    @Test
    public void testApplicantConstructorCase1() {
        // Test the constructor by testing all getters
        testGetNameCase1();
        testGetAddressCase1();
    }
    
    // ========== TEST CASE 2: Empty Values ==========
    
    @Test
    public void testGetNameCase2() {
        assertEquals("", applicantCase2.getName());
    }
    
    @Test
    public void testGetAddressCase2() {
        assertEquals("", applicantCase2.getAddress());
    }
    
    @Test
    public void testSubmitApplicationCase2() {
        MembershipApplication app = applicantCase2.submitApplication();
        assertNotNull(app, "Application should be created even with empty values");
    }
    
    @Test
    public void testSetNameCase2() {
        applicantCase2.setName("Sara");
        assertEquals("Sara", applicantCase2.getName());
    }
    
    @Test
    public void testSetAddressCase2() {
        applicantCase2.setAddress("789 doha");
        assertEquals("789 doha", applicantCase2.getAddress());
    }
    
    @Test
    public void testApplicantConstructorCase2() {
        // Test the constructor by testing all getters
        testGetNameCase2();
        testGetAddressCase2();
    }
}