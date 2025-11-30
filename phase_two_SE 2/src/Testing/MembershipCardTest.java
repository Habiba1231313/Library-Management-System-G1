package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.MembershipCard;
import Model.Member;

public class MembershipCardTest {
	
	
    private MembershipCard cardCase1;
    private MembershipCard cardCase2;

    private Member member1;
    private Member member2;

    @BeforeEach
    public void setUp() {
        // Members for the cards
        member1 = new Member(1, "Habiba", "123 Aspire Park");
        member2 = new Member(2, "", ""); 

        // MembershipCard instances
        cardCase1 = new MembershipCard(101, member1);
        cardCase2 = new MembershipCard(102, member2);
    }

    // ========== TEST CASE 1: Valid MembershipCard ==========

    @Test
    public void testGetCardNumberCase1() {
        assertEquals(101, cardCase1.getCardNumber());
    }

    @Test
    public void testSetCardNumberCase1() {
        cardCase1.setCardNumber(201);
        assertEquals(201, cardCase1.getCardNumber());
    }

    @Test
    public void testGetMemberCase1() {
        assertEquals(member1, cardCase1.getMember());
    }

    @Test
    public void testSetMemberCase1() {
        Member newMember = new Member(3, "Ahmed", "456 Westbay");
        cardCase1.setMember(newMember);
        assertEquals(newMember, cardCase1.getMember());
    }

    // ========== TEST CASE 2: Empty values ==========

    @Test
    public void testGetCardNumberCase2() {
        assertEquals(102, cardCase2.getCardNumber());
    }

    @Test
    public void testSetCardNumberCase2() {
        cardCase2.setCardNumber(202);
        assertEquals(202, cardCase2.getCardNumber());
    }

    @Test
    public void testGetMemberCase2() {
        assertEquals(member2, cardCase2.getMember());
    }

    @Test
    public void testSetMemberCase2() {
        Member newMember = new Member(4, "Sara", "789 Doha");
        cardCase2.setMember(newMember);
        assertEquals(newMember, cardCase2.getMember());
    }
}
