/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Producto;
import Modelo.ListaDeseos;
import Modelo.ListaCarrito;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class WishListController implements Initializable {

    @FXML private TilePane contenedorDeseos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarDeseos();
    }

    private void cargarDeseos() {
        contenedorDeseos.getChildren().clear();
        for (Producto p : ListaDeseos.getDeseos()) {
            contenedorDeseos.getChildren().add(crearTarjeta(p));
        }
    }

    private VBox crearTarjeta(Producto p) {
        Label nombre = new Label(p.getNombre());
        nombre.setFont(new Font("Arial", 14));

        Label precio = new Label("$" + p.getPrecio());
        precio.setStyle("-fx-text-fill: green;");

        ImageView img = new ImageView(new Image(p.getRutaImagen()));
        img.setFitWidth(100);
        img.setFitHeight(100);

        Button btnMover = new Button("Mover al carrito");
        btnMover.setOnAction(e -> {
          CatalogoController.carrito.Insertar(p);
ListaDeseos.eliminar(p);
mostrarAlerta("Producto movido al carrito");
cargarDeseos();

        });

        VBox tarjeta = new VBox(5, img, nombre, precio, btnMover);
        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setStyle("-fx-border-color: #ccc; -fx-padding:10; -fx-background-color:#f5f5f5;");
        return tarjeta;
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Lista de Deseos");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

