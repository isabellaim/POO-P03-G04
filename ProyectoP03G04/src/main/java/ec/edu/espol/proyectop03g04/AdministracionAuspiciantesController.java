/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;
import modelo.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.LineTo;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Border;

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
    private BorderPane bpAdminAuspiciantes;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private Button btnNuevoAuspiciante;
    @FXML
    private Button btnEditarAuspiciante;
    @FXML
    private Label lblAuspicianteEscogido;
    @FXML
    private VBox vbAuspiciantes;
    
    public static Auspiciante auspicianteEscogido;
    public static String codigoAuspiciante;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnAsignarAuspicianteFeria;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
        auspicianteEscogido = null;
        codigoAuspiciante = null;
        this.cargarAuspiciantes();
    }    
    
    @FXML
    private void clickRegresar() {
        try{
            App.setRoot("menuPrincipal");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
            
   
            
    private void cargarAuspiciantes(){
        // mostrarAuspiciantes
        ArrayList<HBox> hbs = new ArrayList<>();
        int index = 0;
        int numHBoxes = 0;
        if(auspiciantes.size()%2==0){
            numHBoxes = auspiciantes.size()/2;
            for(int i=1; i<=numHBoxes;i++){
                HBox hbAuspiciantes = new HBox(10);
                hbAuspiciantes.setPrefWidth(738);
                hbAuspiciantes.setPrefHeight(219);
                hbAuspiciantes.setMinWidth(738);
                hbAuspiciantes.setMinHeight(219);
                hbAuspiciantes.setMaxWidth(738);
                hbAuspiciantes.setMaxHeight(219);
                hbs.add(hbAuspiciantes);
                vbAuspiciantes.getChildren().add(hbAuspiciantes);
            }
        } else{
            int num = auspiciantes.size() + 1;
            numHBoxes = num/2;
            for(int i=1; i<=numHBoxes;i++){
                HBox hbAuspiciantes = new HBox(10);
                hbAuspiciantes.setPrefWidth(738);
                hbAuspiciantes.setPrefHeight(219);
                hbAuspiciantes.setMinWidth(738);
                hbAuspiciantes.setMinHeight(219);
                hbAuspiciantes.setMaxWidth(738);
                hbAuspiciantes.setMaxHeight(219);
                hbs.add(hbAuspiciantes);
                vbAuspiciantes.getChildren().add(hbAuspiciantes);
            }
        }
        System.out.println(numHBoxes);
        
        for (Auspiciante auspiciante: auspiciantes){
           Image img = new Image("/imagenes/sponsor_mostrar.png");
            ImageView iv = new ImageView(img);
            iv.setFitHeight(55);
            iv.setFitWidth(55);
            VBox vbAuspiciante = new VBox();
            vbAuspiciante.setAlignment(Pos.CENTER);
            vbAuspiciante.setSpacing(6);
            vbAuspiciante.setPrefHeight(219);
            vbAuspiciante.setPrefWidth(364);
            Font fontb = Font.font("Arial Rounded MT Bold", 12);
            Font fontr = Font.font("Arial Rounded MT", 12);
            Button btnSeleccionar = new Button("Seleccionar");
            btnSeleccionar.setFont(fontb);
            btnSeleccionar.setStyle("-fx-background-color: indigo; -fx-text-fill: white;");
            Label cedula1 = new Label("Cédula:");
            Label nombre1 = new Label("Nombre:");
            Label telefono1 = new Label("Teléfono:");
            Label email1 = new Label("Email:");
            Label cedula2 = new Label(auspiciante.getCedula());
            Label nombre2 = new Label(auspiciante.getNombre());
            Label telefono2 = new Label(auspiciante.getTelefono());
            Label email2 = new Label(auspiciante.getEmail());
            cedula1.setFont(fontb);
            nombre1.setFont(fontb);
            email1.setFont(fontb);
            telefono1.setFont(fontb);
            cedula2.setFont(fontr);
            nombre2.setFont(fontr);
            telefono2.setFont(fontr);
            email2.setFont(fontr);
            HBox cedula = new HBox();
            cedula.getChildren().addAll(cedula1,cedula2);
            cedula.setSpacing(5);
            cedula.setAlignment(Pos.CENTER);
            HBox nombre = new HBox();
            nombre.getChildren().addAll(nombre1,nombre2);
            nombre.setSpacing(5);
            nombre.setAlignment(Pos.CENTER);
            HBox telefono = new HBox();
            telefono.getChildren().addAll(telefono1,telefono2);
            telefono.setSpacing(5);
            telefono.setAlignment(Pos.CENTER);
            HBox email = new HBox();
            email.getChildren().addAll(email1,email2);
            email.setSpacing(5);
            email.setAlignment(Pos.CENTER);
            vbAuspiciante.getChildren().addAll(iv,cedula,nombre,telefono,email, btnSeleccionar);
            Border border = new Border(new BorderStroke(javafx.scene.paint.Color.INDIGO, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));
            vbAuspiciante.setBorder(border);
            
            HBox hb = hbs.get(index);
            hb.getChildren().add(vbAuspiciante);
            if(hb.getChildren().size()>=2){
                index+=1;
            }
            
           
            btnSeleccionar.setOnAction(e -> {
                auspicianteEscogido=auspiciante;
                lblAuspicianteEscogido.setText(auspiciante.getNombre());
                btnEditarAuspiciante.setDisable(false);
                btnAsignarAuspicianteFeria.setDisable(false);
            });
            
              btnNuevoAuspiciante.setOnAction(e -> {
                  try{
                    App.setRoot("opcionNuevoAuspiciante");
                    } catch(IOException c){
                    c.printStackTrace();
                    }
               });
        }
    }
    
       
            
    /*
    private boolean auspicianteExiste(String cedula){
        for(Auspiciante auspiciante: auspiciantes){
            if (auspiciante.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    */
}
