package entrega5;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CGPViewController {

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
		direccionLabel.setText("CGP Juntada de truco");
		serviciosLabel.setText("Servicio de catering");
		zonaLabel.setText("Villa Ballester");
		Image image = new Image ("shop.png");
		imagenBanco.setImage(image);
	}
}
