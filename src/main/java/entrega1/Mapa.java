package entrega1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.geodds.Point;

import javafx.scene.control.TextField;

public class Mapa {
	private static Mapa instance = null;

	public static Mapa getInstance() {
		if (instance == null) {
			instance = new Mapa();
		}
		return instance;
	}

	private Mapa() {
		this.setColeccionDePOIS(); // Inicizializa ArrayList de POIS
		this.setColeccionDeBusquedas(); // Inicializa ArrayList de Busquedas
		int cantidadDeBusquedas = 0;
	}

	// ATRIBUTOS

	public ArrayList<POI> coleccionDePOIS;
	public ArrayList<Busqueda> coleccionDeBusquedas;
	public int cantidadDeBusquedas;

	// GETTERS, SETTERS Y AGREGACIONES

	public void setColeccionDePOIS() {
		coleccionDePOIS = new ArrayList<POI>();
	}

	public ArrayList<POI> getColeccionDePOIS() {
		return coleccionDePOIS;
	}

	public void addPOI(POI unPOI) {
		System.out.println("lleno coleccion de POIs");
		coleccionDePOIS.add(unPOI);
	}

	public void setColeccionDeBusquedas() {
		coleccionDeBusquedas = new ArrayList<Busqueda>();
	}

	public ArrayList<Busqueda> getColeccionDeBusquedas() {
		return coleccionDeBusquedas;
	}

	public void addBusqueda(Busqueda unaBusqueda) {
		System.out.println("lleno coleccion de busquedas");
		coleccionDeBusquedas.add(unaBusqueda);
	}

	public void actualizarCantidadDeBusquedas() {
		this.cantidadDeBusquedas = coleccionDeBusquedas.size();
	}

	public int getCantidadDeBusquedas() {
		return coleccionDeBusquedas.size();
	}

	// Busqueda por texto libre

	public ArrayList<POI> buscarPorTextoLibre(String unTag) {

		return (ArrayList<POI>) this.getColeccionDePOIS().stream().filter(poi -> poi.detectarTagBuscado(unTag))
				.collect(Collectors.toList());
	}

	public void eliminarPOI(String unPOI) {
		ArrayList<POI> auxPois = new ArrayList<>(coleccionDePOIS);
		for (POI p : auxPois) {
			if (p.getNombre().equals(unPOI)) {
				coleccionDePOIS.remove(p);
			}
		}
	}

	public void modificarPOI(String poi, String nombre) {

		for (POI p : coleccionDePOIS) {
			if (p.getNombre().equals(poi)) {
				p.setNombre(nombre);
			}
		}
	}

	public void reportarBusquedasPorTag(String unTag) {

		int busquedasPorTag;
		busquedasPorTag = this.getColeccionDeBusquedas().stream().filter(busqueda -> busqueda.tagBuscado.equals(unTag))
				.collect(Collectors.toList()).size();
		System.out.println("Tag buscado: " + unTag + "    |Cantidad de búsquedas: " + busquedasPorTag);
	}

	public void reportarBusquedasPorUsuario(String unUsuario) {

		int busquedasPorUsuario;
		busquedasPorUsuario = this.getColeccionDeBusquedas().stream()
				.filter(busqueda -> busqueda.usuario.getNombreDeUsuario().equals(unUsuario))
				.collect(Collectors.toList()).size();
		System.out.println("Usuario: " + unUsuario + "    |Cantidad de búsquedas: " + busquedasPorUsuario);
	}

	public void reportarBusquedasPorFecha(LocalDate unaFecha) {

		int busquedasALaFecha;
		busquedasALaFecha = this.getColeccionDeBusquedas().stream()
				.filter(busqueda -> busqueda.fechaDeLaBusqueda.isBefore(unaFecha)).collect(Collectors.toList()).size();
		System.out.println("Fecha: " + unaFecha + "    |Cantidad de búsquedas: " + busquedasALaFecha);

	}

	public String buscarPOI(String poi) {
		for (POI p : coleccionDePOIS) {

			if (p.getNombre().equals(poi)) {
				System.out.println("Encontre al poi");
				return p.getNombre();
			}
		}
		return null;
	}

	public void agregarPOI(POI poi) {
		addPOI(poi);
		System.out.println(poi.getNombre());
	}

}
