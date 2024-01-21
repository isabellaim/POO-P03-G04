/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import excepciones.StringVacio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import modelo.Emprendedor;
import modelo.R;
import modelo.RedSocial;
import modelo.SC;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class OpcionNuevoEmprendedorController implements Initializable {

    @FXML
    private BorderPane bpOpcionNuevoEmprendedor;
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
    private TextField tfCedula;
    @FXML
    private ImageView imageView3;
    @FXML
    private TextField tfPersonResponable;
    @FXML
    private ImageView imageView4;
    @FXML
    private TextField tfTelefono;
    @FXML
    private ImageView imageView5;
    @FXML
    private TextField tfEmail;
    @FXML
    private ImageView imageView6;
    @FXML
    private TextField tfDireccion;
    @FXML
    private ImageView imageView7;
    @FXML
    private TextField tfSitioWeb;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private ImageView imageView9;
    @FXML
    private CheckBox cbInstagram;
    @FXML
    private CheckBox cbFacebook;
    @FXML
    private CheckBox cbTwitter;
    @FXML
    private CheckBox cbTikTok;
    @FXML
    private CheckBox cbPinterest;
    @FXML
    private CheckBox cbYoutube;
    @FXML
    private CheckBox cbLinkedIn;
    @FXML
    private TextField tfInstagram;
    @FXML
    private TextField tfFacebook;
    @FXML
    private TextField tfTwitter;
    @FXML
    private TextField tfTikTok;
    @FXML
    private TextField tfPinterest;
    @FXML
    private TextField tfYouTube;
    @FXML
    private TextField tfLinkedIn;
    @FXML
    private ImageView imageView8;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
        imageView1.setImage(new Image("/imagenes/nombrePersona.png"));
        imageView2.setImage(new Image("/imagenes/cedula.png"));
        imageView3.setImage(new Image("/imagenes/perRes.png"));
        imageView4.setImage(new Image("/imagenes/telefono.png"));
        imageView5.setImage(new Image("/imagenes/email.png"));
        imageView6.setImage(new Image("/imagenes/lugar.png"));
        imageView7.setImage(new Image("/imagenes/sitioWeb.png"));
        imageView8.setImage(new Image("/imagenes/descripcion1.png"));
        imageView9.setImage(new Image("/imagenes/redes.png"));
        
        
    }    
    
    @FXML
    private void clickRegresar(ActionEvent event) {
        try{
            App.setRoot("administracionAuspiciantes");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(null);
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            System.out.println("User clicked OK");
            try{
                App.setRoot("opcionNuevoAuspiciante");
            } catch(IOException e){
                e.printStackTrace();
            }
        });
        alert.showAndWait();
    }
    
    private static String recuperarString(TextField tf) throws StringVacio{
        String str = tf.getText();
        if (str.equals("")){
            throw new StringVacio("Por favor coloque información válida.");
        }
        return str;
    }
    
    private static String recuperarCuenta(TextField tf) throws StringVacio{
        String str = tf.getText();
        if (str.equals("")){
            throw new StringVacio("Por favor coloque una cuenta válida.");
        }
        return str;
    }
    
    @FXML
    private void clickCbInstagram(ActionEvent event){
        if(cbInstagram.isSelected()){
            tfInstagram.setDisable(false);
        } else{
            tfInstagram.clear();
            tfInstagram.setDisable(true);
        }
    }
    
    @FXML
    private void clickCbFacebook(ActionEvent event){
        if(cbFacebook.isSelected()){
            tfFacebook.setDisable(false);
        } else{
            tfFacebook.clear();
            tfFacebook.setDisable(true);
        }
    }
    
    @FXML
    private void clickCbTwitter(ActionEvent event){
        if(cbTwitter.isSelected()){
            tfTwitter.setDisable(false);
        } else{
            tfTwitter.clear();
            tfTwitter.setDisable(true);
        }
    }
    
    @FXML
    private void clickCbTikTok(ActionEvent event){
        if(cbTikTok.isSelected()){
            tfTikTok.setDisable(false);
        } else{
            tfTikTok.clear();
            tfTikTok.setDisable(true);
        }
    }
    
    @FXML
    private void clickCbPinterest(ActionEvent event){
        if(cbPinterest.isSelected()){
            tfPinterest.setDisable(false);
        } else{
            tfPinterest.clear();
            tfPinterest.setDisable(true);
        }
    }
    
    @FXML
    private void clickCbYouTube(ActionEvent event){
        if(cbYoutube.isSelected()){
            tfYouTube.setDisable(false);
        } else{
            tfYouTube.clear();
            tfYouTube.setDisable(true);
        }
    }
    
    @FXML
    private void clickCbLinkedIn(ActionEvent event){
        if(cbLinkedIn.isSelected()){
            tfLinkedIn.setDisable(false);
        } else{
            tfLinkedIn.clear();
            tfLinkedIn.setDisable(true);
        }
        
    }
    
    @FXML
    private void clickGuardar(ActionEvent event) {
        String nombre = null;
        String cedula = null;
        String personaRes = null;
        String telefono = null;
        String email = null;
        String direccion = null;
        String sitioWeb = null;
        ArrayList<RedSocial> redes = new ArrayList<>();
        String descripcion = null;
        try{
            nombre = recuperarString(tfNombre);
            cedula = recuperarString(tfCedula);
            personaRes = recuperarString(tfPersonResponable);
            telefono = recuperarString(tfTelefono);
            email = recuperarString(tfEmail);
            direccion = tfDireccion.getText();
            sitioWeb = tfSitioWeb.getText();
            descripcion = recuperarString(tfDescripcion);
            
            if(cbInstagram.isSelected()){
                String cuenta = recuperarCuenta(tfInstagram);
                RedSocial red = new RedSocial(cuenta,R.INSTAGRAM);
                redes.add(red);
            }
            if(cbFacebook.isSelected()){
                String cuenta = recuperarCuenta(tfFacebook);
                RedSocial red = new RedSocial(cuenta,R.FACEBOOK);
                redes.add(red);
            }
            if(cbTwitter.isSelected()){
                String cuenta = recuperarCuenta(tfTwitter);
                RedSocial red = new RedSocial(cuenta,R.TWITTER);
                redes.add(red);
            }
            if(cbTikTok.isSelected()){
                String cuenta = recuperarCuenta(tfTikTok);
                RedSocial red = new RedSocial(cuenta,R.TIKTOK);
                redes.add(red);
            }
            if(cbPinterest.isSelected()){
                String cuenta = recuperarCuenta(tfPinterest);
                RedSocial red = new RedSocial(cuenta,R.PINTEREST);
                redes.add(red);
            }
            if(cbYoutube.isSelected()){
                String cuenta = recuperarCuenta(tfYouTube);
                RedSocial red = new RedSocial(cuenta,R.YOUTUBE);
                redes.add(red);
            }
            if(cbLinkedIn.isSelected()){
                String cuenta = recuperarCuenta(tfLinkedIn);
                RedSocial red = new RedSocial(cuenta,R.LINKEDIN);
                redes.add(red);
            }
            
            AdministracionEmprendedoresController.emprendedores.add(new Emprendedor(cedula, nombre, personaRes, telefono, email, direccion, sitioWeb, redes,descripcion));
            App.setRoot("administracionEmprendedores");
                
        } catch(StringVacio sv){
            mostrarAlerta(sv.getMessage());
        } catch(IOException e){
            e.printStackTrace();
        } catch (Exception e){
            mostrarAlerta("Error");
        }
    }
    
}
