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

public class OpretDeltagerWindow extends Stage {

    private TextField txfNavn, txfAlder, txfBy, txfAdresse, txfLand, txfTelefonNr, txfFirmaNavn, txfFirmaTlfNr;

    private Label lblError;

    public OpretDeltagerWindow() {

        setTitle("Opret deltager");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private Deltager deltager = null;

    public OpretDeltagerWindow(Deltager deltager) {
        this.deltager = deltager;
        setTitle("Rediger deltager");
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

        Label lblNavn = new Label("Navn:* ");
        deltagerPane.add(lblNavn, 0, 0);

        this.txfNavn = new TextField();
        this.txfNavn.setPromptText("Hans Jensen");
        this.txfNavn.setFocusTraversable(false);
        deltagerPane.add(this.txfNavn, 3, 0);

        Label lblAlder = new Label("Alder:* ");
        deltagerPane.add(lblAlder, 0, 1);

        this.txfAlder = new TextField();
        this.txfAlder.setPromptText("24 år");
        this.txfAlder.setFocusTraversable(false);
        deltagerPane.add(this.txfAlder, 3, 1);

        Label lblBy = new Label("By:* ");
        deltagerPane.add(lblBy, 0, 2);

        this.txfBy = new TextField();
        this.txfBy.setPromptText("Aarhus");
        this.txfBy.setFocusTraversable(false);
        deltagerPane.add(this.txfBy, 3, 2);

        Label lblAdresse = new Label("Adresse:* ");
        deltagerPane.add(lblAdresse, 0, 3);

        this.txfAdresse = new TextField();
        this.txfAdresse.setPromptText("Vej 17");
        this.txfAdresse.setFocusTraversable(false);
        deltagerPane.add(txfAdresse, 3, 3);

        Label lblTelefonNr = new Label("Tlf:* ");
        deltagerPane.add(lblTelefonNr, 0, 4);

        this.txfTelefonNr = new TextField();
        this.txfTelefonNr.setPromptText("70 12 14 16");
        this.txfTelefonNr.setFocusTraversable(false);
        deltagerPane.add(txfTelefonNr, 3, 4);

        Label lblLand = new Label("Land: ");
        deltagerPane.add(lblLand, 0, 5);

        this.txfLand = new TextField();
        this.txfLand.setPromptText("Denmark");
        this.txfLand.setFocusTraversable(false);
        deltagerPane.add(this.txfLand, 3, 5);

        Label lblFirmaNavn = new Label("Firma navn: ");
        deltagerPane.add(lblFirmaNavn, 0, 6, 4, 1);

        this.txfFirmaNavn = new TextField();
        this.txfFirmaNavn.setPromptText("Bobs vaskehus");
        this.txfFirmaNavn.setFocusTraversable(false);
        deltagerPane.add(this.txfFirmaNavn, 3, 6);

        Label lblFirmaNr = new Label("Firma tlf: ");
        deltagerPane.add(lblFirmaNr, 0, 7, 4, 1);

        this.txfFirmaTlfNr = new TextField();
        this.txfFirmaTlfNr.setPromptText("20 20 20 20");
        this.txfFirmaTlfNr.setFocusTraversable(false);
        deltagerPane.add(this.txfFirmaTlfNr, 3, 7);

        Button ok = new Button("OK");
        ok.setOnAction(Event -> okAction());

        Button cancel = new Button("Cancel");
        cancel.setOnAction(Event -> cancelAction());

        lblError = new Label("");
        lblError.setStyle("-fx-text-fill: red");

        HBox box = new HBox(5);
        box.getChildren().addAll(ok, cancel, lblError);
        pane.add(box, 0, 1);

        initControl();

    }

    private void initControl() {
        if (this.deltager != null) {
            txfNavn.setText(deltager.getNavn());
            txfAlder.setText(deltager.getAlder() + "");
            txfAdresse.setText(deltager.getAdresse());
            txfTelefonNr.setText(deltager.getTelefonNr());
            txfBy.setText(deltager.getBy());
            if (deltager.getLand() != null) {
                txfLand.setText(deltager.getLand());
            }
            if (deltager.getFirmaNavn() != null && deltager.getFirmatlfNr() != null) {
                txfFirmaNavn.setText(deltager.getFirmaNavn());
                txfFirmaTlfNr.setText(deltager.getFirmatlfNr());
            }
        }
    }

    private void okAction() {

        String deltagerNavn = this.txfNavn.getText().trim();
        int alder = -1;
        alder = Integer.parseInt(txfAlder.getText().trim());
        String by = this.txfBy.getText().trim();
        String adress = this.txfAdresse.getText().trim();
        String phone = this.txfTelefonNr.getText().trim();
        if (deltagerNavn.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }

        else if (alder < 0) {
            lblError.setText("Age is empty");
            return;
        }

        else if (by.length() == 0) {
            lblError.setText("City is empty");
            return;
        }

        else if (adress.length() == 0) {
            lblError.setText("Adress is empty");
            return;
        }

        else if (phone.length() == 0) {
            lblError.setText("Phone is empty");
            return;
        } else {
            if (deltager == null) {
                Deltager d = Service.createDeltager(deltagerNavn, alder, by, adress, phone);
                if (this.txfLand.getText().trim().length() != 0) {
                    d.setLand(this.txfLand.getText().trim());
                }
                if (this.txfFirmaNavn.getText().trim().length() != 0
                        && this.txfFirmaTlfNr.getText().trim().length() != 0) {
                    d.setFirmaNavn(this.txfFirmaNavn.getText().trim());
                    d.setFirmatlfNr(this.txfFirmaTlfNr.getText().trim());
                }

            } else {
                Service.updateDeltager(deltager, deltagerNavn, alder, by, adress, phone);
                if (this.txfLand.getText().trim().length() != 0) {
                    deltager.setLand(this.txfLand.getText().trim());
                }
                if (this.txfFirmaNavn.getText().trim().length() != 0
                        && this.txfFirmaTlfNr.getText().trim().length() != 0) {
                    deltager.setFirmaNavn(this.txfFirmaNavn.getText().trim());
                    deltager.setFirmatlfNr(this.txfFirmaTlfNr.getText().trim());
                }
            }
            hide();
        }

    }

    private void cancelAction() {
        hide();
    }

}
