package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        showRegisterView();
    }
    
    public static void showRegisterView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/RegisterView.fxml"));
        Scene scene = new Scene((Parent) loader.load(), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Library System - Register");
        primaryStage.show();
    }
    
    public static void showReserveView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ReserveView.fxml"));
        Scene scene = new Scene((Parent) loader.load(), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Library System - Reserve");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}