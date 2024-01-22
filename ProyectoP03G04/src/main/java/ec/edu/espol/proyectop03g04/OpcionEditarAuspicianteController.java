/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package ec.edu.espol.proyectop03g04;

import excepciones.FechaNoPuedeSerDespues;
import excepciones.FechaVacia;
import excepciones.StringVacio;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
import modelo.Auspiciante;
import modelo.Emprendedor;
import modelo.Feria;
import modelo.R;
import modelo.RedSocial;
import modelo.SC;
import modelo.Utilitaria;

/**
 * FXML Controller class
 *
 * @author asala
 */
public class OpcionEditarAuspicianteController implements Initializable {

    @FXML
    private BorderPane bpOpcionEditarAuspiciante;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private VBox vbTodoEditarAuspiciante;
    @FXML
    private Label lblAuspicianteEscogido;
    @FXML
    private ComboBox<String> cbEditarAuspiciante;
    @FXML
    private VBox vbEditarAuspiciante;
    @FXML
    private ImageView ivImagenAntesEditar;

@Override
    public void initialize(URL url, ResourceBundle rb) {
        imgHeader2.setImage(new Image("/imagenes/rueda-de-la-fortuna.png"));
        ivImagenAntesEditar.setImage(new Image("/imagenes/amigos.png"));
        Auspiciante auspiciante = AdministracionAuspiciantesController.auspicianteEscogido;
        lblAuspicianteEscogido.setText(auspiciante.getNombre());
        cbEditarAuspiciante.getItems().addAll("Nombre","Persona Responsable", "Teléfono","Email","Dirección","Sitio Web","Redes Sociales","Sectores Cubiertos");
        cbEditarAuspiciante.setCellFactory((ListView<String> param) -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);
                    setFont(Font.font("Arial Rounded MT", 14));
                    setAlignment(Pos.CENTER);
                } else {
                    setText(null);
                }
            }
        });
        
        cbEditarAuspiciante.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);
                    setFont(Font.font("Arial Rounded MT", 14));
                } else {
                    setText(null);
                }
            }
        });
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
    private void clickComboBox() {
        vbEditarAuspiciante.getChildren().clear();
        Auspiciante auspiciante = AdministracionAuspiciantesController.auspicianteEscogido;
        String elegido = cbEditarAuspiciante.getSelectionModel().getSelectedItem();
        editarNormal(elegido,auspiciante);
        editarListas(elegido, auspiciante);

    }
    
    private void validarTextField1(TextField tf,String campo) throws StringVacio{
        if(tf.getText().equals("")){
            throw new StringVacio("El campo " + campo + " no puede estar vacío.");
        }
    }
    
    private void validarTextField2(TextArea ta,String campo) throws StringVacio{
        if(ta.getText().equals("")){
            throw new StringVacio("El campo " + campo + " no puede estar vacío.");
        }
    }
    
    private static String recuperarCuenta(TextField tf) throws StringVacio{
        String str = tf.getText();
        if (str.equals("")){
            throw new StringVacio("Por favor coloque una cuenta válida.");
        }
        return str;
    }
    
    
    public void mostrarAlerta1(String msg, String elegido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(null);
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            System.out.println("User clicked OK");
            cbEditarAuspiciante.setValue(elegido);
            clickComboBox();
        });
        alert.showAndWait();
    }
    
    private void definirEscena(Font fontb18,HBox hbInfoEditar, Button btnGuardar){
        
        hbInfoEditar.setPrefWidth(1280);
        hbInfoEditar.setPrefHeight(300);
        hbInfoEditar.setAlignment(Pos.CENTER);
        
        HBox hbBotones = new HBox(120);
        hbBotones.setPrefWidth(1280);
        hbBotones.setPrefHeight(100);
        hbBotones.setAlignment(Pos.CENTER);
        
        btnGuardar.setFont(fontb18);
        btnGuardar.setAlignment(Pos.CENTER);
        btnGuardar.setPrefWidth(230);
        btnGuardar.setPrefHeight(50);
        BackgroundFill backgroundFill = new BackgroundFill(Color.INDIGO, new CornerRadii(5), javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        btnGuardar.setBackground(background);
        btnGuardar.setStyle(  "-fx-text-fill: white;");
        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setFont(fontb18);
        btnCancelar.setAlignment(Pos.CENTER);
        btnCancelar.setPrefWidth(230);
        btnCancelar.setPrefHeight(50);
        btnCancelar.setBackground(background);
        btnCancelar.setStyle(  "-fx-text-fill: white;");
        btnCancelar.setOnAction(e -> {
            try{
            App.setRoot("administracionauspiciantes");
            } catch(IOException i){
                i.printStackTrace();
            }
        });
        
        hbBotones.getChildren().addAll(btnGuardar,btnCancelar);
        vbEditarAuspiciante.getChildren().addAll(hbInfoEditar,hbBotones);
    }
    
    private void editarNormal(String elegido, Auspiciante auspiciante){
        Font fontb24 = Font.font("Arial Rounded MT Bold", 24);
        Font fontr24 = Font.font("Arial Rounded MT", 24);
        Font fontb18 = Font.font("Arial Rounded MT Bold", 18);
        Font fontr18 = Font.font("Arial Rounded MT", 18);
        
        HBox hbInfoEditar = new HBox(40);
        Button btnGuardar = new Button("Guardar");
        ImageView ivFotoEditar1 = new ImageView();
        ivFotoEditar1.setFitWidth(192);
        ivFotoEditar1.setFitHeight(189);
        
        VBox vbAntes = new VBox(40);
        vbAntes.setPrefWidth(300);
        vbAntes.setPrefHeight(300);
        vbAntes.setAlignment(Pos.CENTER);
        Label lblAnterior = new Label();
        lblAnterior.setFont(fontb24);
        lblAnterior.setWrapText(true);
        lblAnterior.setTextAlignment(TextAlignment.CENTER);
        lblAnterior.setAlignment(Pos.CENTER);
        Label lblAnteriorInfo = new Label();
        lblAnteriorInfo.setFont(fontr24);
        lblAnteriorInfo.setTextAlignment(TextAlignment.CENTER);
        lblAnteriorInfo.setAlignment(Pos.CENTER);
        lblAnteriorInfo.setWrapText(true);
        
        VBox vbNuevo = new VBox(40);
        vbNuevo.setPrefWidth(300);
        vbNuevo.setPrefHeight(300);
        vbNuevo.setAlignment(Pos.CENTER);
        Label lblNuevo = new Label();
        lblNuevo.setFont(fontb24);
        lblNuevo.setTextAlignment(TextAlignment.CENTER);
        lblNuevo.setAlignment(Pos.CENTER);
        lblNuevo.setWrapText(true);
        TextField tfNuevoInfo = new TextField();
        tfNuevoInfo.setFont(fontr18);
        tfNuevoInfo.setAlignment(Pos.CENTER);
        tfNuevoInfo.setPrefWidth(250);
        tfNuevoInfo.setMinWidth(250);
        tfNuevoInfo.setMaxWidth(250);
        tfNuevoInfo.setPrefHeight(40);
        
        ImageView ivFotoEditar2 = new ImageView();
        ivFotoEditar2.setFitWidth(192);
        ivFotoEditar2.setFitHeight(189);
        
        if(elegido.equals("Nombre")){
            ivFotoEditar1.setImage(new Image("/imagenes/iconoAus.png"));
            lblAnterior.setText("Nombre anterior");
            lblAnteriorInfo.setText(auspiciante.getNombre());
            lblNuevo.setText("Nombre nuevo");
            tfNuevoInfo.setPromptText("Edite el nombre");
            ivFotoEditar2.setImage(new Image("/imagenes/iconoAus.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"nombre");
                    auspiciante.setNombre(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
           });
       } else if(elegido.equals("Persona Responsable")){
            ivFotoEditar1.setImage(new Image("/imagenes/nombrePersona.png"));
            lblAnterior.setText("Anterior Persona Responsable");
            lblAnteriorInfo.setText(auspiciante.getNombrePersona());
            lblNuevo.setText("Nueva Persona Responsable");
            tfNuevoInfo.setPromptText("Edite el nombre");
            ivFotoEditar2.setImage(new Image("/imagenes/nombrePersona.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"nombre persona responsable");
                    auspiciante.setEmail(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
           
       } else if(elegido.equals("Teléfono")){
            ivFotoEditar1.setImage(new Image("/imagenes/telefono.png"));
            lblAnterior.setText("Teléfono anterior");
            lblAnteriorInfo.setText(auspiciante.getTelefono());
            lblNuevo.setText("Teléfono nuevo");
            tfNuevoInfo.setPromptText("Edite el Teléfono");
            ivFotoEditar2.setImage(new Image("/imagenes/telefono.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"teléfono");
                    auspiciante.setTelefono(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Email")){
            ivFotoEditar1.setImage(new Image("/imagenes/email.png"));
            lblAnterior.setText("Email anterior");
            lblAnteriorInfo.setText(auspiciante.getEmail());
            lblNuevo.setText("Email nuevo");
            tfNuevoInfo.setPromptText("Edite el email");
            ivFotoEditar2.setImage(new Image("/imagenes/email.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Email");
                    auspiciante.setEmail(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Sitio Web")){
            ivFotoEditar1.setImage(new Image("/imagenes/sitioWeb.png"));
            lblAnterior.setText("Sitio Web anterior");
            lblAnteriorInfo.setText(auspiciante.getSitioWeb());
            lblNuevo.setText("Sitio Web nuevo");
            tfNuevoInfo.setPromptText("Edite el Sitio Web");
            ivFotoEditar2.setImage(new Image("/imagenes/sitioWeb.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Email");
                    auspiciante.setSitioWeb(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Dirección")){
            ivFotoEditar1.setImage(new Image("/imagenes/lugar.png"));
            lblAnterior.setText("Dirección  anterior");
            lblAnteriorInfo.setText(auspiciante.getDireccion());
            lblNuevo.setText("Dirección nueva");
            tfNuevoInfo.setPromptText("Edite la dirección");
            ivFotoEditar2.setImage(new Image("/imagenes/lugar.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Dirección");
                    auspiciante.setDireccion(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       }
        
       if((elegido.equals("Nombre"))||(elegido.equals("Persona Responsable"))||(elegido.equals("Teléfono"))||(elegido.equals("Email"))||(elegido.equals("Dirección"))||(elegido.equals("Sitio Web"))){
        vbAntes.getChildren().addAll(lblAnterior,lblAnteriorInfo);
        vbNuevo.getChildren().addAll(lblNuevo,tfNuevoInfo);
        hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
        definirEscena(fontb18,hbInfoEditar,btnGuardar);
       }
    }
    
    private void editarListas(String elegido, Auspiciante auspiciante){
        Font fontb24 = Font.font("Arial Rounded MT Bold", 20);
        Font fontr24 = Font.font("Arial Rounded MT", 24);
        Font fontb18 = Font.font("Arial Rounded MT Bold", 18);
        Font fontr18 = Font.font("Arial Rounded MT", 14);
        Font fontr12 = Font.font("Arial Rounded MT", 12);
        Font fontb12 = Font.font("Arial Rounded MT Bold", 12);
        
        HBox hbInfoEditar = new HBox(40);
        Button btnGuardar = new Button("Guardar");
        ImageView ivFotoEditar1 = new ImageView();
        ivFotoEditar1.setFitWidth(192);
        ivFotoEditar1.setFitHeight(189);
        
        VBox vbAntes = new VBox(20);
        vbAntes.setPrefWidth(300);
        vbAntes.setPrefHeight(300);
        vbAntes.setAlignment(Pos.CENTER);
        Label lblAnterior = new Label();
        lblAnterior.setFont(fontb24);
        lblAnterior.setWrapText(true);
        lblAnterior.setTextAlignment(TextAlignment.CENTER);
        lblAnterior.setAlignment(Pos.CENTER);
        
        VBox vbAnteriorInfo = new VBox(8);
        vbAnteriorInfo.setAlignment(Pos.CENTER);
        vbAnteriorInfo.setMinHeight(246);
        vbAnteriorInfo.setPrefWidth(276);
        vbAnteriorInfo.setMaxWidth(276);
        vbAnteriorInfo.setMinWidth(276);
        vbAnteriorInfo.setStyle("-fx-background-color: white;");
        
        ScrollPane spAnteriorInfo = new ScrollPane(vbAnteriorInfo);
        spAnteriorInfo.setPrefWidth(280);
        spAnteriorInfo.setMaxWidth(280);
        spAnteriorInfo.setMinWidth(280);
        spAnteriorInfo.setPrefHeight(250);
        spAnteriorInfo.setMaxHeight(250);
        spAnteriorInfo.setMinHeight(250);
        spAnteriorInfo.setStyle("-fx-border-color: lavender;");
        spAnteriorInfo.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spAnteriorInfo.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        VBox vbNuevo = new VBox(20);
        vbNuevo.setPrefWidth(300);
        vbNuevo.setPrefHeight(300);
        vbNuevo.setAlignment(Pos.CENTER);
        Label lblNuevo = new Label();
        lblNuevo.setFont(fontb24);
        lblNuevo.setTextAlignment(TextAlignment.CENTER);
        lblNuevo.setAlignment(Pos.CENTER);
        lblNuevo.setWrapText(true);
        
        VBox vbNuevaInfo = new VBox(8);
        vbNuevaInfo.setAlignment(Pos.CENTER);
        vbNuevaInfo.setMinHeight(246);
        vbNuevaInfo.setPrefWidth(276);
        vbNuevaInfo.setMaxWidth(276);
        vbNuevaInfo.setMinWidth(276);
        vbNuevaInfo.setStyle("-fx-background-color: white;");
        
        ScrollPane spNuevaInfo = new ScrollPane(vbNuevaInfo);
        spNuevaInfo.setPrefWidth(280);
        spNuevaInfo.setMaxWidth(280);
        spNuevaInfo.setMinWidth(280);
        spNuevaInfo.setPrefHeight(250);
        spNuevaInfo.setMaxHeight(250);
        spNuevaInfo.setMinHeight(250);
        spNuevaInfo.setStyle("-fx-border-color: lavender;");
        spNuevaInfo.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spNuevaInfo.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            
        ImageView ivFotoEditar2 = new ImageView();
        ivFotoEditar2.setFitWidth(192);
        ivFotoEditar2.setFitHeight(189);
        
        if(elegido.equals("Redes Sociales")){
            ivFotoEditar1.setImage(new Image("/imagenes/redes.png"));
            lblAnterior.setText("Anteriores Redes Sociales");
            
            HBox hbInstagram1 = new HBox(5);
            hbInstagram1.setAlignment(Pos.CENTER);
            hbInstagram1.setPrefHeight(55);
            hbInstagram1.setPrefWidth(248);
            CheckBox cbInstagram1 = new CheckBox();
            cbInstagram1.setFont(fontr18);
            cbInstagram1.setPrefWidth(100);
            cbInstagram1.setPrefHeight(16);
            cbInstagram1.setText("Instagram");
            TextField tfInstagram1 = new TextField();
            tfInstagram1.setFont(fontr18);
            tfInstagram1.setPrefWidth(125);
            tfInstagram1.setPrefHeight(20);
            
            HBox hbFacebook1 = new HBox(5);
            hbFacebook1.setAlignment(Pos.CENTER);
            hbFacebook1.setPrefHeight(55);
            hbFacebook1.setPrefWidth(248);
            CheckBox cbFacebook1 = new CheckBox();
            cbFacebook1.setFont(fontr18);
            cbFacebook1.setText("Facebook");
            cbFacebook1.setPrefWidth(100);
            cbFacebook1.setPrefHeight(16);
            TextField tfFacebook1 = new TextField();
            tfFacebook1.setFont(fontr18);
            tfFacebook1.setPrefWidth(125);
            tfFacebook1.setPrefHeight(20);
            
            HBox hbTwitter1 = new HBox(5);
            hbTwitter1.setAlignment(Pos.CENTER);
            hbTwitter1.setPrefHeight(55);
            hbTwitter1.setPrefWidth(248);
            CheckBox cbTwitter1 = new CheckBox();
            cbTwitter1.setFont(fontr18);
            cbTwitter1.setText("Twitter");
            cbTwitter1.setPrefWidth(100);
            cbTwitter1.setPrefHeight(16);
            TextField tfTwitter1 = new TextField();
            tfTwitter1.setFont(fontr18);
            tfTwitter1.setPrefWidth(125);
            tfTwitter1.setPrefHeight(20);
            
            HBox hbTikTok1 = new HBox(5);
            hbTikTok1.setAlignment(Pos.CENTER);
            hbTikTok1.setPrefHeight(55);
            hbTikTok1.setPrefWidth(248);
            CheckBox cbTikTok1 = new CheckBox();
            cbTikTok1.setFont(fontr18);
            cbTikTok1.setPrefWidth(100);
            cbTikTok1.setPrefHeight(16);
            cbTikTok1.setText("TikTok");
            TextField tfTikTok1 = new TextField();
            tfTikTok1.setFont(fontr18);
            tfTikTok1.setPrefWidth(125);
            tfTikTok1.setPrefHeight(20);
            
            HBox hbPinterest1 = new HBox(5);
            hbPinterest1.setAlignment(Pos.CENTER);
            hbPinterest1.setPrefHeight(55);
            hbPinterest1.setPrefWidth(248);
            CheckBox cbPinterest1 = new CheckBox();
            cbPinterest1.setFont(fontr18);
            cbPinterest1.setPrefWidth(100);
            cbPinterest1.setPrefHeight(16);
            cbPinterest1.setText("Pinterest");
            TextField tfPinterest1 = new TextField();
            tfPinterest1.setFont(fontr18);
            tfPinterest1.setPrefWidth(125);
            tfPinterest1.setPrefHeight(20);
            
            HBox hbYouTube1 = new HBox(5);
            hbYouTube1.setAlignment(Pos.CENTER);
            hbYouTube1.setPrefHeight(55);
            hbYouTube1.setPrefWidth(248);
            CheckBox cbYouTube1 = new CheckBox();
            cbYouTube1.setFont(fontr18);
            cbYouTube1.setPrefWidth(100);
            cbYouTube1.setPrefHeight(16);
            cbYouTube1.setText("YouTube");
            TextField tfYouTube1 = new TextField();
            tfYouTube1.setFont(fontr18);
            tfYouTube1.setPrefWidth(125);
            tfYouTube1.setPrefHeight(20);
            
            HBox hbLinkedIn1 = new HBox(5);
            hbLinkedIn1.setAlignment(Pos.CENTER);
            hbLinkedIn1.setPrefHeight(55);
            hbLinkedIn1.setPrefWidth(248);
            CheckBox cbLinkedIn1 = new CheckBox();
            cbLinkedIn1.setFont(fontr18);
            cbLinkedIn1.setPrefWidth(100);
            cbLinkedIn1.setPrefHeight(16);
            cbLinkedIn1.setText("LinkedIn");
            TextField tfLinkedIn1 = new TextField();
            tfLinkedIn1.setFont(fontr18);
            tfLinkedIn1.setPrefWidth(125);
            tfLinkedIn1.setPrefHeight(20);
            
            for(RedSocial red: auspiciante.getRedesSociales()){
                if(red.getR().equals(R.INSTAGRAM)){
                    cbInstagram1.setSelected(true);
                    tfInstagram1.setText(red.getCuenta());
                    cbInstagram1.setDisable(true);
                    tfInstagram1.setDisable(true);
                    hbInstagram1.getChildren().addAll(cbInstagram1,tfInstagram1);
                    vbAnteriorInfo.getChildren().add(hbInstagram1);
                }
                if(red.getR().equals(R.FACEBOOK)){
                    cbFacebook1.setSelected(true);
                    tfFacebook1.setText(red.getCuenta());
                    cbFacebook1.setDisable(true);
                    tfFacebook1.setDisable(true);
                    hbFacebook1.getChildren().addAll(cbFacebook1,tfFacebook1);
                    vbAnteriorInfo.getChildren().add(hbFacebook1);
                }
                if(red.getR().equals(R.TWITTER)){
                    cbTwitter1.setSelected(true);
                    tfTwitter1.setText(red.getCuenta());
                    cbTwitter1.setDisable(true);
                    tfTwitter1.setDisable(true);
                    hbTwitter1.getChildren().addAll(cbTwitter1,tfTwitter1);
                    vbAnteriorInfo.getChildren().add(hbTwitter1);
                }
                if(red.getR().equals(R.TIKTOK)){
                    cbTikTok1.setSelected(true);
                    tfTikTok1.setText(red.getCuenta());
                    cbTikTok1.setDisable(true);
                    tfTikTok1.setDisable(true);
                    hbTikTok1.getChildren().addAll(cbTikTok1,tfTikTok1);
                    vbAnteriorInfo.getChildren().add(hbTikTok1);
                }
                if(red.getR().equals(R.PINTEREST)){
                    cbPinterest1.setSelected(true);
                    tfPinterest1.setText(red.getCuenta());
                    cbPinterest1.setDisable(true);
                    tfPinterest1.setDisable(true);
                    hbPinterest1.getChildren().addAll(cbPinterest1,tfPinterest1);
                    vbAnteriorInfo.getChildren().add(hbPinterest1);
                }
                if(red.getR().equals(R.YOUTUBE)){
                    cbYouTube1.setSelected(true);
                    tfYouTube1.setText(red.getCuenta());
                    cbYouTube1.setDisable(true);
                    tfYouTube1.setDisable(true);
                    hbYouTube1.getChildren().addAll(cbYouTube1,tfYouTube1);
                    vbAnteriorInfo.getChildren().add(hbYouTube1);
                }
                if(red.getR().equals(R.LINKEDIN)){
                    cbLinkedIn1.setSelected(true);
                    tfLinkedIn1.setText(red.getCuenta());
                    cbLinkedIn1.setDisable(true);
                    tfLinkedIn1.setDisable(true);
                    hbLinkedIn1.getChildren().addAll(cbLinkedIn1,tfLinkedIn1);
                    vbAnteriorInfo.getChildren().add(hbLinkedIn1);
                }
            }
            
            lblNuevo.setText("Nuevas Redes Sociales");
            HBox hbInstagram = new HBox(5);
            hbInstagram.setAlignment(Pos.CENTER);
            hbInstagram.setPrefHeight(55);
            hbInstagram.setPrefWidth(248);
            CheckBox cbInstagram = new CheckBox();
            cbInstagram.setFont(fontr18);
            cbInstagram.setPrefWidth(100);
            cbInstagram.setPrefHeight(16);
            cbInstagram.setText("Instagram");
            TextField tfInstagram = new TextField();
            tfInstagram.setFont(fontr18);
            tfInstagram.setPrefWidth(125);
            tfInstagram.setPrefHeight(20);
            tfInstagram.setDisable(true);
            
            HBox hbFacebook = new HBox(5);
            hbFacebook.setAlignment(Pos.CENTER);
            hbFacebook.setPrefHeight(55);
            hbFacebook.setPrefWidth(248);
            CheckBox cbFacebook= new CheckBox();
            cbFacebook.setFont(fontr18);
            cbFacebook.setText("Facebook");
            cbFacebook.setPrefWidth(100);
            cbFacebook.setPrefHeight(16);
            TextField tfFacebook = new TextField();
            tfFacebook.setFont(fontr18);
            tfFacebook.setPrefWidth(125);
            tfFacebook.setPrefHeight(20);
            tfFacebook.setDisable(true);
            
            HBox hbTwitter = new HBox(5);
            hbTwitter.setAlignment(Pos.CENTER);
            hbTwitter.setPrefHeight(55);
            hbTwitter.setPrefWidth(248);
            CheckBox cbTwitter = new CheckBox();
            cbTwitter.setFont(fontr18);
            cbTwitter.setText("Twitter");
            cbTwitter.setPrefWidth(100);
            cbTwitter.setPrefHeight(16);
            TextField tfTwitter = new TextField();
            tfTwitter.setFont(fontr18);
            tfTwitter.setPrefWidth(125);
            tfTwitter.setPrefHeight(20);
            tfTwitter.setDisable(true);
            
            HBox hbTikTok = new HBox(5);
            hbTikTok.setAlignment(Pos.CENTER);
            hbTikTok.setPrefHeight(55);
            hbTikTok.setPrefWidth(248);
            CheckBox cbTikTok = new CheckBox();
            cbTikTok.setFont(fontr18);
            cbTikTok.setPrefWidth(100);
            cbTikTok.setPrefHeight(16);
            cbTikTok.setText("TikTok");
            TextField tfTikTok = new TextField();
            tfTikTok.setFont(fontr18);
            tfTikTok.setPrefWidth(125);
            tfTikTok.setPrefHeight(20);
            tfTikTok.setDisable(true);
            
            HBox hbPinterest = new HBox(5);
            hbPinterest.setAlignment(Pos.CENTER);
            hbPinterest.setPrefHeight(55);
            hbPinterest.setPrefWidth(248);
            CheckBox cbPinterest = new CheckBox();
            cbPinterest.setFont(fontr18);
            cbPinterest.setPrefWidth(100);
            cbPinterest.setPrefHeight(16);
            cbPinterest.setText("Pinterest");
            TextField tfPinterest = new TextField();
            tfPinterest.setFont(fontr18);
            tfPinterest.setPrefWidth(125);
            tfPinterest.setPrefHeight(20);
            tfPinterest.setDisable(true);
            
            HBox hbYouTube = new HBox(5);
            hbYouTube.setAlignment(Pos.CENTER);
            hbYouTube.setPrefHeight(55);
            hbYouTube.setPrefWidth(248);
            CheckBox cbYouTube = new CheckBox();
            cbYouTube.setFont(fontr18);
            cbYouTube.setPrefWidth(100);
            cbYouTube.setPrefHeight(16);
            cbYouTube.setText("YouTube");
            TextField tfYouTube = new TextField();
            tfYouTube.setFont(fontr18);
            tfYouTube.setPrefWidth(125);
            tfYouTube.setPrefHeight(20);
            tfYouTube.setDisable(true);
            
            HBox hbLinkedIn = new HBox(5);
            hbLinkedIn.setAlignment(Pos.CENTER);
            hbLinkedIn.setPrefHeight(55);
            hbLinkedIn.setPrefWidth(248);
            CheckBox cbLinkedIn = new CheckBox();
            cbLinkedIn.setFont(fontr18);
            cbLinkedIn.setPrefWidth(100);
            cbLinkedIn.setPrefHeight(16);
            cbLinkedIn.setText("LinkedIn");
            TextField tfLinkedIn = new TextField();
            tfLinkedIn.setFont(fontr18);
            tfLinkedIn.setPrefWidth(125);
            tfLinkedIn.setPrefHeight(20);
            tfLinkedIn.setDisable(true);
            
            for(RedSocial red: auspiciante.getRedesSociales()){
                if(red.getR().equals(R.INSTAGRAM)){
                    cbInstagram.setSelected(true);
                    tfInstagram.setDisable(false);
                    tfInstagram.setText(red.getCuenta());
                }
                if(red.getR().equals(R.FACEBOOK)){
                    cbFacebook.setSelected(true);
                    tfFacebook.setDisable(false);
                    tfFacebook.setText(red.getCuenta());
                }
                if(red.getR().equals(R.TWITTER)){
                    cbTwitter.setSelected(true);
                    tfTwitter.setDisable(false);
                    tfTwitter.setText(red.getCuenta());
                }
                if(red.getR().equals(R.TIKTOK)){
                    cbTikTok.setSelected(true);
                    tfTikTok.setDisable(false);
                    tfTikTok.setText(red.getCuenta());
                }
                if(red.getR().equals(R.PINTEREST)){
                    cbPinterest.setSelected(true);
                    tfPinterest.setDisable(false);
                    tfPinterest.setText(red.getCuenta());
                }
                if(red.getR().equals(R.YOUTUBE)){
                    cbYouTube.setSelected(true);
                    tfYouTube.setDisable(false);
                    tfYouTube.setText(red.getCuenta());
                }
                if(red.getR().equals(R.LINKEDIN)){
                    cbLinkedIn.setSelected(true);
                    tfLinkedIn.setDisable(false);
                    tfLinkedIn.setText(red.getCuenta());
                }
            }
            
            
            
            cbInstagram.setOnAction(e -> {
                if(cbInstagram.isSelected()){
                    tfInstagram.setDisable(false);
                } else{
                    tfInstagram.clear();
                    tfInstagram.setDisable(true);
                }
            });
            
            cbFacebook.setOnAction(e -> {
                if(cbFacebook.isSelected()){
                    tfFacebook.setDisable(false);
                } else{
                    tfFacebook.clear();
                    tfFacebook.setDisable(true);
                }
            });
            
            cbTwitter.setOnAction(e -> {
                if(cbTwitter.isSelected()){
                    tfTwitter.setDisable(false);
                } else{
                    tfTwitter.clear();
                    tfTwitter.setDisable(true);
                }
            });
            
            cbTikTok.setOnAction(e -> {
                if(cbTikTok.isSelected()){
                    tfTikTok.setDisable(false);
                } else{
                    tfTikTok.clear();
                    tfTikTok.setDisable(true);
                }
            });
            
            cbPinterest.setOnAction(e -> {
                if(cbPinterest.isSelected()){
                    tfPinterest.setDisable(false);
                } else{
                    tfPinterest.clear();
                    tfPinterest.setDisable(true);
                }
            });
            
            cbYouTube.setOnAction(e -> {
                if(cbYouTube.isSelected()){
                    tfYouTube.setDisable(false);
                } else{
                    tfYouTube.clear();
                    tfYouTube.setDisable(true);
                }
            });
            
            cbLinkedIn.setOnAction(e -> {
                if(cbLinkedIn.isSelected()){
                    tfLinkedIn.setDisable(false);
                } else{
                    tfLinkedIn.clear();
                    tfLinkedIn.setDisable(true);
                }
            });
            hbInstagram.getChildren().addAll(cbInstagram,tfInstagram);
            hbFacebook.getChildren().addAll(cbFacebook,tfFacebook);
            hbTwitter.getChildren().addAll(cbTwitter,tfTwitter);
            hbTikTok.getChildren().addAll(cbTikTok,tfTikTok);
            hbPinterest.getChildren().addAll(cbPinterest,tfPinterest);
            hbYouTube.getChildren().addAll(cbYouTube,tfYouTube);
            hbLinkedIn.getChildren().addAll(cbLinkedIn,tfLinkedIn);
            vbNuevaInfo.getChildren().addAll(hbInstagram,hbFacebook,hbTwitter,hbTikTok,hbPinterest,hbYouTube,hbLinkedIn);
            
            ivFotoEditar2.setImage(new Image("/imagenes/redes.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    ArrayList<RedSocial> redes = new ArrayList<>();
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
                    if(cbYouTube.isSelected()){
                        String cuenta = recuperarCuenta(tfYouTube);
                        RedSocial red = new RedSocial(cuenta,R.YOUTUBE);
                        redes.add(red);
                    }
                    if(cbLinkedIn.isSelected()){
                        String cuenta = recuperarCuenta(tfLinkedIn);
                        RedSocial red = new RedSocial(cuenta,R.LINKEDIN);
                        redes.add(red);
                    }
                    auspiciante.setRedesSociales(redes);
                    Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);
                    App.setRoot("opcionEditarAuspiciante");

                } catch(StringVacio sv){
                    mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                } catch (Exception a){
                    mostrarAlerta1("Error", elegido);
                }
            });
        
        }
        if(elegido.equals("Sectores Cubiertos")){
            
            ivFotoEditar1.setImage(new Image("/imagenes/s.png"));
            
            lblAnterior.setText("Anteriores Sectores Cubiertos");
            HBox hbAlimentacion1 = new HBox(5);
            hbAlimentacion1.setAlignment(Pos.CENTER);
            hbAlimentacion1.setPrefHeight(55);
            hbAlimentacion1.setPrefWidth(248);
            CheckBox cbAlimentacion1 = new CheckBox();
            cbAlimentacion1.setFont(fontr18);
            cbAlimentacion1.setPrefWidth(100);
            cbAlimentacion1.setPrefHeight(16);
            cbAlimentacion1.setText("Alimentación");
            
            HBox hbVestimenta1 = new HBox(5);
            hbVestimenta1.setAlignment(Pos.CENTER);
            hbVestimenta1.setPrefHeight(55);
            hbVestimenta1.setPrefWidth(248);
            CheckBox cbVestimenta1 = new CheckBox();
            cbVestimenta1.setFont(fontr18);
            cbVestimenta1.setPrefWidth(100);
            cbVestimenta1.setPrefHeight(16);
            cbVestimenta1.setText("Vestimenta");
            
            HBox hbSalud1 = new HBox(5);
            hbSalud1.setAlignment(Pos.CENTER);
            hbSalud1.setPrefHeight(55);
            hbSalud1.setPrefWidth(248);
            CheckBox cbSalud1 = new CheckBox();
            cbSalud1.setFont(fontr18);
            cbSalud1.setPrefWidth(100);
            cbSalud1.setPrefHeight(16);
            cbSalud1.setText("Salud");
            
            HBox hbEducacion1 = new HBox(5);
            hbEducacion1.setAlignment(Pos.CENTER);
            hbEducacion1.setPrefHeight(55);
            hbEducacion1.setPrefWidth(248);
            CheckBox cbEducacion1 = new CheckBox();
            cbEducacion1.setFont(fontr18);
            cbEducacion1.setPrefWidth(100);
            cbEducacion1.setPrefHeight(16);
            cbEducacion1.setText("Educación");
            
            for(SC sector: auspiciante.getSectores()){
                if(sector.equals(SC.ALIMENTACION)){
                    cbAlimentacion1.setSelected(true);
                    cbAlimentacion1.setDisable(true);
                    hbAlimentacion1.getChildren().addAll(cbAlimentacion1);
                    vbAnteriorInfo.getChildren().add(hbAlimentacion1);
                }
                if(sector.equals(SC.VESTIMENTA)){
                    cbVestimenta1.setSelected(true);
                    cbVestimenta1.setDisable(true);
                    hbVestimenta1.getChildren().addAll(cbVestimenta1);
                    vbAnteriorInfo.getChildren().add(hbVestimenta1);
                }
                if(sector.equals(SC.SALUD)){
                    cbSalud1.setSelected(true);
                    cbSalud1.setDisable(true);
                    hbSalud1.getChildren().addAll(cbSalud1);
                    vbAnteriorInfo.getChildren().add(hbSalud1);
                }
                if(sector.equals(SC.EDUCACION)){
                    cbEducacion1.setSelected(true);
                    cbEducacion1.setDisable(true);
                    hbEducacion1.getChildren().addAll(cbEducacion1);
                    vbAnteriorInfo.getChildren().add(hbEducacion1);
                }
            }
            
            lblNuevo.setText("Nuevos Sectores Cubiertos");
            
            HBox hbAlimentacion = new HBox(5);
            hbAlimentacion.setAlignment(Pos.CENTER);
            hbAlimentacion.setPrefHeight(55);
            hbAlimentacion.setPrefWidth(248);
            CheckBox cbAlimentacion = new CheckBox();
            cbAlimentacion.setFont(fontr18);
            cbAlimentacion.setPrefWidth(100);
            cbAlimentacion.setPrefHeight(16);
            cbAlimentacion.setText("Alimentación");
            
            HBox hbVestimenta = new HBox(5);
            hbVestimenta.setAlignment(Pos.CENTER);
            hbVestimenta.setPrefHeight(55);
            hbVestimenta.setPrefWidth(248);
            CheckBox cbVestimenta = new CheckBox();
            cbVestimenta.setFont(fontr18);
            cbVestimenta.setPrefWidth(100);
            cbVestimenta.setPrefHeight(16);
            cbVestimenta.setText("Vestimenta");
            
            HBox hbSalud = new HBox(5);
            hbSalud.setAlignment(Pos.CENTER);
            hbSalud.setPrefHeight(55);
            hbSalud.setPrefWidth(248);
            CheckBox cbSalud = new CheckBox();
            cbSalud.setFont(fontr18);
            cbSalud.setPrefWidth(100);
            cbSalud.setPrefHeight(16);
            cbSalud.setText("Salud");
            
            HBox hbEducacion = new HBox(5);
            hbEducacion.setAlignment(Pos.CENTER);
            hbEducacion.setPrefHeight(55);
            hbEducacion.setPrefWidth(248);
            CheckBox cbEducacion = new CheckBox();
            cbEducacion.setFont(fontr18);
            cbEducacion.setPrefWidth(100);
            cbEducacion.setPrefHeight(16);
            cbEducacion.setText("Educación");
            
            for(SC sector: auspiciante.getSectores()){
                if(sector.equals(SC.ALIMENTACION)){
                    cbAlimentacion.setSelected(true);
                }
                if(sector.equals(SC.VESTIMENTA)){
                    cbVestimenta.setSelected(true);
                }
                if(sector.equals(SC.SALUD)){
                    cbSalud.setSelected(true);
                }
                if(sector.equals(SC.EDUCACION)){
                    cbEducacion.setSelected(true);
                }
            }
            
            hbAlimentacion.getChildren().add(cbAlimentacion);
            hbVestimenta.getChildren().add(cbVestimenta);
            hbSalud.getChildren().add(cbSalud);
            hbEducacion.getChildren().add(cbEducacion);
            vbNuevaInfo.getChildren().addAll(hbAlimentacion,hbVestimenta,hbSalud,hbEducacion);
            
            ivFotoEditar2.setImage(new Image("/imagenes/s.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    ArrayList<SC> sectores = new ArrayList<>();
                    if(cbAlimentacion.isSelected()){
                        SC sector = SC.ALIMENTACION;
                        sectores.add(sector);
                    }
                    if(cbVestimenta.isSelected()){
                        SC sector = SC.VESTIMENTA;
                        sectores.add(sector);
                    }
                    if(cbSalud.isSelected()){
                        SC sector = SC.SALUD;
                        sectores.add(sector);
                    }
                    if(cbEducacion.isSelected()){
                        SC sector = SC.EDUCACION;
                        sectores.add(sector);
                    }
                    auspiciante.setSectores(sectores);
                    App.setRoot("opcionEditarAuspiciante");

                } catch(IOException a){
                    a.printStackTrace();
                } catch (Exception a){
                    mostrarAlerta1("Error", elegido);
                }
            });
        }
        if((elegido.equals("Redes Sociales")) || (elegido.equals("Sectores Cubiertos"))){
            vbAntes.getChildren().addAll(lblAnterior, spAnteriorInfo);
            vbNuevo.getChildren().addAll(lblNuevo,spNuevaInfo);
            hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
            definirEscena(fontb18,hbInfoEditar,btnGuardar);
        }
    } 
    
    
}
