package entrega1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Json {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws java.io.IOException {
		Gson gson = new Gson();
		@SuppressWarnings("rawtypes")
		Collection collection = new ArrayList();
		collection.add("hello");
		collection.add(5);
		collection.add("juan");
		String json = gson.toJson(collection);
		FileWriter file = new FileWriter("D:\\fichero1.txt");
		file.write(json);
		file.flush();
		file.close();
		leerDeJson();
	}

	private static void leerDeJson() {
		JsonParser parser = new JsonParser();
		FileReader fr;
		try {
			fr = new FileReader("D:\\fichero1.txt");
			JsonElement datos = parser.parse(fr);
			System.out.println(datos);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
