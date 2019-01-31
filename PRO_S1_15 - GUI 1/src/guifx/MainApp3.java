package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp3 extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	private TextField txfCounter;
	private Button btn1, btn2;
	private int count = 15;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Counter");

		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	public void initContent(GridPane pane) {
		txfCounter = new TextField();
		txfCounter.setEditable(false);
		pane.add(txfCounter, 1, 1);
		txfCounter.setText(String.valueOf(this.count));

		btn1 = new Button("Up");
		pane.add(btn1, 1, 2, 2, 1);
		btn1.setOnAction(e -> btnUpAction());

		btn2 = new Button("Down");
		pane.add(btn2, 1, 3, 2, 1);
		btn2.setOnAction(e -> btnDownAction());

	}

	public void btnUpAction() {
		this.count++;
		txfCounter.setText(String.valueOf(this.count));
	}

	public void btnDownAction() {
		this.count--;
		txfCounter.setText(String.valueOf(this.count));

	}

}
