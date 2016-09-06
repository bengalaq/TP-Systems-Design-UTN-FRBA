package entrega1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.uqbar.geodds.Point;

import entrega2.MainApp;
import entrega5.LocalViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LocalComercial extends StrategyPOI {

	// CONSTRUCTOR

	public LocalComercial(Point unaUbicacion, Comuna comuna8) {

		super(unaUbicacion, comuna8);
		ArrayList<RangoDeAtencion> unaColeccionDeRangosDeAtencion = new ArrayList<RangoDeAtencion>();
		this.setColeccionDeRangosDeAtencion(unaColeccionDeRangosDeAtencion);
	}

	// ATRIBUTOS

	private Rubro rubro;
	private ArrayList<RangoDeAtencion> coleccionDeRangosDeAtencion;

	// GETTERS Y SETTERS

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro unRubro) {
		rubro = unRubro;
	}

	public ArrayList<RangoDeAtencion> getColeccionDeRangosDeAtencion() {
		return coleccionDeRangosDeAtencion;
	}

	public void setColeccionDeRangosDeAtencion(ArrayList<RangoDeAtencion> unaColeccionDeRangosDeAtencion) {
		coleccionDeRangosDeAtencion = unaColeccionDeRangosDeAtencion;
	}
	// METODOS

	@Override
	public double cercaniaRequerida() {
		return this.getRubro().getRadioDeCercania();
	}

	public boolean estaDisponible(LocalDateTime unTiempo) {
		return this.getColeccionDeRangosDeAtencion().stream()
				.anyMatch(rangoDeAtencion -> this.rangoDeAtencionDisponible(rangoDeAtencion, unTiempo));
	}

	public boolean rangoDeAtencionDisponible(RangoDeAtencion unRangoDeAtencion, LocalDateTime unTiempo) {
		return unRangoDeAtencion.disponible(unTiempo);
	}

	public void addRangoDeAtencion(RangoDeAtencion unRangoDeAtencion) {
		this.getColeccionDeRangosDeAtencion().add(unRangoDeAtencion);
	}

	/*
	 * public boolean estaCercaDeMaquina(Maquina unaMaquina){ return
	 * this.getRubro().getRadioDeCercania().isInside(unaMaquina.getUbicacion());
	 * }
	 */
	public void crearVista(){

		Parent rootLayout;

		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/LocalView.fxml"));
			loader.setController(new LocalViewController());
			rootLayout = loader.load();
			stage.setTitle("Creación de Punto De Interés");

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);

			stage.show();

			} catch (IOException e) {
			e.printStackTrace();
			}
			}
}
