package Model;

public class Book extends Item {
	
	  public Book(int callNumber, String title, int year) {
	        super(callNumber, title);
	        this.setYear(year);
	    }
}
