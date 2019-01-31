package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private TextField txfName;
	private PasswordField txfPass;
	Button btnLogin, btnCreate;
	private CreateWindow createWindow;
	// private final Controller controller = new Controller();

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Kajack's Cars Inc.");

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

		Label lblWelcome = new Label("Welcome to Kajack's cars.");
		pane.add(lblWelcome, 10, 10);

		Label lblName = new Label("Name");
		pane.add(lblName, 10, 20);

		txfName = new TextField();
		pane.add(txfName, 11, 20);

		Label lblPassword = new Label("Password");
		pane.add(lblPassword, 10, 21);

		txfPass = new PasswordField();
		pane.add(txfPass, 11, 21);

		btnLogin = new Button("Login");
		pane.add(btnLogin, 10, 24);
		// btnLogin.setOnAction(e -> );

		btnCreate = new Button("Create new user");
		pane.add(btnCreate, 11, 24);
		// btnCreate.setOnAction(e -> controller.createWindow());

	}

	// private class Controller {
	// // -----------------------------------------------------
	// // Button actions
	//
	// private void createWindow() {
	// CreateWindow.showAndWait();
	// if (movieWindow.getActualMovie() != null) {
	// txfResult.setText(movieWindow.getActualMovie().toString());
	// }
	//
	// }
	//
	// }
}