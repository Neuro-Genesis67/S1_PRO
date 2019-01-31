package guifx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewWindow extends Stage {

	public NewWindow() {
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public void initContent(GridPane pane) {
		Label lblTest = new Label("Test");
		pane.add(lblTest, 1, 1);
	}
}
