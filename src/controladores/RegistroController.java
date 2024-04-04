/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logica.GestionGasto;

public class RegistroController implements Initializable {

    @FXML
    private Button close;

    @FXML
    private Button loginBtn;


    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    @Override
       public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
    
    @FXML
    void loginAdmin(ActionEvent event)  {
         GestionGasto upa = new GestionGasto();

        String correo = username.getText();
        String contrasena = password.getText();

        if (upa.nuevoUsuario(correo, contrasena)) {
            try {
                // Cargar el nuevo FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/seleccion.fxml"));
                Parent root = loader.load();

                // Crear una nueva escena
                Scene scene = new Scene(root);

                // Obtener la ventana actual y cambiar su contenido por la nueva escena
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                // Manejo de errores si la carga del FXML falla o algo va mal
            }
        }
    }
    
    

}