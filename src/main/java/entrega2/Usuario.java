package entrega2;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	// ATRIBUTOS
	@Id
	String nombre;

	String password;

	@ElementCollection
	private List<String> acciones;

	public List<String> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<String> acciones) {
		this.acciones = acciones;
	}

	private int esAdmin;

	// GETTERS Y SETTERS

	public String getNombreDeUsuario() {
		return nombre;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombre = nombreDeUsuario;
	}

	public String getPasswordUsuario() {
		return password;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.password = passwordUsuario;
	}

	public int getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(int esAdmin) {
		this.esAdmin = esAdmin;
	}

}
