package Model;

import java.util.ArrayList;

public class Member {
    protected int memberID;
    protected String name;
    protected String address;
    protected int totalBorrowed;
    protected int totalReserved;
    private MembershipCard card;
    private ArrayList<Item> borrowedItems = new ArrayList<>();
    private ArrayList<Item> reservedItems = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    
    // Maximum reservation limit as per use case
    private static final int MAX_RESERVATIONS = 3;

    public Member(int memberID, String name, String address) {
        this.memberID = memberID;
        this.name = name;
        this.address = address;
        this.totalBorrowed = 0;
        this.totalReserved = 0;
    }

    /**
     * Reserve item following use case specification
     * Returns false if:
     * - Already at max reservations (3)
     * - Item is not available
     */
    public boolean ReserveItem(Item item) {
        // Check maximum reservation limit (use case precondition 4)
        if (totalReserved >= MAX_RESERVATIONS) {
            return false;
        }
        
        // Check if item is available (use case precondition 3)
        if (!item.isAvailable()) {
            return false;
        }
        
        // Reserve the item
        reservedItems.add(item);
        totalReserved++;
        item.setAvailable(false);
        
        // Create reservation record
        Reservation r = new Reservation(reservations.size() + 1, this, item);
        reservations.add(r);
        
        return true;
    }

    public void BorrowItem(Item item) {
        borrowedItems.add(item);
        totalBorrowed++;
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }
    
    public void cancelReservation(Item item) {
        if (reservedItems.remove(item)) {
            totalReserved--;
            item.setAvailable(true);
        }
    }

    // Getters and Setters
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalBorrowed() {
        return totalBorrowed;
    }

    public void setTotalBorrowed(int totalBorrowed) {
        this.totalBorrowed = totalBorrowed;
    }

    public int getTotalReserved() {
        return totalReserved;
    }

    public void setTotalReserved(int totalReserved) {
        this.totalReserved = totalReserved;
    }

    public MembershipCard getCard() {
        return card;
    }

    public void setCard(MembershipCard card) {
        this.card = card;
    }

    public ArrayList<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(ArrayList<Item> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public ArrayList<Item> getReservedItems() {
        return reservedItems;
    }

    public void setReservedItems(ArrayList<Item> reservedItems) {
        this.reservedItems = reservedItems;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}