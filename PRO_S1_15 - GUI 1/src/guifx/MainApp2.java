package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp2 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	private TextField txfTop, txfBot;
	private Button btnSwap;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Swappa");
		GridPane gp = new GridPane();
		this.initContent(gp);

		Scene sc = new Scene(gp);
		stage.setScene(sc);
		stage.show();

	}

	public void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setVgap(10);
		pane.setHgap(10);
		pane.setPrefSize(200, 100);

		txfTop = new TextField();
		txfTop.setPromptText("Top field");
		pane.add(txfTop, 2, 1);

		txfBot = new TextField();
		txfBot.setPromptText("Bot field");
		pane.add(txfBot, 2, 2);

		btnSwap = new Button("Swap");
		pane.add(btnSwap, 2, 3);

		btnSwap.setOnAction(e -> swapAction());

	}

	public void swapAction() {

		String top = txfTop.getText().trim();
		String bot = txfBot.getText().trim();

		txfTop.setText(bot);
		txfBot.setText(top);

	}

}
