/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modelo.Auspiciante;
import modelo.AuspicianteEnFeria;
import modelo.Emprendedor;
import modelo.Feria;
import modelo.R;
import modelo.RedSocial;
import modelo.SC;
import modelo.Stand;
/**
 * FXML Controller class
 *
 * @author isabella
 */
public class MenuPrincipalController implements Initializable {


    @FXML
    private BorderPane bpPrincipal;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnAdminFeria;
    @FXML
    private Button btnAdminEmpre;
    @FXML
    private Button btnAdminAus;
    @FXML
    private Button btnAdminStands;
    @FXML
    private Button btnSalir;
    @FXML
    private ImageView imgHeader1;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private ImageView imgAdminFeria;
    @FXML
    private ImageView imgAdminEmpre;
    @FXML
    private ImageView imgAdminAus;
    @FXML
    private ImageView imgAdminStands;
    @FXML
    private ImageView imgSalir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img1 = new Image("/imagenes/feria.png");
        imgHeader1.setImage(img1);
        
        Image img2 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img2);
        
        
        Image img3 = new Image("/imagenes/parque-tematico.png");
        imgAdminFeria.setImage(img3);
        
        
        Image img4 = new Image("/imagenes/grupo.png");
        imgAdminEmpre.setImage(img4);
        
    
        Image img5 = new Image("/imagenes/lucha.png");
        imgAdminAus.setImage(img5);
        
        Image img6 = new Image("/imagenes/feria (1).png");
        imgAdminStands.setImage(img6);
        
        Image img7 = new Image("/imagenes/salida.png");
        imgSalir.setImage(img7);
    }
    
    @FXML
    private void clickAdministracionStands() {
        try{
            App.setRoot("administracionStands");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickAdministracionFerias() {
        try{
            App.setRoot("administracionFerias");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickAdministracionEmprendedores() {
        try{
            App.setRoot("administracionEmprendedores");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickAdministracionAuspiciantes() {
        try{
            App.setRoot("administracionAuspiciantes");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickSalir() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText("Está saliendo del programa");
        alert.setContentText("¡Gracias por visitarnos!");
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            Platform.exit();
        });
        alert.showAndWait();
    }
}
