package Model;

public class ItemFactory {

    public static Item createItem(String type, int callNumber, String title, int year) {

        switch(type.toLowerCase()) {

            case "book":
                return new Book(callNumber, title, year);

            case "digital":
                return new DigitalMedia(callNumber, title, year);

            case "magazine":
                return new Magazine(callNumber, title, year);

            default:
                return new Item(callNumber, title); // fallback
        }
    }
}
