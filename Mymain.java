package com.Mr_vishal.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Mymain extends Application {

	@Override
	public void init() throws Exception {
		super.init();
	}

	public static void main(String[] args){

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter  Tool");
		primaryStage.show();
	}

	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		//MenuItem newMenuItem = new MenuItem("New");

		//newMenuItem.setOnAction(event ->{ });

		//SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem =new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(quitMenuItem);

		Menu helpMenu  = new Menu("Help");
		MenuItem aboutApp  =new MenuItem("About");

		aboutApp.setOnAction(event -> { aboutApp();});
		helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
	}

	private void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);

		alertDialog.setTitle("T.C.T. 1.0");
		alertDialog.setHeaderText("Temperature Converter Tool");
		alertDialog.setContentText("This is a temperature converting tool." +
				"This tool can be used to convert celsius temperature to fahrenheit" +
				" and also fahrenheit to celsius.");
		ButtonType yesBtn = new ButtonType("OK");
		//ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn);

		Optional<ButtonType> clickedBtn= alertDialog.showAndWait();

		if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn)
		{
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
