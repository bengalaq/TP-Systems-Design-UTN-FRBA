package entrega1;

import java.io.IOException;
import java.util.ArrayList;

import org.uqbar.geodds.Point;

import entrega2.MainApp;
import entrega5.BancoViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Banco extends POIConServicio {

	//CONSTRUCTOR

	public Banco(Point ubicacion, Comuna comuna8) {
		super(ubicacion, comuna8);
		this.instancioColeccionDeServiciosDeBanco();
	}

	public void instancioColeccionDeServiciosDeBanco(){
		//Instacio rango de atencion de banco
		double	horaDeApertura 				= 10.0;
		double	horaDeCierre				= 15.0;
		int		diaDeInicioDeAtencion		= 1;
		int		diaDeFinDeAtencion			= 5;
		RangoDeAtencion rangoDeAtencionDeBanco =
				new RangoDeAtencion(horaDeApertura,horaDeCierre,diaDeInicioDeAtencion,diaDeFinDeAtencion);

		//Instancio servicios de banco
		Servicio atencionAlCliente = new Servicio("Atencion al cliente", rangoDeAtencionDeBanco);
		Servicio atencionTarjetasDeCredito = new Servicio("Atencion a tarjetas de credito", rangoDeAtencionDeBanco);

		//Instancio y seteo coleccion de servicios de banco
		ArrayList<Servicio> coleccionDeServiciosDeBanco = new ArrayList<Servicio>();
		coleccionDeServiciosDeBanco.add(atencionTarjetasDeCredito);
		coleccionDeServiciosDeBanco.add(atencionAlCliente);
		this.setColeccionServicios(coleccionDeServiciosDeBanco);
	}

	//METODOS

	public double cercaniaRequerida(){
		return 500;
	}

	public void crearVista(){

		Parent rootLayout;

		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/BancoView.fxml"));
			loader.setController(new BancoViewController());
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

