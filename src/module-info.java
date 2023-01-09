module DigitalWorksheets {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.json;
	requires json.simple;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
