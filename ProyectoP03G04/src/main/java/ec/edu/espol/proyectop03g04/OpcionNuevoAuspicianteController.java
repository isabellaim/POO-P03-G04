/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author asala
 */
public class OpcionNuevoAuspicianteController implements Initializable {


    @FXML
    private BorderPane bpOpcionNuevoAuspiciante;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private ImageView imageView1;
    @FXML
    private TextField tfNombre;
    @FXML
    private ImageView imageView2;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private ImageView imageView3;
    @FXML
    private TextField tfLugar;
    @FXML
    private ImageView imageView4;
    @FXML
    private TextField tfLugar1;
    @FXML
    private ImageView imageView5;
    @FXML
    private TextField tfLugar2;
    @FXML
    private ImageView imageView6;
    @FXML
    private TextField tfHorario;
    @FXML
    private ImageView imageView7;
    @FXML
    private TextField tfCantidadStands1;
    @FXML
    private ImageView imageView8;
    @FXML
    private ImageView imageView9;
    @FXML
    private ImageView imageView51;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void clickRegresar(ActionEvent event) {
        try{
            App.setRoot("administracionAuspiciantes");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickGuardar(ActionEvent event) {
    }

    @FXML
    private void initialize(ActionEvent event) {
    }

}
