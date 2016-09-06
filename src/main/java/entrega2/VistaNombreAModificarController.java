package entrega2;

import entrega1.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VistaNombreAModificarController {
	private Stage primaryStage;
	Administrador admin;

	public VistaNombreAModificarController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		admin = new Administrador();
	}

	@FXML
	private TextField nombreNuevo;

	@FXML
	void volver(ActionEvent event) {

	}

	@FXML
	void finalizar(ActionEvent event) {

	}
}