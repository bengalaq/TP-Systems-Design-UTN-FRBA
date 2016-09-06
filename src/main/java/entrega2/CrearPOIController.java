package entrega2;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import entrega1.Administrador;
import entrega1.Banco;
import entrega1.CGP;
import entrega1.Comuna;
import entrega1.LocalComercial;
import entrega1.Mapa;
import entrega1.POI;
import entrega1.ParadaDeColectivo;
import entrega1.Rubro;
import entrega1.StrategyPOI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearPOIController {
	private Stage primaryStage;
	Mapa mapa;
	ObservableList<String> options = FXCollections.observableArrayList("CGP", "Parada colectivo", "Banco",
			"Local comercial");

	POI poi;

	@FXML
	private ListView<String> listView;

	public CrearPOIController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private void initialize() {
		mapa = Mapa.getInstance();
		tiposPOI.setItems(options);
	}

	@FXML
	private TextField direccion;

	@FXML
	private TextField ubicacionY;

	@FXML
	private TextField ubicacionX;

	@FXML
	private TextField nombre;

	@FXML
	private TextField comuna;

	@FXML
	private ComboBox<String> tiposPOI;

	@FXML
	private TextField tag;

	@FXML
	void crear(ActionEvent event) {
		mapa.agregarPOI(poi);
		primaryStage.close();
	}

	private StrategyPOI resolverEstrategia(double x, double y, Comuna c) {
		if (tiposPOI.getSelectionModel().getSelectedItem().equals("Parada colectivo"))
			return new ParadaDeColectivo(new Point(x, y), c);

		if (tiposPOI.getSelectionModel().getSelectedItem().equals("Banco"))
			return new Banco(new Point(x, y), c);

		if (tiposPOI.getSelectionModel().getSelectedItem().equals("CGP"))
			return new CGP(new Point(x, y), c);

		// TODO: Corregir el tema de los rubros
		if (tiposPOI.getSelectionModel().getSelectedItem().equals("Local comercial"))
			return new LocalComercial(new Point(x, y), c);

		return null;
	}

	@FXML
	void agregar(ActionEvent event) {
		Comuna c = new Comuna();
		c.setNombre(comuna.getText());
		double x = Double.parseDouble(ubicacionX.getText());
		double y = Double.parseDouble(ubicacionY.getText());
		poi = new POI(new Point(x, y), c);
		poi.setNombre(nombre.getText());
		poi.setDireccion(direccion.getText());
		StrategyPOI estrategia = resolverEstrategia(x, y, c);
		poi.estrategia = estrategia;
		listView.getItems().add(tag.getText());
		for (int i = 0; i < listView.getItems().size(); i++) {
			poi.addTag(listView.getItems().get(i));
		}

	}

}