package application;

import application.Helpers.Crypt;
import application.Helpers.FileSystem;

import application.Tabs.InfoTab;
import application.Tabs.StartTab;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Crypt crypto = new Crypt(); // Objekt Crypt zum Verschlüsseln
			FileSystem fs = new FileSystem(); // Object FileSystem um Dateien zu lesen und zu schreiben

			TabPane root = new TabPane();
			root.getStyleClass().add("root");

			/*Tab start*/
			Tab startTab = new Tab("Start");
			startTab.setClosable(false);

			/*Tab bearbeiten*/
			Tab bearbeitenTab = new Tab("Bearbeiten");
			bearbeitenTab.setClosable(false);

			/*Tab vergleichen*/
			Tab vergleichenTab = new Tab("Vergleichen");
			vergleichenTab.setClosable(false);
			
			/*Tab erstellen*/
			Tab erstellenTab = new Tab("Erstellen");
			erstellenTab.setClosable(false);
			
			/*Tab "info"*/
			Tab infoTab = new Tab("Info");
			infoTab.setClosable(false);
			GridPane infoGrid = new InfoTab().build();
			infoTab.setContent(infoGrid);

			root.getTabs().add(startTab);
			root.getTabs().add(bearbeitenTab);
			root.getTabs().add(vergleichenTab);
			root.getTabs().add(erstellenTab);
			root.getTabs().add(infoTab);

			Scene scene = new Scene(root, 900, 600);
			/* Stylesheet application.css verlinken */
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			primaryStage.show(); // Fenster zeigen

			/* Den Benutzer fragen, ob er das Fenster wirklich shließen möchte */
			Dialog<ButtonType> closeConfirmation = new Dialog<>();
			closeConfirmation.setTitle("Schließen bestätigen");
			closeConfirmation
					.setHeaderText("Sind Sie sicher das Programm zu schließen. Alles ungespeicherte geht verloren.");
			closeConfirmation.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
			primaryStage.setOnCloseRequest(event -> {
				closeConfirmation.showAndWait().ifPresent(response -> {
					if (response == ButtonType.YES) { // Wenn ja Prozess beenden
						System.exit(0);
					} else { // Wenn nein Schliepen stoppen
						event.consume();
					}
				});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
