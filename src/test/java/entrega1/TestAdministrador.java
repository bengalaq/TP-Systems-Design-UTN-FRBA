package entrega1;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class TestAdministrador {
	
	private Comuna comuna8;
	private ParadaDeColectivo paradaDel47;
	private Polygon	zonaComuna8;
	private Mapa mapa;
	private POI poi;
	private POI otropoi;
	private Administrador admin;
	
	
	@Before
	public void init(){		
		
		// Comuna 8
		comuna8 = new Comuna();
		zonaComuna8 = new Polygon();
		zonaComuna8.add(new Point(-34.6744,-58.5025));
		zonaComuna8.add(new Point(-34.6578,-58.4787));
		zonaComuna8.add(new Point(-34.6648,-58.4697));
		zonaComuna8.add(new Point(-34.6621,-58.4240));
		zonaComuna8.add(new Point(-34.7048,-58.4612));
		comuna8.setZona(zonaComuna8);	
					
				
		// Parada del 47 -- Corvalan 3691
		paradaDel47 = new ParadaDeColectivo(new Point(-34.6715, -58.4676), comuna8);
		paradaDel47.setDireccion("Corvalan 3691");
	
		//Creacion de poi
		poi = new POI(new Point(-34.6744,-58.5025),comuna8);
		poi.setNombre("juan");		
		
		admin = new Administrador();
		
		mapa = Mapa.getInstance();
		mapa.addPOI(poi);
		
		
	
	}
	
	@Test
	public void testNombreActual(){
		Assert.assertEquals(poi.getNombre(),"juan");		
	}
	
	@Test
	public void testModificacionDeNombre(){	
		admin.mapa = mapa;
		admin.modificarPOI(poi,"juanchi");
		Assert.assertEquals("juanchi",poi.getNombre());		
	}
}
