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
public class RegistroController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtContraseña;
    @FXML
    private Button btnRegistro;
    @FXML
    private Label lblIniciarS;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    private void handleRegistrar(ActionEvent event) {
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String clave = txtContraseña.getText().trim();

        // Validación de campos vacíos
        if (nombre.isEmpty() || correo.isEmpty() || clave.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Por favor, completa todos los campos.", Alert.AlertType.WARNING);
            return;
        }

        // Verificar si ya existe un usuario con el mismo correo
        boolean exito = LoginApp.listaUsuarios.registrarUsuario(new Usuario(nombre, correo, clave));

        if (exito) {
            mostrarAlerta("Registro exitoso", "¡Usuario registrado correctamente!", Alert.AlertType.INFORMATION);

            // Volver al login
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Iniciar Sesión");
                stage.setScene(new Scene(root));
                stage.show();

                // Cerrar ventana actual
                Stage actual = (Stage) btnRegistro.getScene().getWindow();
                actual.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            mostrarAlerta("Registro fallido", "El correo ya está registrado.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    

    
}
