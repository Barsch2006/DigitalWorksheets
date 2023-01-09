package application.Tabs;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class InfoTab {
	public GridPane build() {
		GridPane infoGrid = new GridPane();
		ColumnConstraints Infocol0 = new ColumnConstraints();
		Infocol0.setPercentWidth(2);
		ColumnConstraints Infocol1 = new ColumnConstraints();
		Infocol1.setPercentWidth(96);
		ColumnConstraints Infocol2 = new ColumnConstraints();
		Infocol2.setPercentWidth(2);
		infoGrid.getColumnConstraints().addAll(Infocol0, Infocol1, Infocol2);
		Text aboutTitle = new Text("Über");
		aboutTitle.getStyleClass().add("title");
		infoGrid.add(aboutTitle, 1, 0);
		Text aboutText = new Text("Github Repository: https://github.com/Barsch2006/DigitalWorksheets");
		aboutText.getStyleClass().add("p");
		infoGrid.add(aboutText, 1, 1);
		Text entwicklerTitle = new Text("Die Entwickler");
		entwicklerTitle.getStyleClass().add("title");
		infoGrid.add(entwicklerTitle, 1, 2);
		Text entwicklerText = new Text(
				"Christian F (https://github.com/Barsch2006)\nDaryan Z (bisher kein Github-Link)");
		entwicklerText.getStyleClass().add("p");
		infoGrid.add(entwicklerText, 1, 3);
		return infoGrid;
	}
}
