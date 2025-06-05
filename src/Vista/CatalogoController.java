/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Modelo.Producto;

public class CatalogoController {

    @FXML private TableView<Producto> tblProductos;
    @FXML private TableColumn<Producto, String> colCodigo;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colTalla;
    @FXML private TableColumn<Producto, String> colColor;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;


    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private ComboBox<String> cmbTalla;
    @FXML private TextField txtColor;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;


    @FXML private TextField txtBusqueda;
    @FXML private ComboBox<String> cmbCategoria;


    @FXML private Button btnBuscar;
    @FXML private Button btnAgregar;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;

    private final ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private final ObservableList<Producto> listaFiltrada = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
    
        cmbCategoria.getItems().setAll("Todos", "Hombres", "Mujeres", "Niños", "Accesorios");
        cmbCategoria.setValue("Todos");
        
        cmbTalla.getItems().setAll("S", "M", "L", "XL");
        cmbTalla.setValue("M");

 
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTalla.setCellValueFactory(new PropertyValueFactory<>("talla"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

         listaFiltrada.setAll(listaProductos);
        tblProductos.setItems(listaFiltrada);

       
        tblProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtCodigo.setText(newSel.getCodigo());
                txtNombre.setText(newSel.getNombre());
                cmbTalla.setValue(newSel.getTalla());
                txtColor.setText(newSel.getColor());
                txtPrecio.setText(String.valueOf(newSel.getPrecio()));
                txtStock.setText(String.valueOf(newSel.getStock()));
            }
        });
    }

    @FXML
    private void onBuscarClicked(ActionEvent event) {
        String texto = txtBusqueda.getText().trim().toLowerCase();
        String categoria = cmbCategoria.getValue();
        listaFiltrada.clear();
        for (Producto p : listaProductos) {
            boolean coincideTexto = p.getNombre().toLowerCase().contains(texto) || p.getCodigo().toLowerCase().contains(texto);
            boolean coincideCategoria = categoria.equals("Todos") || p.getCategoria().equalsIgnoreCase(categoria);
            if (coincideTexto && coincideCategoria) {
                listaFiltrada.add(p);
            }
        }
        tblProductos.refresh();
    }

    @FXML
    private void onAgregarClicked(ActionEvent event) {
        if (camposValidos()) {
            Producto p = new Producto(
                txtCodigo.getText().trim(),
                txtNombre.getText().trim(),
                cmbTalla.getValue(),
                txtColor.getText().trim(),
                Double.parseDouble(txtPrecio.getText().trim()),
                Integer.parseInt(txtStock.getText().trim()),
                cmbCategoria.getValue()
            );
            listaProductos.add(p);
            listaFiltrada.add(p);
            limpiarFormulario();
        } else {
            mostrarAlerta("Completa todos los campos correctamente.");
        }
    }

    @FXML
    private void onEditarClicked(ActionEvent event) {
        Producto seleccionado = tblProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null && camposValidos()) {
            seleccionado.setCodigo(txtCodigo.getText().trim());
            seleccionado.setNombre(txtNombre.getText().trim());
            seleccionado.setTalla(cmbTalla.getValue());
            seleccionado.setColor(txtColor.getText().trim());
            seleccionado.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
            seleccionado.setStock(Integer.parseInt(txtStock.getText().trim()));
            seleccionado.setCategoria(cmbCategoria.getValue());
            tblProductos.refresh();
            limpiarFormulario();
        } else {
            mostrarAlerta("Selecciona un producto y completa los campos para editar.");
        }
    }

    @FXML
    private void onEliminarClicked(ActionEvent event) {
        Producto seleccionado = tblProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaProductos.remove(seleccionado);
            listaFiltrada.remove(seleccionado);
            limpiarFormulario();
        } else {
            mostrarAlerta("Selecciona un producto para eliminar.");
        }
    }

    private boolean camposValidos() {
        try {
            if (txtCodigo.getText().trim().isEmpty()) return false;
            if (txtNombre.getText().trim().isEmpty()) return false;
            if (cmbTalla.getValue() == null) return false;
            if (txtColor.getText().trim().isEmpty()) return false;
            Double.parseDouble(txtPrecio.getText().trim());
            Integer.parseInt(txtStock.getText().trim());
            if (cmbCategoria.getValue() == null || cmbCategoria.getValue().trim().isEmpty()) return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void limpiarFormulario() {
        txtCodigo.clear();
        txtNombre.clear();
        cmbTalla.setValue("M");
        txtColor.clear();
        txtPrecio.clear();
        txtStock.clear();
        txtBusqueda.clear();
        cmbCategoria.setValue("Todos");
        tblProductos.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Atención");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    
}

