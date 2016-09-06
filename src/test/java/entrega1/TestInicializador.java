package entrega1;

import org.junit.Before;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import entrega2.Usuario;

public class TestInicializador {
	public Comuna comuna8;
	public ParadaDeColectivo paradaDel47;
	public Polygon zonaComuna8;
	public Mapa mapa;
	public POI poi;
	public Usuario usuario;

	@Before
	public void init() {

		// Comuna 8
		comuna8 = new Comuna();
		zonaComuna8 = new Polygon();
		zonaComuna8.add(new Point(-34.6744, -58.5025));
		zonaComuna8.add(new Point(-34.6578, -58.4787));
		zonaComuna8.add(new Point(-34.6648, -58.4697));
		zonaComuna8.add(new Point(-34.6621, -58.4240));
		zonaComuna8.add(new Point(-34.7048, -58.4612));
		comuna8.setZona(zonaComuna8);

		// Parada del 47 -- Corvalan 3691
		paradaDel47 = new ParadaDeColectivo(new Point(-34.6715, -58.4676), comuna8);
		paradaDel47.setDireccion("Corvalan 3691");

		// Creacion de poi
		poi = new POI(new Point(-34.6744, -58.5025), comuna8);
		poi.setNombre("114");
		poi.estrategia = paradaDel47;

		mapa = Mapa.getInstance();
		mapa.addPOI(poi);

		usuario = new Usuario();

	}
}
