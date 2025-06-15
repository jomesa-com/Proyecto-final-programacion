/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vista;

import Modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;

public class CatalogoController implements Initializable {

    @FXML private TilePane contenedorProductos;
    @FXML private Button btnTodos;
    @FXML private Button btnHombres;
    @FXML private Button btnMujeres;
    @FXML private Button btnInfantil;
    @FXML private ScrollPane scrollCatalogo;
    
public static ListaCarrito carrito = new ListaCarrito();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarProductos("Todos");
    }
    
    


    private void cargarProductos(String filtroCategoria) {
        contenedorProductos.getChildren().clear();
        for (Producto producto : ListaCatalogo.getProductos()) {
            if (filtroCategoria.equals("Todos") || producto.getCategoria().equalsIgnoreCase(filtroCategoria)) {
                VBox tarjeta = crearTarjetaProducto(producto);
                contenedorProductos.getChildren().add(tarjeta);
            }
        }
    }

    private VBox crearTarjetaProducto(Producto p) {
        Label nombre = new Label(p.getNombre());
        nombre.setFont(new Font("Arial", 14));

        Label precio = new Label("$" + p.getPrecio() + " /pc");
        precio.setStyle("-fx-text-fill: green;");

        ImageView img = new ImageView(new Image(p.getRutaImagen())); 
        img.setFitWidth(100);
        img.setFitHeight(100);

        Label colores = new Label("Colores disponibles");
        colores.setStyle("-fx-font-size: 11px;");

        Button btnAgregar = new Button("Agregar al carrito");
        btnAgregar.setStyle("-fx-background-color: #000000; -fx-text-fill: white; -fx-cursor: hand;");
        btnAgregar.setOnAction(e -> agregarAlCarrito(p));


        VBox tarjeta = new VBox(5, img, nombre, precio, colores, btnAgregar);
        tarjeta.setPrefWidth(150);
        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 8; -fx-padding: 10; -fx-background-radius: 10; -fx-background-color: #f9f9f9;");

        return tarjeta;
    }

    // Métodos de filtrado
    @FXML private void filtrarTodos() {
        cargarProductos("Todos");
    }

    @FXML private void filtrarHombres() {
        cargarProductos("Hombres");
    }

    @FXML private void filtrarMujeres() {
        cargarProductos("Mujeres");
    }

    @FXML private void filtrarInfantil() {
        cargarProductos("Infantil");
    }
    
    private void agregarAlCarrito(Producto p) {
    carrito.Insertar(p);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Carrito");
    alert.setHeaderText(null);
    alert.setContentText(p.getNombre() + " fue agregado al carrito.");
    alert.showAndWait();
}
}

