package guifx;

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

public class OpretKonferenceWindow extends Stage {
    private Konference konference;

    private TextField txfKonference, txfSted, txfPris;
    private DatePicker dateStart, dateSlut;
    private Label lblError;

    public OpretKonferenceWindow(Konference konference) {
        this.konference = konference;

        setTitle("Rediger Konference");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public OpretKonferenceWindow() {
        this.konference = null;

        setTitle("Opret Konference");
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
        GridPane konferencePane = new GridPane();
        konferencePane.setGridLinesVisible(false);
        konferencePane.setPadding(new Insets(40));
        konferencePane.setPrefSize(375, 375);
        konferencePane.setHgap(10);
        konferencePane.setVgap(10);
        konferencePane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        pane.add(konferencePane, 0, 0);

        txfKonference = new TextField();
        konferencePane.add(txfKonference, 12, 0, 16, 1);

        Label lblKonference = new Label("Konference Navn: ");
        konferencePane.add(lblKonference, 0, 0, 15, 1);

        txfSted = new TextField();
        konferencePane.add(txfSted, 12, 2, 16, 1);

        Label lblSted = new Label("Konference Sted: ");
        konferencePane.add(lblSted, 0, 2, 17, 1);

        Label lblStart = new Label("Start Dato: ");
        konferencePane.add(lblStart, 0, 3, 10, 1);

        this.dateStart = new DatePicker();
        konferencePane.add(dateStart, 12, 3, 16, 1);
        this.dateStart.setEditable(false);

        Label lblSlut = new Label("Slut Dato: ");
        konferencePane.add(lblSlut, 0, 4, 10, 1);

        this.dateSlut = new DatePicker();
        konferencePane.add(this.dateSlut, 12, 4, 16, 1);
        this.dateSlut.setEditable(false);

        txfPris = new TextField();
        konferencePane.add(txfPris, 12, 5, 16, 1);

        Label lblPris = new Label("Konference Pris: ");
        konferencePane.add(lblPris, 0, 5, 16, 1);

        Button btnCreate = new Button("OK");
        btnCreate.setOnAction(event -> createOKAction());

        Button btnDelete = new Button("Cancel");
        btnDelete.setOnAction(event -> createCancelAction());

        this.lblError = new Label("");

        HBox box = new HBox(5);
        box.getChildren().addAll(btnCreate, btnDelete, lblError);
        pane.add(box, 0, 1);

        initRediger();
    }
    // ------------------------------------------------------------

    private void initRediger() {
        if (konference != null) {
            txfKonference.setText(konference.getNavn());
            dateStart.setValue(konference.getStartDato());
            dateSlut.setValue(konference.getSlutDato());
            txfPris.setText(Double.toString(konference.getKonferencePris()));
            txfSted.setText(konference.getSted());
        }
    }

    private void createOKAction() {
        if (konference == null) {
            if (txfKonference.getText() == null || dateStart.getValue() == null || dateSlut.getValue() == null
                    || txfPris.getText().isEmpty() == true || txfSted.getText() == null) {
                lblError.setText("Fejl i data. Manglende indput!");
                return;
            } else {
                Service.createKonference(txfKonference.getText().trim(), txfSted.getText().trim(), dateStart.getValue(),
                        dateSlut.getValue(), Double.parseDouble(txfPris.getText()));

            }
        } else if (konference != null) {
            konference.setNavn(txfKonference.getText().trim());
            konference.setStartDato(dateStart.getValue());
            konference.setSlutDato(dateSlut.getValue());
            konference.setKonferencePris(Double.parseDouble(txfPris.getText()));
            konference.setSted(txfSted.getText());
        }
        hide();
    }

    private void createCancelAction() {
        hide();
    }

}