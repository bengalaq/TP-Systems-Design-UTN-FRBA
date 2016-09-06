package entrega1;


import java.io.IOException;
import java.time.LocalDateTime;

import org.uqbar.geodds.Point;

import entrega2.MainApp;
import entrega5.ParadaViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParadaDeColectivo extends StrategyPOI {

	//CONSTRUCTOR

	public ParadaDeColectivo(Point miUbicacion, Comuna comuna8) {
		super(miUbicacion, comuna8);
		this.instanciarRangoDeAtencionDeColectivo();
	}

	private RangoDeAtencion rangoDeAtencion;

	//METODOS

	@Override
	public double cercaniaRequerida(){
		return 100.0;
	}

	public boolean estaDisponible(LocalDateTime unTiempo){
		return true;
	}

	private void instanciarRangoDeAtencionDeColectivo(){
		double horaDeApertura 		= 0.0;
		double horaDeCierre			= 23.0;
		int diaDeInicioDeAtencion 	= 1;
		int diaDeFinDeAtencion		= 7;
		RangoDeAtencion rangoDeAtencionDeColectivos = new RangoDeAtencion(horaDeApertura,horaDeCierre,diaDeInicioDeAtencion,diaDeFinDeAtencion);
		this.setRangoDeAtencion(rangoDeAtencionDeColectivos);
	}


	public RangoDeAtencion getRangoDeAtencion() {
		return rangoDeAtencion;
	}

	public void setRangoDeAtencion(RangoDeAtencion rangoDeAtencion) {
		this.rangoDeAtencion = rangoDeAtencion;
	}

	public void crearVista(){

		Parent rootLayout;

		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/ParadaView.fxml"));
			loader.setController(new ParadaViewController());
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
