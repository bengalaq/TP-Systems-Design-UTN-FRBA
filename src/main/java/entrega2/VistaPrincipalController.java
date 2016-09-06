package entrega2;

import java.io.IOException;
import java.util.List;

import entrega3.FabricaDeDB;
import entrega5.AsignarAccionesController;
import entrega5.HistorialBusquedasController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VistaPrincipalController {
	private Parent rootLayout;
	private Usuario usuario;

	@FXML
	private Button eliminarButton;

	@FXML
	private Button asignaAccionesButton;

	@FXML
	private Button modificarButton;

	@FXML
	private Button crearButton;

	@FXML
	private Button consultarButton;

	@FXML
	private Button historialButton;

	public VistaPrincipalController(Usuario usuario, Stage primaryStage) {
		this.usuario = usuario;
		System.out.println("Soy el usuario: " + usuario.nombre);
	}

	@FXML
	private void initialize() {
		availableActionsSet();
	}

	private void availableActionsSet() {
		if (usuario.getEsAdmin() == 0) {
			List<Usuario> aux = FabricaDeDB.getInstance().findAllUsersNotAdmins();
			Usuario u = aux.get(0);
			asignaAccionesButton.setDisable(true);
			for (String s : u.getAcciones()) {
				System.out.println(s);
				if (!s.equals("Crear")) {
					crearButton.setDisable(true);
				}
				if (!s.equals("Borrar")) {
					eliminarButton.setDisable(true);
				}
				if (!s.equals("Consultar")) {
					consultarButton.setDisable(true);
				}
				if (!s.equals("Modificar")) {
					modificarButton.setDisable(true);
				}
			}
		}
	}

	@FXML
	void crearPOI(ActionEvent event) {
		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/crearPOI.fxml"));
			loader.setController(new CrearPOIController(stage));
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

	@FXML
	void eliminarPOI(ActionEvent event) {

		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/eliminarPOI.fxml"));
			loader.setController(new EliminarPOIController(stage));
			rootLayout = loader.load();
			stage.setTitle("Eliminación de Punto De Interés");

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void consultarPOI(ActionEvent event) {
		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/consultarPOI.fxml"));
			loader.setController(new BuscarController(usuario, stage));
			rootLayout = loader.load();
			stage.setTitle("Consulta de Punto De Interés");

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void asignarAcciones(ActionEvent event) {
		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/asignarAcciones.fxml"));
			loader.setController(new AsignarAccionesController(usuario, stage));
			rootLayout = loader.load();
			stage.setTitle("Asignación de acciones");

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void modificarPOI(ActionEvent event) {

		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/modificarPOI.fxml"));
			loader.setController(new ModificarPOIController(stage));
			rootLayout = loader.load();
			stage.setTitle("Modificación de Punto De Interés");

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void historialDeBusquedas(ActionEvent event) {
		try {
			Stage stage = new Stage();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/HistorialBusquedas.fxml"));
			loader.setController(new HistorialBusquedasController(stage));
			rootLayout = loader.load();
			stage.setTitle("Historial de búsquedas");

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);

			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
