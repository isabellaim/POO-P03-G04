/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import java.util.*;
import modelo.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class AdministracionAuspiciantesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    public static ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private VBox vbAuspiciantes;
    @FXML
    private Label lblAuspicianteEscogido;
    @FXML
    private Button btnNuevoAuspiciante;
    @FXML
    private Button btnEditarAuspiciante;
    @FXML
    private Button btnAsignarAuspicianteFeria;
    @FXML
    private BorderPane bpAdminAuspiciantes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
    }
    
    @FXML
    private void clickRegresar() {
        try{
            App.setRoot("menuPrincipal");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
