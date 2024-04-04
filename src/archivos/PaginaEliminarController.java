/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package archivos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logica.GestionGasto;

/**
 * FXML Controller class
 *
 * @author Mary Flores
 */
public class PaginaEliminarController implements Initializable {

    @FXML
    private Button btnBoton;
    @FXML
    private TextField textfield;
    @FXML
    private Button buscar;
    @FXML
    private TextArea TextArea;

    /**
     * Initializes the controller class.
     */
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
private void guardarTex(ActionEvent event) {
    String identificador = textfield.getText();
    GestionGasto gestionGastos = new GestionGasto();
    boolean eliminacionExitosa = gestionGastos.eliminarGasto(identificador);

    // Usa el nombre correcto del TextArea definido en FXML
    if (eliminacionExitosa) {
        TextArea.appendText("Eliminación exitosa para el identificador: " + identificador + "\n");
    } else {
        TextArea.appendText("No se encontró el identificador: " + identificador + "\n");
    }
}
}