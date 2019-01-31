package guifx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateWindow extends Application {

	private TextField txfName, txfAddress, txfLicense, txfPhone, txfPassword;

	public CreateWindow(Stage stage) {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(40));
		pane.setPrefSize(375, 375);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
		pane.setPadding(new Insets(40));
		pane.setHgap(40);
		pane.setVgap(30);
		pane.setGridLinesVisible(false);
		// stage.setTitle("Create new user");
		// stage.initModality(Modality.APPLICATION_MODAL);
		// stage.setHeight(500);
		// stage.setWidth(400);
		// stage.show();
		//
		// GridPane pane = new GridPane();
		// stage.setScene(scene);
		// Scene scene = new Scene();

	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(40));
		pane.setPrefSize(375, 375);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
		pane.setPadding(new Insets(40));
		pane.setHgap(40);
		pane.setVgap(30);
		pane.setGridLinesVisible(false);

	}

}
