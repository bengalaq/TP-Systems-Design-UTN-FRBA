package entrega5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BancoViewController {

	@FXML
	private Label direccionLabel;

	@FXML
	private Label zonaLabel;

	@FXML
	private ImageView imagenBanco;

	@FXML
	private Label serviciosLabel;

	@FXML
	private void initialize() {
		direccionLabel.setText("Banco Santander Rio");
		serviciosLabel.setText("Depositos - Banelco - Asistencia de cuentas");
		zonaLabel.setText("Lanus");
		Image image = new Image ("bank.png");
		imagenBanco.setImage(image);

	}
}