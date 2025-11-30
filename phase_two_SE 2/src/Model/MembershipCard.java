package Model;

public class MembershipCard {
    int cardNumber;
    Member member;

    public MembershipCard(int number, Member member) {
        this.cardNumber = number;
        this.member = member;
    }

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
    
    
}
