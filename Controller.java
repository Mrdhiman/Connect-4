package com.Mr_vishal.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
	public Label welLabel;

    @FXML
    public ChoiceBox<String> chBox;

    @FXML
    public TextField textBox;

    @FXML
    public Button convertButton;

    private static final String C_to_F="Celsius to Fahrenheit";
    private static final String F_to_C="Fahrenheit to Celsius";
    private boolean isC_to_F = true;

    @Override
	public void initialize(URL location, ResourceBundle resources) {

    	chBox.getItems().addAll(C_to_F);
        chBox.getItems().addAll(F_to_C);

        chBox.setValue(C_to_F);
        chBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        if (newValue.equals(C_to_F)) {
			        isC_to_F = true;
		        } else {
			        isC_to_F = false;
		        }
	        }
	        });




    	convertButton.setOnAction(event -> {
             convert();
	    });
	}

	private void convert() {
    String input =	textBox.getText();
    float enteredTemp=0.0f;
    try{
    	 enteredTemp = Float.parseFloat(input);
    }catch (Exception exception){
    	warnUser();
    	return;
    }
    float temp = 0.0f;
    if(isC_to_F)
    {
    	temp=(enteredTemp*9/5)+32;
    }
    else
    {
    	temp=(enteredTemp-32)*5/9;
    }
    
    display(temp);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter Valid Temperature");
		alert.show();

    }

	private void display(float temp) {
    	String unit = isC_to_F ? " F" : " C";
		System.out.println("The new temperature is: "+temp+"°"+unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setHeaderText("Temperature After Conversion");
		alert.setContentText("The new temperature is: "+temp+"°"+unit);
		alert.show();
	}
}
