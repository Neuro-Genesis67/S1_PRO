package personDatabaseGUI;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Person;

public class CreateWindow extends Stage {

	// Controller controller = new Controller();
	TextField txfName, txfAge;
	TextArea txaDescription;
	Label lblName, lblAge, lblDescription;
	Button btnCreate, btnCancel;
	Person person;

	public CreateWindow(String title, Stage owner) {
		this.setTitle(title);
		this.initOwner(owner);
		// this.initModality(Modality.APPLICATION_MODAL);

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPrefSize(600, 450);
		// pane.setGridLinesVisible(true);
		initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

	}

	public void initContent(GridPane pane) {

		lblName = new Label("Name: ");
		pane.add(lblName, 1, 4);

		txfName = new TextField();
		pane.add(txfName, 3, 4, 5, 1);

		// lblAge = new Label("Age: ");
		// pane.add(lblAge, 1, 5);
		//
		// txfAge = new TextField();
		// pane.add(txfAge, 3, 5, 5, 1);

		lblDescription = new Label("Description: ");
		pane.add(lblDescription, 3, 12, 5, 1);
		pane.setHalignment(lblDescription, HPos.CENTER);

		txaDescription = new TextArea();
		pane.add(txaDescription, 3, 13, 5, 5);

		btnCreate = new Button("Create");
		pane.add(btnCreate, 3, 20);
		btnCreate.setOnAction(e -> createAction());

		btnCancel = new Button("Cancel");
		pane.add(btnCancel, 4, 20);
		btnCancel.setOnAction(e -> cancelAction());

	}

	// private class Controller {

	private void createAction() {
		String name = txfName.getText();
		String description = txaDescription.getText();

		if (name.length() == 0 && description.length() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Create person");
			alert.setHeaderText("Missing information");
			alert.setContentText("Please fill out name and age");
			alert.show();
		} else {
			if (name.length() > 0 && description.length() > 0) {
				person = new Person(name, description);
				clearFields();
				this.hide();
			}
		}

	}

	private void clearFields() {
		txfName.clear();
		txaDescription.clear();
	}

	public Person getPerson() {
		return person;
	}

	private void cancelAction() {
		clearFields();
		this.hide();

	}

}
