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
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
import modelo.Auspiciante;
import modelo.Feria;

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
        cbEditarAuspiciante.getItems().addAll("Nombre","Persona responsable", "Teléfono","Email","Dirección","Sitio web","Sectores cubiertos","Redes Sociales");
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
            ivFotoEditar1.setImage(new Image("/imagenes/nombre.png"));
            lblAnterior.setText("Nombre anterior");
            lblAnteriorInfo.setText(auspiciante.getNombre());
            lblNuevo.setText("Nombre nuevo");
            tfNuevoInfo.setPromptText("Edite el nombre");
            ivFotoEditar2.setImage(new Image("/imagenes/nombre.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"nombre");
                    auspiciante.setNombre(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
           });
       } else if(elegido.equals("Nombre persona responsable")){
            ivFotoEditar1.setImage(new Image("/imagenes/lugar.png"));
            lblAnterior.setText("Persona responsable anterior");
            lblAnteriorInfo.setText(auspiciante.getNombrePersona());
            lblNuevo.setText("Persona responsable nuevo");
            tfNuevoInfo.setPromptText("Edite el nombre");
            ivFotoEditar2.setImage(new Image("/imagenes/lugar.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Nombre persona responsable");
                    auspiciante.setEmail(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
           
       } else if(elegido.equals("Teléfono")){
            ivFotoEditar1.setImage(new Image("/imagenes/horario.png"));
            lblAnterior.setText("Teléfono anterior");
            lblAnteriorInfo.setText(auspiciante.getTelefono());
            lblNuevo.setText("Teléfono nuevo");
            tfNuevoInfo.setPromptText("Edite el teléfono");
            ivFotoEditar2.setImage(new Image("/imagenes/horario.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Teléfono");
                    auspiciante.setTelefono(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Email")){
            ivFotoEditar1.setImage(new Image("/imagenes/horario.png"));
            lblAnterior.setText("Email anterior");
            lblAnteriorInfo.setText(auspiciante.getEmail());
            lblNuevo.setText("Email nuevo");
            tfNuevoInfo.setPromptText("Edite el email");
            ivFotoEditar2.setImage(new Image("/imagenes/horario.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Email");
                    auspiciante.setEmail(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Dirección ")){
            ivFotoEditar1.setImage(new Image("/imagenes/horario.png"));
            lblAnterior.setText("Dirección  anterior");
            lblAnteriorInfo.setText(auspiciante.getTelefono());
            lblNuevo.setText("Dirección nueva");
            tfNuevoInfo.setPromptText("Edite la dirección");
            ivFotoEditar2.setImage(new Image("/imagenes/horario.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Dirección");
                    auspiciante.setDireccion(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarAuspiciante");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       }
        
       if((elegido.equals("Nombre"))||(elegido.equals("Email"))||(elegido.equals("Horario"))||(elegido.equals("Stands en Sección #1"))||(elegido.equals("Stands en Sección #2"))||(elegido.equals("Stands en Sección #3"))||(elegido.equals("Stands en Sección #4"))){
        vbAntes.getChildren().addAll(lblAnterior,lblAnteriorInfo);
        vbNuevo.getChildren().addAll(lblNuevo,tfNuevoInfo);
        hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
        definirEscena(fontb18,hbInfoEditar,btnGuardar);
       }
    }
    
    
}
