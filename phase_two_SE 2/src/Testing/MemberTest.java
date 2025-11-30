package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Member;
import Model.Item;
import Model.MembershipCard;

public class MemberTest {
    
    private Member memberCase1;
    private Member memberCase2;
    
    @BeforeEach
    public void setUp() {
        memberCase1 = new Member(1, "Habiba", "123 gharaffa");
        memberCase2 = new Member(2, "Ahmed", "456 westbay");
    }
    
    // ========== TEST CASE 1: Valid Member ==========
    
    @Test
    public void testMemberConstructorCase1() {
        assertEquals(1, memberCase1.getMemberID());
        assertEquals("Habiba", memberCase1.getName());
        assertEquals("123 gharaffa", memberCase1.getAddress());
        assertEquals(0, memberCase1.getTotalBorrowed());
        assertEquals(0, memberCase1.getTotalReserved());
    }
    
    @Test
    public void testReserveItemCase1() {
        Item item = new Item(101, "Java Programming");
        boolean success = memberCase1.ReserveItem(item);
        
        assertTrue(success, "Reservation should succeed");
        assertEquals(1, memberCase1.getTotalReserved());
        assertFalse(item.isAvailable(), "Item should be unavailable after reservation");
    }
    
    @Test
    public void testReserveMultipleItemsCase1() {
        Item item1 = new Item(101, "Java Programming");
        Item item2 = new Item(102, "Data Structures");
        Item item3 = new Item(103, "Algorithms");
        
        assertTrue(memberCase1.ReserveItem(item1));
        assertTrue(memberCase1.ReserveItem(item2));
        assertTrue(memberCase1.ReserveItem(item3));
        
        assertEquals(3, memberCase1.getTotalReserved());
    }
    
    @Test
    public void testReserveMaximumLimitCase1() {
        // Reserve 3 items (maximum)
        Item item1 = new Item(101, "Java");
        Item item2 = new Item(102, "Data");
        Item item3 = new Item(103, "Algo");
        
        memberCase1.ReserveItem(item1);
        memberCase1.ReserveItem(item2);
        memberCase1.ReserveItem(item3);
        
        // Try to reserve 4th item (should fail)
        Item item4 = new Item(104, "Database");
        boolean success = memberCase1.ReserveItem(item4);
        
        assertFalse(success, "Should not allow more than 3 reservations");
        assertEquals(3, memberCase1.getTotalReserved());
    }
    
    @Test
    public void testReserveUnavailableItemCase1() {
        Item item = new Item(101, "Java Programming");
        item.setAvailable(false);
        
        boolean success = memberCase1.ReserveItem(item);
        assertFalse(success, "Should not reserve unavailable item");
    }
    
    @Test
    public void testBorrowItemCase1() {
        Item item = new Item(101, "Java Programming");
        memberCase1.BorrowItem(item);
        
        assertEquals(1, memberCase1.getTotalBorrowed());
        assertEquals(1, memberCase1.getBorrowedItems().size());
    }
    
    @Test
    public void testSetCardCase1() {
        MembershipCard card = new MembershipCard(1000, memberCase1);
        memberCase1.setCard(card);
        
        assertNotNull(memberCase1.getCard());
        assertEquals(1000, memberCase1.getCard().getCardNumber());
    }
    
    @Test
    public void testGetReservedItemsCase1() {
        Item item1 = new Item(101, "Java");
        Item item2 = new Item(102, "Data");
        
        memberCase1.ReserveItem(item1);
        memberCase1.ReserveItem(item2);
        
        assertEquals(2, memberCase1.getReservedItems().size());
    }
    
    @Test
    public void testGetReservationsCase1() {
        Item item = new Item(101, "Java");
        memberCase1.ReserveItem(item);
        
        assertEquals(1, memberCase1.getReservations().size());
    }
    
    // ========== TEST CASE 2: Another Member ==========
    
    @Test
    public void testMemberConstructorCase2() {
        assertEquals(2, memberCase2.getMemberID());
        assertEquals("Ahmed", memberCase2.getName());
        assertEquals("456 westbay", memberCase2.getAddress());
    }
    
    @Test
    public void testReserveItemCase2() {
        Item item = new Item(105, "Software Engineering");
        assertTrue(memberCase2.ReserveItem(item));
        assertEquals(1, memberCase2.getTotalReserved());
    }
    
    @Test
    public void testCancelReservationCase2() {
        Item item = new Item(101, "Java Programming");
        memberCase2.ReserveItem(item);
        
        memberCase2.cancelReservation(item);
        
        assertEquals(0, memberCase2.getTotalReserved());
        assertTrue(item.isAvailable(), "Item should be available after cancellation");
    }
    
    @Test
    public void testReturnItemCase2() {
        Item item = new Item(101, "Java");
        memberCase2.BorrowItem(item);
        
        memberCase2.returnItem(item);
        
        assertEquals(0, memberCase2.getBorrowedItems().size());
    }
    
    @Test
    public void testSetNameCase2() {
        memberCase2.setName("Sara");
        assertEquals("Sara", memberCase2.getName());
    }
    
    @Test
    public void testSetAddressCase2() {
        memberCase2.setAddress("789 doha");
        assertEquals("789 doha", memberCase2.getAddress());
    }
}