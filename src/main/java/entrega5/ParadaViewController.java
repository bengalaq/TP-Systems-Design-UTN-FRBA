package entrega5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ParadaViewController {

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
		direccionLabel.setText("Colectivo 114");
		serviciosLabel.setText("");
		zonaLabel.setText("Lugano");
		Image image = new Image ("bus-icon.png");
		imagenBanco.setImage(image);
	}
}
