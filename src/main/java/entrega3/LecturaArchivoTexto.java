package entrega3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LecturaArchivoTexto {
	public String archivo = "src/main/resources/LocalComercial.txt";
	public Map<String, List<String>> map = new HashMap<String, List<String>>();

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void muestraContenido() throws FileNotFoundException, IOException {
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				procesarLinea(linea);
			}

			fr.close();
		} catch (Exception e) {
		}
	}

	private void procesarLinea(String linea) {
		List<String> aux = new ArrayList<String>();
		int posCOma = linea.indexOf(";", 0);
		String clave = linea.substring(0, posCOma);
		String valor = linea.substring(posCOma + 1, linea.length());

		String delimiter = " ";
		String[] temp;
		temp = valor.split(delimiter);
		for (int i = 0; i < temp.length; i++)
			aux.add(temp[i]);
		map.put(clave, aux);

	}

	public void procesar() {

		try {
			muestraContenido();

			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		/*
		 * TODO: Tengo que buscar en la base de datos la lista de tags, y
		 * fijarme si coincide. Si no uso la base, tengo que crear los poi y
		 * modificarlos desde el repo..
		 */

	}

}
