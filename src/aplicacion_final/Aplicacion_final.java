/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package aplicacion_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 
import javafx.stage.StageStyle;
import logica.GestionGasto;

public class Aplicacion_final extends Application {
    private double x = 0; 
    private double y = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            GestionGasto gasto = new GestionGasto();
            System.out.println(gasto.linea1Blanco());

            String ruta;
            if (gasto.linea1Blanco()) {
                ruta = "/archivos/registro.fxml";
            } else {
                ruta = "/archivos/FXMLDocument.fxml";
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion_final.class.getResource(ruta));
            Pane ventana = (Pane) loader.load();

            Scene scene = new Scene(ventana);

            ventana.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            ventana.setOnMouseDragged((MouseEvent event) -> {
                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);

                primaryStage.setOpacity(.8);
            });

            ventana.setOnMouseReleased((MouseEvent event) -> {
                primaryStage.setOpacity(1);
            });

            primaryStage.initStyle(StageStyle.TRANSPARENT);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable cause = e.getCause();
            if (cause != null) {
                cause.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
