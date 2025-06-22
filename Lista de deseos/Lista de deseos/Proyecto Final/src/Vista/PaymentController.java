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
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class PaymentController {
    @FXML private Label lblTotalPago;
    @FXML private TextField tfTarjeta, tfFecha, tfCvv;

    private final CarritoCompra carrito = CarritoCompra.getInstancia();
    private double totalPagoManual = -1; 

    public void setTotal(double total) {
        this.totalPagoManual = total;

        if (lblTotalPago != null) {
            lblTotalPago.setText(String.format("$%.2f", total));
        }
    }

    @FXML
    public void initialize() {
        System.out.println("Hash del carrito: " + carrito.hashCode());

        double totalMostrar = (totalPagoManual >= 0) ? totalPagoManual : carrito.getTotal();
        System.out.println("initialize() ejecutado. Total mostrado: " + totalMostrar);

        lblTotalPago.setText(String.format("$%.2f", totalMostrar));
    }

    @FXML
    private void confirmarPago() {
        double total = (totalPagoManual >= 0) ? totalPagoManual : carrito.getTotal();
        System.out.println("Confirmando pago ? Total: " + total);

        List<Producto> items = new ArrayList<>(carrito.getItems());
        Orden orden = new Orden(items, total, LocalDateTime.now());
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

    @FXML
    private void volverAlCatalogo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Catalogo.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo cargar el catálogo");
            alert.setContentText("Ocurrió un error al intentar volver al catálogo.");
            alert.showAndWait();
        }
    }
}
