package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Loan;
import java.util.Date;
import java.util.Calendar;

public class LoanTest {
    
    private Loan loanCase1;
    private Loan loanCase2;
    
    // Dates for testing
    private Date loanDate1;
    private Date dueDate1;
    private Date returnDate1;
    
    private Date loanDate2;
    private Date dueDate2;
    
    @BeforeEach
    public void setUp() {
        // Set up dates for test case 1 (overdue loan with constructor)
        Calendar cal = Calendar.getInstance();
        loanDate1 = cal.getTime();
        
        cal.add(Calendar.DATE, -10); // Due date 10 days ago
        dueDate1 = cal.getTime();
        
        cal.add(Calendar.DATE, 5); // Returned 5 days late
        returnDate1 = cal.getTime();
        
        // Test Case 1: Using parameterized constructor with overdue loan
        loanCase1 = new Loan(1001, loanDate1, dueDate1, returnDate1, true, 0.0);
        
        // Set up dates for test case 2 (not overdue)
        Calendar cal2 = Calendar.getInstance();
        loanDate2 = cal2.getTime();
        cal2.add(Calendar.DATE, 10); // Due date in future
        dueDate2 = cal2.getTime();
        
        // Test Case 2: Using parameterized constructor, no return date
        loanCase2 = new Loan(1002, loanDate2, dueDate2, null, false, 0.0);
    }
    
    // ========== CONSTRUCTOR TESTS ==========
    
    @Test
    public void testLoanConstructorCase1() {
        // Test all fields are set correctly via constructor
        assertEquals(1001, loanCase1.getLoanID(), "Loan ID should be 1001");
        assertEquals(loanDate1, loanCase1.getLoanDate(), "Loan date should match");
        assertEquals(dueDate1, loanCase1.getDueDate(), "Due date should match");
        assertEquals(returnDate1, loanCase1.getReturnDate(), "Return date should match");
        assertTrue(loanCase1.isStatus(), "Status should be true");
        assertEquals(0.0, loanCase1.getFineAmount(), 0.01, "Initial fine should be 0");
    }
    
    @Test
    public void testLoanConstructorCase2() {
        // Test constructor with null return date
        assertEquals(1002, loanCase2.getLoanID(), "Loan ID should be 1002");
        assertEquals(loanDate2, loanCase2.getLoanDate(), "Loan date should match");
        assertEquals(dueDate2, loanCase2.getDueDate(), "Due date should match");
        assertNull(loanCase2.getReturnDate(), "Return date should be null");
        assertFalse(loanCase2.isStatus(), "Status should be false");
        assertEquals(0.0, loanCase2.getFineAmount(), 0.01, "Initial fine should be 0");
    }
    
    @Test
    public void testLoanConstructorWithFineCase1() {
        // Test constructor with initial fine amount
        Loan loanWithFine = new Loan(1003, loanDate1, dueDate1, returnDate1, true, 25.50);
        assertEquals(25.50, loanWithFine.getFineAmount(), 0.01, "Fine should be 25.50");
    }
    
    @Test
    public void testLoanConstructorWithAllNullDates() {
        // Test constructor with null dates
        Loan loanNullDates = new Loan(1004, null, null, null, false, 0.0);
        assertEquals(1004, loanNullDates.getLoanID());
        assertNull(loanNullDates.getLoanDate());
        assertNull(loanNullDates.getDueDate());
        assertNull(loanNullDates.getReturnDate());
    }
    
    // ========== TEST CASE 1: Overdue Loan ==========
    
    @Test
    public void testIsOverDueCase1() {
        assertTrue(loanCase1.isOverDue(), "Loan should be overdue");
    }
    
    @Test
    public void testApplyFineIfOverdueCase1() {
        double initialFine = loanCase1.getFineAmount();
        loanCase1.ApplyFineIfOverdue();
        assertEquals(initialFine + 10, loanCase1.getFineAmount(), 0.01, 
                     "Fine should be increased by 10");
    }
    
    @Test
    public void testGetFineAmountCase1() {
        loanCase1.ApplyFineIfOverdue();
        assertTrue(loanCase1.getFineAmount() >= 10, "Fine should be at least 10");
    }
    
    @Test
    public void testGetLoanIDCase1() {
        assertEquals(1001, loanCase1.getLoanID(), "Loan ID should be 1001");
    }
    
