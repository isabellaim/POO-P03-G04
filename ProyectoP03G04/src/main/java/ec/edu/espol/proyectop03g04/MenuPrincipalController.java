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
        try{
            Image img1 = new Image(new FileInputStream("src/main/resources/imágenes/feria.png"));
            imgHeader1.setImage(img1);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img2 = new Image(new FileInputStream("src/main/resources/imágenes/rueda-de-la-fortuna.png"));
            imgHeader2.setImage(img2);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img3 = new Image(new FileInputStream("src/main/resources/imágenes/parque-tematico.png"));
            imgAdminFeria.setImage(img3);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img4 = new Image(new FileInputStream("src/main/resources/imágenes/grupo.png"));
            imgAdminEmpre.setImage(img4);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img5 = new Image(new FileInputStream("src/main/resources/imágenes/lucha.png"));
            imgAdminAus.setImage(img5);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img6 = new Image(new FileInputStream("src/main/resources/imágenes/feria (1).png"));
            imgAdminStands.setImage(img6);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
        
        try{
            Image img7 = new Image(new FileInputStream("src/main/resources/imágenes/salida.png"));
            imgSalir.setImage(img7);
        } catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de la imagen.");
        }
    }    
    
}
