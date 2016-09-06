package entrega1;

import org.uqbar.geodds.Point;
import java.util.ArrayList;
import java.lang.String;
import java.time.LocalDateTime;

public class POI {

	// CONSTRUCTOR

	public POI(Point unaUbicacion, Comuna unaComuna) {
		setComuna(unaComuna);
		setUbicacion(unaUbicacion);
	}
	
	public POI(){ 
		
	}

	// ATRIBUTOS

	private Comuna comuna;
	public StrategyPOI estrategia;
	private Point ubicacion;
	private String nombre;
	private String direccion;
	private ArrayList<String> tags = new ArrayList<String>(); // Array de String que contienen todos los
									// tags de busqueda libre


	// GETTERS Y SETTERS

	


	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public Point getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Point unaUbicacion) {
		ubicacion = unaUbicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String unNombre) {
		// if(nombre != null){
		// this.autoDetectTag(nombre, true);
		// }
		nombre = unNombre;
		// this.autoDetectTag(nombre, false);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String unaDireccion) {
		// if(direccion != null){
		// this.autoDetectTag(direccion, true);
		// }
		direccion = unaDireccion;
		// this.autoDetectTag(direccion, false);
	}

	public void setTags() { // Inicializa el ArrayList
		tags = new ArrayList<String>();
	}

	public void addTag(String tag) {// Agrega un tag al ArrayList
		tags.add(tag);
	}

	public void removeTag(String tag) {
		tags.remove(tag);
	}

	/*
	 * Generado de tags automaticamente al instanciar un nombre y direccion
	 * 
	 * public void autoDetectTag(String identificador, boolean remover){ //El
	 * booleando indica si la funcion va a remover o agregar Tags String
	 * identificadorTag = new String(identificador); String[]
	 * partesIdentificador = identificadorTag.split(" "); int i; if (remover){
	 * this.removeTag(identificador); for(i = 0; i < partesIdentificador.length;
	 * i++){ this.removeTag(partesIdentificador[i]); } }else{
	 * this.addTag(identificador); for(i = 0; i < partesIdentificador.length;
	 * i++){ this.addTag(partesIdentificador[i]); } } }
	 */

	/*
	 * public void setRangoDeAtencionDeUnServicio(String
	 * unNombreDeServicio,RangoDeAtencion unRangoDeAtencion){
	 * this.getServicio(unNombreDeServicio
	 * ).setRangoDeAtencion(unRangoDeAtencion); }
	 */// despues veo para que sirve

	// METODOS

	public boolean estaAMenosDeXMetrosDeOtroPOI(POI otroPOI, double metros) {
		return this.getUbicacion().distance(otroPOI.getUbicacion()) * 1000 < metros; // Para
																						// pasarlo
																						// a
																						// metros
	}

	public boolean esPOIValido() {
		return this.estaGeolocalizado() && this.tieneNombre();
	}

	public boolean estaGeolocalizado() {
		return this.getUbicacion() != null;
	}

	public boolean tieneNombre() {
		return this.getNombre() != null;
	}

	public boolean estaDisponible(LocalDateTime unTiempo) {
		return estrategia.estaDisponible(unTiempo);
	}

	// Busqueda por texto libre
	public boolean detectarTagBuscado(String unTag) {
		return estrategia.detectarTagBuscado(unTag);
	}

	// Calculo de cercania

	public boolean estaCercaDe(Point unaUbicacion) {
		return estrategia.estaCercaDe(unaUbicacion);
	}

	public boolean estaCercaDeUnPOI(POI unPOI) {
		return this.estaAMenosDeXMetrosDeOtroPOI(unPOI, 500); // para pasar a
																// metros
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}


}
