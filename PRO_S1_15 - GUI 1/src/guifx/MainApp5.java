package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp5 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	// C = Celsius, CC = Celsius Converted (to fahrenheit, naturally). FC =
	// Fahrenheit Converted.
	private TextField txfC, txfF;
	private Button btnConvert;
	private Label lblC, lblF, lblEquals;
	private double fResult, cResult, temp;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Fahrenheit / Celsius converter");

		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	public void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setHgap(10);
		pane.setVgap(10);

		lblC = new Label("Celsius");
		pane.add(lblC, 1, 1);

		lblF = new Label("Fahrenheit");
		pane.add(lblF, 3, 1);

		lblEquals = new Label("         =");
		pane.add(lblEquals, 2, 2);

		txfC = new TextField();
		pane.add(txfC, 1, 2);
		txfC.setOnMouseClicked(e -> clearAction());

		txfF = new TextField();
		pane.add(txfF, 3, 2);
		txfF.setOnMouseClicked(e -> clearAction());

		btnConvert = new Button("Convert");
		pane.add(btnConvert, 2, 3);
		btnConvert.setOnAction(e -> convertAction());

	}

	public void clearAction() {
		txfC.clear();
		txfF.clear();
	}

	public void convertAction() {
		if (txfC.getText().length() > 0 && txfF.getText().length() == 0) {

			temp = Double.parseDouble(txfC.getText());
			fResult = 1.8 * temp + 32;
			txfF.setText(String.valueOf(fResult));
		}
		if (txfF.getText().length() > 0 && txfC.getText().length() == 0) {
			temp = Double.parseDouble(txfF.getText());
			cResult = (temp - 32) * 5 / 9;
			txfC.setText(String.valueOf(cResult));

		}
	}

}
