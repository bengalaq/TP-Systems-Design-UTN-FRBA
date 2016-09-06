package entrega3;

import entrega2.MainApp;
import entrega2.Usuario;
import entrega4.Accion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	private Stage primaryStage;
	private Usuario user;
	private MainApp app;

	@FXML
	private TextField password;

	@FXML
	private TextField usuario;

	public LoginController(MainApp mainApp, Stage primaryStage) {
		this.primaryStage = primaryStage;
		user = new Usuario();
		app = mainApp;
	}

	@FXML
	void ingresar(ActionEvent event) {
		if (usuarioValido()) {
			app.crearVistPrincipal(user);
		}

	}

	private boolean usuarioValido() {
		user = FabricaDeDB.getInstance().usuarioLogueado(usuario.getText());
		return !user.equals(null);
	}

}
