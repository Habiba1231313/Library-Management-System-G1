package Model;

public class DigitalMedia extends Item {
	
	 public DigitalMedia(int callNumber, String title, int year) {
	        super(callNumber, title);
	        this.setYear(year);
	    }
}
