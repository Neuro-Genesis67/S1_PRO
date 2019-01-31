package personDatabaseGUI;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Person;

public class App extends Application {

	Controller controller = new Controller();
	public ListView<Person> lvwPersons;
	Button btnCreate, btnEdit, btnDelete;
	TextArea txaDescription;
	Label lblPersons, lblDescription, lblArrow;
	CreateWindow createWindow;
	Person persona;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Person database system");

		GridPane pane = new GridPane();
		initContent(pane);

		createWindow = new CreateWindow("Create new person", stage);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(GridPane pane) {

		pane.setPrefSize(800, 600);
		pane.setVgap(10);
		pane.setHgap(10);
		// pane.setGridLinesVisible(true);

		lblPersons = new Label("Persons");
		pane.add(lblPersons, 4, 3);
		pane.setHalignment(lblPersons, HPos.CENTER);

		lblDescription = new Label("Description");
		pane.add(lblDescription, 12, 3);
		pane.setHalignment(lblDescription, HPos.CENTER);

		lblArrow = new Label("------->");
		pane.add(lblArrow, 8, 4);

		lvwPersons = new ListView();
		lvwPersons.setPrefSize(300, 400);
		lvwPersons.getSelectionModel().selectedItemProperty()
				.addListener((list, oldValue, newValue) -> txaDescription.setText(newValue.getDescription()));
		// APEX - Finish the listener - Look in demo1listview gui2
		pane.add(lvwPersons, 4, 4);

		txaDescription = new TextArea();
		txaDescription.setEditable(false);
		pane.add(txaDescription, 12, 4);
		txaDescription.setPrefSize(300, 400);

		btnCreate = new Button("Create new person");
		pane.add(btnCreate, 4, 6);
		btnCreate.setOnAction(e -> controller.createAction());

		btnEdit = new Button("Edit selected person");
		pane.add(btnEdit, 4, 7);
		btnEdit.setOnAction(e -> controller.editAction());

		btnDelete = new Button("Delete selected person");
		pane.add(btnDelete, 4, 8);
		btnDelete.setOnAction(e -> controller.deleteAction());

	}

	private class Controller {
		private ArrayList<Person> persons = new ArrayList<>();

		private void createAction() {
			lvwPersons.getSelectionModel().clearSelection();

			createWindow.showAndWait();
			if (createWindow.getPerson() != null) {
				// Hvis der er lavet en person, tilføjes han til ListViewet:
				persons.add(createWindow.getPerson());
				lvwPersons.getItems().setAll(persons);

				System.out.println(persons);

			}
		}

		private void editAction() {
			System.out.println("top kek bro");
		}

		private void deleteAction() {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Add person");
			alert.setHeaderText("No named typed");
			alert.setContentText("Type the name of the person");
			alert.show();
		}
	}

}
