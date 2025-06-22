/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vista;

import Modelo.Orden;
import Modelo.HistorialCompras;
import Modelo.Producto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {
    @FXML private TableView<Orden> tableHistory;
    @FXML private TableColumn<Orden, String> colFecha;
    @FXML private TableColumn<Orden, Double> colTotal;

    private static HistoryController instance;
    public static HistoryController getInstance() { return instance; }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;

        colFecha.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getFecha().toString())
        );
        colTotal.setCellValueFactory(data ->
            new SimpleDoubleProperty(data.getValue().getTotal()).asObject()
        );

        loadData();
    }

    public void loadData() {
        tableHistory.setItems(FXCollections.observableArrayList(HistorialCompras.getHistorial()));
    }

    @FXML
    private void verDetalle() {
        Orden seleccion = tableHistory.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            StringBuilder sb = new StringBuilder();
            seleccion.getProductos().forEach(p ->
                sb.append(p.getNombre()).append(" - ").append(p.getPrecio()).append("€\n")
            );
            sb.append("\nTotal: $").append(String.format("%.2f", seleccion.getTotal()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION, sb.toString(), ButtonType.OK);
            alert.setHeaderText("Detalle de la orden");
            alert.showAndWait();
        }
    }
}
