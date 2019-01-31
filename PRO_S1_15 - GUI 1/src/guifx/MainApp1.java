package guifx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp1 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Combine names");
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfFirstName, txfLastName, txfOutput;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		txfFirstName = new TextField();
		pane.add(txfFirstName, 1, 1);

		txfLastName = new TextField();
		pane.add(txfLastName, 2, 1);

		txfOutput = new TextField();
		pane.add(txfOutput, 1, 2, 2, 1);

		Button btnCombine = new Button("Combine");
		pane.add(btnCombine, 1, 3);
		btnCombine.setOnAction(e -> CombineAction());
	}

	public void CombineAction() {
		String fName = txfFirstName.getText().trim();
		String lName = txfLastName.getText().trim();
		txfOutput.setText(fName + " " + lName);
	}

}