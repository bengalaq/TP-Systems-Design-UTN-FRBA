package entrega1;

import entrega2.Usuario;

//TODO: Desde los controllers le digo al admin que cree/elimine etc, pois.
//Esta clase actuaria de pasamano. Habria que ver que otras responsabilidades asignarle

public class Administrador extends Usuario {
	public Mapa mapa;

	public Administrador() {
		// mapa = new Mapa();
	}

	public void agregarPOI(POI unPOI) {
		mapa.addPOI(unPOI);
	}

	public void eliminarPOI(POI unPOI) {
		mapa.eliminarPOI(unPOI.getNombre());
	}

	public void modificarPOI(POI unPOI, String nombre) {
		mapa.modificarPOI(unPOI.getNombre(), nombre);
	}
}
