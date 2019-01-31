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

public class OpretUdflugtWindow extends Stage {
    private Konference konference;

    private TextField txfUdflugt, txfSted, txfPris, txfKonference;
    private ListView<Deltager> lvwDeltagere;
    private ListView<Konference> lvwKonference;
    private ComboBox<Hotel> comboHotel;
    private ListView<Udflugt> lvwUdflugter;
    private CheckBox chkForedrag;
    private ListView<HotelService> lvwService;
    private DatePicker date, dateSlut;
    private Label lblError;

    public OpretUdflugtWindow(Konference konference) {
        this.konference = konference;

        setTitle("Tilføj Udflugt");
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
        GridPane udflugtPane = new GridPane();
        udflugtPane.setGridLinesVisible(false);
        udflugtPane.setPadding(new Insets(40));
        udflugtPane.setPrefSize(375, 375);
        udflugtPane.setHgap(10);
        udflugtPane.setVgap(10);
        udflugtPane.setStyle("-fx-border-color: black; -fx-border-radius: 10 10 10 10;");
        pane.add(udflugtPane, 0, 0);

        txfUdflugt = new TextField();
        udflugtPane.add(txfUdflugt, 12, 0, 16, 1);

        Label lblUdflugt = new Label("Udflugts Navn: ");
        udflugtPane.add(lblUdflugt, 0, 0, 15, 1);

        txfSted = new TextField();
        udflugtPane.add(txfSted, 12, 2, 16, 1);

        Label lblSted = new Label("Udflugts Sted: ");
        udflugtPane.add(lblSted, 0, 2, 17, 1);

        Label lblStart = new Label("Start Dato: ");
        udflugtPane.add(lblStart, 0, 3, 10, 1);

        this.date = new DatePicker();
        udflugtPane.add(date, 12, 3, 16, 1);
        this.date.setEditable(false);

        txfPris = new TextField();
        udflugtPane.add(txfPris, 12, 5, 16, 1);

        Label lblPris = new Label("Udflugts Pris: ");
        udflugtPane.add(lblPris, 0, 5, 16, 1);

        Button btnCreate = new Button("OK");
        btnCreate.setOnAction(event -> createOKAction());

        Button btnDelete = new Button("Cancel");
        btnDelete.setOnAction(event -> createCancelAction());

        this.lblError = new Label("");

        HBox box = new HBox(5);
        box.getChildren().addAll(btnCreate, btnDelete, lblError);
        pane.add(box, 0, 1);

    }
    // ------------------------------------------------------------

    private void createOKAction() {
        if (txfUdflugt.getText() == null || date.getValue() == null || txfPris.getText().isEmpty() == true
                || txfSted.getText() == null) {
            lblError.setText("Fejl i data. Manglende indput!");
            return;
        } else {
            Service.createUdflugt(txfUdflugt.getText().trim(), txfSted.getText().trim(), date.getValue(),
                    Double.parseDouble(txfPris.getText()), this.konference);
            hide();
        }
    }

    private void createCancelAction() {
        hide();
    }
}