package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SceneApp extends Application {
	private TextField txfName, txfPass, txfCreateName, txfCreatePass, txfCreateAddress, txfCreateLicense,
			txfCreatePhone, txfCreatePassword;
	Button btnLogin, btnCreate, btnCreateCreate, btnCreateCancel;
	private Scene loginScene, createScene, manageScene;
	private Stage window;

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage stage) throws Exception {
		this.window = stage;
		stage.setTitle("Kaj's biler");

		GridPane Loginlayout = new GridPane();
		Loginlayout.setGridLinesVisible(false);
		Loginlayout.setHgap(10);
		Loginlayout.setVgap(10);
		Loginlayout.setPrefSize(400, 500);
		this.loginSceneWindow(Loginlayout);
		loginScene = new Scene(Loginlayout, 400, 500);
		stage.setScene(loginScene);
		stage.show();

		GridPane createLayout = new GridPane();
		createLayout.setGridLinesVisible(true);
		createLayout.setHgap(10);
		createLayout.setVgap(10);
		createLayout.setPrefSize(400, 500);
		createScene = new Scene(createLayout, 400, 500);
		this.CreateSceneWindow(createLayout);

	}

	private void loginSceneWindow(GridPane pane) {

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
		btnCreate.setOnAction(e -> window.setScene(createScene));

	}

	private void CreateSceneWindow(GridPane pane) {

		Label lblCreated = new Label("");
		pane.add(lblCreated, 10, 5, 10, 1);

		Label lblCreateName = new Label("Name");
		pane.add(lblCreateName, 10, 10);

		txfCreateName = new TextField();
		pane.add(txfCreateName, 11, 10);

		Label lblCreateAddress = new Label("Address");
		pane.add(lblCreateAddress, 10, 12);

		txfCreateAddress = new TextField();
		pane.add(txfCreateAddress, 11, 12);

		Label lblCreateLicense = new Label("License");
		pane.add(lblCreateLicense, 10, 14);

		txfCreateLicense = new TextField();
		pane.add(txfCreateLicense, 11, 14);

		Label lblCreatePhone = new Label("Phone");
		pane.add(lblCreatePhone, 10, 16);

		txfCreatePhone = new TextField();
		pane.add(txfCreatePhone, 11, 16);

		Label lblCreatePassword = new Label("Password");
		pane.add(lblCreatePassword, 10, 18);

		txfCreatePassword = new TextField();
		pane.add(txfCreatePassword, 11, 18);

		btnCreateCreate = new Button("Create user");
		pane.add(btnCreateCreate, 10, 20);
		btnCreateCreate.setOnAction(e -> {

			// private void okAction() {
			// String title = txfTitle.getText().trim();
			// String actor = txfActor.getText().trim();
			//
			// if (title.length() > 0 && actor.length() > 0) {
			// actualMovie = new Movie(title, actor);
			// txfTitle.clear();
			// txfActor.clear();
			// txfTitle.requestFocus();
			// this.hide();

			int i = Integer.parseInt(txfCreatePhone.getText());
			if (txfCreateName.getText().length() == 0 || txfCreateAddress.getText().length() == 0
					|| txfCreateLicense.getText().length() == 0
			// || i == 0
					|| txfCreatePassword.getText().length() == 0) {
				lblCreated.setText("Missing information, please fill out all fields");
			} else {
				lblCreated.setText("User successfully created!");
				// Service.createCustomer(customer);
			}
			clearCreate();

		});

		btnCreateCancel = new Button("Cancel");
		pane.add(btnCreateCancel, 11, 20);
		btnCreateCancel.setOnAction(e -> {
			window.setScene(loginScene);
			clearCreate();
		});

	}

	private void clearCreate() {
		txfCreateName.setText("");
		txfCreateAddress.setText("");
		txfCreateLicense.setText("");
		txfCreatePhone.setText("");
		txfCreatePassword.setText("");
	}

}
