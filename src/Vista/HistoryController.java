/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.HistorialCompras;
import Modelo.Orden;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.beans.property.*;

public class HistoryController {
    @FXML private TableView<Orden> tableHistory;
    @FXML private TableColumn<Orden, String> colFecha;
    @FXML private TableColumn<Orden, Double> colTotal;

    @FXML
    public void initialize() {
        colFecha.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFecha().toString()));
        colTotal.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotal()).asObject());
        tableHistory.setItems(FXCollections.observableArrayList(HistorialCompras.getHistorial()));
    }

    @FXML
    private void verDetalle() {
        Orden seleccion = tableHistory.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            StringBuilder sb = new StringBuilder();
            seleccion.getProductos().forEach(p -> sb.append(p.getNombre()).append(" - ").append(p.getPrecio()).append("€\n"));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, sb.toString(), ButtonType.OK);
            alert.setHeaderText("Detalle de la orden");
            alert.showAndWait();
        }
    }
}