    @Test
    public void testGetLoanDateCase1() {
        assertEquals(loanDate1, loanCase1.getLoanDate(), "Loan date should match");
    }
    
    @Test
    public void testGetDueDateCase1() {
        assertEquals(dueDate1, loanCase1.getDueDate(), "Due date should match");
    }
    
    @Test
    public void testGetReturnDateCase1() {
        assertEquals(returnDate1, loanCase1.getReturnDate(), "Return date should match");
    }
    
    @Test
    public void testSetLoanIDCase1() {
        loanCase1.setLoanID(12345);
        assertEquals(12345, loanCase1.getLoanID());
    }
    
    @Test
    public void testSetStatusCase1() {
        loanCase1.setStatus(false);
        assertFalse(loanCase1.isStatus());
    }
    
    @Test
    public void testSetFineAmountCase1() {
        loanCase1.setFineAmount(50.0);
        assertEquals(50.0, loanCase1.getFineAmount(), 0.01);
    }
    
    @Test
    public void testMultipleFineApplicationsCase1() {
        // Apply fine multiple times
        loanCase1.ApplyFineIfOverdue();
        double firstFine = loanCase1.getFineAmount();
        loanCase1.ApplyFineIfOverdue();
        assertEquals(firstFine + 10, loanCase1.getFineAmount(), 0.01, 
                     "Fine should increase by 10 each time");
    }
    
    // ========== TEST CASE 2: Not Overdue ==========
    
    @Test
    public void testIsOverDueCase2() {
        assertFalse(loanCase2.isOverDue(), "Loan should not be overdue (no return date)");
    }
    
    @Test
    public void testApplyFineIfOverdueCase2() {
        double initialFine = loanCase2.getFineAmount();
        loanCase2.ApplyFineIfOverdue();
        assertEquals(initialFine, loanCase2.getFineAmount(), 0.01, 
                     "Fine should not increase for non-overdue loan");
    }
    
    @Test
    public void testGetFineAmountCase2() {
        assertEquals(0, loanCase2.getFineAmount(), 0.01, 
                     "Initial fine should be 0");
    }
    
    @Test
    public void testGetLoanIDCase2() {
        assertEquals(1002, loanCase2.getLoanID(), "Loan ID should be 1002");
    }
    
    @Test
    public void testGetLoanDateCase2() {
        assertEquals(loanDate2, loanCase2.getLoanDate(), "Loan date should match");
    }
    
    @Test
    public void testGetDueDateCase2() {
        assertEquals(dueDate2, loanCase2.getDueDate(), "Due date should match");
    }
    
    @Test
    public void testGetReturnDateCase2() {
        assertNull(loanCase2.getReturnDate(), "Return date should be null");
    }
    
    @Test
    public void testSetLoanIDCase2() {
        loanCase2.setLoanID(54321);
        assertEquals(54321, loanCase2.getLoanID());
    }
    
    @Test
    public void testSetStatusCase2() {
        loanCase2.setStatus(true);
        assertTrue(loanCase2.isStatus());
    }
    
    @Test
    public void testSetReturnDateCase2() {
        // Set return date for a loan that didn't have one
        Calendar cal = Calendar.getInstance();
        Date newReturnDate = cal.getTime();
        loanCase2.setReturnDate(newReturnDate);
        assertEquals(newReturnDate, loanCase2.getReturnDate());
    }
    
    @Test
    public void testSetDueDateCase2() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 20);
        Date newDueDate = cal.getTime();
        loanCase2.setDueDate(newDueDate);
        assertEquals(newDueDate, loanCase2.getDueDate());
    }
    
    // ========== INTEGRATION TESTS ==========
    
    @Test
    public void testLoanLifecycle() {
        // Create a new loan
        Calendar cal = Calendar.getInstance();
        Date loanDate = cal.getTime();
        cal.add(Calendar.DATE, 7);
        Date dueDate = cal.getTime();
        
        Loan loan = new Loan(2001, loanDate, dueDate, null, false, 0.0);
        
        // Initially not overdue
        assertFalse(loan.isOverDue());
        
        // Simulate late return
        cal.add(Calendar.DATE, 5); // 5 days after due date
        loan.setReturnDate(cal.getTime());
        
        // Now it's overdue
        assertTrue(loan.isOverDue());
        
        // Apply fine
        loan.ApplyFineIfOverdue();
        assertTrue(loan.getFineAmount() > 0);
    }
}
