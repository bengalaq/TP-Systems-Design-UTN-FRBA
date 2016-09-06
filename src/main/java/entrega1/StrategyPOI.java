package entrega1;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.uqbar.geodds.Point;

public abstract class StrategyPOI {
	private Point ubicacion;
	private String nombre;
	private String direccion;
	private Comuna comuna;
	private ArrayList<String> tags;


	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags() {
		tags = new ArrayList<String>();
	}

	public Point getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public StrategyPOI(Point unaUbicacion, Comuna unaComuna) {
		this.setUbicacion(unaUbicacion);
		this.setTags(); // Para inicializar el Array
		this.setComuna(unaComuna);
	}

	public double cercaniaRequerida() { // Defino la cercania requerida standar
		return 500.0;
	}

	abstract boolean estaDisponible(LocalDateTime unTiempo);

	public boolean estaCercaDe(Point unaUbicacion) {
		return this.getUbicacion().distance(unaUbicacion) * 1000 < this
				.cercaniaRequerida();
	}

	// Busqueda por texto libre
	public boolean detectarTagBuscado(String unTag) {
		return tags.contains(unTag);
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

	public abstract void crearVista();

}
