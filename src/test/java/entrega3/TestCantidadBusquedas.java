package entrega3;

import org.junit.Assert;
import org.junit.Test;

import entrega1.Busqueda;
import entrega1.TestInicializador;

public class TestCantidadBusquedas extends TestInicializador {

	@Test
	public void testCantidadBusquedas() {
		usuario.setNombreDeUsuario("dante");
		Busqueda unaBusqueda = new Busqueda();
		unaBusqueda.usuario = usuario;
		unaBusqueda.setTagBuscado("114");
		mapa.addBusqueda(unaBusqueda);
		Assert.assertTrue(mapa.getCantidadDeBusquedas() == 1);
	}

	@Test
	public void testCantidadResultadosDevueltos() {
		/*
		 * TODO: La cantidad de resultados devueltos es el tamaño del combobox,
		 * el combobox debe llenarse con la cantidad de elementos en la base de
		 * acuerdo a la busqueda del usuario.
		 */
	}

}
