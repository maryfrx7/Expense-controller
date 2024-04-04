/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aplicacion_final;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mary Flores
 */

public class SeleccionController implements Initializable {

    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnActualizar;
    @FXML
    private AnchorPane rightAnchor;

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

    private void setRootNode(Parent root) {
        rightAnchor.getChildren().clear();
        rightAnchor.getChildren().add(root);
    }

    @FXML
    private void Registrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/paginaAgregar.fxml"));
            Parent root = loader.load();
            setRootNode(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/paginaEliminar.fxml"));
            Parent root = loader.load();
            setRootNode(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Mostrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/paginaMostrar.fxml"));
            Parent root = loader.load();
            setRootNode(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Actualizar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/archivos/paginaModificar.fxml"));
            Parent root = loader.load();
            setRootNode(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
