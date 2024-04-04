/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package archivos;

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
public class PaginaAgregarController implements Initializable {

    @FXML
    private Button btnBoton;

    @FXML
    private Button btnConfirmar;

    @FXML
    private ComboBox<String> listCategoria;

    @FXML
    private TextField text_cantidad;

    @FXML
    private TextField text_descripcion;

    @FXML
    private TextField text_identificador;

    /**
     * Initializes the controller class.
     */
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> list = new ArrayList();
        Collections.addAll(list, new String[]{"Entretenimiento", "Alimentos", "Servicios", "Ropa"});
        listCategoria.getItems().addAll(list);
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
    private void comboEvent(ActionEvent event) {
        
        
        System.out.println(listCategoria.getValue());
        
    }

    @FXML
    private void confirmar(ActionEvent event) {
        
        GestionGasto gasto = new GestionGasto();
        
        String id = text_identificador.getText();
        String cat = listCategoria.getValue();
        double can = Double.parseDouble(text_cantidad.getText());
        String des = text_descripcion.getText();
        
        if(gasto.agregarGasto(id, cat, can, des)){
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