package Model;

public class Magazine extends Item {

    public Magazine(int callNumber, String title, int year) {
        super(callNumber, title);
        this.setYear(year);
    }

}
