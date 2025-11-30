package Model;

import java.util.ArrayList;

import adapter.UniversitySystemAdapter;
import adapter.PearlSysAdapter;
import adapter.FinanceSystemAdapter;
import adapter.FinanceSysAdapter;

public class LibraryAdmin {
    // Singleton instance
    private static LibraryAdmin instance = null;
    
    public ArrayList<Loan> loans = new ArrayList<>();
    public ArrayList<Member> members = new ArrayList<>();
    
    private int nextMemberID = 1;
    private int nextCardID = 1000;
    
    UniversitySystem uni = new UniversitySystem();
    FinanceSys finance = new FinanceSys();

    // Private constructor to prevent direct instantiation
    public LibraryAdmin() {
    }
    
    /**
     * Get the singleton instance
     */
    public static LibraryAdmin getInstance() {
        if (instance == null) {
            instance = new LibraryAdmin();
        }
        return instance;
    }

    /**
     * STEP 3 of Register Use Case: Admin verifies application
     */
    public boolean verifies(MembershipApplication app) {
        app.VerifyApplication();
        return app.isVerified();
    }

    /**
     * STEPS 4-12 of Register Use Case: Complete registration process
     */
    public MembershipCard registerNewMember(MembershipApplication app) {
        // STEP 5-6: University system verification
    	// Adapter for UniversitySystem (PearlSys)
    	
    	UniversitySystemAdapter uniAdapter = new PearlSysAdapter();
    	boolean verified = uniAdapter.verifyApplicant(app);
        
        // Alternative flow 6a: If verification fails, return null
        if (!verified) {
            System.out.println("University verification failed");
            return null;
        }
        
        // STEP 7-9: Request FinanceSys to transfer deposit
        // Adapter for FinanceSys
        FinanceSystemAdapter financeAdapter = new FinanceSysAdapter();
        boolean transfer = financeAdapter.transferDeposit(1000f);
        
        // Alternative flow 9a: If transfer fails, return null
        if (!transfer) {
            System.out.println("Financial transfer failed");
            return null;
        }
        
        // STEP 10: Create membership account and deposit money
        Member newMember = new Member(nextMemberID++, app.name, app.address);
        
        // STEP 11: Prepare membership card and assign unique number
        MembershipCard card = new MembershipCard(nextCardID++, newMember);
        newMember.setCard(card);
        
        // Store member in system
        members.add(newMember);
        
        // STEP 12: Send card to member (in GUI, displayed on screen)
        System.out.println("Card issued: " + card.getCardNumber() + " to " + newMember.getName());
        
        return card;
    }

    public void manageUnreturnedItems() {
        for (Loan loan : loans) {
            if (loan.isOverDue()) {
                loan.ApplyFineIfOverdue();
            }
        }
    }

    public void generateSummaryReports() {
        System.out.println("Total Loans: " + loans.size());
        System.out.println("Total Members: " + members.size());
    }
    
    /**
     * Helper method to find member by ID
     */
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberID() == memberId) {
                return member;
            }
        }
        return null;
    }
    
    /**
     * Get next available member ID (for testing/display)
     */
    public int getNextMemberID() {
        return nextMemberID;
    }
    
    /**
     * Get next available card ID (for testing/display)
     */
    public int getNextCardID() {
        return nextCardID;
    }

	public Item findItemByCallNumber(int i) {
	
		return null;
	}
}