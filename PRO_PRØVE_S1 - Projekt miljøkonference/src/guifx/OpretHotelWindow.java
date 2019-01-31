package guifx;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Hotel;
import model.HotelService;
import model.Konference;
import service.Service;

public class OpretHotelWindow extends Stage {
	private Konference konference;

	// mListView.setOnMouseClicked(event -> {
	// String selectedItem =
	// mListView.getSelectionModel().getSelectedItem().toString();

	private TextField txfHotel, txfAddresse, txfEnkelt, txfDobbelt, txfService, txfServicePris;

	private ListView<HotelService> lvwService;
	private ArrayList<HotelService> tempServices = new ArrayList<>();
	private Hotel hotel;
	private Label lblError;

	public OpretHotelWindow(Konference konference) {
		this.konference = konference;
		hotel = null;

		setTitle("Tilføj Hotel");
		GridPane pane = new GridPane();
		initContent(pane);
		Scene scene = new Scene(pane);
		setScene(scene);
	}

	public OpretHotelWindow(Hotel hotel) {

		this.hotel = hotel;

		setTitle("Rediger Hotel");
		GridPane pane = new GridPane();
		initContent(pane);
		Scene scene = new Scene(pane);
		setScene(scene);
	}

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(40));
		pane.setHgap(40);
		pane.setVgap(30);
		pane.setGridLinesVisible(false);

		// --------------------------------------------------------------
		GridPane hotelPane = new GridPane();
		hotelPane.setGridLinesVisible(false);
		hotelPane.setPadding(new Insets(40));
		hotelPane.setPrefSize(375, 375);
		hotelPane.setHgap(10);
		hotelPane.setVgap(10);
		hotelPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
		pane.add(hotelPane, 0, 0);

		Label lblHotel = new Label("Navn: ");
		hotelPane.add(lblHotel, 0, 0, 7, 1);

		txfHotel = new TextField();
		hotelPane.add(txfHotel, 7, 0, 28, 1);

		Label lblAddresse = new Label("Addresse: ");
		hotelPane.add(lblAddresse, 0, 1, 8, 1);

		txfAddresse = new TextField();
		hotelPane.add(txfAddresse, 7, 1, 28, 1);
		// ___________________
		Label lblVærelsesType = new Label("Værelsestyper: ");
		hotelPane.add(lblVærelsesType, 5, 7, 15, 1);

		Label lblEnkelt = new Label("Pris enkeltværelse: ");
		hotelPane.add(lblEnkelt, 0, 8, 20, 1);

		txfEnkelt = new TextField();
		hotelPane.add(txfEnkelt, 15, 8, 20, 1);

		Label lblDobbelt = new Label("Pris dobbeltværelse: ");
		hotelPane.add(lblDobbelt, 0, 9, 20, 1);

		txfDobbelt = new TextField();
		hotelPane.add(txfDobbelt, 15, 9, 20, 1);

		Button btnCreate = new Button("OK");
		btnCreate.setOnAction(event -> createOKAction());

		Button btnDelete = new Button("Cancel");
		btnDelete.setOnAction(event -> cancelAction());

		this.lblError = new Label("");

		HBox box = new HBox(5);
		box.getChildren().addAll(btnCreate, btnDelete, lblError);
		pane.add(box, 0, 1);

		Label lblService = new Label("Service:");
		hotelPane.add(lblService, 0, 15, 10, 1);

		txfService = new TextField();
		hotelPane.add(txfService, 6, 15, 9, 1);

		Label lblServicePris = new Label("Pris:");
		hotelPane.add(lblServicePris, 0, 17, 9, 1);

		txfServicePris = new TextField();
		hotelPane.add(txfServicePris, 6, 17, 9, 1);

		Button btnAddService = new Button("Add service");
		btnAddService.setOnAction(event -> addServiceAction());
		hotelPane.add(btnAddService, 0, 28, 20, 1);
		// setonaction(k�r en metode der opretter et objekt af hotelService klassen);

		//
		// M�ske skal den updatere lvwService, n�r man trykker p� knappen
		//

		lvwService = new ListView<>();
		lvwService.setPrefHeight(100);
		lvwService.setPrefWidth(100);
		hotelPane.add(lvwService, 15, 12, 20, 20);

		Button btnRemoveService = new Button("Remove service");
		btnRemoveService.setOnAction(event -> removeServiceAction());
		hotelPane.add(btnRemoveService, 0, 30, 20, 1);

		initControls();
	}
	// ------------------------------------------------------------

	private void initControls() {
		if (hotel != null) {
			this.txfHotel.setText(hotel.getNavn());
			this.txfAddresse.setText(hotel.getAdresse());
			this.txfEnkelt.setText(hotel.getPrisEnkelt() + "");
			this.txfDobbelt.setText(hotel.getPrisDobbelt() + "");
			this.lvwService.getItems().setAll(hotel.getHotelServices());
		}
	}

	private void createOKAction() {
		if (hotel == null) {
			if (txfHotel.getLength() == 0 || txfAddresse.getLength() == 0 || txfEnkelt.getLength() == 0
					|| txfDobbelt.getLength() == 0) {
				lblError.setText("Fejl i data. Manglende indput!");
				return;
			} else {
				Hotel hotel = Service.createHotel(txfHotel.getText().trim(), txfAddresse.getText().trim(),
						Double.parseDouble(txfEnkelt.getText()), Double.parseDouble(txfDobbelt.getText()));
				for (HotelService hotelService : tempServices) {
					if (!hotel.getHotelServices().contains(hotelService)) {
						Service.connectHotelServiceToHotel(hotelService, hotel);
					}
				}

			}

		} else {
			hotel.setAdresse(this.txfAddresse.getText());
			hotel.setNavn(this.txfHotel.getText());
			hotel.setPrisEnkelt(Double.parseDouble(txfEnkelt.getText()));
			hotel.setPrisDobbelt(Double.parseDouble(this.txfDobbelt.getText()));

		}
		hide();
	}

	private void cancelAction() {
		if (hotel != null) {
			for (HotelService hotelService : tempServices) {
				hotel.getHotelServices().remove(hotelService);
			}
		}
		hide();
	}

	private void addServiceAction() {
		if (this.txfService.getText() == null || this.txfServicePris.getText().isEmpty() == true) {
			this.lblError.setText("Service price or name missing");
			return;
		}
		String serviceNavn = this.txfService.getText();
		double servicePris = Double.parseDouble(this.txfServicePris.getText());

		if (hotel == null) {
			HotelService hotelservice = new HotelService(serviceNavn, servicePris);

			this.tempServices.add(hotelservice);

		} else {

			HotelService hotelService = Service.addHotelServiceToHotel(serviceNavn, servicePris, hotel);
			tempServices.add(hotelService);
		}
		updateList();

		txfService.clear();
		txfServicePris.clear();

	}

	private void removeServiceAction() {
		HotelService hotelService = lvwService.getSelectionModel().getSelectedItem();

		if (hotelService == null) {
			return;
		} else if (hotel == null) {
			tempServices.remove(hotelService);
		} else {
			Service.removeHotelServiceFromHotel(hotelService, hotel);
		}
		updateList();

	}

	private void updateList() {
		if (hotel == null) {
			this.lvwService.getItems().setAll(tempServices);

		} else {
			this.lvwService.getItems().setAll(hotel.getHotelServices());

		}
	}
}
