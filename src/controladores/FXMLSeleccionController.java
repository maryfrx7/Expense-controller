/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logica.GestionGasto;

public class FXMLSeleccionController implements Initializable{
    

@FXML
    private Label aceptadoLabel;

    @FXML
    private Button agregarBtn;

    @FXML
    private Button eliminarBtn;

    @FXML
    private Button modificarBtn;

    @FXML
    private Label nomLabel;
    


    @FXML
    void agregarGasto(ActionEvent event) {

    }
    
    
    @FXML
    void eliminarGasto(ActionEvent event) {

    }

    @FXML
    void modificarGasto(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void recibirDatos(String nombre) {
        
    }
    
}

