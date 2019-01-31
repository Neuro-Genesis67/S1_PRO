package opg1;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	private ListView<Person> lvwPersons;
	private Button btnAdd;
	private Label lblName, lblTitle, lblSenior, lblPeople;
	private TextField txfName, txfTitle;
	private CheckBox cbSenior;
	private Controller controller = new Controller();

	public void start(Stage stage) {
		stage.setTitle("Person List App");

		GridPane pane = new GridPane();
		this.initContent(pane);
		pane.setPrefSize(450, 500);
		pane.setHgap(10);
		pane.setVgap(10);
		// pane.setGridLinesVisible(true);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	private void initContent(GridPane pane) {

		lblName = new Label("Name");
		pane.add(lblName, 4, 2);

		lblTitle = new Label("Title");
		pane.add(lblTitle, 4, 3);

		lblPeople = new Label("People");
		pane.add(lblPeople, 4, 6);

		lblSenior = new Label("Senior");
		pane.add(lblSenior, 5, 4);

		cbSenior = new CheckBox();
		pane.add(cbSenior, 4, 4);

		btnAdd = new Button("Add person");
		pane.add(btnAdd, 6, 4);
		btnAdd.setOnAction(e -> controller.addAction());

		txfName = new TextField();
		pane.add(txfName, 5, 2);

		txfTitle = new TextField();
		pane.add(txfTitle, 5, 3);

		lvwPersons = new ListView();
		pane.add(lvwPersons, 5, 6);
		lvwPersons.getItems().setAll(controller.initPersons());

	}

	private class Controller {
		private ArrayList<Person> persons;

		// Kører hver gang man kalder på et objekt af klassen Controller.
		public Controller() {
			initPersons();
		}

		public ArrayList<Person> initPersons() {
			persons = new ArrayList<Person>();
			Person p = new Person("mogens", "mortensen", false);

			persons.add(p);

			return persons;
		}

		// private ArrayList<String> initNames() {
		// names = new ArrayList<String>();
		// names.add("Chloe");
		// names.add("Eddie");
		// names.add("Kazumi");
		// names.add("Nina");
		// names.add("Josie");
		// names.add("Jack");
		// names.add("Poul");
		// names.add("Yoshimitsu");
		// names.add("Xiaoyu");
		// return names;
		//
		// }

		private void addAction() {
			// name = navnet i TextField
			// String name = txfName.getText().trim();
			// if (name.length() > 0) { // Hvis der er valgt et navn ->
			//
			// persons.add(name);
			// lvwPersons.getItems().setAll(persons);

		}
	}

	private void removeAction() {
		// index sættes til den valgte entity i listview af navne
		// int index = lvwPersons.getSelectionModel().getSelectedIndex();
		//
		// persons.remove(index);
		// txfName.clear();
		// lvwPersons.getItems().setAll(persons);
	}
}

// Næste skridt:
//
// Skift names
// listen ud
// med en
// liste af
// Personer af
// Persons klassen.
