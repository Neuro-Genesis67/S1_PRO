package guifx;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Booking;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Tilmelding;
import model.Udflugt;
import service.Service;

public class KonferenceOversigtPane extends GridPane {
	private TextArea txaHotelNavn, txaUdflugtNavn;
	private ListView<Konference> lvwKonferencer;

	public KonferenceOversigtPane() {
		GridPane listPane = new GridPane();
		listPane.setGridLinesVisible(false);
		listPane.setPadding(new Insets(40));
		listPane.setPrefSize(375, 375);
		listPane.setHgap(10);
		listPane.setVgap(10);
		listPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
		add(listPane, 0, 0);
		setPadding(new Insets(40));
		setHgap(40);
		setVgap(30);
		setGridLinesVisible(false);

		// -------------------------------------------------------------------------------------------

		GridPane konferenceOversigtPane = new GridPane();
		konferenceOversigtPane.setGridLinesVisible(false);
		konferenceOversigtPane.setPadding(new Insets(40));
		konferenceOversigtPane.setPrefSize(375, 375);
		konferenceOversigtPane.setHgap(10);
		konferenceOversigtPane.setVgap(10);
		konferenceOversigtPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
		add(konferenceOversigtPane, 1, 0);

		GridPane infoPane = new GridPane();
		infoPane.setGridLinesVisible(false);
		infoPane.setPadding(new Insets(40));
		infoPane.setVgap(10);
		infoPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
		add(infoPane, 2, 0);

		Label lblKonference = new Label("Konferencer: ");
		listPane.add(lblKonference, 0, 0);

		lvwKonferencer = new ListView<>();
		lvwKonferencer.setPrefHeight(400);
		lvwKonferencer.setPrefWidth(300);
		listPane.add(lvwKonferencer, 0, 1);
		lvwKonferencer.getItems().setAll(Service.getKonference());

		Button btnOpretKonference = new Button("Opret konference");
		listPane.add(btnOpretKonference, 0, 2);
		btnOpretKonference.setOnAction(event -> createKonferenceAction());

		ChangeListener<Konference> listener1 = (ov, oldKonf, newKonf) -> selectedKonferenceChanged();
		lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener1);
		// -------------------------------------------------------------------------------------------
		GridPane hotelPane = new GridPane();
		hotelPane.setGridLinesVisible(false);
		hotelPane.setPadding(new Insets(40));
		hotelPane.setPrefSize(375, 375);
		hotelPane.setHgap(10);
		hotelPane.setVgap(10);
		hotelPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10");
		this.add(hotelPane, 1, 0);

		Label lblHotelNavn = new Label("Hotel navn:");
		hotelPane.add(lblHotelNavn, 0, 1);

		txaHotelNavn = new TextArea();
		hotelPane.add(txaHotelNavn, 0, 2);
		txaHotelNavn.setEditable(false);

		Button btnTilføjHotel = new Button("Tilføj Hotel");
		hotelPane.add(btnTilføjHotel, 0, 3);
		btnTilføjHotel.setOnAction(event -> createHotelAction());

		// -------------------------------------------------------------------------------------------
		GridPane udflugtPane = new GridPane();
		udflugtPane.setGridLinesVisible(false);
		udflugtPane.setPadding(new Insets(40));
		udflugtPane.setPrefSize(375, 375);
		udflugtPane.setHgap(10);
		udflugtPane.setVgap(10);
		udflugtPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10");
		this.add(udflugtPane, 2, 0);

		Label lblUdflugtNavn = new Label("Udflugts navn:");
		udflugtPane.add(lblUdflugtNavn, 0, 1);

		txaUdflugtNavn = new TextArea();
		udflugtPane.add(txaUdflugtNavn, 0, 2);
		txaUdflugtNavn.setEditable(false);

		Button btnOpretUdflugt = new Button("Tilføj udflugt");
		udflugtPane.add(btnOpretUdflugt, 0, 3);
		btnOpretUdflugt.setOnAction(event -> createUdflugtAction());

	}
	// -------------------------------------------------------------------------------------------

	private void selectedKonferenceChanged() {
		Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			selectedHotelChanged(konference);
			selectedUdflugtChanged(konference);
		}

	}

	private void createKonferenceAction() {

		OpretKonferenceWindow til = new OpretKonferenceWindow();
		til.showAndWait();
		updateAfterWindow();
		this.lvwKonferencer.getSelectionModel().select(0);

	}

	private void createUdflugtAction() {
		Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}
		OpretUdflugtWindow til = new OpretUdflugtWindow(konference);
		til.showAndWait();
		updateAfterWindow();
		selectAfterWindow(konference);

	}

	private void createHotelAction() {
		Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}
		HotelWindow hotelwin = new HotelWindow(konference);
		hotelwin.showAndWait();
		updateAfterWindow();
		selectAfterWindow(konference);
	}

	private void selectedHotelChanged(Konference konference) {
		if (konference != null) {
			StringBuilder sb = new StringBuilder();
			for (Hotel hotel : konference.getHoteller()) {
				sb.append(hotel + ":" + "\n");
				for (Booking booking : hotel.getBookings()) {
					if (booking.getTilmelding().getKonference() == konference) {
						if (booking.getTilmelding().getLedsager() == null) {
							sb.append(" - " + booking.getTilmelding() + "\n");
						} else {
							sb.append(" - " + booking.getTilmelding() + " ( " + booking.getTilmelding().getLedsager()
									+ " ) " + "\n");
						}

					}
				}
				sb.append("\n");

			}

			txaHotelNavn.setText(sb.toString());
		}
	}

	private void updateAfterWindow() {
		this.lvwKonferencer.getItems().setAll(Service.getKonference());
	}

	private void selectAfterWindow(Konference konference) {
		if (this.lvwKonferencer.getItems().size() > 0) {
			this.lvwKonferencer.getSelectionModel().select(konference);
		}
	}

	private void selectedUdflugtChanged(Konference konference) {
		if (konference != null) {
			StringBuilder sb2 = new StringBuilder();
			for (Udflugt udflugt : konference.getUdflugter()) {
				sb2.append(udflugt + ": " + "\n");
				for (Ledsager ledsager : udflugt.getLedsagere()) {
					if (ledsager.getTilmelding() != null) {
						Tilmelding tilmelding = ledsager.getTilmelding();
						sb2.append(" - " + tilmelding.getLedsager().getNavn() + " ( " + tilmelding.getDeltager()
								+ " ID: " + tilmelding.getId() + " ) " + "\n");
					}
				}

				sb2.append("\n");
			}
			txaUdflugtNavn.setText(sb2.toString());
		}

	}

	public void updateWhenTabChanged() {
		txaUdflugtNavn.clear();
		txaHotelNavn.clear();
		updateAfterWindow();
		this.lvwKonferencer.getSelectionModel().select(0);
	}

}
