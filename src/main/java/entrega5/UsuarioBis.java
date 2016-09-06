package entrega5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class UsuarioBis{
	private StringProperty nombreUsuario;
	private StringProperty password;

	public UsuarioBis(String nombreUsuario, String password) {
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
		this.password = new SimpleStringProperty(password);
	}

	//Metodos atributo: nombreUsuario
	public String getNombreUsuario() {
		return nombreUsuario.get();
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	}
	public StringProperty NombreUsuarioProperty() {
		return nombreUsuario;
	}
	//Metodos atributo: password
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password = new SimpleStringProperty(password);
	}
	public StringProperty PasswordProperty() {
		return password;
	}

	public static void llenarInformacionCMBUsuario(Connection connection, ObservableList<UsuarioBis> lista){

		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery(
					"SELECT nombre, "
					+ "password "
					+ "FROM usuario "
			);
			while (resultado.next()){
				lista.add(new UsuarioBis (resultado.getString("nombre"), resultado.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString(){
		return nombreUsuario.get();
	}
}