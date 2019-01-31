package opg1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CombineNamesApp extends Application {

	private Controller controller = new Controller();
	private TextField name, lastName, combine;
	private Button btnCombine;

	public static void main(String[] args) {
		Application.launch(args);

	}

	public void start(Stage stage) {
		stage.setTitle("Combine names");

		GridPane pane = new GridPane();
		Scene scene = new Scene(pane);
		initContent(pane);

		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPrefSize(320, 200);

		stage.setScene(scene);
		stage.show();
	}

	public void initContent(GridPane pane) {

		name = new TextField();
		name.setPromptText("Name");
		pane.add(name, 1, 1);

		lastName = new TextField();
		lastName.setPromptText("Last name");
		pane.add(lastName, 2, 1);

		combine = new TextField();
		combine.setPromptText("Name + Last name");
		pane.add(combine, 1, 2, 2, 1);

		btnCombine = new Button("Combine");
		pane.add(btnCombine, 1, 3);
		btnCombine.setOnAction(e -> controller.combineAction());

	}

	private class Controller {

		public void combineAction() {
			String combination;
			combination = name.getText() + " " + lastName.getText();
			combine.setText(combination);
		}
	}

}
