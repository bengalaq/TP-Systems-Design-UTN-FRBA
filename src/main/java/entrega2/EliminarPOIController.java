package entrega2;

import entrega1.Administrador;
import entrega1.Mapa;
import entrega1.POI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EliminarPOIController {
	private Stage primaryStage;
	Administrador admin;
	Mapa mapa;

	public EliminarPOIController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		admin = new Administrador();
		mapa = Mapa.getInstance();
	}

	@FXML
	private TextField poi;

	@FXML
	private TextField poiPorBorrar;

	@FXML
	void buscar(ActionEvent event) {
		for(POI p : mapa.coleccionDePOIS){
			System.out.println(p.getNombre());
		}
		poiPorBorrar.setText(mapa.buscarPOI(poi.getText()));
	}

	@FXML
	void eliminar(ActionEvent event) {		
		mapa.eliminarPOI(poiPorBorrar.getText());
		primaryStage.close();
	}

}