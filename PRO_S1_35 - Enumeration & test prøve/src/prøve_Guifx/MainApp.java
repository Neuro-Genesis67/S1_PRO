package prøve_Guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	// private Listview<Deltagelse> lvwKampe;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) {

		stage.setTitle("Administration af spiller deltagelse");

		GridPane layout = new GridPane();
		layout.setGridLinesVisible(true);
		layout.setHgap(10);
		layout.setVgap(10);
		layout.setPrefSize(400, 500);
		this.initContent(layout);

		Scene scene = new Scene(layout, 400, 500);
		stage.setScene(scene);
		stage.show();

	}

	private void initContent(GridPane pane) {

		Label lblSted = new Label("Sted");
		pane.add(lblSted, 2, 12);

		Label lblDato = new Label("Dato");
		pane.add(lblDato, 2, 13);

		Label lblTid = new Label("Tid");
		pane.add(lblTid, 2, 14);

		Label lblKampe = new Label("Kampe");
		pane.add(lblKampe, 5, 13);
	}

}
