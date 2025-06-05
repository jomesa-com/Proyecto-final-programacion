/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vista;

import Modelo.Usuario;
import Modelo.ListaUsuario;
import Main.LoginApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jomes
 */
public class ControladorLogin implements Initializable {

   @FXML 
   private TextField txtCorreo;
   @FXML
   private TextField txtContraseña;
   @FXML
   private Button btnIniciar;
   @FXML
   private Label lblCrearCuenta;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    
    
    
    @FXML
private void handleIniciar(ActionEvent event) {
    String correo = txtCorreo.getText().trim();
    String clave = txtContraseña.getText().trim();

    if (correo.isEmpty() || clave.isEmpty()) {
        mostrarAlerta("Campos incompletos", "Por favor, completa todos los campos.", Alert.AlertType.WARNING);
        return;
    }

    Usuario u = LoginApp.listaUsuarios.login(correo, clave);

    if (u != null) {
        mostrarAlerta("Bienvenido", "Inicio de sesión exitoso.", Alert.AlertType.INFORMATION);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Catalogo.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Catálogo de Productos");
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar ventana actual
            Stage actual = (Stage) btnIniciar.getScene().getWindow();
            actual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    } else {
        mostrarAlerta("Acceso denegado", "Correo o contraseña incorrectos.", Alert.AlertType.ERROR);
    }
}

private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
    Alert alert = new Alert(tipo);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}

     
     @FXML
private void handleIrARegistro() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registro.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Registro de Usuario");
        stage.setScene(new Scene(root));
        stage.show();

        // Cerrar la ventana de login actual si deseas
        Stage actual = (Stage) lblCrearCuenta.getScene().getWindow();
        actual.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
