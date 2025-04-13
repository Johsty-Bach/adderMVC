package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.AdderModel;

public class AdderController {

	AdderModel model;
	
    @FXML
    private Label ResultSum;

    @FXML
    private Button addButton;

    @FXML
    private TextField firstNumber;

    @FXML
    private TextField secondNumber;

    public void setModel(AdderModel newModel)
    {
      model=newModel;
      
      //Bind numbers
      StringConverter<Number> fmt = new NumberStringConverter();
      
      Bindings.bindBidirectional(ResultSum.textProperty(), model.getSumResult(), fmt);
    }
    
    private double getFirstNumber()
    {
      String val = firstNumber.textProperty().get();
      double amt = 0;
      
      try
      {
        amt = Double.parseDouble(val);
      }
      catch(NumberFormatException e)
      {
    	  firstNumber.textProperty().set("");
      }
      firstNumber.textProperty().set("");
      return amt;
    }
    
    private double getSecondNumber()
    {
      String val = secondNumber.textProperty().get();
      double amt = 0;
      
      try
      {
        amt = Double.parseDouble(val);
      }
      catch(NumberFormatException e)
      {
    	  secondNumber.textProperty().set("");
      }
	  secondNumber.textProperty().set("");
      return amt;
    }
    
    @FXML
    void addNumbers(ActionEvent event) {
    	model.addNumbers(getFirstNumber(), getSecondNumber());
    }

}
