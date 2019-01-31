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

public class HotelWindow extends Stage {
    private Konference konference;

    private Label lblError;
    private ListView<Hotel> lvwHoteller;

    public HotelWindow(Konference konference) {
        this.konference = konference;

        setTitle("Tilføj Hotel til konference");
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

        Label lblHoteller = new Label("Hoteller");
        hotelPane.add(lblHoteller, 0, 0);

        this.lvwHoteller = new ListView<>();
        lvwHoteller.setPrefSize(375, 300);
        hotelPane.add(lvwHoteller, 0, 1);
        this.lvwHoteller.getItems().setAll(Service.getHotel());
        this.lvwHoteller.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button btnCreateHotel = new Button("Opret Hotel");
        hotelPane.add(btnCreateHotel, 0, 2);
        btnCreateHotel.setOnAction(event -> createHotelAction());

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

    private void createHotelAction() {
        OpretHotelWindow til = new OpretHotelWindow(konference);
        til.showAndWait();
        lvwHoteller.getItems().setAll(Service.getHotel());

    }

    private void createOKAction() {
        for (Hotel hotel : this.lvwHoteller.getSelectionModel().getSelectedItems()) {
            Service.connectHotelToKonference(konference, hotel);
        }

        hide();
    }

    private void createCancelAction() {
        hide();
    }
}