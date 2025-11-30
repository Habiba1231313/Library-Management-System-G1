package Controller;

import Model.LibraryAdmin;
import application.Main;
import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private Label statusLabel;
    
    // Use singleton instance
    private LibraryAdmin admin = LibraryAdmin.getInstance();
    
    @FXML
    public void initialize() {
        statusLabel.setText("Status: ---");
    }
    
    @FXML
    private void registerMember() {
        // Clear previous status
        statusLabel.setText("");
        statusLabel.setStyle("-fx-text-fill: black;");
        
        // STEP 1: Person submits application form
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        
        // Validate empty fields
        if (name.isEmpty() || email.isEmpty()) {
            showError("All fields are required!");
            return;
        }
        
        // Basic email validation
        if (!email.contains("@") || !email.contains(".")) {
            showError("Invalid email format!");
            return;
        }
        
        // STEP 2: Store application and alert admin
        MembershipApplication app = new MembershipApplication(name, email);
        System.out.println("Application submitted: " + name);
        
        // STEP 3: Admin checks application
        boolean adminVerified = admin.verifies(app);
        if (!adminVerified) {
            showError("Application verification failed");
            return;
        }
        
        // STEP 10-12: Create membership, deposit money, prepare card, send to member
        MembershipCard card = admin.registerNewMember(app);
        
        if (card != null) {
            showSuccess("Member Registered Successfully!\n" +
                       "Member ID: " + card.getMember().getMemberID() + "\n" +
                       "Card Number: " + card.getCardNumber() + "\n" +
                       "Name: " + card.getMember().getName());
            
            // Clear fields
            nameField.clear();
            emailField.clear();
        } else {
            showError("Registration Failed. University verification or payment failed.");
        }
    }
    
    @FXML
    public void handleGoToReserve() {
        try {
            Main.showReserveView();
        } catch (Exception e) {
            e.printStackTrace();
            showError("Failed to open reservation view");
        }
    }
    
    private void showError(String message) {
        statusLabel.setText("Error: " + message);
        statusLabel.setStyle("-fx-text-fill: red;");
    }
    
    private void showSuccess(String message) {
        statusLabel.setText(message);
        statusLabel.setStyle("-fx-text-fill: green;");
    }
}