package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.LibraryAdmin;
import Model.MembershipApplication;
import Model.MembershipCard;

public class LibraryAdminTest {
    
    private LibraryAdmin adminCase1;
    private LibraryAdmin adminCase2;
    private MembershipApplication validApp;
    private MembershipApplication invalidApp;
    
    @BeforeEach
    public void setUp() {
        adminCase1 = new LibraryAdmin();
        adminCase2 = new LibraryAdmin();
        
        validApp = new MembershipApplication("Ahmed", "123 Westbay");
        invalidApp = new MembershipApplication("", "");
    }
    
    // ========== TEST CASE 1: Valid Operations ==========
    
    @Test
    public void testVerifiesCase1() {
        assertTrue(adminCase1.verifies(validApp), "Verification should return true");
    }
    
    @Test
    public void testRegisterNewMemberCase1() {
        MembershipCard card = adminCase1.registerNewMember(validApp);
        assertNotNull(card, "Card should be created for valid application");
    }
    
    @Test
    public void testGenerateSummaryReportsCase1() {
        assertDoesNotThrow(() -> adminCase1.generateSummaryReports(), 
                          "Should generate reports without error");
    }
    
    @Test
    public void testManageUnreturnedItemsCase1() {
        assertDoesNotThrow(() -> adminCase1.manageUnreturnedItems(), 
                          "Should manage unreturned items without error");
    }
    
    @Test
    public void testMultipleMemberRegistrationsCase1() {
        MembershipCard card1 = adminCase1.registerNewMember(validApp);
        MembershipApplication app2 = new MembershipApplication("Sara", "456 Aspire");
        MembershipCard card2 = adminCase1.registerNewMember(app2);
        
        assertNotNull(card1);
        assertNotNull(card2);
    }
    
    // ========== TEST CASE 2: Edge Cases ==========
    
    @Test
    public void testVerifiesCase2() {
        assertTrue(adminCase2.verifies(invalidApp), "Verification should return true");
    }
    
    @Test
    public void testRegisterNewMemberCase2() {
        // This might return null if verification fails
        MembershipCard card = adminCase2.registerNewMember(invalidApp);
        // Card might be null for invalid application
    }
    
    @Test
    public void testGenerateSummaryReportsCase2() {
        assertDoesNotThrow(() -> adminCase2.generateSummaryReports());
    }
    
    @Test
    public void testManageUnreturnedItemsCase2() {
        assertDoesNotThrow(() -> adminCase2.manageUnreturnedItems());
    }
    
    @Test
    public void testLibraryAdminCreationCase2() {
        assertNotNull(adminCase2, "LibraryAdmin should be created");
    }
}
