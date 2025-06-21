/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Node;
import Modelo.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;

public class CartController {

    @FXML private TableView<Producto> tableCart;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private Label lblTotal;
    @FXML private Label lblTotalCarrito;

    @FXML
    private void volverAlCatalogo() throws Exception {
        Stage stage = (Stage) tableCart.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Vista/Catalogo.fxml")));
        stage.setScene(scene);
    }

    @FXML
private void irAPago() throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Payment.fxml"));
    Parent root = loader.load();

    PaymentController controller = loader.getController();
    double totalActual = CatalogoController.carrito.getTotal();
    System.out.println("Total antes de cargar Payment.fxml: " + totalActual);
    controller.setTotal(totalActual);

    Stage stage = (Stage) tableCart.getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
}



    @FXML
    public void initialize() {
       
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colPrecio.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrecio()).asObject());
        tableCart.setItems(FXCollections.observableArrayList(CatalogoController.carrito.getProductos()));
        lblTotalCarrito.setText(String.format("$%.2f", CatalogoController.carrito.getTotal()));
    }
}
