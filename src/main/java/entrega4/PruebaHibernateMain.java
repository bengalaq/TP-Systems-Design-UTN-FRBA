package entrega4;

import entrega3.FabricaDeDB;

public class PruebaHibernateMain {

	public static void main(String[] args) {
		FabricaDeDB f = new FabricaDeDB();
		Perro perro1 = new Perro();
		Perro perro2 = new Perro();
		Persona persona = new Persona();		
		persona.nombre = "unaPersona";
		perro1.nombre = "perro1";
		perro1.persona = persona;
		perro2.persona = persona;
		perro2.nombre = "perro2";
		f.crearPersona(persona);
		f.crearPerro(perro1);
		f.crearPerro(perro2);
		
	}
}

