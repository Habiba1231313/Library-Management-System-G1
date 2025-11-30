package Model;

import java.util.Date;

public class Loan {
    private int loanID;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;
    private boolean status;
    private double fineAmount;

    public Loan(int loanID, Date loanDate, Date dueDate, Date returnDate, boolean status, double fineAmount) {
		super();
		this.loanID = loanID;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
		this.fineAmount = fineAmount;
	}

	public boolean isOverDue() {
        return returnDate != null && returnDate.after(dueDate);
    }

    public void ApplyFineIfOverdue() {
        if (isOverDue()) {
            fineAmount += 10; // example logic
        }
    }

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
    
    
}

