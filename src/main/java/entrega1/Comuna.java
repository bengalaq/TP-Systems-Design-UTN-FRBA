package entrega1;

import org.uqbar.geodds.Polygon;

public class Comuna {

	//ATRIBUTOS
	private String nombre;
	
	private Polygon zona;
	
	//GETERS Y SETERS 
	
	public Polygon getZona() {
		return zona;
	}

	public void setZona(Polygon zona) {
		this.zona = zona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
