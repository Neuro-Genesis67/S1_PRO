package guifx;

import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import model.HotelService;
import model.Konference;
import model.Tilmelding;
import model.Udflugt;
import service.Service;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TilmeldingsPane extends GridPane {
    private TextField txfNavn, txfPris, txfId, txfTilFra, txfLedsager, txfHotel;
    private ListView<Konference> lvwKonferencer;
    private ListView<Tilmelding> lvwTilmeldinger;
    private ListView<Udflugt> lvwUdflugter;
    private ListView<HotelService> lvwService;

    public TilmeldingsPane() {
        GridPane listPane = new GridPane();
        listPane.setGridLinesVisible(false);
        listPane.setPadding(new Insets(40));
        listPane.setPrefSize(375, 375);
        listPane.setHgap(10);
        listPane.setVgap(10);
        listPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        this.add(listPane, 0, 0);
        setPadding(new Insets(40));
        setHgap(40);
        setVgap(30);
        setGridLinesVisible(false);

        GridPane tilmeldingPane = new GridPane();
        tilmeldingPane.setGridLinesVisible(false);
        tilmeldingPane.setPadding(new Insets(40));
        tilmeldingPane.setPrefSize(375, 375);
        tilmeldingPane.setHgap(10);
        tilmeldingPane.setVgap(10);
        tilmeldingPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        this.add(tilmeldingPane, 1, 0);

        GridPane infoPane = new GridPane();
        infoPane.setGridLinesVisible(false);
        infoPane.setPadding(new Insets(40));
        infoPane.setVgap(10);
        infoPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        this.add(infoPane, 2, 0);

        Label lblKonference = new Label("Konferencer: ");
        listPane.add(lblKonference, 0, 0);

        lvwKonferencer = new ListView<>();
        lvwKonferencer.setPrefHeight(400);
        lvwKonferencer.setPrefWidth(300);
        listPane.add(lvwKonferencer, 0, 1);
        lvwKonferencer.getItems().setAll(Service.getKonference());

        Button btnCreate = new Button("Opret tilmelding");
        listPane.add(btnCreate, 0, 2);
        btnCreate.setOnAction(event -> createTilmeldingAction());

        ChangeListener<Konference> listener = (ov, oldKonf, newKonf) -> selectedKonferenceChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblTilmeldinger = new Label("Tilmeldinger:");
        tilmeldingPane.add(lblTilmeldinger, 0, 0);

        lvwTilmeldinger = new ListView<>();
        lvwTilmeldinger.setPrefHeight(400);
        lvwTilmeldinger.setPrefWidth(300);
        tilmeldingPane.add(lvwTilmeldinger, 0, 1);

        Button btnDelete = new Button("Delete tilmelding");
        tilmeldingPane.add(btnDelete, 0, 2);
        btnDelete.setOnAction(event -> deleteAction());

        ChangeListener<Tilmelding> listenerTil = (ov, oldTil, newTil) -> selectedTilmeldingChanged();
        this.lvwTilmeldinger.getSelectionModel().selectedItemProperty().addListener(listenerTil);

        Label lblInfo = new Label("Info: ");
        infoPane.add(lblInfo, 0, 0);

        Label lblNavn = new Label("Deltager: ");
        infoPane.add(lblNavn, 0, 1);

        this.txfNavn = new TextField();
        infoPane.add(txfNavn, 1, 1);
        this.txfNavn.setEditable(false);

        Label lblId = new Label("ID: ");
        infoPane.add(lblId, 0, 2);

        this.txfId = new TextField();
        infoPane.add(txfId, 1, 2);
        this.txfId.setEditable(false);

        Label lblDato = new Label("Til / Fra: ");
        infoPane.add(lblDato, 0, 3);

        this.txfTilFra = new TextField();
        infoPane.add(this.txfTilFra, 1, 3);
        this.txfTilFra.setEditable(false);

        Label lblHotel = new Label("Hotel: ");
        infoPane.add(lblHotel, 0, 4);

        this.txfHotel = new TextField();
        infoPane.add(this.txfHotel, 1, 4);
        this.txfHotel.setEditable(false);

        Label lblService = new Label("HotelServices: ");
        infoPane.add(lblService, 0, 5);

        this.lvwService = new ListView<>();
        this.lvwService.setPrefSize(60, 60);
        infoPane.add(this.lvwService, 1, 5);

        Label lblLedsager = new Label("Ledsager: ");
        infoPane.add(lblLedsager, 0, 6);

        this.txfLedsager = new TextField();
        infoPane.add(this.txfLedsager, 1, 6);
        this.txfLedsager.setEditable(false);

        Label lblUdflugter = new Label("Udflugt(er): ");
        infoPane.add(lblUdflugter, 0, 7);

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(60, 60);
        infoPane.add(this.lvwUdflugter, 1, 7);

        Label lblPris = new Label("Total Pris: ");
        infoPane.add(lblPris, 0, 10);

        this.txfPris = new TextField();
        infoPane.add(this.txfPris, 1, 10);
        this.txfPris.setEditable(false);

        Button btnRediger = new Button("Rediger tilmelding");
        infoPane.add(btnRediger, 0, 11);
        btnRediger.setOnAction(event -> redigerAction());

        updateAfterWindow();

    }

    private void selectedKonferenceChanged() {
        Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            this.lvwTilmeldinger.getItems().setAll(Service.getTilmeldinger(konference));
        }
    }

    private void updateAfterWindow() {
        updateWhenTabChanged();
    }

    private void redigerAction() {
        Tilmelding tilmelding = this.lvwTilmeldinger.getSelectionModel().getSelectedItem();
        if (tilmelding == null) {
            return;

        }
        Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
        TilmeldingsWindow til = new TilmeldingsWindow("Rediger Tilmelding", tilmelding, konference);
        til.showAndWait();
        this.lvwTilmeldinger.getItems().setAll(Service.getTilmeldinger(konference));
        this.lvwTilmeldinger.getSelectionModel().select(tilmelding);
        selectedTilmeldingChanged();

    }

    private void createTilmeldingAction() {
        Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference == null) {
            return;
        }
        TilmeldingsWindow til = new TilmeldingsWindow("Opret Tilmelding", konference);
        til.showAndWait();

        this.lvwTilmeldinger.getItems().setAll(Service.getTilmeldinger(konference));
        updateAfterWindow();

        this.lvwKonferencer.getSelectionModel().select(konference);
    }

    private void deleteAction() {
        Tilmelding tilmelding = this.lvwTilmeldinger.getSelectionModel().getSelectedItem();
        Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
        if (tilmelding == null) {
            return;
        }
        Stage owner = (Stage) getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Tilmelding");
        alert.initOwner(owner);
        alert.setHeaderText("Are you sure?");

        // Wait for the modal dialog to close
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Service.deleteTilmelding(tilmelding);
            konference.removeTilmelding(tilmelding);
            this.lvwTilmeldinger.getItems().setAll(Service.getTilmeldinger(konference));
            updateAfterWindow();
        }
    }

    private void selectedTilmeldingChanged() {
        clearInfo();
        Tilmelding tilmelding = this.lvwTilmeldinger.getSelectionModel().getSelectedItem();
        if (tilmelding != null) {
            this.txfNavn.setText(tilmelding.getDeltager().getNavn());
            this.txfId.setText("" + tilmelding.getId());
            datoFormat(tilmelding);
            if (tilmelding.getBooking() != null && tilmelding.getBooking().getHotel() != null) {
                this.txfHotel.setText(tilmelding.getBooking().getHotel().getNavn() + " ("
                        + tilmelding.getBooking().getAntalDage() + " dage" + ")");
                if (tilmelding.getBooking().getHotelServicesValgt() != null) {
                    this.lvwService.getItems().setAll(tilmelding.getBooking().getHotelServicesValgt());
                }
            }

            if (tilmelding.getLedsager() != null) {
                this.txfLedsager.setText(tilmelding.getLedsager().getNavn());
                this.lvwUdflugter.getItems().setAll(tilmelding.getLedsager().getUdflugter());
            }
            this.txfPris.setText("" + tilmelding.udregnTotalPris() + " DKK.-");

        }
    }

    private void datoFormat(Tilmelding tilmelding) {
        this.txfTilFra.setText(tilmelding.getAnkomstDato().getDayOfMonth() + "/"
                + tilmelding.getAnkomstDato().getMonthValue() + " - " + tilmelding.getAfrejseDato().getDayOfMonth()
                + "/" + tilmelding.getAfrejseDato().getMonthValue());
    }

    private void clearInfo() {
        this.txfNavn.setText("");
        this.txfId.setText("");
        this.txfTilFra.setText("");
        this.txfHotel.setText("");
        this.txfLedsager.setText("");
        this.lvwService.getItems().setAll();
        this.lvwUdflugter.getItems().setAll();
        this.txfPris.setText("");
    }

    public void updateWhenTabChanged() {
        this.lvwKonferencer.getItems().setAll(Service.getKonference());
        if (this.lvwKonferencer.getItems().size() > 0) {
            this.lvwKonferencer.getSelectionModel().select(0);

            if (this.lvwTilmeldinger.getItems().size() > 0) {
                this.lvwTilmeldinger.getSelectionModel().select(0);
            }
        }
    }
}
