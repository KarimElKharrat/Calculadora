package dad.calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculadoraController implements Initializable {

	// model

	private Calculadora calculadora;
	
	// view

	@FXML
	private GridPane view;

	@FXML
	private TextField resultadoText;

	@FXML
	private Button unoButton, dosButton, tresButton, cuatroButton, cincoButton, seisButton, sieteButton, ochoButton,
			nueveButton, ceroButton;
	@FXML
	private Button sumaButton, restaButton, multiplicacionButton, divisionButton;
	@FXML
	private Button comaButton, igualButton;
	@FXML
	private Button ceButton, cButton;

	public CalculadoraController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {

		// load data

		calculadora = new Calculadora();

		// bindings

		resultadoText.textProperty().bind(calculadora.pantallaProperty());

	}

	public void onDigitClickListener(ActionEvent e) {
		calculadora.insertar(((Button) e.getSource()).getText().charAt(0)); // recoger valor de texto de boton que ha
																			// accionado el listener
	}

	public void onComaClickListener(ActionEvent e) {
		calculadora.insertarComa();
	}

	public void onOperationClickListener(ActionEvent e) {
		calculadora.operar(((Button) e.getSource()).getText().charAt(0));
	}

	public void onDeleteClickListener(ActionEvent e) {
		if (((Button) e.getSource()).getText().equals("C"))
			calculadora.borrar();
		else
			calculadora.borrarTodo();
	}

	public GridPane getView() {
		return view;
	}

}
