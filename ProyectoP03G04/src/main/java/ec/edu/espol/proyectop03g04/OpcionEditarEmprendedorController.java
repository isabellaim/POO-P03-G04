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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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
import modelo.Emprendedor;
import modelo.Feria;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class OpcionEditarEmprendedorController implements Initializable {

    @FXML
    private BorderPane bpOpcionEditarEmprendedor;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private VBox vbTodoEditarFeria;
    @FXML
    private Label lblEmprendedorEscogido;
    @FXML
    private ComboBox<String> cbEditarEmprendedor;
    @FXML
    private VBox vbEditarEmprendedores;
    @FXML
    private ImageView ivImagenAntesEditar;

    /**
     * Initializes the controller class.
     */
@Override
    public void initialize(URL url, ResourceBundle rb) {
        imgHeader2.setImage(new Image("/imagenes/rueda-de-la-fortuna.png"));
        ivImagenAntesEditar.setImage(new Image("/imagenes/amigos.png"));
        Emprendedor emprendedor = AdministracionEmprendedoresController.emprendedorEscogido;
        lblEmprendedorEscogido.setText(emprendedor.getNombre());
        cbEditarEmprendedor.getItems().addAll("Nombre","Persona responsable","Teléfono","Email","Dirección","Sitio web","Redes sociales","Descripción");
        cbEditarEmprendedor.setCellFactory((ListView<String> param) -> new ListCell<String>() {
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
        
        cbEditarEmprendedor.setButtonCell(new ListCell<String>() {
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
            App.setRoot("administracionEmprendedores");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickComboBox() {
        vbEditarEmprendedores.getChildren().clear();
        Emprendedor emprendedor = AdministracionEmprendedoresController.emprendedorEscogido;
        String elegido = cbEditarEmprendedor.getSelectionModel().getSelectedItem();
        editarNormal(elegido,emprendedor);
        editarDescripcion(elegido,emprendedor);
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
            cbEditarEmprendedor.setValue(elegido);
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
            App.setRoot("administracionEmprendedores");
            } catch(IOException i){
                i.printStackTrace();
            }
        });
        
        hbBotones.getChildren().addAll(btnGuardar,btnCancelar);
        vbEditarEmprendedores.getChildren().addAll(hbInfoEditar,hbBotones);
    }
    
    private void editarNormal(String elegido, Emprendedor emprendedor){
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
            lblAnteriorInfo.setText(emprendedor.getNombre());
            lblNuevo.setText("Nombre nuevo");
            tfNuevoInfo.setPromptText("Edite el nombre");
            ivFotoEditar2.setImage(new Image("/imagenes/nombre.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"nombre");
                    emprendedor.setNombre(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
           });
       } else if(elegido.equals("Persona responsable")){
            ivFotoEditar1.setImage(new Image("/imagenes/lugar.png"));
            lblAnterior.setText("Persona responsable anterior");
            lblAnteriorInfo.setText(emprendedor.getNombrePersona());
            lblNuevo.setText("Nueva persona responsable");
            tfNuevoInfo.setPromptText("Edite la persona responsable");
            ivFotoEditar2.setImage(new Image("/imagenes/lugar.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Persona responsable");
                    emprendedor.setNombrePersona(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
           
       } else if(elegido.equals("Teléfono")){
            ivFotoEditar1.setImage(new Image("/imagenes/horario.png"));
            lblAnterior.setText("Anterior teléfono");
            lblAnteriorInfo.setText(emprendedor.getTelefono());
            lblNuevo.setText("Nuevo teléfono");
            tfNuevoInfo.setPromptText("Edite el teléfono");
            ivFotoEditar2.setImage(new Image("/imagenes/horario.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"telefono");
                    emprendedor.setTelefono(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Email")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior Email");
            lblAnteriorInfo.setText(emprendedor.getEmail());
            lblNuevo.setText("Nuevo email");
            tfNuevoInfo.setPromptText("Edite el email");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Email");
                    emprendedor.setEmail(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
            
       } else if(elegido.equals("Dirección")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior Direccion");
            lblAnteriorInfo.setText(emprendedor.getDireccion());
            lblNuevo.setText("Nueva Direccion");
            tfNuevoInfo.setPromptText("Edite la direccion");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    emprendedor.setEmail(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
       } else if(elegido.equals("Sitio web")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior sitio web");
            lblAnteriorInfo.setText(emprendedor.getSitioWeb());
            lblNuevo.setText("Nuevo sitio web");
            tfNuevoInfo.setPromptText("Edite el sitio web");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    emprendedor.setEmail(tfNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
       }
       if((elegido.equals("Nombre"))||(elegido.equals("Persona responsable"))||(elegido.equals("Telefono"))||(elegido.equals("Email"))||(elegido.equals("Dirección"))||(elegido.equals("Sitio web"))){
        vbAntes.getChildren().addAll(lblAnterior,lblAnteriorInfo);
        vbNuevo.getChildren().addAll(lblNuevo,tfNuevoInfo);
        hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
        definirEscena(fontb18,hbInfoEditar,btnGuardar);
       }
    }
    
    private void editarDescripcion(String elegido, Emprendedor emprendedor){
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
        TextArea taNuevoInfo = new TextArea();
        taNuevoInfo.setPrefWidth(250);
        taNuevoInfo.setMinWidth(250);
        taNuevoInfo.setMaxWidth(250);
        taNuevoInfo.setPrefHeight(150);
        taNuevoInfo.setFont(fontr18);
        
        ImageView ivFotoEditar2 = new ImageView();
        ivFotoEditar2.setFitWidth(192);
        ivFotoEditar2.setFitHeight(189);
        
        if(elegido.equals("Descripción")){
            ivFotoEditar1.setImage(new Image("/imagenes/descripcion.png"));
            lblAnterior.setText("Descripción anterior");
            lblAnteriorInfo.setText(emprendedor.getDescripcion());
            lblNuevo.setText("Descripción nueva");
            taNuevoInfo.setPromptText("Edite la descripción");
            ivFotoEditar2.setImage(new Image("/imagenes/descripcion.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField2(taNuevoInfo,"descripción");
                    emprendedor.setDescripcion(taNuevoInfo.getText());
                    App.setRoot("opcionEditarEmprendedor");
                } catch(StringVacio sv){
                    mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
        
        }
        if(elegido.equals("Descripción")){
        vbAntes.getChildren().addAll(lblAnterior,lblAnteriorInfo);
        vbNuevo.getChildren().addAll(lblNuevo,taNuevoInfo);
        hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
        definirEscena(fontb18,hbInfoEditar,btnGuardar);
        }
    } 
    
}
