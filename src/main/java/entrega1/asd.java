package entrega1;

import java.util.ArrayList;

import org.uqbar.geodds.Point;

import entrega3.ActualizacionLocalComercial;

public class asd {
	public static void main(String[] args) {
		Mapa mapa = Mapa.getInstance();
		ArrayList<String> list = new ArrayList<>();
		POI p = new POI(new Point(2, 3), new Comuna());
		p.setNombre("Cine");
		list.add("entrada");
		list.add("pantalla");
		p.setTags(list);
		mapa.addPOI(p);
		ActualizacionLocalComercial a = new ActualizacionLocalComercial();
		a.execute();
		for (POI poi : mapa.getColeccionDePOIS()){
			System.out.println(p.getTags());
		}
	}

}
