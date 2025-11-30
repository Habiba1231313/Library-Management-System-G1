package Controller;

import Model.*;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReservationController {

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField itemCallField;

    @FXML
    private Label resultLabel;

    // Use singleton instance
    private LibraryAdmin admin = LibraryAdmin.getInstance();
    private Member currentMember;

    @FXML
    public void initialize() {
        resultLabel.setText("Result: ---");
    }

    @FXML
    private void reserveItem() {
        // Clear previous result
        resultLabel.setText("");
        resultLabel.setStyle("-fx-text-fill: black;");

        // STEP 1-2: Validate member ID and retrieve membership details
        String memberIdText = memberIdField.getText().trim();
        if (memberIdText.isEmpty()) {
            showError("Please enter Member ID");
            return;
        }

        int memberId;
        try {
            memberId = Integer.parseInt(memberIdText);
        } catch (NumberFormatException e) {
            showError("Member ID must be a number");
            return;
        }

        // Find member from the SHARED admin instance
        currentMember = admin.findMemberById(memberId);
        if (currentMember == null) {
            showError("Member not found. Please check Member ID.");
            return;
        }

        // STEP 3: Check total number of reserved items
        if (currentMember.getTotalReserved() >= 5) {
            showError("Maximum reservations reached. You have already reserved 5 items.");
            return;
        }

        // STEP 4-5: Member enters item call number
        String callNumberText = itemCallField.getText().trim();
        if (callNumberText.isEmpty()) {
            showError("Please enter Item Call Number");
            return;
        }

        int callNumber;
        try {
            callNumber = Integer.parseInt(callNumberText);
        } catch (NumberFormatException e) {
            showError("Call Number must be a number");
            return;
        }

        // STEP 6: Retrieve item details
        Item item = findItemByCallNumber(callNumber);
        if (item == null) {
            showError("Item not found with call number: " + callNumber);
            return;
        }
        if (item.isReserved() == true) {
            showError("Item with call number is reserved: " + callNumber);
            return;
        }

        // STEP 7: Check if item is already reserved
        if (item.isReserved()) {
            showError("Item '" + item.getTitle() + "' is already reserved by another member");
            return;
        }

        // STEP 8: Reserve the item under member account
        boolean success = currentMember.ReserveItem(item);
        item.setReserved(true);

        if (success) {
            // STEP 9: Confirm reservation to member
            showSuccess("Success! Item '" + item.getTitle() + "' reserved successfully.\n" +
                       "Member: " + currentMember.getName() + " | " +
                       "Total Reserved: " + currentMember.getTotalReserved() + "/3");

            // Clear fields for next reservation
            itemCallField.clear();
        } else {
            showError("Reservation failed. Please try again.");
        }
    }

    private Item findItemByCallNumber(int callNumber) {
        // Demo items for testing
        // Instead of manually creating Items, we use the Factory
        Item item1 = ItemFactory.createItem("book", 101, "Java Programming", 2021);
        Item item2 = ItemFactory.createItem("book", 102, "Data Structures", 2020);
        Item item3 = ItemFactory.createItem("digital", 103, "Algorithms (Digital Media)", 2023);
        Item item4 = ItemFactory.createItem("magazine", 104, "Database Monthly Magazine", 2024);
        Item item5 = ItemFactory.createItem("book", 105, "Software Engineering", 2022);

        Item[] demoItems = {item1, item2, item3, item4, item5};

        for (Item item : demoItems) {
            if (item.getCallNumber() == callNumber) {
                return item;
            }
        }
        return null;
    }

    @FXML
    public void handleGoToRegister() {
        try {
            Main.showRegisterView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showError(String message) {
        resultLabel.setText("Error: " + message);
        resultLabel.setStyle("-fx-text-fill: red;");
    }

    private void showSuccess(String message) {
        resultLabel.setText(message);
        resultLabel.setStyle("-fx-text-fill: green;");
    }
}