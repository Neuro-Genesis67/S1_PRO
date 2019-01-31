package opg2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SwapApp extends Application {

	private Controller controller = new Controller();
	private TextField txfFirst, txfSecond;
	private Button btnSwap;

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Swap");

		GridPane pane = new GridPane();
		pane.setPrefSize(200, 200);
		pane.setVgap(10);
		pane.setHgap(10);
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	public void initContent(GridPane pane) {

		txfFirst = new TextField();
		txfFirst.setPromptText("First");
		pane.add(txfFirst, 1, 1);

		txfSecond = new TextField();
		txfSecond.setPromptText("Second");
		pane.add(txfSecond, 1, 2);

		btnSwap = new Button("Swap");
		pane.add(btnSwap, 1, 3);
		btnSwap.setOnAction(e -> controller.swap());
	}

	private class Controller {

		public void swap() {
			String first;
			String second;
			first = txfFirst.getText();
			second = txfSecond.getText();
			txfFirst.setText(second);
			txfSecond.setText(first);
		}
	}

}
