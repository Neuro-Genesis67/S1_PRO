package opg3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CounterApp extends Application {

	Controller controller = new Controller();
	TextField txfCount;
	Button btnUp, btnDown;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Counter");

		GridPane pane = new GridPane();
		pane.setPrefSize(200, 200);
		pane.setVgap(10);
		pane.setHgap(10);
		initContent(pane);

		Scene scene = new Scene(pane);

		stage.setScene(scene);
		stage.show();

	}

	private class Controller {

		private void upAction() {

			String up = txfCount.getText();
			up = Integer.toString(Integer.parseInt(up) + 1);
			txfCount.setText(up);

		}

		private void downAction() {

			String down = txfCount.getText();
			down = Integer.toString(Integer.parseInt(down) - 1);
			txfCount.setText(down);
		}
	}

	public void initContent(GridPane pane) {
		txfCount = new TextField();
		txfCount.setText("15");
		// txfCount.setEditable(false);
		pane.add(txfCount, 1, 1, 2, 1);

		btnUp = new Button("Up");
		pane.add(btnUp, 1, 2);
		btnUp.setOnAction(e -> controller.upAction());

		btnDown = new Button("Down");
		pane.add(btnDown, 2, 2);
		btnDown.setOnAction(e -> controller.downAction());

	}
}
