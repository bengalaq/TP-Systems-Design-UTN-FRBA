package entrega3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import entrega1.Mapa;
import entrega1.POI;

public class ActualizacionLocalComercial {
	Mapa mapa = Mapa.getInstance();
	LecturaArchivoTexto archivo = new LecturaArchivoTexto();

	public void execute() {
		archivo.procesar();
		Iterator<String> it = archivo.getMap().keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("Cave: " + key + " -> Valor: " + archivo.getMap().get(key));
			validarContenido(key, archivo.getMap().get(key));
		}
	}

	private void validarContenido(String key, List<String> values) {
		ArrayList<POI> aux = new ArrayList<POI>(mapa.coleccionDePOIS);
		for (POI p : aux) {
			if (p.getNombre().equals(key)) {
				HashSet<String> hs = new HashSet<String>();
				hs.addAll(p.getTags());
				hs.addAll(values);
				p.getTags().clear();
				p.getTags().addAll(hs);
			} else
				System.out.println("No existe el poi con el nombre " + key + " , crearlo.");
		}
	}
}
