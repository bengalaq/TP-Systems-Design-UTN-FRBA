package entrega4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Persona {

	@Id
	@GeneratedValue
	public int id;

	public String nombre;

	public Persona() {

	}

}
