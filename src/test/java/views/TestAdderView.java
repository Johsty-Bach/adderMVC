package views;


import java.io.IOException;

import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import models.AdderModel;

@ExtendWith(ApplicationExtension.class)
public class TestAdderView {

	@Start //Before
	private void start(Stage stage) {
		AdderModel model = new AdderModel();
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(Main.class.getResource("../views/AdderView.fxml"));
	    try {
		    VBox view = loader.load();
		    AdderController adderController = loader.getController();
		    adderController.setModel(model);
		    
		    Scene newScene = new Scene(view);
		    stage.setScene(newScene);
		    stage.show();
		    
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	//Helper functions
	private void enterNumberField(FxRobot robot, String amount, String inputFieldID) {
		robot.clickOn(inputFieldID);
		robot.write(amount);
	}
	
	private void checkAnswer(FxRobot robot, String answer) {
		Assertions.assertThat(robot.lookup("#resultLabel")
				.queryAs(Label.class)).hasText(answer);
	}
	
	private void checkAddNumbers(FxRobot robot, String numOne, String numTwo, String result) {
		enterNumberField(robot, numOne, "#firstNumberInputField");
		enterNumberField(robot, numTwo, "#secondNumberInputField");
		robot.clickOn("#addNumbersButton");
		checkAnswer(robot, result);
	}
	
	//Tests
	@Test
	public void testAddBasicCase(FxRobot robot) {
		checkAddNumbers(robot, "10", "20", "30");
		checkAddNumbers(robot, "1", "2", "3");
		checkAddNumbers(robot, "1.5", "2.5", "4");
		checkAddNumbers(robot, "-1", "1", "0");
		checkAddNumbers(robot, "-5", "6", "1");

	}
	
}
