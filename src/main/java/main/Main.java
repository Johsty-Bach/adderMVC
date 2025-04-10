package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.AdderModel;
import views.AdderController;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		AdderModel model = new AdderModel();
		 
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(Main.class.getResource("../views/AdderView.fxml"));
	    VBox view = loader.load();
	    AdderController adderController = loader.getController();
	    adderController.setModel(model);
	    
	    
	    Scene s = new Scene(view);
	    primaryStage.setScene(s);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
