package dad.calculadora;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Implementaci�n de la l�gica de una calculadora.
 * @author Fran Vargas
 */
public class Calculadora {
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private static final char COMA = '.'; 
	
	private Double operando;
	private char operador;
	private Boolean nuevoOperando;
	//TODO crear pantalla con property
	private StringProperty pantalla = new SimpleStringProperty();
	
	public Calculadora() {
		borrar();
	}
	
	/**
	 * Devuelve el contenido de la pantalla de la calculadora.
	 * @return Cadena de texto con el contenido de la pantalla de la calculdora.
	 */
	public StringProperty pantallaProperty() {
		return pantalla;
	}
	
	public String getPantalla() {
		return pantalla.get();
	}
	
	public void setPantalla(String s) {
		pantalla.set(s);
	}

	/**
	 * Inicializa por completo la calculadora, borrando la informaci�n que tiene memorizada y la pantalla.
	 */
	public void borrar() {
		operando = 0.0;
		operador = '=';
		borrarTodo();
	}
	
	/**
	 * Borra lo que hay en la pantalla (el �ltimo operando introducido).
	 */
	public void borrarTodo() {
		nuevoOperando = true;
		setPantalla("0.0");
	}
	
	/**
	 * Indica a la calculadora que realice la operaci�n indicada. 
	 * @param operador Operación a realizar; usar una constante: IGUAL, SUMAR, RESTAR, MULTIPLCIAR, DIVIDIR.
	 */
	public void operar(char operador) {
		nuevoOperando = true;
		double operando2 = Double.parseDouble(getPantalla());
		switch (this.operador) {
			case SUMAR: operando += operando2; break;
			case RESTAR: operando -= operando2; break;
			case MULTIPLICAR: operando *= operando2; break;
			case DIVIDIR: operando /= operando2; break;
			case IGUAL: operando = operando2; break;
		}
		this.operador = operador;
		pantalla.set("" + operando);
	}
	
	/**
	 * Inserta una coma en el operando actual (pantalla).
	 */
	public void insertarComa() {
		if (!getPantalla().contains("" + COMA)) {
			setPantalla(getPantalla() + COMA);
		}
	}
	
	/**
	 * Inserta un d�gito en el operando actual (pantalla).
	 * @param digito Digito a introducir en la pantalla.
	 */
	public void insertar(char digito) {
		if (digito >= '0' && digito <= '9') {
			if (nuevoOperando) {
				nuevoOperando = false;
				setPantalla("");
			}
			setPantalla(getPantalla() + digito);
		} else if (digito == COMA) {
			insertarComa();
		}
	}
	
}
