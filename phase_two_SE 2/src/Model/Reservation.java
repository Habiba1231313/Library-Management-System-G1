package Model;

import java.util.Date;

public class Reservation {
    private int ID;
    private Date reservationDate;
    private Member m; 
    private Item item;
    
    public Reservation(int id, Member member, Item item) {
        this.ID = id;
        this.m = member;
        this.item = item;
        this.reservationDate = new Date();
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member m) {
		this.m = m;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
    
    
    
    
}
