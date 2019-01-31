package guifx;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Deltager;
import model.Hotel;
import model.Konference;
import service.Service;

public class StoragePane extends GridPane {
    private ListView<Konference> lvwKonferencer;
    private ListView<Hotel> lvwHoteller;
    private ListView<Deltager> lvwDeltagere;

    public StoragePane() {
        // Opretter Konference pane
        GridPane konfPane = new GridPane();
        konfPane.setGridLinesVisible(false);
        konfPane.setPadding(new Insets(40));
        konfPane.setPrefSize(375, 375);
        konfPane.setHgap(10);
        konfPane.setVgap(10);
        konfPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        this.add(konfPane, 0, 0);
        setPadding(new Insets(40));
        setHgap(40);
        setVgap(30);

        // Label til konference pane (�verst)
        Label lblKonf = new Label("Konferencer:");
        konfPane.add(lblKonf, 0, 0);

        // Inds�tter listen af konferencer i konference pane
        lvwKonferencer = new ListView<>();
        lvwKonferencer.setPrefHeight(400);
        lvwKonferencer.setPrefWidth(300);
        konfPane.add(lvwKonferencer, 0, 1);

        // knappen der sletter valgte konference
        Button btnDeleteKonf = new Button("Delete konference");
        konfPane.add(btnDeleteKonf, 0, 2);
        btnDeleteKonf.setOnAction(event -> konfDeleteAction());

        // knappen der redigerer valgte konference
        Button btnRedigerKonf = new Button("Rediger Konference");
        konfPane.add(btnRedigerKonf, 0, 3);
        btnRedigerKonf.setOnAction(event -> konfRedigerAction());
        // --------------------------------------------------------------------------------

        // Opretter hotelPane
        GridPane hotelPane = new GridPane();
        hotelPane.setGridLinesVisible(false);
        hotelPane.setPadding(new Insets(40));
        hotelPane.setPrefSize(375, 375);
        hotelPane.setHgap(10);
        hotelPane.setVgap(10);
        hotelPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        this.add(hotelPane, 1, 0);

        // Label til hotel pane (�verst)
        Label lblHotel = new Label("Hoteller:");
        hotelPane.add(lblHotel, 0, 0);

        // Inds�tter listen af hoteller i hotel pane
        lvwHoteller = new ListView<>();
        lvwHoteller.setPrefHeight(400);
        lvwHoteller.setPrefWidth(300);
        hotelPane.add(lvwHoteller, 0, 1);

        // knappen der sletter valgte hotel
        Button btnDeleteHotel = new Button("Delete hotel");
        hotelPane.add(btnDeleteHotel, 0, 2);
        btnDeleteHotel.setOnAction(event -> hotelDeleteAction());

        // knappen der redigerer valgte hotel
        Button btnRedigerHotel = new Button("Rediger Hotel");
        hotelPane.add(btnRedigerHotel, 0, 3);
        btnRedigerHotel.setOnAction(event -> hotelRedigerAction());
        // --------------------------------------------------------------------------------

        // Opretter deltager pane
        GridPane deltPane = new GridPane();
        deltPane.setGridLinesVisible(false);
        deltPane.setPadding(new Insets(40));
        deltPane.setPrefSize(375, 375);
        deltPane.setHgap(10);
        deltPane.setVgap(10);
        deltPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        this.add(deltPane, 2, 0);

        // Label til deltager pane (�verst)
        Label lblDelt = new Label("Deltagere:");
        deltPane.add(lblDelt, 0, 0);

        // Inds�tter listen af deltagere i deltager pane
        lvwDeltagere = new ListView<>();
        lvwDeltagere.setPrefHeight(400);
        lvwDeltagere.setPrefWidth(300);
        deltPane.add(lvwDeltagere, 0, 1);

        // knappen der sletter valgte deltager
        Button btnDeleteDelt = new Button("Delete Deltager");
        deltPane.add(btnDeleteDelt, 0, 2);
        btnDeleteDelt.setOnAction(event -> deltDeleteAction());

        // knappen der redigerer valgte deltager
        Button btnRedigerDelt = new Button("Rediger deltager");
        deltPane.add(btnRedigerDelt, 0, 3);
        btnRedigerDelt.setOnAction(event -> deltRedigerAction());

        updateWhenWindowClosed();

    }
    // --------------------------------------------------------------------------------

    private void hotelRedigerAction() {

        Hotel hotel = this.lvwHoteller.getSelectionModel().getSelectedItem();
        if (hotel == null) {
            return;
        }
        OpretHotelWindow hotelRedi = new OpretHotelWindow(hotel);
        hotelRedi.showAndWait();
        updateWhenWindowClosed();
        this.lvwHoteller.getSelectionModel().select(hotel);
    }

    private void konfRedigerAction() {
        Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference == null) {
            return;
        }
        OpretKonferenceWindow til = new OpretKonferenceWindow(konference);
        til.showAndWait();
        updateWhenWindowClosed();
        this.lvwKonferencer.getSelectionModel().select(konference);

    }

    private void deltRedigerAction() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager == null) {
            return;
        }
        OpretDeltagerWindow rediger = new OpretDeltagerWindow(deltager);
        rediger.showAndWait();
        updateWhenWindowClosed();
        this.lvwDeltagere.getSelectionModel().select(deltager);
    }

    // Delete metoder for konf, hotel og deltagere.
    public void konfDeleteAction() {

        Konference konference = this.lvwKonferencer.getSelectionModel().getSelectedItem();

        if (konference == null) {
            return;
        }

        Stage owner = (Stage) getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Tilmelding");
        alert.initOwner(owner);
        alert.setHeaderText("Are you sure you want to delete " + konference.getNavn() + "?");

        // Wait for the modal dialog to close
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Service.removeKonference(konference);
            updateWhenWindowClosed();
        }

    }

    public void hotelDeleteAction() {

        Hotel hotel = this.lvwHoteller.getSelectionModel().getSelectedItem();
        if (hotel == null) {
            return;
        }
        Stage owner = (Stage) getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Tilmelding");
        alert.initOwner(owner);
        alert.setHeaderText("Are you sure you want to delete " + hotel.getNavn() + "?");

        // Wait for the modal dialog to close
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Service.removeHotel(hotel);
            updateWhenWindowClosed();
        }

    }

    public void deltDeleteAction() {

        Deltager deltager = this.lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager == null) {
            return;
        }
        Stage owner = (Stage) getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Tilmelding");
        alert.initOwner(owner);
        alert.setHeaderText("Are you sure you want to delete " + deltager.getNavn() + "?");

        // Wait for the modal dialog to close
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Service.removeDeltager(deltager);
            updateWhenWindowClosed();

        }

    }

    public void updateWhenWindowClosed() {
        updateWhenTabChanged();
    }

    public void updateWhenTabChanged() {
        this.lvwKonferencer.getItems().setAll(Service.getKonference());
        this.lvwHoteller.getItems().setAll(Service.getHotel());
        this.lvwDeltagere.getItems().setAll(Service.getDeltager());
        if (this.lvwKonferencer.getItems().size() > 0) {
            this.lvwKonferencer.getSelectionModel().select(0);
        }
        if (this.lvwHoteller.getItems().size() > 0) {
            this.lvwHoteller.getSelectionModel().select(0);
        }
        if (this.lvwDeltagere.getItems().size() > 0) {
            this.lvwDeltagere.getSelectionModel().select(0);
        }
    }
}