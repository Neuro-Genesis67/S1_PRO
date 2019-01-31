// Tom Steinmeier - DMU 18v

package gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.PraktikKontrakt;
import model.PraktikVirksomhed;
import service.Service;
import storage.Storage;

public class App extends Application {

	private TextField txfNavn, txfFeedback, txfKontakt;
	private Label lblNavn, lblFeedback, lblKontakt, lblVirksomhed, lblVirksomheder;
	private ListView lvwVirksomheder = new ListView<>();
	private Button btnAdd, btnUpdate;
	private final Controller controller = new Controller();
	private PraktikVirksomhed praktikVirksomhed;
	private PraktikKontrakt praktikKontrakt;

	public static void main(String[] args) {
		Application.launch(args);
		// Service.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administration af praktikvirksomheder");
		GridPane pane = new GridPane();
		this.initContent(pane);

		pane.setPrefSize(800, 400);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(true);

		lblNavn = new Label("Navn: ");
		pane.add(lblNavn, 2, 2);

		lblFeedback = new Label("Feedback: ");
		pane.add(lblFeedback, 2, 3);

		lblKontakt = new Label("Kontakt: ");
		pane.add(lblKontakt, 2, 4);

		lblVirksomhed = new Label("Praktikvirksomhed: ");
		pane.add(lblVirksomhed, 3, 1);

		lblVirksomheder = new Label("Praktikvirksomheder: ");
		pane.add(lblVirksomheder, 3, 5);

		btnAdd = new Button("Add");
		pane.add(btnAdd, 2, 7);
		btnAdd.setOnAction(e -> controller.addAction());

		btnUpdate = new Button("Update");
		pane.add(btnUpdate, 2, 8);
		btnUpdate.setOnAction(e -> controller.updateAction());

		txfNavn = new TextField();
		pane.add(txfNavn, 3, 2);

		txfFeedback = new TextField();
		pane.add(txfFeedback, 3, 3);

		txfKontakt = new TextField();
		pane.add(txfKontakt, 3, 4);

		pane.add(lvwVirksomheder, 3, 6);
		lvwVirksomheder.getItems().setAll(this.controller.initVirksomheder());

		// ChangeListener<Boolean> listener = (ov, oldValue, newValue) ->
		// controller.textFieldAction(newValue);
		// lvwVirksomheder.selectedProperty().addListener(listener);

	}

	private class Controller {

		private ArrayList<PraktikVirksomhed> praktikVirksomheder;

		public void addAction() {
			if (txfNavn.getText().length() > 0 && txfFeedback.getText().length() > 0
					&& txfKontakt.getText().length() > 0) {
				Service.createPraktikVirksomhed(txfNavn.getText(), txfFeedback.getText(), txfKontakt.getText());
				lvwVirksomheder.getItems().setAll(Storage.getPraktikVirksomheder());
			}

		}

		public void updateAction() {
			// Service.updatePraktikVirksomhed();
		}

		public ArrayList<PraktikVirksomhed> initVirksomheder() {
			praktikVirksomheder = new ArrayList<PraktikVirksomhed>();
			for (PraktikVirksomhed pv : Storage.getPraktikVirksomheder()) {
				praktikVirksomheder.add(pv);

			}
			return praktikVirksomheder;

		}
	}

}
