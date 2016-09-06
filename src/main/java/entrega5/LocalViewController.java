package entrega5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LocalViewController {

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
		direccionLabel.setText("Shopping Avellaneda");
		serviciosLabel.setText("Patio de comidas - Comprar Ropa - Restaurant");
		zonaLabel.setText("Avellaneda");
		Image image = new Image ("bank.png");
		imagenBanco.setImage(image);
	}
}
