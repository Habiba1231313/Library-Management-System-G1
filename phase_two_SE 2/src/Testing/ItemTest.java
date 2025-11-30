package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Item;

public class ItemTest {
    
    // Test Case 1: Valid item
    private Item itemCase1;
    
    // Test Case 2: Another item with different values
    private Item itemCase2;
    
    @BeforeEach
    public void setUp() {
        itemCase1 = new Item(101, "pride and prejudice");
        itemCase2 = new Item(0, "");
    }
    
    // ========== TEST CASE 1: Valid Item ==========
    
    @Test
    public void testCheckAvailabilityCase1() {
        assertTrue(itemCase1.checkAvailability(), "New item should be available");
    }
    
    @Test
    public void testMarkLostCase1() {
        itemCase1.markLost();
        assertTrue(itemCase1.isLost(), "Item should be marked as lost");
    }
    
    @Test
    public void testMarkReturnedCase1() {
        itemCase1.markLost();
        itemCase1.markReturned();
        assertTrue(itemCase1.checkAvailability(), "Item should be available after return");
    }
    
    @Test
    public void testItemConstructorCase1() {
        testCheckAvailabilityCase1();
    }
    
    @Test
    public void testMarkLostThenReturnCase1() {
        itemCase1.markLost();
        itemCase1.markReturned();
        assertTrue(itemCase1.checkAvailability());
    }
    
    // ========== TEST CASE 2: Empty Values ==========
    
    @Test
    public void testCheckAvailabilityCase2() {
        assertTrue(itemCase2.checkAvailability(), "Item should be available by default");
    }
    
    @Test
    public void testMarkLostCase2() {
        itemCase2.markLost();
        // Item is marked as lost
    }
    
    @Test
    public void testMarkReturnedCase2() {
        itemCase2.markReturned();
        assertTrue(itemCase2.checkAvailability());
    }
    
    @Test
    public void testItemConstructorCase2() {
        testCheckAvailabilityCase2();
    }
}