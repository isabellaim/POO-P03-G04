/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.ScrollPane;
import modelo.*;
import excepciones.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.geometry.Pos;
import static javafx.print.PrintColor.COLOR;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class AdministracionStandsController implements Initializable {

    @FXML
    private BorderPane bpAdminStands;
    @FXML
    private HBox hbHeading;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private ImageView imgAntesMostrarStands;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField tfCodigoFeria;
    @FXML
    private Button btnBuscar;
    @FXML
    private HBox hbCentro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
        
        Image img2 = new Image("/imagenes/globos.png");
        imgAntesMostrarStands.setImage(img2);
    }    
    
    @FXML
    private void clickRegresar() {
        try{
            App.setRoot("menuPrincipal");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickBuscar() {
        try{
            Feria feria = recuperarFeria(tfCodigoFeria);
            hbCentro.getChildren().clear();
            HBox hb1 = new HBox(35); //OJO
            hb1.setPrefWidth(710);
            hb1.setPrefHeight(410);
            hb1.setAlignment(Pos.CENTER);
            
            VBox vb2 = new VBox(); //OJO
            vb2.setPrefWidth(450);
            vb2.setPrefHeight(410);
            vb2.setAlignment(Pos.CENTER);
            
            HBox hbInfoFeria = new HBox(10); //OJO
            hbInfoFeria.setPrefWidth(414);
            hbInfoFeria.setPrefHeight(80);
            hbInfoFeria.setAlignment(Pos.CENTER);
            Font font = Font.font("Arial Rounded MT Bold", 24);
            Font font2 = Font.font("Arial Rounded MT Bold", 18);
            Font font3 = Font.font("Arial Rounded MT", 24);
            Font font4 = Font.font("Arial Rounded MT", 18);
            Label lblFeria = new Label("Feria:");
            lblFeria.setPrefWidth(70);
            lblFeria.setPrefHeight(28);
            lblFeria.setFont(font);
            lblFeria.setAlignment(Pos.CENTER);
            Label lblNombreFeria = new Label(feria.getNombre());
            lblNombreFeria.setFont(font3);
            lblNombreFeria.setAlignment(Pos.CENTER);
            lblNombreFeria.setWrapText(true);
            hbInfoFeria.getChildren().addAll(lblFeria,lblNombreFeria);
            
            VBox vbInfoStand = new VBox();
            vbInfoStand.setPrefWidth(414);
            vbInfoStand.setPrefHeight(330);
            vbInfoStand.setAlignment(Pos.CENTER);
            ImageView ivAntesInfoStand = new ImageView(new Image("/imagenes/hotBalloon.png"));
            ivAntesInfoStand.setFitWidth(275);
            ivAntesInfoStand.setFitHeight(290);
            vbInfoStand.getChildren().add(ivAntesInfoStand);
            
            vb2.getChildren().addAll(hbInfoFeria,vbInfoStand);
            
            VBox vbSecStand1 = new VBox();
            vbSecStand1.setPrefWidth(140);
            vbSecStand1.setPrefHeight(410);
            vbSecStand1.setAlignment(Pos.CENTER);
            VBox vbSecStand2 = new VBox();
            vbSecStand2.setPrefWidth(140);
            vbSecStand2.setPrefHeight(410);
            vbSecStand2.setAlignment(Pos.CENTER);
            VBox vbSecStand3 = new VBox();
            vbSecStand3.setPrefWidth(140);
            vbSecStand3.setPrefHeight(410);
            vbSecStand3.setAlignment(Pos.CENTER);
            VBox vbSecStand4 = new VBox();
            vbSecStand4.setPrefWidth(140);
            vbSecStand4.setPrefHeight(410);
            vbSecStand4.setAlignment(Pos.CENTER);
            
            HBox hbSec1 = new HBox();
            hbSec1.setPrefWidth(140);
            hbSec1.setPrefHeight(80);
            hbSec1.setAlignment(Pos.CENTER);
            HBox hbSec2 = new HBox();
            hbSec2.setPrefWidth(140);
            hbSec2.setPrefHeight(80);
            hbSec2.setAlignment(Pos.CENTER);
            HBox hbSec3 = new HBox();
            hbSec3.setPrefWidth(140);
            hbSec3.setPrefHeight(80);
            hbSec3.setAlignment(Pos.CENTER);
            HBox hbSec4 = new HBox();
            hbSec4.setPrefWidth(140);
            hbSec4.setPrefHeight(80);
            hbSec4.setAlignment(Pos.CENTER);
            Label lblSec1 = new Label("Sección #1");
            lblSec1.setAlignment(Pos.CENTER);
            Label lblSec2 = new Label("Sección #2");
            lblSec2.setAlignment(Pos.CENTER);
            Label lblSec3 = new Label("Sección #3");
            lblSec3.setAlignment(Pos.CENTER);
            Label lblSec4 = new Label("Sección #4");
            lblSec4.setAlignment(Pos.CENTER);
            lblSec1.setFont(font);
            lblSec2.setFont(font);
            lblSec3.setFont(font);
            lblSec4.setFont(font);
            hbSec1.getChildren().add(lblSec1);
            hbSec2.getChildren().add(lblSec2);
            hbSec3.getChildren().add(lblSec3);
            hbSec4.getChildren().add(lblSec4);
            vbSecStand1.getChildren().add(hbSec1);
            vbSecStand2.getChildren().add(hbSec2);
            vbSecStand3.getChildren().add(hbSec3);
            vbSecStand4.getChildren().add(hbSec4);
            
            
            VBox vbSec1 = crearVbSec();
            VBox vbSec2 = crearVbSec();
            VBox vbSec3 = crearVbSec();
            VBox vbSec4 = crearVbSec();
            
            ArrayList<Stand> standsSec1 = feria.getSeccion1().getStandsPorSeccion();
            for(Stand stand: standsSec1){
                mostrarStands(vbSec1, stand, feria, vbInfoStand, font2, font3, font4,"Sección #1");
            }
            ArrayList<Stand> standsSec2 = feria.getSeccion2().getStandsPorSeccion();
            for(Stand stand: standsSec2){
                mostrarStands(vbSec2, stand, feria, vbInfoStand, font2, font3, font4,"Sección #2");
            }
            ArrayList<Stand> standsSec3 = feria.getSeccion3().getStandsPorSeccion();
            for(Stand stand: standsSec3){
                mostrarStands(vbSec3, stand, feria, vbInfoStand, font2, font3, font4,"Sección #3");
            }
            ArrayList<Stand> standsSec4 = feria.getSeccion4().getStandsPorSeccion();
            for(Stand stand: standsSec4){
                mostrarStands(vbSec4, stand, feria, vbInfoStand, font2, font3, font4,"Sección #4");
            }
            
            Pane pane5 = new Pane();
            pane5.setPrefWidth(198);
            pane5.setPrefHeight(0);
            vbSec1.getChildren().add(pane5);
            Pane pane6 = new Pane();
            pane6.setPrefWidth(198);
            pane6.setPrefHeight(0);
            vbSec2.getChildren().add(pane6);
            Pane pane7 = new Pane();
            pane7.setPrefWidth(198);
            pane7.setPrefHeight(0);
            vbSec3.getChildren().add(pane7);
            Pane pane8 = new Pane();
            pane8.setPrefWidth(198);
            pane8.setPrefHeight(0);
            vbSec4.getChildren().add(pane8);
            
            ScrollPane spSec1 = crearSpSec(vbSec1);
            ScrollPane spSec2 = crearSpSec(vbSec2);
            ScrollPane spSec3 = crearSpSec(vbSec3);
            ScrollPane spSec4 = crearSpSec(vbSec4);
            vbSecStand1.getChildren().add(spSec1);
            vbSecStand2.getChildren().add(spSec2);
            vbSecStand3.getChildren().add(spSec3);
            vbSecStand4.getChildren().add(spSec4);

            hb1.getChildren().addAll(vbSecStand1,vbSecStand2,vbSecStand3,vbSecStand4);
            
            hbCentro.getChildren().addAll(hb1,vb2);
            
            
            
        } catch(NoExisteFeria noExisteFeria){
            mostrarAlerta("No existe una Feria con ese código.", Alert.AlertType.ERROR);
        }
    }
    
    public void mostrarAlerta(String msg, Alert.AlertType a) {
        Alert alert = new Alert(a);

        alert.setTitle(null);
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            System.out.println("User clicked OK");
            try{
                App.setRoot("administracionStands");
            } catch(IOException e){
                e.printStackTrace();
            }
        });
        alert.showAndWait();
    }
    
    public void mostrarAlerta2(String msg,String msg2, Alert.AlertType a,Feria feria) {
        Alert alert = new Alert(a);

        alert.setTitle(null);
        alert.setHeaderText(msg2);
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            System.out.println("User clicked OK");
                tfCodigoFeria.setText(feria.getCodigo());
                clickBuscar();
        });
        alert.showAndWait();
    }
    
    public void mostrarAlerta3(String msg,String msg2, Alert.AlertType a,Feria feria, HBox hbLock, VBox vbInfoStand, Stand stand, Font font2, Font font3, Font font4, TextField tfCedula) {
        Alert alert = new Alert(a);

        alert.setTitle(null);
        alert.setHeaderText(msg2);
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            System.out.println("User clicked OK");
            tfCedula.setText("");
            hacerClickLock(hbLock, vbInfoStand, stand, font2, font3, font4);
        });
        alert.showAndWait();
    }
    
    private Feria recuperarFeria(TextField tfCodigoFeria) throws NoExisteFeria {
        boolean noExisteFeria = true;
        Feria feriaEncontrada = null;
        for(Feria feria: AdministracionFeriasController.ferias){
            String cod = feria.getCodigo();
            if (cod.equals(tfCodigoFeria.getText().toUpperCase())){
                feriaEncontrada = feria;
                noExisteFeria = false;
            }
        }
        if(noExisteFeria){
            throw new NoExisteFeria();
        }
        return feriaEncontrada;
    }
    
    private Persona recuperarCedula(String cedula, Feria feria) throws NoExistePersona {
        Persona p = null;
        boolean noExiste = true;
        
        for(AuspicianteEnFeria aus: feria.getAuspiciantes()){
            if (aus.getAus().getCedula().equals(cedula)){
                noExiste= false;
                p=aus.getAus();
            }
        }
        for(Emprendedor emp: AdministracionEmprendedoresController.emprendedores){
            if (emp.getCedula().equals(cedula)){
                noExiste = false;
                p=emp;
            }
        }
        if(noExiste){
            throw new NoExistePersona("No existe un Emprendedor o Auspiciante con cédula " + cedula + " elegible para esta Feria.");
        }
        return p;
    }
    
    private VBox crearVbSec(){
        VBox vbSec = new VBox(27.75);
        vbSec.setPrefWidth(136);
        vbSec.setPrefHeight(330);
        vbSec.setAlignment(Pos.TOP_CENTER);
        Pane pane = new Pane();
        pane.setPrefWidth(140);
        pane.setPrefHeight(0);
        vbSec.getChildren().add(pane);
        vbSec.setStyle("-fx-background-color: #ffffff;");
        return vbSec;
    }
    
    private ScrollPane crearSpSec(VBox vbSec){
        ScrollPane spSec = new ScrollPane(vbSec);
        spSec.setPrefWidth(140);
        spSec.setPrefHeight(330);
        spSec.setStyle("-fx-background-color: white;");
        spSec.setStyle("-fx-border-color: lavender;");
        spSec.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spSec.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        return spSec;
    }
    private void mostrarStands(VBox vbSec, Stand stand, Feria feria, VBox vbInfoStand, Font font2, Font font3, Font font4,String seccion){
        ImageView ivStand = new ImageView(new Image("/imagenes/stand.png"));
        ivStand.setFitWidth(70);
        ivStand.setFitHeight(72);
        HBox hbLock = new HBox();
        hbLock.setPrefWidth(70);
        hbLock.setPrefHeight(72);
        hbLock.setMaxHeight(72);
        hbLock.setMinHeight(72);
        hbLock.setAlignment(Pos.CENTER);
        ImageView ivLock = new ImageView(new Image("/imagenes/lockOficial.png"));
        ivLock.setFitWidth(50);
        ivLock.setFitHeight(55);
        hbLock.getChildren().add(ivLock);
        if (stand.getReservado()){
            vbSec.getChildren().add(hbLock);
            hbLock.setOnMouseClicked(e->{
                verInformacionStand(vbInfoStand,stand,font2,font3, font4);
            });
        } else{
            vbSec.getChildren().add(ivStand);
            ivStand.setOnMouseClicked(e->{
                reservarStand(hbLock,feria,vbInfoStand,stand,font2,font3, font4,seccion);
            });
        }
    }
    
    private void hacerClickLock(HBox hbLock, VBox vbInfoStand, Stand stand, Font font2, Font font3, Font font4){
        hbLock.setOnMouseClicked(e->{
                verInformacionStand(vbInfoStand,stand,font2,font3, font4);
            });
    }
    
    private void validarCuantosStands(Persona persona, Feria feria) throws MaximoStands,AuspicianteNoIncluyeStand{
        if (persona instanceof Emprendedor){
            Emprendedor empPer = (Emprendedor) persona;
            ArrayList<EmprendedorEnFeria> emps = feria.getEmprendedores();
            for(EmprendedorEnFeria empFeria: emps){
                if(empFeria.getEmprendedor().equals(empPer)){
                    throw new MaximoStands ("El Emprendedor con cédula " + persona.getCedula() + " no puede reservar más de un stand en la feria " + feria.getNombre() + ".");
                }
            }
        } else if(persona instanceof Auspiciante){
            Auspiciante ausPer = (Auspiciante) persona;
            ArrayList<AuspicianteEnFeria> auss = feria.getAuspiciantes();
            for(AuspicianteEnFeria ausFeria: auss){
                if(ausFeria.getAus().equals(ausPer)){
                    if(ausFeria.getIncluyeStand()){
                        if (ausFeria.getStandsAsignados().size()>=2){
                            throw new MaximoStands ("El Auspiciante con cédula " + persona.getCedula() + " no puede reservar más de dos stands en la feria " + feria.getNombre() + ".");
                        }
                    } else{
                        throw new AuspicianteNoIncluyeStand("El Auspiciante con cédula " + persona.getCedula() + " no incluye stands en la feria " + feria.getNombre() + ".");
                    }
                }
            }
        }
    }
    
    private void reservarStand(HBox hbLock,Feria feria,VBox vbInfoStand,Stand stand,Font font2, Font font3, Font font4, String seccion){
        vbInfoStand.getChildren().clear();
                        
        HBox hbEmpreAus = new HBox(30);
        hbEmpreAus.setPrefWidth(450);
        hbEmpreAus.setPrefHeight(130);
        hbEmpreAus.setAlignment(Pos.CENTER);

        VBox vbEmpre = new VBox(20);
        vbEmpre.setPrefWidth(220);
        vbEmpre.setPrefHeight(130);
        vbEmpre.setAlignment(Pos.CENTER);
        Label lblEmpre = new Label("Emprendedores");
        lblEmpre.setFont(font2);
        lblEmpre.setAlignment(Pos.CENTER);
        VBox vbListaEmpre = new VBox(18);
        vbListaEmpre.setPrefWidth(181);
        vbListaEmpre.setPrefHeight(120);
        vbListaEmpre.setAlignment(Pos.TOP_CENTER);
        vbListaEmpre.setStyle("-fx-background-color: white;");
        Pane paneE1 = new Pane();   
        paneE1.setPrefWidth(181);
        paneE1.setPrefHeight(0);
        Pane paneE2 = new Pane();   
        paneE2.setPrefWidth(181);
        paneE2.setPrefHeight(0);
        vbListaEmpre.getChildren().add(paneE1);
        for(Emprendedor emp: AdministracionEmprendedoresController.emprendedores){
            HBox hbEmprendedor = new HBox(10);
            hbEmprendedor.setPrefWidth(185);
            hbEmprendedor.setPrefHeight(30);
            VBox vbElements = new VBox(2);
            vbElements.setAlignment(Pos.CENTER);
            ImageView ivIconoEmpre = new ImageView(new Image("/imagenes/persona.png"));
            ivIconoEmpre.setFitHeight(30);
            ivIconoEmpre.setFitWidth(30);
            hbEmprendedor.setAlignment(Pos.CENTER);
            Label lblNombreEmpre = new Label(emp.getNombre() + "\n" + emp.getCedula());
            lblNombreEmpre.setFont(Font.font("Arial Rounded MT Bold", 12));
            lblNombreEmpre.setTextAlignment(TextAlignment.CENTER);
            lblNombreEmpre.setAlignment(Pos.CENTER);
            Label lblCedula = new Label(emp.getCedula());
            lblCedula.setFont(Font.font("Arial Rounded MT", 12));
            lblCedula.setWrapText(true);
            lblCedula.setTextAlignment(TextAlignment.CENTER);
            lblCedula.setAlignment(Pos.CENTER);
            vbElements.getChildren().addAll(lblNombreEmpre,lblCedula);
            hbEmprendedor.getChildren().addAll(ivIconoEmpre,vbElements);
            vbListaEmpre.getChildren().add(hbEmprendedor);
        }
        vbListaEmpre.getChildren().add(paneE2);
        ScrollPane spListaEmpre = new ScrollPane(vbListaEmpre);
        spListaEmpre.setPrefWidth(185);
        spListaEmpre.setMaxWidth(185);
        spListaEmpre.setPrefHeight(130);
        spListaEmpre.setStyle("-fx-background-color: white;");
        spListaEmpre.setStyle("-fx-border-color: lavender;");
        spListaEmpre.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spListaEmpre.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        vbEmpre.getChildren().addAll(lblEmpre,spListaEmpre);

        VBox vbAus = new VBox(20);
        vbAus.setPrefWidth(185);
        vbAus.setPrefHeight(130);
        vbAus.setAlignment(Pos.CENTER);
        Label lblAus = new Label("Auspiciantes");
        lblAus.setFont(font2);
        lblAus.setAlignment(Pos.CENTER);
        VBox vbListaAus = new VBox(18);
        vbListaAus.setPrefWidth(181);
        vbListaAus.setPrefHeight(110);
        vbListaAus.setAlignment(Pos.TOP_CENTER);
        vbListaAus.setStyle("-fx-background-color: white;");
        Pane paneA1 = new Pane();   
        paneA1.setPrefWidth(181);
        paneA1.setPrefHeight(0);
        Pane paneA2 = new Pane();   
        paneA2.setPrefWidth(181);
        paneA2.setPrefHeight(0);
        vbListaAus.getChildren().add(paneA1);
        ArrayList<AuspicianteEnFeria> auspicianteEnFeria = feria.getAuspiciantes();
        for(AuspicianteEnFeria aus: auspicianteEnFeria){
            HBox hbAus = new HBox(10);
            hbAus.setPrefWidth(185);
            hbAus.setPrefHeight(30);
            ImageView ivIconoAus = new ImageView(new Image("/imagenes/iconoAus.png"));
            ivIconoAus.setFitHeight(30);
            ivIconoAus.setFitWidth(30);
            VBox vbElements = new VBox(2);
            vbElements.setAlignment(Pos.CENTER);
            hbAus.setAlignment(Pos.CENTER);
            Label lblNombreAus = new Label(aus.getAus().getNombre());
            lblNombreAus.setFont(Font.font("Arial Rounded MT Bold", 12));
            lblNombreAus.setWrapText(true);
            lblNombreAus.setTextAlignment(TextAlignment.CENTER);
            lblNombreAus.setAlignment(Pos.CENTER);
            Label lblCedula = new Label(aus.getAus().getCedula());
            lblCedula.setFont(Font.font("Arial Rounded MT", 12));
            lblCedula.setTextAlignment(TextAlignment.CENTER);
            lblCedula.setAlignment(Pos.CENTER);
            vbElements.getChildren().addAll(lblNombreAus,lblCedula);
            hbAus.getChildren().addAll(ivIconoAus,vbElements);
            vbListaAus.getChildren().add(hbAus);
        }
        vbListaAus.getChildren().add(paneA2);
        ScrollPane spListaAus = new ScrollPane(vbListaAus);
        spListaAus.setPrefWidth(185);
        spListaAus.setPrefHeight(130);
        spListaAus.setStyle("-fx-background-color: white;");
        spListaAus.setStyle("-fx-border-color: lavender;");
        spListaAus.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spListaAus.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        vbAus.getChildren().addAll(lblAus,spListaAus);

        hbEmpreAus.getChildren().addAll(vbEmpre,vbAus);

        HBox hbCodCed = new HBox(30);
        hbCodCed.setAlignment(Pos.CENTER);
        hbCodCed.setPrefWidth(510);
        hbCodCed.setPrefHeight(200);

        VBox vbCodigoStand = new VBox(15);
        vbCodigoStand.setAlignment(Pos.CENTER);
        vbCodigoStand.setPrefWidth(250);
        vbCodigoStand.setPrefHeight(195);
        ImageView ivCodigoStand = new ImageView(new Image("/imagenes/codigo.png"));
        ivCodigoStand.setFitWidth(50);
        ivCodigoStand.setFitHeight(50);
        Label lblCodigoStand = new Label("Código de Stand");
        lblCodigoStand.setFont(font2);
        lblCodigoStand.setAlignment(Pos.CENTER);
        lblCodigoStand.setTextAlignment(TextAlignment.CENTER);
        Label lblCodigo = new Label(stand.getCodigoStand());
        lblCodigo.setFont(Font.font("Arial Rounded MT", 18));
        lblCodigo.setAlignment(Pos.CENTER);
        lblCodigo.setWrapText(true);
        vbCodigoStand.getChildren().addAll(ivCodigoStand,lblCodigoStand,lblCodigo);

        VBox vbCedula = new VBox(18);
        vbCedula.setAlignment(Pos.CENTER);
        vbCedula.setPrefWidth(250);
        vbCedula.setPrefHeight(195);
        ImageView ivCedula = new ImageView(new Image("/imagenes/cedula.png"));
        ivCedula.setFitWidth(50);
        ivCedula.setFitHeight(50);
        Label lblCedula = new Label("Cédula del Dueño");
        lblCedula.setFont(font2);
        lblCedula.setAlignment(Pos.CENTER);
        TextField tfCedula = new TextField();
        tfCedula.setPromptText("Cédula");
        tfCedula.setFont(Font.font("Arial Rounded MT", 14));
        tfCedula.setPrefWidth(173);
        tfCedula.setMaxWidth(173);
        tfCedula.setPrefHeight(12);
        vbCedula.getChildren().addAll(ivCedula,lblCedula,tfCedula);

        hbCodCed.getChildren().addAll(vbCodigoStand,vbCedula);

        HBox hbReservar = new HBox();
        hbReservar.setAlignment(Pos.CENTER);
        Button btnReservar = new Button("Reservar");
        btnReservar.setPrefWidth(420);
        btnReservar.setPrefHeight(56);
        btnReservar.setFont(font2);
        BackgroundFill backgroundFill = new BackgroundFill(Color.INDIGO, new CornerRadii(5), javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
        btnReservar.setBackground(background);
        btnReservar.setStyle(  "-fx-text-fill: white;");
        btnReservar.setOnMouseClicked(a -> {
            String cedula = tfCedula.getText();
            try{
                Persona persona = recuperarCedula(cedula,feria);
                validarCuantosStands(persona,feria);
                stand.setDueno(persona);
                stand.setReservado(true);
                stand.setFechaAsig(LocalDate.now());
                if (persona instanceof Emprendedor){
                    Emprendedor empPer = (Emprendedor) persona;
                    EmprendedorEnFeria empFeria = new EmprendedorEnFeria(empPer,stand,seccion);
                    ArrayList<EmprendedorEnFeria> empsFeria = feria.getEmprendedores();
                    empsFeria.add(empFeria);
                    feria.setEmprendedores(empsFeria);
                    mostrarAlerta2("El emprendedimiento " + empPer.getNombre() + " ha reservado el stand de código " + stand.getCodigoStand() + "." ,"Confirmación", Alert.AlertType.INFORMATION,feria);
                } else if(persona instanceof Auspiciante){
                    Auspiciante ausPer = (Auspiciante) persona;
                    ArrayList<AuspicianteEnFeria> aussFeria = feria.getAuspiciantes();
                    for(AuspicianteEnFeria ausFeria: aussFeria){
                        if(ausFeria.getAus().equals(ausPer)){
                            if(ausFeria.getIncluyeStand()){
                                ausFeria.getStandsAsignados().add(stand);
                            }
                        }
                    }
                    mostrarAlerta2("El auspiciante " + ausPer.getNombre() + " ha reservado el stand de código " + stand.getCodigoStand() + "." , "Confirmación", Alert.AlertType.INFORMATION,feria);
                }
            } catch(NoExistePersona n){
                mostrarAlerta3(n.getMessage(),"Error", Alert.AlertType.ERROR,feria,hbLock, vbInfoStand, stand, font2, font3, font4, tfCedula);
            } catch(AuspicianteNoIncluyeStand ausNo){
                mostrarAlerta3(ausNo.getMessage(),"Error", Alert.AlertType.ERROR,feria,hbLock, vbInfoStand, stand, font2, font3, font4, tfCedula);
            } catch(MaximoStands ms){
                mostrarAlerta3(ms.getMessage(),"Error", Alert.AlertType.ERROR,feria,hbLock, vbInfoStand, stand, font2, font3, font4, tfCedula);
            } 
        });
        hbReservar.getChildren().add(btnReservar);


        vbInfoStand.getChildren().addAll(hbEmpreAus,hbCodCed,hbReservar);
    }
    
    private void verInformacionStand(VBox vbInfoStand,Stand stand,Font font2, Font font3, Font font4){
        vbInfoStand.getChildren().clear();

        HBox hbCodFecha = new HBox(10);
        hbCodFecha.setAlignment(Pos.CENTER);
        hbCodFecha.setPrefWidth(450);
        hbCodFecha.setPrefHeight(255);

        VBox vbCodigoStand = new VBox(10);
        vbCodigoStand.setAlignment(Pos.CENTER);
        vbCodigoStand.setPrefWidth(250);
        vbCodigoStand.setPrefHeight(255);
        ImageView ivCodigoStand = new ImageView(new Image("/imagenes/codigo.png"));
        ivCodigoStand.setFitWidth(60);
        ivCodigoStand.setFitHeight(60);
        Label lblCodigoStand = new Label("Código de Stand");
        lblCodigoStand.setFont(font2);
        lblCodigoStand.setAlignment(Pos.CENTER);
        lblCodigoStand.setPrefWidth(200);
        lblCodigoStand.setPrefHeight(31);
        lblCodigoStand.setTextAlignment(TextAlignment.CENTER);
        Label lblCodigo = new Label(stand.getCodigoStand());
        lblCodigo.setFont(Font.font("Arial Rounded MT", 18));
        lblCodigo.setAlignment(Pos.CENTER);
        lblCodigo.setWrapText(true);
        vbCodigoStand.getChildren().addAll(ivCodigoStand,lblCodigoStand,lblCodigo);

        VBox vbFechaAsig = new VBox(10);
        vbFechaAsig.setAlignment(Pos.CENTER);
        vbFechaAsig.setPrefWidth(250);
        vbFechaAsig.setPrefHeight(255);
        ImageView ivFechaAsig = new ImageView(new Image("/imagenes/fechaAsig.png"));
        ivFechaAsig.setFitWidth(60);
        ivFechaAsig.setFitHeight(60);
        Label lblFechaAsig = new Label("Fecha de Asignación");
        lblFechaAsig.setFont(font2);
        lblFechaAsig.setAlignment(Pos.CENTER);
        lblFechaAsig.setPrefWidth(230);
        lblFechaAsig.setPrefHeight(31);
        Label lblFecha = new Label(stand.getFechaAsig().toString());
        lblFecha.setFont(Font.font("Arial Rounded MT", 18));
        lblFecha.setAlignment(Pos.CENTER);
        lblFecha.setWrapText(true);
        lblFecha.setTextAlignment(TextAlignment.CENTER);
        vbFechaAsig.getChildren().addAll(ivFechaAsig,lblFechaAsig,lblFecha);

        hbCodFecha.getChildren().addAll(vbCodigoStand,vbFechaAsig);

        HBox hbDueno = new HBox(10);
        hbDueno.setAlignment(Pos.CENTER);
        hbDueno.setPrefWidth(450);
        hbDueno.setPrefHeight(255);

        VBox vbDueno = new VBox(10);
        vbDueno.setAlignment(Pos.CENTER);
        vbDueno.setPrefWidth(250);
        vbDueno.setPrefHeight(255);
        Persona per = stand.getDueno();
        ImageView ivDueno = new ImageView();

        Label lblDueno = new Label("Dueño");
        lblDueno.setFont(font2);
        lblDueno.setAlignment(Pos.CENTER);
        lblDueno.setPrefWidth(74);
        lblDueno.setPrefHeight(31);
        Label lblPersona = new Label();
        lblPersona.setFont(Font.font("Arial Rounded MT", 18));
        lblPersona.setAlignment(Pos.CENTER);
        lblPersona.setWrapText(true);

        if(per instanceof Emprendedor){
            lblPersona.setText("Emprendimiento");
            ivDueno.setImage(new Image("/imagenes/empre.png"));
            ivDueno.setFitWidth(60);
            ivDueno.setFitHeight(60);
        } else if (per instanceof Auspiciante){
            lblPersona.setText("Auspiciante");
            ivDueno.setImage(new Image("/imagenes/ausPersona.png"));
            ivDueno.setFitWidth(60);
            ivDueno.setFitHeight(60);
        }

        vbDueno.getChildren().addAll(ivDueno,lblDueno,lblPersona);

        VBox vbInfoDueno = new VBox(5);
        vbInfoDueno.setPrefWidth(211);
        vbInfoDueno.setPrefHeight(146);
        vbInfoDueno.setAlignment(Pos.TOP_CENTER);
        vbInfoDueno.setStyle("-fx-background-color: white;");

        Pane paneD1 = new Pane();   
        paneD1.setPrefWidth(245);
        paneD1.setPrefHeight(0);

        HBox hbNombreDueno = new HBox(10);
        hbNombreDueno.setPrefWidth(245);
        hbNombreDueno.setPrefHeight(40);
        hbNombreDueno.setAlignment(Pos.CENTER);
        ImageView ivNombreDueno = new ImageView(new Image("/imagenes/dueno.png"));
        ivNombreDueno.setFitWidth(25);
        ivNombreDueno.setFitHeight(25);
        Label lblNombrePersona = new Label(stand.getDueno().getNombre());
        lblNombrePersona.setFont(Font.font("Arial Rounded MT", 12));
        lblNombrePersona.setAlignment(Pos.CENTER);
        lblNombrePersona.setTextAlignment(TextAlignment.CENTER);
        lblNombrePersona.setWrapText(true);
        hbNombreDueno.getChildren().addAll(ivNombreDueno,lblNombrePersona);

        HBox hbTelDueno = new HBox(10);
        hbTelDueno.setPrefWidth(245);
        hbTelDueno.setPrefHeight(40);
        hbTelDueno.setAlignment(Pos.CENTER);
        ImageView ivTelDueno = new ImageView(new Image("/imagenes/telefono.png"));
        ivTelDueno.setFitWidth(25);
        ivTelDueno.setFitHeight(25);
        Label lblTelPersona = new Label(stand.getDueno().getTelefono());
        lblTelPersona.setFont(Font.font("Arial Rounded MT", 12));
        lblTelPersona.setAlignment(Pos.CENTER);
        lblTelPersona.setTextAlignment(TextAlignment.CENTER);
        lblTelPersona.setWrapText(true);
        hbTelDueno.getChildren().addAll(ivTelDueno,lblTelPersona);

        HBox hbEmailDueno = new HBox(10);
        hbEmailDueno.setPrefWidth(245);
        hbEmailDueno.setPrefHeight(40);
        hbEmailDueno.setAlignment(Pos.CENTER);
        ImageView ivEmailDueno = new ImageView(new Image("/imagenes/email.png"));
        ivEmailDueno.setFitWidth(25);
        ivEmailDueno.setFitHeight(25);
        Label lblEmailPersona = new Label(stand.getDueno().getEmail());
        lblEmailPersona.setFont(Font.font("Arial Rounded MT", 12));
        lblEmailPersona.setTextAlignment(TextAlignment.CENTER);
        lblEmailPersona.setAlignment(Pos.CENTER);
        lblEmailPersona.setTextAlignment(TextAlignment.CENTER);
        lblEmailPersona.setWrapText(true);
        hbEmailDueno.getChildren().addAll(ivEmailDueno,lblEmailPersona);

        Pane paneD2 = new Pane();   
        paneD2.setPrefWidth(245);
        paneD2.setPrefHeight(0);

        vbInfoDueno.getChildren().addAll(paneD1,hbNombreDueno,hbTelDueno,hbEmailDueno,paneD2);

        ScrollPane spInfoDueno = new ScrollPane(vbInfoDueno);
        spInfoDueno.setPrefWidth(240);
        spInfoDueno.setPrefHeight(150);
        spInfoDueno.setMaxHeight(150);
        spInfoDueno.setMinHeight(150);
        spInfoDueno.setStyle("-fx-background-color: white;");
        spInfoDueno.setStyle("-fx-border-color: lavender;");
        spInfoDueno.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spInfoDueno.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        hbDueno.getChildren().addAll(vbDueno,spInfoDueno);


        vbInfoStand.getChildren().addAll(hbCodFecha,hbDueno);
    }
}
