package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.MembershipApplication;

public class MembershipApplicationTest {
    
    private MembershipApplication appCase1;
    private MembershipApplication appCase2;
    
    @BeforeEach
    public void setUp() {
        appCase1 = new MembershipApplication("Habiba", "habiba@qu.edu.qa");
        appCase2 = new MembershipApplication();
    }
    
    // ========== TEST CASE 1: Valid Application ==========
    
    @Test
    public void testConstructorCase1() {
        assertEquals("Habiba", appCase1.getName());
        assertEquals("habiba@qu.edu.qa", appCase1.getAddress());
        assertFalse(appCase1.isVerified());
    }
    
    @Test
    public void testVerifyApplicationCase1() {
        appCase1.VerifyApplication();
        assertTrue(appCase1.isVerified());
    }
    
    @Test
    public void testSetNameCase1() {
        appCase1.setName("Ahmed");
        assertEquals("Ahmed", appCase1.getName());
    }
    
    @Test
    public void testSetAddressCase1() {
        appCase1.setAddress("new@address.com");
        assertEquals("new@address.com", appCase1.getAddress());
    }
    
    @Test
    public void testSetApplicationIDCase1() {
        appCase1.setApplicationID(100);
        assertEquals(100, appCase1.getApplicationID());
    }
    
    @Test
    public void testGetApplicationIDCase1() {
        appCase1.setApplicationID(50);
        assertEquals(50, appCase1.getApplicationID());
    }
    
    @Test
    public void testGetNameCase1() {
        assertEquals("Habiba", appCase1.getName());
    }
    
    @Test
    public void testGetAddressCase1() {
        assertEquals("habiba@qu.edu.qa", appCase1.getAddress());
    }
    
    // ========== TEST CASE 2: No-Arg Constructor ==========
    
    @Test
    public void testConstructorCase2() {
        assertFalse(appCase2.isVerified());
    }
    
    @Test
    public void testSetVerifiedCase2() {
        appCase2.setVerified(true);
        assertTrue(appCase2.isVerified());
    }
    
    @Test
    public void testSetNameCase2() {
        appCase2.setName("Test User");
        assertEquals("Test User", appCase2.getName());
    }
    
    @Test
    public void testSetAddressCase2() {
        appCase2.setAddress("test@qu.edu");
        assertEquals("test@qu.edu", appCase2.getAddress());
    }
    
    @Test
    public void testVerifyApplicationCase2() {
        assertFalse(appCase2.isVerified());
        appCase2.VerifyApplication();
        assertTrue(appCase2.isVerified());
    }
}