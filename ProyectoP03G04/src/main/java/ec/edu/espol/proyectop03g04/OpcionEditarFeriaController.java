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
import modelo.Feria;
import modelo.Utilitaria;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class OpcionEditarFeriaController implements Initializable {

    @FXML
    private BorderPane bpOpcionEditarFeria;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private VBox vbTodoEditarFeria;
    @FXML
    private Label lblFeriaEscogida;
    @FXML
    private ComboBox<String> cbEditarFeria;
    @FXML
    private VBox vbEditarFerias;
    @FXML
    private ImageView ivImagenAntesEditar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgHeader2.setImage(new Image("/imagenes/rueda-de-la-fortuna.png"));
        ivImagenAntesEditar.setImage(new Image("/imagenes/amigos.png"));
        Feria feria = AdministracionFeriasController.feriaEscogida;
        lblFeriaEscogida.setText(feria.getNombre());
        cbEditarFeria.getItems().addAll("Nombre","Descripción","Lugar","Fecha de Inicio","Fecha de Fin","Horario","Stands en Sección #1", "Stands en Sección #2","Stands en Sección #3","Stands en Sección #4");
        cbEditarFeria.setCellFactory((ListView<String> param) -> new ListCell<String>() {
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
        
        cbEditarFeria.setButtonCell(new ListCell<String>() {
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
            App.setRoot("administracionFerias");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickComboBox() {
        vbEditarFerias.getChildren().clear();
        Feria feria = AdministracionFeriasController.feriaEscogida;
        String elegido = cbEditarFeria.getSelectionModel().getSelectedItem();
        editarNormal(elegido,feria);
        editarFechas(elegido,feria);
        editarDescripcion(elegido,feria);
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
    
    private void validarHorario(String horario) throws StringVacio {
        horario = horario.strip().toLowerCase();
        String[] palabras = horario.split("-");
        double num1 = 0;
        double num2 = 0;
        int count = 1;
        for (String pal: palabras){
           String[] numeros = pal.split("h");
           try{
               int parte1 = Integer.parseInt(numeros[0]);
               int parte2 = Integer.parseInt(numeros[1]);
               if(parte1>23){
                   throw new StringVacio();
               }
               if(parte2>59){
                   throw new StringVacio();
               }
               if(count == 1){
                    num1 = Double.parseDouble(parte1 + "." + parte2);
               }
               if(count == 2){
                    num2 = Double.parseDouble(parte1 + "." + parte2);
               }
            } catch(NumberFormatException n){
                throw new StringVacio("Por favor ingrese el horario en el correcto formato (00h00-00h00)");
            }
           count++;
        }
        
        if(num1>num2){
            throw new StringVacio();
        }
    }
    
    private void validarCantStands(int num) throws StringVacio{
        if(num==0){
            throw new StringVacio("Por favor escoja una cantidad de Stands diferente de 0.");
        }
    }
    
    private LocalDate validateDatePicker(DatePicker datePicker) throws FechaVacia{
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate == null) {
            throw new FechaVacia();
        }
        return selectedDate;
    }
    
    private void validarSiFechaEstaDespues(LocalDate ldInicio, LocalDate ldFin) throws FechaNoPuedeSerDespues{
        if (ldInicio.isAfter(ldFin)) {
            // fechaIni esta despues de fechaFin
            throw new FechaNoPuedeSerDespues();   
        }
    }
    
    public void mostrarAlerta1(String msg, String elegido) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(null);
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            System.out.println("User clicked OK");
            cbEditarFeria.setValue(elegido);
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
            App.setRoot("administracionFerias");
            } catch(IOException i){
                i.printStackTrace();
            }
        });
        
        hbBotones.getChildren().addAll(btnGuardar,btnCancelar);
        vbEditarFerias.getChildren().addAll(hbInfoEditar,hbBotones);
    }
    
    private void editarNormal(String elegido, Feria feria){
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
            lblAnteriorInfo.setText(feria.getNombre());
            lblNuevo.setText("Nombre nuevo");
            tfNuevoInfo.setPromptText("Edite el nombre");
            ivFotoEditar2.setImage(new Image("/imagenes/nombre.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"nombre");
                    feria.setNombre(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
           });
       } else if(elegido.equals("Lugar")){
            ivFotoEditar1.setImage(new Image("/imagenes/lugar.png"));
            lblAnterior.setText("Lugar anterior");
            lblAnteriorInfo.setText(feria.getLugar());
            lblNuevo.setText("Lugar nuevo");
            tfNuevoInfo.setPromptText("Edite el lugar");
            ivFotoEditar2.setImage(new Image("/imagenes/lugar.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"lugar");
                    feria.setLugar(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
           
       } else if(elegido.equals("Horario")){
            ivFotoEditar1.setImage(new Image("/imagenes/horario.png"));
            lblAnterior.setText("Horario anterior");
            lblAnteriorInfo.setText(feria.getHorario());
            lblNuevo.setText("Horario nuevo");
            tfNuevoInfo.setPromptText("Edite el horario");
            ivFotoEditar2.setImage(new Image("/imagenes/horario.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"horario");
                    validarHorario(tfNuevoInfo.getText());
                    feria.setHorario(tfNuevoInfo.getText());
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
             });
           
       } else if(elegido.equals("Stands en Sección #1")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior cantidad de Stands en Sección #1");
            lblAnteriorInfo.setText(feria.getSeccion1().getCantStands() + "");
            lblNuevo.setText("Nueva cantidad de Stands en Sección #1");
            tfNuevoInfo.setPromptText("Edite la cantidad");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Stands en Sección #1");
                    int num = Integer.parseInt(tfNuevoInfo.getText());
                    validarCantStands(num);
                    feria.getSeccion1().setCantStands(num,feria);
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(NumberFormatException nfe){
                    mostrarAlerta1("Por favor coloque un número en la cantidad de Stands de la Sección #1.",elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
            
       } else if(elegido.equals("Stands en Sección #2")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior cantidad de Stands en Sección #2");
            lblAnteriorInfo.setText(feria.getSeccion2().getCantStands() + "");
            lblNuevo.setText("Nueva cantidad de Stands en Sección #2");
            tfNuevoInfo.setPromptText("Edite la cantidad");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Stands en Sección #2");
                    int num = Integer.parseInt(tfNuevoInfo.getText());
                    validarCantStands(num);
                    feria.getSeccion2().setCantStands(num,feria);
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(NumberFormatException nfe){
                    mostrarAlerta1("Por favor coloque un número en la cantidad de Stands de la Sección #2.",elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
       } else if(elegido.equals("Stands en Sección #3")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior cantidad de Stands en Sección #3");
            lblAnteriorInfo.setText(feria.getSeccion3().getCantStands() + "");
            lblNuevo.setText("Nueva cantidad de Stands en Sección #3");
            tfNuevoInfo.setPromptText("Edite la cantidad");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Stands en Sección #3");
                    int num = Integer.parseInt(tfNuevoInfo.getText());
                    validarCantStands(num);
                    feria.getSeccion3().setCantStands(num,feria);
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(NumberFormatException nfe){
                    mostrarAlerta1("Por favor coloque un número en la cantidad de Stands de la Sección #3.",elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
       } else if(elegido.equals("Stands en Sección #4")){
            ivFotoEditar1.setImage(new Image("/imagenes/stand.png"));
            lblAnterior.setText("Anterior cantidad de Stands en Sección #4");
            lblAnteriorInfo.setText(feria.getSeccion4().getCantStands() + "");
            lblNuevo.setText("Nueva cantidad de Stands en Sección #4");
            tfNuevoInfo.setPromptText("Edite la cantidad");
            ivFotoEditar2.setImage(new Image("/imagenes/stand.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField1(tfNuevoInfo,"Stands en Sección #4");
                    int num = Integer.parseInt(tfNuevoInfo.getText());
                    validarCantStands(num);
                    feria.getSeccion4().setCantStands(num,feria);
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(StringVacio sv){
                   mostrarAlerta1(sv.getMessage(),elegido);
                } catch(NumberFormatException nfe){
                    mostrarAlerta1("Por favor coloque un número en la cantidad de Stands de la Sección #4.",elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
       }
       if((elegido.equals("Nombre"))||(elegido.equals("Lugar"))||(elegido.equals("Horario"))||(elegido.equals("Stands en Sección #1"))||(elegido.equals("Stands en Sección #2"))||(elegido.equals("Stands en Sección #3"))||(elegido.equals("Stands en Sección #4"))){
        vbAntes.getChildren().addAll(lblAnterior,lblAnteriorInfo);
        vbNuevo.getChildren().addAll(lblNuevo,tfNuevoInfo);
        hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
        definirEscena(fontb18,hbInfoEditar,btnGuardar);
       }
    }
    
    private void editarFechas(String elegido, Feria feria){
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
        DatePicker dpNuevoInfo = new DatePicker();
        dpNuevoInfo.setPrefWidth(250);
        dpNuevoInfo.setMinWidth(250);
        dpNuevoInfo.setMaxWidth(250);
        dpNuevoInfo.setPrefHeight(40);
        
        ImageView ivFotoEditar2 = new ImageView();
        ivFotoEditar2.setFitWidth(192);
        ivFotoEditar2.setFitHeight(189);
        
        if(elegido.equals("Fecha de Inicio")){
            ivFotoEditar1.setImage(new Image("/imagenes/fechaIni.png"));
            lblAnterior.setText("Fecha de Inicio anterior");
            lblAnteriorInfo.setText(feria.getFechaIni().toString());
            lblNuevo.setText("Fecha de Inicio nueva");
            ivFotoEditar2.setImage(new Image("/imagenes/fechaIni.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    LocalDate fechaIni = validateDatePicker(dpNuevoInfo);
                    feria.setFechaIni(fechaIni);
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(FechaVacia fv){
                    mostrarAlerta1("Por favor coloque una fecha válida.",elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
        } else if(elegido.equals("Fecha de Fin")){
            ivFotoEditar1.setImage(new Image("/imagenes/fechaFin.png"));
            lblAnterior.setText("Fecha de Fin anterior");
            lblAnteriorInfo.setText(feria.getFechaFin().toString());
            lblNuevo.setText("Fecha de Fin nueva");
            ivFotoEditar2.setImage(new Image("/imagenes/fechaFin.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    LocalDate fechaFin = validateDatePicker(dpNuevoInfo);
                    validarSiFechaEstaDespues(feria.getFechaIni(),fechaFin);
                    feria.setFechaFin(fechaFin);
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
                } catch(FechaVacia fv){
                    mostrarAlerta1("Por favor coloque una fecha válida.",elegido);
                } catch(FechaNoPuedeSerDespues fv){
                    mostrarAlerta1("La fecha de fin no puede ser antes de la fecha de Inicio.",elegido);
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
        }
        if((elegido.equals("Fecha de Inicio"))||(elegido.equals("Fecha de Fin"))){
            vbAntes.getChildren().addAll(lblAnterior,lblAnteriorInfo);
            vbNuevo.getChildren().addAll(lblNuevo,dpNuevoInfo);
            hbInfoEditar.getChildren().addAll(ivFotoEditar1,vbAntes,vbNuevo,ivFotoEditar2);
            definirEscena(fontb18,hbInfoEditar,btnGuardar);
            }
    }
    
    private void editarDescripcion(String elegido, Feria feria){
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
            lblAnteriorInfo.setText(feria.getDescripcion());
            lblNuevo.setText("Descripción nueva");
            taNuevoInfo.setPromptText("Edite la descripción");
            ivFotoEditar2.setImage(new Image("/imagenes/descripcion.png"));
            btnGuardar.setOnAction(e -> {
                try{
                    validarTextField2(taNuevoInfo,"descripción");
                    feria.setDescripcion(taNuevoInfo.getText());
                    Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
                    App.setRoot("opcionEditarFeria");
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
