module phase_two_SE {

	
	opens application to javafx.graphics, javafx.fxml;
    opens view to javafx.fxml;  // If you have controllers in view package
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
	requires org.junit.jupiter.api;
	requires ApacheJMeter.core;
	requires ApacheJMeter.java;  // Add this explicitly
    opens Controller to javafx.fxml;
    exports application;
}
