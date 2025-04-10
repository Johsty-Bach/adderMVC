package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class AdderModel {
	DoubleProperty sumResult = new SimpleDoubleProperty();
	
	public AdderModel() {}


	public DoubleProperty getSumResult() {
		return sumResult;
	}


	public void addNumbers(double nOne, double nTwo) {
		sumResult.set(nOne + nTwo);
	}
}
