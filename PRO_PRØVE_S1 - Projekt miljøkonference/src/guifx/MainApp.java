package guifx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import service.Service;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Service.initStorage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("KAS - Konference system");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    // ------------------------------------------------------------------------------------
    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabTilmeldinger = new Tab("Tilmeldings oversigt");
        tabPane.getTabs().add(tabTilmeldinger);

        TilmeldingsPane tilmeldingsPane = new TilmeldingsPane();
        tabTilmeldinger.setContent(tilmeldingsPane);

        Tab tabKonferenceOversigtPane = new Tab("Konference oversigt");
        tabPane.getTabs().add(tabKonferenceOversigtPane);

        KonferenceOversigtPane konferenceOversigtPane = new KonferenceOversigtPane();
        tabKonferenceOversigtPane.setContent(konferenceOversigtPane);

        Tab tabStorage = new Tab("Storage");
        tabPane.getTabs().add(tabStorage);

        StoragePane storagePane = new StoragePane();
        tabStorage.setContent(storagePane);

        tabStorage.setOnSelectionChanged(event -> setContentClickStorage(tilmeldingsPane, konferenceOversigtPane));
        tabTilmeldinger.setOnSelectionChanged(event -> setContentClickTilmelding(konferenceOversigtPane));
        tabKonferenceOversigtPane.setOnSelectionChanged(event -> setContentClickOversigt(storagePane, tilmeldingsPane));
    }

    private void setContentClickStorage(TilmeldingsPane tilmeldingsPane,
            KonferenceOversigtPane konferenceOversigtPane) {

        tilmeldingsPane.updateWhenTabChanged();
        konferenceOversigtPane.updateWhenTabChanged();
        System.out.println("fisk");

    }

    private void setContentClickTilmelding(KonferenceOversigtPane konferenceOversigtPane) {
        konferenceOversigtPane.updateWhenTabChanged();

    }

    private void setContentClickOversigt(StoragePane storagePane, TilmeldingsPane tilmeldingsPane) {
        storagePane.updateWhenTabChanged();
        tilmeldingsPane.updateWhenTabChanged();
    }

}
