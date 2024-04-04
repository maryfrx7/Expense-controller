/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logica.GestionGasto;

/**
 * FXML Controller class
 *
 * @author Mary Flores
 */
public class PaginaModificarController implements Initializable {

     @FXML
    private Button btnBoton;
    @FXML
    private TextField txt_ID;
    @FXML
    private TextField txt_ID_Original;
    @FXML
    private ComboBox<String> Categoria;
    @FXML
    private TextField txt_Cantidad;
    @FXML
    private TextField txt_Descripcion;
    @FXML
    private Button btnCambiar;
    
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> list = new ArrayList();
        Collections.addAll(list, new String[]{"Entretenimiento", "Alimentos", "Servicios", "Ropa"});
        Categoria.getItems().addAll(list);
    }    

    @FXML
    private void regresar(ActionEvent event) {
        try {
            // Cargar el nuevo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/seleccion.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena
            Scene scene = new Scene(root);

            // Obtener la ventana actual y cambiar su contenido por la nueva escena
            Stage stage = (Stage) btnBoton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        // Manejo de errores si la carga del FXML falla o algo va mal
        }
    }

    @FXML
    private void cambiar(ActionEvent event) {
        
        GestionGasto gasto = new GestionGasto();
        
        if(gasto.actualizarDatos(txt_ID_Original.getText(), txt_ID.getText(), Categoria.getValue(),Double.parseDouble(txt_Cantidad.getText()) , txt_Descripcion.getText())){
            try {
                // Cargar el nuevo FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/seleccion.fxml"));
                Parent root = loader.load();

                // Crear una nueva escena
                Scene scene = new Scene(root);

                // Obtener la ventana actual y cambiar su contenido por la nueva escena
                Stage stage = (Stage) btnBoton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                // Manejo de errores si la carga del FXML falla o algo va mal
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null); // No queremos un encabezado adicional
            alert.setContentText("Error verifique su informacion");
            alert.showAndWait();
        }
        
    }
    
}