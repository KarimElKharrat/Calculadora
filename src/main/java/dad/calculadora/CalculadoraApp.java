package dad.calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {

	private CalculadoraController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new CalculadoraController();
		
		primaryStage.setTitle("Calculadora");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
