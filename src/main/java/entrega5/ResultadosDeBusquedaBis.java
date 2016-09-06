package entrega5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class ResultadosDeBusquedaBis{
	private BusquedaBis busqueda;
	private StringProperty resultado;

	public ResultadosDeBusquedaBis(BusquedaBis busqueda, String resultado) {
		this.busqueda = busqueda;
		this.resultado = new SimpleStringProperty(resultado);
	}

	//Metodos atributo: busqueda
	public BusquedaBis getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(BusquedaBis busqueda) {
		this.busqueda = busqueda;
	}
	//Metodos atributo: resultado
	public String getResultado() {
		return resultado.get();
	}
	public void setResultado(String resultado) {
		this.resultado = new SimpleStringProperty(resultado);
	}
	public StringProperty ResultadoProperty() {
		return resultado;
	}

}