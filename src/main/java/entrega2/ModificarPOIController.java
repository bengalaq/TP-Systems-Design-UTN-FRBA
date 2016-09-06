package entrega2;

import entrega1.Administrador;
import entrega1.Mapa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarPOIController {
	private Stage primaryStage;
	Administrador admin;
	Mapa mapa;

	public ModificarPOIController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		admin = new Administrador();
		mapa = Mapa.getInstance();
	}

	@FXML
	private TextField poi;

	@FXML
	private TextField nombre;

	@FXML
	void modificar(ActionEvent event) {
		mapa.modificarPOI(poi.getText(), nombre.getText());
		primaryStage.close();
	}
}
