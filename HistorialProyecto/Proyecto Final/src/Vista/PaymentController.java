/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vista;

import Modelo.HistorialCompras;
import Modelo.Orden;
import Modelo.Producto;
import Modelo.CarritoCompra; 
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.time.LocalDateTime;
import java.util.List;
import java.io.IOException;

public class PaymentController {
    @FXML private Label lblTotalPago;
    @FXML private TextField tfTarjeta, tfFecha, tfCvv;

    private final CarritoCompra carrito = CarritoCompra.getInstancia();

    @FXML
    public void initialize() {
        lblTotalPago.setText(String.format("$%.2f", carrito.getTotal()));
    }

    @FXML
    private void confirmarPago() {
       
        List<Producto> items = carrito.getItems();
        Orden orden = new Orden(items, carrito.getTotal(), LocalDateTime.now());
        HistorialCompras.agregar(orden);

        
        carrito.vaciar();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pago realizado");
        alert.setHeaderText(null);
        alert.setContentText("¡Pago completado con éxito!");
        alert.showAndWait();

       
        if (HistoryController.getInstance() != null) {
            HistoryController.getInstance().loadData();
        }
       
        tfTarjeta.clear();
        tfFecha.clear();
        tfCvv.clear();
    }

    @FXML
    private void cancelar() {
 
        tfTarjeta.clear();
        tfFecha.clear();
        tfCvv.clear();
    }
}