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
     public void handleIniciar(ActionEvent event) {
        String correo = txtCorreo.getText().trim();
        String clave = txtContraseña.getText().trim();

        // Validar campos vacíos
        if (correo.isEmpty() || clave.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, completa todos los campos.");
            alert.showAndWait();
            return;
        }

        // Verificar usuario en la lista global
        Usuario u = LoginApp.listaUsuarios.login(correo, clave);

        if (u != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acceso permitido");
            alert.setHeaderText(null);
            alert.setContentText("¡Bienvenido, " + u.nombre + "!");
            alert.showAndWait();

            // TODO: abrir menú principal (por ahora solo notifica)

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de acceso");
            alert.setHeaderText(null);
            alert.setContentText("Correo o contraseña incorrectos.");
            alert.showAndWait();
        }
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
