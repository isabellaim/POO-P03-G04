/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import java.util.*;
import modelo.*;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.ScrollPane;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class AdministracionEmprendedoresController implements Initializable {
    
    public static ArrayList<Emprendedor> emprendedores = Utilitaria.readListFromFileEmprendedor();
    @FXML
    private BorderPane bpAdminEmprendedores;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private VBox vbEmprendedores;
    @FXML
    private Label lblEmprendedorEscogido;
    @FXML
    private Button btnNuevoEmprendedor;
    @FXML
    private Button btnEditarEmprendedor;
    
    public static Emprendedor emprendedorEscogido;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
        emprendedorEscogido = null;
        this.cargarEmprendedores();
    }    

    @FXML
    private void clickRegresar() {
        try{
            App.setRoot("menuPrincipal");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void cargarEmprendedores(){
        ArrayList<HBox> hbs = new ArrayList<>();
        int index = 0;
        int numHBoxes = 0;
        if(emprendedores.size()%2==0){
            numHBoxes = emprendedores.size()/2;
            for(int i=1; i<=numHBoxes;i++){
                HBox hbEmprendedores = new HBox(10);
                hbEmprendedores.setPrefWidth(738);
                hbEmprendedores.setPrefHeight(219);
                hbEmprendedores.setMinWidth(738);
                hbEmprendedores.setMinHeight(219);
                hbEmprendedores.setMaxWidth(738);
                hbEmprendedores.setMaxHeight(219);
                hbs.add(hbEmprendedores);
                vbEmprendedores.getChildren().add(hbEmprendedores);
            }
        } else{
            int num = emprendedores.size() + 1;
            numHBoxes = num/2;
            for(int i=1; i<=numHBoxes;i++){
                HBox hbEmprendedores = new HBox(10);
                hbEmprendedores.setPrefWidth(738);
                hbEmprendedores.setPrefHeight(219);
                hbEmprendedores.setMinWidth(738);
                hbEmprendedores.setMinHeight(219);
                hbEmprendedores.setMaxWidth(738);
                hbEmprendedores.setMaxHeight(219);
                hbs.add(hbEmprendedores);
                vbEmprendedores.getChildren().add(hbEmprendedores);
            }
        }
        System.out.println(numHBoxes);
        
        for (Emprendedor emprendedor: emprendedores){
            Image img = new Image("/imagenes/emprendedorMostrar.png");
            ImageView iv = new ImageView(img);
            iv.setFitHeight(60);
            iv.setFitWidth(60);
            VBox vbEmprendedor = new VBox();
            vbEmprendedor.setAlignment(Pos.CENTER);
            vbEmprendedor.setSpacing(6);
            vbEmprendedor.setPrefHeight(219);
            vbEmprendedor.setPrefWidth(364);
            Font fontb = Font.font("Arial Rounded MT Bold", 12);
            Font fontr = Font.font("Arial Rounded MT", 12);
            Button btnSeleccionar = new Button("Seleccionar");
            btnSeleccionar.setFont(fontb);
            btnSeleccionar.setStyle("-fx-background-color: indigo; -fx-text-fill: white;");
            Label cedula1 = new Label("Cédula:");
            Label nombre1 = new Label("Nombre:");
            Label telefono1 = new Label("Teléfono:");
            Label email1 = new Label("Email:");
            Label cedula2 = new Label(emprendedor.getCedula());
            Label nombre2 = new Label(emprendedor.getNombre());
            Label telefono2 = new Label(emprendedor.getTelefono());
            Label email2 = new Label(emprendedor.getEmail());
            //.
            cedula1.setFont(fontb);
            nombre1.setFont(fontb);
            telefono1.setFont(fontb);
            email1.setFont(fontb);
            cedula2.setFont(fontb);
            nombre2.setFont(fontb);
            telefono2.setFont(fontb);
            email2.setFont(fontb);
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
            vbEmprendedor.getChildren().addAll(iv,cedula,nombre,telefono,email, btnSeleccionar);
            Border border = new Border(new BorderStroke(javafx.scene.paint.Color.INDIGO, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));
            vbEmprendedor.setBorder(border);
            
            HBox hb = hbs.get(index);
            hb.getChildren().add(vbEmprendedor);
            if(hb.getChildren().size()>=2){
                index+=1;
            }
            
            btnNuevoEmprendedor.setOnAction(e -> {
                try{
                    App.setRoot("opcionNuevoEmprendedor");
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
            btnSeleccionar.setOnAction(e -> {
                emprendedorEscogido=emprendedor;
                lblEmprendedorEscogido.setText(emprendedor.getNombre());
                btnEditarEmprendedor.setDisable(false);
                btnEditarEmprendedor.setOnAction(u -> {
                try{
                    App.setRoot("opcionEditarEmprendedor");
                } catch(IOException a){
                    a.printStackTrace();
                }
                });
            });
        }
    
    }
    
}
