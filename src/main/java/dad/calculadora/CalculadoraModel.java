package dad.calculadora;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CalculadoraModel {

	private StringProperty valorPantalla = new SimpleStringProperty();

	public final StringProperty valorPantallaProperty() {
		return this.valorPantalla;
	}

	public final String getValorPantalla() {
		return this.valorPantallaProperty().get();
	}

	public final void setValorPantalla(final String valorPantalla) {
		this.valorPantallaProperty().set(valorPantalla);
	}
	
}
