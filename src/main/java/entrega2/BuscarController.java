package entrega2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entrega1.Administrador;
import entrega1.Busqueda;
import entrega1.Mapa;
import entrega1.POI;
import entrega5.BancoViewController;
import entrega5.CGPViewController;
import entrega5.LocalViewController;
import entrega5.ParadaViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuscarController {
	private Stage primaryStage;
	Administrador admin;
	Mapa mapa;
	Usuario user;
	private Parent rootLayout;

	public BuscarController(Usuario usuario, Stage primaryStage) {
		this.primaryStage = primaryStage;
		admin = new Administrador();
		user = usuario;
		mapa = Mapa.getInstance();
	}

	@FXML
	private TextField buscarPOI;

	@FXML
	private TextField direccion;

	@FXML
	private ComboBox<String> nombres;

	ObservableList<String> options;

	@FXML
	void buscar(ActionEvent event) {
		long time_start;
		long time_end;
		time_start = System.currentTimeMillis();
		mapa.buscarPorTextoLibre(buscarPOI.getText());
		time_end = System.currentTimeMillis();
		long tiempoQueTardo = time_end - time_start;

		Busqueda unaBusqueda = new Busqueda();
		time_end = System.currentTimeMillis();
		unaBusqueda.setTagBuscado(buscarPOI.getText());
		unaBusqueda.setFechaDeLaBusqueda(LocalDate.now());
		unaBusqueda.setResultadosDevueltos(nombres.getItems().size());
		unaBusqueda.setUsuario(user);
		unaBusqueda.setDuracionDeConsulta(tiempoQueTardo);
		mapa.addBusqueda(unaBusqueda);
		primaryStage.close();
	}

	private void mostrarOpciones() {
		options = FXCollections.observableArrayList(filtrarPOI());
		nombres.setItems(options);
	}

	private List<String> filtrarPOI() {

		ArrayList<String> aux = new ArrayList<String>();
		for (POI p : mapa.coleccionDePOIS) {
			for (String s : p.getTags()) {
				System.out.println("POI " + p.getNombre() + " string " + s.toString());
			}
			if (p.getTags().contains(buscarPOI.getText())) {
				System.out.println("entro");
				aux.add(p.getNombre());
			} else
				System.out.println("no entro");
		}
		return aux;
	}

	@FXML
	void consultar(ActionEvent event) {
		mostrarOpciones();
		nombres.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				for (POI p : mapa.coleccionDePOIS) {
					if (p.getNombre().equals(t1)){
						direccion.setText(p.getDireccion());
						p.estrategia.crearVista();
					}

				}
			}
		});
	}

	private void selectorDeVistas(POI p) {

		if(p.estrategia.equals("CGP")){
			System.out.println("entro al cgp");
		try {
		Stage stage = new Stage();
		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/CGPView.fxml"));
		loader.setController(new CGPViewController());
		rootLayout = loader.load();
		stage.setTitle("Vista general de CGP");

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);

		stage.show();

		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		if(p.estrategia.equals("Parada colectivo")){
		try {
		Stage stage = new Stage();
		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/ParadaView.fxml"));
		loader.setController(new BancoViewController());
		rootLayout = loader.load();
		stage.setTitle("Vista general de Paradas de colectivo");

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);

		stage.show();

		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		if(p.estrategia.equals("Banco")){
		try {
		Stage stage = new Stage();
		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/BancoView.fxml"));
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
		if(p.estrategia.equals("Local comercial")){
		try {
		Stage stage = new Stage();
		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/LocalView.fxml"));
		loader.setController(new LocalViewController());
		rootLayout = loader.load();
		stage.setTitle("Vista general de Locales comerciales");

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);

		stage.show();

			}
		catch (IOException e) {
			e.printStackTrace();
			}
		}
		}
}