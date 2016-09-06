package entrega5;

import java.util.ArrayList;
import java.util.List;

import entrega2.Usuario;
import entrega3.FabricaDeDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AsignarAccionesController {
	Usuario user = new Usuario();
	ObservableList<String> options = FXCollections.observableArrayList("Crear", "Borrar", "Consultar","Modificar");
	ObservableList<String> acciones;
	private Stage stage;

	@FXML
	private Button elmBtn;

	@FXML
	private ListView<String> listview;

	@FXML
	private ComboBox<String> combobox;

	public AsignarAccionesController(Usuario user,Stage stage) {
		this.user = user;
		this.stage = stage;		
	}

	@FXML
	private void initialize() {
		combobox.setItems(options);
		acciones = FXCollections.observableArrayList();
	}

	@FXML
	void agregar(ActionEvent event) {
		if (!acciones.contains(combobox.getSelectionModel().getSelectedItem()))
			acciones.add(combobox.getSelectionModel().getSelectedItem());
		listview.setItems(acciones);
	}

	@FXML
	void aceptar(ActionEvent event) {
		List<Usuario> usuariosNoAdmins = FabricaDeDB.getInstance().findAllUsersNotAdmins();
		establecerAcciones(usuariosNoAdmins);
		stage.close();
	}

	private void establecerAcciones(List<Usuario> usuariosNoAdmins) {
		List<String> listaAcciones = transformarALista(listview.getItems().toArray());
		for (Usuario u : usuariosNoAdmins) {
			u.setAcciones(listaAcciones);
			FabricaDeDB.getInstance().crearUsuario(u);
		}
	}

	private List<String> transformarALista(Object[] objects) {
		List<String> aux = new ArrayList<>();
		for (int i = 0; i < objects.length; i++) {
			aux.add(objects[i].toString());
		}
		return aux;
	}

	@FXML
	void cancelar(ActionEvent event) {
		listview.getItems().clear();
	}

	@FXML
	void eliminar(ActionEvent event) {
		elmBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				final int selectedIdx = listview.getSelectionModel().getSelectedIndex();
				if (selectedIdx != -1) {

					final int newSelectedIdx = (selectedIdx == listview.getItems().size() - 1) ? selectedIdx - 1
							: selectedIdx;

					listview.getItems().remove(selectedIdx);
					listview.getSelectionModel().select(newSelectedIdx);
				}
			}
		});
	}

}
