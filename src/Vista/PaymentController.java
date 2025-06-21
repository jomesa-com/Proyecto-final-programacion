/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vista;

import Modelo.CarritoCompra;
import Modelo.Orden;
import Modelo.HistorialCompras;
import Modelo.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;
import java.time.LocalDateTime;

public class PaymentController {
    @FXML private Label lblTotalPago;
    @FXML private TextField tfTarjeta, tfFecha, tfCvv;
    private final CarritoCompra carrito = CarritoCompra.getInstancia();

    @FXML
    public void initialize() {
        lblTotalPago.setText(String.format("%.2f €", carrito.getTotal()));
    }

    @FXML
    private void confirmarPago() throws Exception {
        List<Producto> items = carrito.getItems();
        Orden orden = new Orden(items, carrito.getTotal(), LocalDateTime.now());
        HistorialCompras.agregar(orden);
        carrito.vaciar();
        var stage = lblTotalPago.getScene().getWindow();
        var pane = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Catalogo.fxml")).load();
        ((javafx.stage.Stage) stage).setScene(new javafx.scene.Scene((javafx.scene.Parent) pane));
    }

    @FXML
    private void cancelar() throws Exception {
        var stage = lblTotalPago.getScene().getWindow();
        var pane = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Cart.fxml")).load();
        ((javafx.stage.Stage) stage).setScene(new javafx.scene.Scene((javafx.scene.Parent) pane));
    }
}