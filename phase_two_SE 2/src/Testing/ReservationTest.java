package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import Model.Member;
import Model.Item;
import Model.Reservation;

public class ReservationTest {

    private Reservation reservationCase1;
    private Reservation reservationCase2;

    private Member member1;
    private Member member2;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        member1 = new Member(1, "Habiba", "123 Aspire Park");
        member2 = new Member(2, "Ahmed", "456 Westbay");

        item1 = new Item(101, "Book A");
        item2 = new Item(102, "Book B");

        reservationCase1 = new Reservation(1, member1, item1);
        reservationCase2 = new Reservation(2, member2, item2);
    }

    // ========== TEST CASE 1: Normal Reservation ==========
    @Test
    public void testGetIDCase1() {
        assertEquals(1, reservationCase1.getID());
    }

    @Test
    public void testSetIDCase1() {
        reservationCase1.setID(10);
        assertEquals(10, reservationCase1.getID());
    }

    @Test
    public void testGetMemberCase1() {
        assertEquals(member1, reservationCase1.getM());
    }

    @Test
    public void testSetMemberCase1() {
        reservationCase1.setM(member2);
        assertEquals(member2, reservationCase1.getM());
    }

    @Test
    public void testGetItemCase1() {
        assertEquals(item1, reservationCase1.getItem());
    }

    @Test
    public void testSetItemCase1() {
        reservationCase1.setItem(item2);
        assertEquals(item2, reservationCase1.getItem());
    }

    @Test
    public void testGetReservationDateCase1() {
        assertNotNull(reservationCase1.getReservationDate(), "Reservation date should be initialized");
    }

    @Test
    public void testSetReservationDateCase1() {
        Date newDate = new Date(2025, 11, 25);
        reservationCase1.setReservationDate(newDate);
        assertEquals(newDate, reservationCase1.getReservationDate());
    }

    // ========== TEST CASE 2: Another Reservation ==========
    @Test
    public void testGetIDCase2() {
        assertEquals(2, reservationCase2.getID());
    }

    @Test
    public void testSetIDCase2() {
        reservationCase2.setID(20);
        assertEquals(20, reservationCase2.getID());
    }

    @Test
    public void testGetMemberCase2() {
        assertEquals(member2, reservationCase2.getM());
    }

    @Test
    public void testSetMemberCase2() {
        reservationCase2.setM(member1);
        assertEquals(member1, reservationCase2.getM());
    }

    @Test
    public void testGetItemCase2() {
        assertEquals(item2, reservationCase2.getItem());
    }

    @Test
    public void testSetItemCase2() {
        reservationCase2.setItem(item1);
        assertEquals(item1, reservationCase2.getItem());
    }

    
}
