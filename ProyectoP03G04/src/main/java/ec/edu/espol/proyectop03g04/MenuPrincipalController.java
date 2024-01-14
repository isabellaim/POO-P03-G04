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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
