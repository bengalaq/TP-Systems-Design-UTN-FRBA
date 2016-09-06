package entrega5;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HistorialBusquedasController implements Initializable {

	private Stage primaryStage;

	// COLUMNAS DE LA TABLA BUSQUEDAS
	@FXML private TableColumn<BusquedaBis, String> clmTagBuscado;
	@FXML private TableColumn<BusquedaBis, Date> clmFecha;
	@FXML private TableColumn<BusquedaBis, String> clmUsuario;
	@FXML private TableColumn<BusquedaBis, Integer> clmPOIsEncontrados;
	@FXML private TableColumn<ResultadosDeBusquedaBis, String> clmDetalle;

	// COMPONENTES INTERFAZ
	@FXML private ComboBox<UsuarioBis> cmbUsuarios;
	@FXML private TableView<BusquedaBis> tablaBusquedas;
	@FXML private TableView<ResultadosDeBusquedaBis> tablaDetallePOIs;
	@FXML private DatePicker dtpckHasta;
	@FXML private Button btnLimpiarFiltros;
	@FXML private DatePicker dtpckDesde;

	// COLLECIONES QUE USO
	private ObservableList<UsuarioBis> listaUsuarios;
	private Conexion conexion;
	private ObservableList<BusquedaBis> listaBusquedas;
	private ObservableList<ResultadosDeBusquedaBis> listaDetalle;

	public HistorialBusquedasController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion = new Conexion();
		conexion.establecerConexion();

		// Inicializar listas
		listaUsuarios = FXCollections.observableArrayList();
		listaBusquedas = FXCollections.observableArrayList();
		listaDetalle = FXCollections.observableArrayList();

		// Llenar lista
		UsuarioBis.llenarInformacionCMBUsuario(conexion.getConnection(), listaUsuarios);
		BusquedaBis.llenarInformacionTBLVWBusquedas(conexion.getConnection(), listaBusquedas);

		// Enlazar lista con combobox y TableView
		cmbUsuarios.setItems(listaUsuarios);
		tablaBusquedas.setItems(listaBusquedas);

		filtrarTablaBusquedasConUsuario();

		// Enlazar columnas con atributos que quiero mostrar
		clmFecha.setCellValueFactory(new PropertyValueFactory<BusquedaBis, Date>("fechaBusqueda"));
		clmUsuario.setCellValueFactory(new PropertyValueFactory<BusquedaBis, String>("nombreUsuario"));
		clmTagBuscado.setCellValueFactory(new PropertyValueFactory<BusquedaBis, String>("tagBuscado"));
		clmPOIsEncontrados.setCellValueFactory(new PropertyValueFactory<BusquedaBis, Integer>("cantidadResultados"));
		gestionarEventos();
		//conexion.cerrarConexion();

	}

	private void filtrarTablaBusquedasConUsuario() {

		// 1. Meto la ObservableList en una FilteredList (inicialmente muestra todas las busquedas)

		FilteredList<BusquedaBis> busquedasFiltradas = new FilteredList<>(listaBusquedas, p -> true);

		// 2. Setteo el filtro siempre que cambie

		cmbUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UsuarioBis>() {

			@Override
			public void changed(ObservableValue ov, UsuarioBis usuarioAnterior, UsuarioBis usuarioNuevo) {
		busquedasFiltradas.setPredicate(person -> {

			// Si el filtro esta vacio, muestro todas las busquedas
			if (usuarioNuevo == null) {
				return true;
			}

			// Comparo el nombre de los usuarios de todas las busquedas con el que elegi del combobox.
			String lowerCaseFilter = usuarioNuevo.getNombreUsuario().toLowerCase();

			if (person.getNombreUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1) {
				return true; // Filter matches first name.
			} else if (person.getNombreUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1) {
				return true; // Filter matches last name.
			}
			return false; // Does not match.
				});
			}});

		// 3. Encierro la FilteredList en una SortedList
		SortedList<BusquedaBis> busquedasFiltradasYSorted = new SortedList<>(busquedasFiltradas);

		// 4. Relaciono el comparador del SortedList con el del TableView. De otra forma ordenar con la TableView no funcionaria.
		busquedasFiltradasYSorted.comparatorProperty().bind(tablaBusquedas.comparatorProperty());

		// 5. Agrego la info de la observableList a la tabla.
		tablaBusquedas.setItems(busquedasFiltradasYSorted);
	}

	public void gestionarEventos() {

		tablaBusquedas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BusquedaBis>() {

			@Override
			public void changed(ObservableValue<? extends BusquedaBis> observable, BusquedaBis valorViejo, BusquedaBis valorSeleccionado) {
				llenarInformacionTBLVWDetalles(conexion.getConnection(), listaDetalle, valorSeleccionado.getIdBusqueda());

				}
		});

	}

	public void llenarInformacionTBLVWDetalles(Connection connection, ObservableList<ResultadosDeBusquedaBis> lista, int unIdDeBusqueda){

		lista.clear();

		try {
			Statement instruccion = connection.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT BUS.id_busqueda, "+
						"BUS.nombre, "+
					    "BUS.tag_buscado, "+
					    "BUS.cantidad_resultados, "+
					    "BUS.duracion_consulta, "+
					    "BUS.fecha_busqueda, "+
					    "RES.resultado "+
					"FROM busquedasbis BUS "+
					"INNER JOIN resultados_de_busquedasbis RES "+
					"ON (BUS.id_busqueda = RES.id_busqueda)"
			);

			while (resultado.next()){
				if (unIdDeBusqueda == resultado.getInt("id_busqueda")){
					lista.add(
						new ResultadosDeBusquedaBis(new BusquedaBis (
							resultado.getInt("id_busqueda"),
							resultado.getString("nombre"),
							resultado.getString("tag_buscado"),
							resultado.getInt("cantidad_resultados"),
							resultado.getInt("duracion_consulta"),
							resultado.getDate("fecha_busqueda")
																), resultado.getString("resultado"))
						);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tablaDetallePOIs.setItems(listaDetalle);
		clmDetalle.setCellValueFactory(new PropertyValueFactory<ResultadosDeBusquedaBis, String>("resultado"));

	}

	@FXML public void limpiarFiltros(){

		cmbUsuarios.setValue(null);
		dtpckDesde.setValue(null);
		dtpckHasta.setValue(null);

	}

}

