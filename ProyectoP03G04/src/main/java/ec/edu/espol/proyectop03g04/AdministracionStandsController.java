/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class AdministracionStandsController implements Initializable {

    @FXML
    private BorderPane bpAdminStands;
    @FXML
    private HBox hbHeading;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private ImageView imgAntesMostrarStands;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField tfCodigoFeria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Image img1 = new Image(new FileInputStream("src/main/resources/imágenes/rueda-de-la-fortuna.png"));
            imgHeader2.setImage(img1);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img2 = new Image(new FileInputStream("src/main/resources/imágenes/amigo.png"));
            imgAntesMostrarStands.setImage(img2);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }   
    }    
    
    @FXML
    private void clickRegresar() throws IOException {
        App.setRoot("menuPrincipal");
    }
}
