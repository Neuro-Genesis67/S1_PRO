package guifx;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import model.Deltager;
import model.Hotel;
import model.HotelService;
import model.Konference;
import model.Tilmelding;
import model.Udflugt;
import service.Service;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TilmeldingsWindow extends Stage {
    private Konference konference = null;
    private Tilmelding tilmelding = null;
    private String buttonName;

    private TextField txfTilFra, txfLedsager;
    private ListView<Deltager> lvwDeltagere;
    private ComboBox<Hotel> comboHotel;
    private ListView<Udflugt> lvwUdflugter;
    private CheckBox chkForedrag;
    private ListView<HotelService> lvwService;
    private DatePicker ankomst, dateAfrejs, hotelFra, dateTilHotel;
    private Label lblError;

    public TilmeldingsWindow(String title, Konference konference) {
        this.konference = konference;
        buttonName = "Opret deltager";

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public TilmeldingsWindow(String title, Tilmelding tilmelding, Konference konference) {
        this.tilmelding = tilmelding;
        this.konference = konference;
        buttonName = "Rediger deltager";

        setTitle(title);
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
        GridPane deltagerPane = new GridPane();
        deltagerPane.setGridLinesVisible(false);
        deltagerPane.setPadding(new Insets(40));
        deltagerPane.setPrefSize(375, 375);
        deltagerPane.setHgap(10);
        deltagerPane.setVgap(10);
        deltagerPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        pane.add(deltagerPane, 0, 0);

        Label lblAnkomst = new Label("Ankomst Dato:* ");
        deltagerPane.add(lblAnkomst, 0, 12, 7, 1);

        this.ankomst = new DatePicker();
        deltagerPane.add(ankomst, 1, 12, 14, 1);
        this.ankomst.setEditable(false);

        this.dateAfrejs = new DatePicker();
        deltagerPane.add(this.dateAfrejs, 1, 13, 14, 1);
        this.dateAfrejs.setEditable(false);

        Label lblAfrejs = new Label("Afrejs Dato:* ");
        deltagerPane.add(lblAfrejs, 0, 13, 7, 1);

        this.chkForedrag = new CheckBox("Er du foredragsholder? ");
        deltagerPane.add(this.chkForedrag, 0, 15, 15, 1);
        Label lblDeltagere = new Label("Deltagere:* ");
        deltagerPane.add(lblDeltagere, 0, 0);

        lvwDeltagere = new ListView<>();
        lvwDeltagere.setPrefHeight(200);
        lvwDeltagere.setPrefWidth(375);
        deltagerPane.add(lvwDeltagere, 0, 1, 15, 10);
        lvwDeltagere.getItems().setAll(Service.getDeltager());

        Button btnCreate = new Button(this.buttonName);
        deltagerPane.add(btnCreate, 0, 17);
        btnCreate.setOnAction(event -> DeltagerAction());

        GridPane hotelPane = new GridPane();
        hotelPane.setGridLinesVisible(false);
        hotelPane.setPadding(new Insets(40));
        hotelPane.setPrefSize(375, 375);
        hotelPane.setHgap(10);
        hotelPane.setVgap(10);
        hotelPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        pane.add(hotelPane, 1, 0);

        Label lblhotel = new Label("Hoteller:");
        hotelPane.add(lblhotel, 0, 0);

        this.comboHotel = new ComboBox<>();
        this.comboHotel.setPrefSize(375, 50);
        hotelPane.add(this.comboHotel, 0, 1, 15, 1);

        ChangeListener<Hotel> listenerHotel = (ov, oldHotel, newHotel) -> selectedHotelChanged();
        this.comboHotel.getSelectionModel().selectedItemProperty().addListener(listenerHotel);

        Label lblFra = new Label("Fra: ");
        hotelPane.add(lblFra, 0, 2);
        this.hotelFra = new DatePicker();
        hotelPane.add(this.hotelFra, 1, 2, 14, 1);

        Label lblTil = new Label("Til: ");
        hotelPane.add(lblTil, 0, 3);
        this.dateTilHotel = new DatePicker();
        hotelPane.add(this.dateTilHotel, 1, 3, 14, 1);

        Label lblServices = new Label("Hotellets Services:");
        hotelPane.add(lblServices, 0, 6);

        lvwService = new ListView<>();
        hotelPane.add(this.lvwService, 0, 7, 15, 1);
        lvwService.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        GridPane ledsagerPane = new GridPane();
        ledsagerPane.setGridLinesVisible(false);
        ledsagerPane.setPadding(new Insets(40));
        ledsagerPane.setVgap(10);
        ledsagerPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        pane.add(ledsagerPane, 2, 0);

        Label lblInfo = new Label("Ledsager: ");
        ledsagerPane.add(lblInfo, 0, 0);

        Label lblNavn = new Label("Ledsager navn: ");
        ledsagerPane.add(lblNavn, 0, 1);

        this.txfLedsager = new TextField();
        ledsagerPane.add(this.txfLedsager, 1, 1);

        Label lblId = new Label("Udflugter: ");
        ledsagerPane.add(lblId, 0, 2);

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(60, 300);
        ledsagerPane.add(this.lvwUdflugter, 0, 3, 10, 1);

        Button ok = new Button("OK");
        ok.setOnAction(event -> OkAction());

        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> CancelAction());

        this.lblError = new Label("");
        lblError.setStyle("-fx-text-fill: red");

        HBox box = new HBox(5);
        box.getChildren().addAll(ok, cancel, this.lblError);
        pane.add(box, 2, 1);

        if (tilmelding != null) {
            Button btnClearHotel = new Button("Clear booking");
            btnClearHotel.setOnAction(Event -> clearBookingAction());
            pane.add(btnClearHotel, 1, 1);
        }

        initControls();

    }

    private void clearBookingAction() {
        this.comboHotel.getSelectionModel().clearSelection();
        this.dateTilHotel.setValue(null);
        this.hotelFra.setValue(null);
        this.lvwService.getSelectionModel().clearSelection();
        this.lvwService.getItems().setAll();
        Service.deleteBooking(tilmelding);
    }

    private void selectedHotelChanged() {
        Hotel hotel = this.comboHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            this.lvwService.getItems().setAll(hotel.getHotelServices());
        }
    }

    private void DeltagerAction() {
        if (this.tilmelding == null) {
            OpretDeltagerWindow del = new OpretDeltagerWindow();
            del.showAndWait();
        } else {
            OpretDeltagerWindow rediger = new OpretDeltagerWindow(tilmelding.getDeltager());
            rediger.showAndWait();
        }
        lvwDeltagere.getItems().setAll(Service.getDeltager());

    }

    private void initControls() {
        if (this.tilmelding != null) {
            comboHotel.getItems().addAll(konference.getHoteller());
            this.lvwUdflugter.getItems().setAll(konference.getUdflugter());
            this.lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            this.lvwDeltagere.getItems().setAll(Service.getDeltager());
            this.lvwDeltagere.getSelectionModel().select(tilmelding.getDeltager());
            this.ankomst.setValue(tilmelding.getAnkomstDato());
            this.dateAfrejs.setValue(tilmelding.getAfrejseDato());

            if (tilmelding.isForedragsholder()) {
                this.chkForedrag.setSelected(true);
            }

            if (this.tilmelding.getBooking() != null) {
                this.comboHotel.getSelectionModel().select(tilmelding.getBooking().getHotel());
                this.hotelFra.setValue(tilmelding.getBooking().getFra());
                this.dateTilHotel.setValue(tilmelding.getBooking().getTil());
                if (this.tilmelding.getBooking().getHotelServicesValgt() != null) {
                    for (HotelService hs : tilmelding.getBooking().getHotelServicesValgt()) {
                        this.lvwService.getSelectionModel().select(hs);
                    }

                }
            }
            if (tilmelding.getLedsager() != null) {
                this.txfLedsager.setText(tilmelding.getLedsager().getNavn());
                if (tilmelding.getLedsager().getUdflugter() != null) {
                    for (Udflugt ud : tilmelding.getLedsager().getUdflugter()) {
                        this.lvwUdflugter.getSelectionModel().select(ud);
                    }
                }
            }

        } else if (this.tilmelding == null) {
            comboHotel.getItems().addAll(konference.getHoteller());
            this.lvwUdflugter.getItems().setAll(konference.getUdflugter());
            this.lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }

    }

    private void OkAction() {
        LocalDate hotelTil = this.dateTilHotel.getValue();
        LocalDate hotelFra = this.hotelFra.getValue();
        LocalDate ankomst = this.ankomst.getValue();
        LocalDate afrejs = this.dateAfrejs.getValue();
        Hotel hotel = this.comboHotel.getSelectionModel().getSelectedItem();
        if (this.tilmelding == null) {
            if (this.lvwDeltagere.getSelectionModel().getSelectedItem() == null) {
                lblError.setText("Deltager missing");
                return;
            }
            if (ankomst == null || afrejs == null) {
                lblError.setText("Konference duration missing");
                return;
            } else {
                Tilmelding til = Service.createTilmelding(ankomst, afrejs,
                        this.lvwDeltagere.getSelectionModel().getSelectedItem(), konference);
                if (this.chkForedrag.isSelected()) {
                    Service.setDeltagerAsForedragsholder(true, til);
                }

                if (hotel != null && hotelFra != null && hotelTil != null) {
                    // booking
                    Service.createBooking(hotelTil, hotelFra, hotel, til);

                    if (this.lvwService.getSelectionModel().getSelectedItems() != null) {
                        for (HotelService service : this.lvwService.getSelectionModel().getSelectedItems()) {
                            Service.connectHotelServiceToBooking(service, til);
                        }
                    }

                }
                // Ledsager
                if (this.txfLedsager.getText().trim().length() != 0) {
                    Service.createLedsager(this.txfLedsager.getText(), til);
                    if (this.lvwUdflugter.getSelectionModel().getSelectedItems() != null) {
                        for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
                            Service.connectLedsagerToUdflugt(til, udflugt);
                        }

                    }
                }

                hide();
            }
        } else if (this.tilmelding != null) {
            Service.updateTilmelding(tilmelding, tilmelding.getDeltager(), afrejs, this.ankomst.getValue());

            if (tilmelding.getBooking() != null) {
                tilmelding.getBooking().setHotel(hotel);
                tilmelding.getBooking().setTil(hotelTil);
                tilmelding.getBooking().setFra(hotelFra);
                if (tilmelding.getBooking().getHotelServicesValgt() != null) {
                    tilmelding.getBooking().clearList();
                    for (HotelService hs : this.lvwService.getSelectionModel().getSelectedItems()) {
                        Service.connectHotelServiceToBooking(hs, tilmelding);
                    }
                }

            } else {

                if (hotel != null && hotelTil == null && hotelFra == null) {

                    this.lblError.setText("Hotel booking info missing");
                    return;

                } else if (hotel != null && hotelTil != null && hotelFra != null) {
                    Service.createBooking(hotelTil, hotelFra, hotel, tilmelding);
                    if (this.lvwService.getSelectionModel().getSelectedItems() != null) {
                        for (HotelService hs : this.lvwService.getSelectionModel().getSelectedItems()) {
                            Service.connectHotelServiceToBooking(hs, tilmelding);
                        }
                    }
                }
            }

            if (this.txfLedsager.getText().trim().length() != 0) {
                if (tilmelding.getLedsager() != null) {
                    this.tilmelding.getLedsager().setNavn(txfLedsager.getText().trim());
                } else {
                    Service.createLedsager(this.txfLedsager.getText(), tilmelding);

                }
                if (this.lvwUdflugter.getSelectionModel().getSelectedItems() != null) {
                    tilmelding.getLedsager().clearList();
                    for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
                        Service.connectLedsagerToUdflugt(tilmelding, udflugt);
                    }
                }
            } else {
                Service.deleteLedsager(tilmelding);

            }
        }

        hide();
    }

    private void CancelAction() {
        hide();
    }
}
