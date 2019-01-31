package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Semesterprøve Juni 2014");
		
		
		GridPane pane = new GridPane();
		initContent(pane);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
	private void initContent(GridPane pane) {
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPrefSize(400, 500);
		
		
		
	}

}
