package entrega4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Perro {
	@Id@GeneratedValue
	public int id;

	public String nombre;

	public Perro() {

	}
	@ManyToOne
	public Persona persona;
}
