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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    private void clickAdministracionStands() throws IOException {
        App.setRoot("administracionStands");
    }
    
    @FXML
    private void clickAdministracionFerias() throws IOException {
        App.setRoot("administracionFerias");
    }
    
    @FXML
    private void clickAdministracionEmprendedores() throws IOException {
        App.setRoot("administracionEmprendedores");
    }
    
    @FXML
    private void clickAdministracionAuspiciantes() throws IOException {
        App.setRoot("administracionAuspiciantes");
    }
}
