/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package archivos;

import datos.Gasto;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import logica.GestionGasto;

/**
 * FXML Controller class
 *
 * @author Mary Flores
 */
public class PaginaMostrarController implements Initializable {

    @FXML
    private Button btnBoton;
    @FXML
    private TextArea textOut;
    
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GestionGasto opFGastos = new GestionGasto();  
        HashMap<String,Gasto> gastos = opFGastos.recuperarGastos();
        for (Gasto gas : gastos.values()) {
            textOut.appendText("-----GASTO-----"+"\nID: "+gas.getIdentificador()+"\nCategoria: "+gas.getCategoria()+"\nCantidad: "+gas.getCantidad()+"\nDescripcion: "+gas.getDescripcion()+"\nFecha: "+gas.getFecha()+"\n");
        }
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

    
}