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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import modelo.*;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class OpcionVerDetallesFeriaController implements Initializable {

    @FXML
    private BorderPane bpOpcionVerDetallesFeria;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    
    @FXML
    private ImageView imgHeader2;
    @FXML
    private ImageView imageView1;
    @FXML
    private Label lbNombre;
    @FXML
    private ImageView imageView2;
    @FXML
    private Label lblDescripcion;
    @FXML
    private ImageView imageView3;
    @FXML
    private Label lblLugar;
    @FXML
    private ImageView imageView4;
    @FXML
    private Label lblFechaInicio;
    @FXML
    private ImageView imageView5;
    @FXML
    private Label lblFechaFin;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private Label lblHorario;
    @FXML
    private Button btnEmprendedores;
    @FXML
    private Button btnAuspiciantes;
    @FXML
    private Button btnCantidadStandsSeccion;
    @FXML
    private VBox vbListas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgHeader2.setImage(new Image("/imagenes/rueda-de-la-fortuna.png"));
        imageView1.setImage(new Image("/imagenes/nombre.png"));
        imageView2.setImage(new Image("/imagenes/descripcion.png"));
        imageView3.setImage(new Image("/imagenes/lugar.png"));
        imageView4.setImage(new Image("/imagenes/fechaIni.png"));
        imageView5.setImage(new Image("/imagenes/fechaFin.png"));
        imageView6.setImage(new Image("/imagenes/horario.png"));
        imageView7.setImage(new Image("/imagenes/globo2.png"));
        
        lbNombre.setText(AdministracionFeriasController.feriaEscogida.getNombre());
        lblDescripcion.setText(AdministracionFeriasController.feriaEscogida.getDescripcion());
        lblLugar.setText(AdministracionFeriasController.feriaEscogida.getLugar());
        lblFechaInicio.setText(AdministracionFeriasController.feriaEscogida.getFechaIni().toString());
        lblFechaFin.setText(AdministracionFeriasController.feriaEscogida.getFechaFin().toString());
        lblHorario.setText(AdministracionFeriasController.feriaEscogida.getHorario());
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
    private void clickEmprendedores(ActionEvent event) {
        vbListas.getChildren().clear();
        ImageView iv = new ImageView(new Image("/imagenes/emprendedores.png"));
        iv.setFitHeight(90);
        iv.setFitWidth(90);
        Label lblEmprendedores = new Label("Emprendededores");
        Font font = Font.font("Arial Rounded MT Bold", 20);
        Font font2 = Font.font("Arial Rounded MT Bold", 12);
        Font font3 = Font.font("Arial Rounded MT", 12);
        lblEmprendedores.setFont(font);
        
        VBox vbListaEmpre = new VBox(20);
        vbListaEmpre.setAlignment(Pos.TOP_CENTER);
        vbListaEmpre.setStyle("-fx-background-color: white;");
        vbListaEmpre.setPrefWidth(296);
        vbListaEmpre.setMinHeight(300);
        Pane pane1 = new Pane();
        pane1.setPrefWidth(300);
        pane1.setPrefHeight(0);
        vbListaEmpre.getChildren().add(pane1);
        Pane pane2 = new Pane();
        pane2.setPrefWidth(300);
        pane2.setPrefHeight(0);
        
        ArrayList<EmprendedorEnFeria> emprendedoresEnFeria = AdministracionFeriasController.feriaEscogida.getEmprendedores();
        for(EmprendedorEnFeria emp: emprendedoresEnFeria){
            HBox hbEmprendedor = new HBox(20);
            hbEmprendedor.setPrefWidth(296);
            //hbEmprendedor.setPrefHeight(50);
            VBox vbInfoEmpre = new VBox(2);
            vbInfoEmpre.setAlignment(Pos.CENTER);
            vbInfoEmpre.setPrefWidth(150);
            //vbInfoEmpre.setPrefHeight(100);
            ImageView ivIconoEmpre = new ImageView(new Image("/imagenes/persona.png"));
            ivIconoEmpre.setFitHeight(55);
            ivIconoEmpre.setFitWidth(55);
            hbEmprendedor.setAlignment(Pos.CENTER);
            Label lblNombreEmpre = new Label(emp.getEmprendedor().getNombre());
            lblNombreEmpre.setPrefWidth(150);
            lblNombreEmpre.setPrefHeight(20);
            lblNombreEmpre.setFont(font2);
            lblNombreEmpre.setWrapText(true);
            lblNombreEmpre.setAlignment(Pos.CENTER);
            Label lblDescri = new Label("Descripción:");
            lblDescri.setPrefWidth(150);
            lblDescri.setPrefHeight(20);
            lblDescri.setFont(font2);
            lblDescri.setWrapText(true);
            lblDescri.setAlignment(Pos.CENTER);
            lblDescri.setTextAlignment(TextAlignment.CENTER);
            Label lblDescriEmpre = new Label(emp.getEmprendedor().getDescripcion());
            lblDescriEmpre.setPrefWidth(150);
            //lblDescriEmpre.setPrefHeight(COMPUTER_SIZE);
            lblDescriEmpre.setFont(font3);
            lblDescriEmpre.setWrapText(true);
            lblDescriEmpre.setTextAlignment(TextAlignment.CENTER);
            lblDescriEmpre.setAlignment(Pos.CENTER);
            Label lblSeccionEmpre = new Label(emp.getSeccion());
            lblSeccionEmpre.setPrefWidth(150);
            lblSeccionEmpre.setPrefHeight(20);
            lblSeccionEmpre.setFont(font2);
            lblSeccionEmpre.setWrapText(true);
            lblSeccionEmpre.setAlignment(Pos.CENTER);
            Label lblStandEmpre = new Label("Stand " + emp.getStandAsignado().getCodigoStand());
            lblStandEmpre.setPrefWidth(150);
            lblStandEmpre.setPrefHeight(20);
            lblStandEmpre.setFont(font2);
            lblStandEmpre.setWrapText(true);
            lblStandEmpre.setAlignment(Pos.CENTER);
            vbInfoEmpre.getChildren().addAll(lblNombreEmpre,lblDescri,lblDescriEmpre,lblSeccionEmpre,lblStandEmpre);
            hbEmprendedor.getChildren().addAll(ivIconoEmpre,vbInfoEmpre);
            vbListaEmpre.getChildren().add(hbEmprendedor);
        }
        vbListaEmpre.getChildren().add(pane2);
        ScrollPane spListaEmpre = new ScrollPane(vbListaEmpre);
        spListaEmpre.setPrefHeight(300);
        spListaEmpre.setPrefWidth(300);
        spListaEmpre.setMaxWidth(300);
        spListaEmpre.setMinWidth(300);
        spListaEmpre.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spListaEmpre.setStyle("-fx-border-color: lavender;"); 
        vbListas.getChildren().addAll(iv,lblEmprendedores,spListaEmpre);
        
    }

    @FXML
    private void clickAuspiciantes(ActionEvent event) {
        vbListas.getChildren().clear();
        ImageView iv = new ImageView(new Image("/imagenes/auspiciantes.png"));
        iv.setFitHeight(90);
        iv.setFitWidth(90);
        Label lblAuspiciantes = new Label("Auspiciantes");
        Font font = Font.font("Arial Rounded MT Bold", 20);
        Font font2 = Font.font("Arial Rounded MT Bold", 12);
        Font font3 = Font.font("Arial Rounded MT", 12);
        lblAuspiciantes.setFont(font);
        
        VBox vbListaAus = new VBox(20);
        vbListaAus.setAlignment(Pos.TOP_CENTER);
        vbListaAus.setStyle("-fx-background-color: white;");
        vbListaAus.setPrefWidth(296);
        vbListaAus.setMinHeight(300);
        Pane pane1 = new Pane();
        pane1.setPrefWidth(300);
        pane1.setPrefHeight(0);
        vbListaAus.getChildren().add(pane1);
        Pane pane2 = new Pane();
        pane2.setPrefWidth(300);
        pane2.setPrefHeight(0);
        
        ArrayList<AuspicianteEnFeria> auspiciantesEnFeria = AdministracionFeriasController.feriaEscogida.getAuspiciantes();
        for(AuspicianteEnFeria aus: auspiciantesEnFeria){
            HBox hbAuspiciante = new HBox(20);
            hbAuspiciante.setPrefWidth(296);
            VBox vbInfoAus = new VBox(2);
            vbInfoAus.setAlignment(Pos.CENTER);
            vbInfoAus.setPrefWidth(150);
            ImageView ivIconoAus = new ImageView(new Image("/imagenes/iconoAus.png"));
            ivIconoAus.setFitHeight(55);
            ivIconoAus.setFitWidth(55);
            hbAuspiciante.setAlignment(Pos.CENTER);
            Label lblNombreAus = new Label(aus.getAus().getNombre());
            lblNombreAus.setPrefWidth(150);
            lblNombreAus.setPrefHeight(20);
            lblNombreAus.setFont(font2);
            lblNombreAus.setWrapText(true);
            lblNombreAus.setAlignment(Pos.CENTER);
            Label lblDescri = new Label("Descripción:");
            lblDescri.setPrefWidth(150);
            lblDescri.setPrefHeight(20);
            lblDescri.setFont(font2);
            lblDescri.setWrapText(true);
            lblDescri.setAlignment(Pos.CENTER);
            lblDescri.setTextAlignment(TextAlignment.CENTER);
            Label lblDescriAus = new Label(aus.getDescripcion());
            lblDescriAus.setPrefWidth(150);
            lblDescriAus.setFont(font3);
            lblDescriAus.setWrapText(true);
            lblDescriAus.setTextAlignment(TextAlignment.CENTER);
            lblDescriAus.setAlignment(Pos.CENTER);
            Label lblTieneStand = new Label();
            lblTieneStand.setPrefWidth(150);
            lblTieneStand.setPrefHeight(20);
            lblTieneStand.setFont(font2);
            lblTieneStand.setWrapText(true);
            lblTieneStand.setAlignment(Pos.CENTER);
            if(aus.getIncluyeStand()){
                lblTieneStand.setText("Incluye Stand");
                Label lblStandsAus = new Label();
                lblStandsAus.setPrefWidth(150);
                lblStandsAus.setPrefHeight(20);
                lblStandsAus.setFont(font2);
                lblStandsAus.setWrapText(true);
                lblStandsAus.setAlignment(Pos.CENTER);
                if(aus.getStandsAsignados().size()==1){
                    lblStandsAus.setText("Stand " +aus.getStandsAsignados().get(0).getCodigoStand());
                } else if(aus.getStandsAsignados().size()==2){
                    lblStandsAus.setText("Stands " + aus.getStandsAsignados().get(0).getCodigoStand() + " y " + aus.getStandsAsignados().get(1).getCodigoStand());
                }
                vbInfoAus.getChildren().addAll(lblNombreAus, lblDescri,lblDescriAus,lblTieneStand,lblStandsAus);
                hbAuspiciante.getChildren().addAll(ivIconoAus,vbInfoAus);
            } else{
                lblTieneStand.setText("No incluye Stand");
                vbInfoAus.getChildren().addAll(lblNombreAus, lblDescri,lblDescriAus,lblTieneStand);
                hbAuspiciante.getChildren().addAll(ivIconoAus,vbInfoAus);
            }
            
            
            vbListaAus.getChildren().add(hbAuspiciante);
        }
        vbListaAus.getChildren().add(pane2);
        ScrollPane spListaAus = new ScrollPane(vbListaAus);
        spListaAus.setPrefHeight(300);
        spListaAus.setPrefWidth(300);
        spListaAus.setMaxWidth(300);
        spListaAus.setMinWidth(300);
        spListaAus.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spListaAus.setStyle("-fx-border-color: lavender;"); 
        vbListas.getChildren().addAll(iv,lblAuspiciantes,spListaAus);
    }

    @FXML
    private void clickCantidadStandsSeccion(ActionEvent event) {
        vbListas.getChildren().clear();
        ImageView iv = new ImageView(new Image("/imagenes/stand.png"));
        iv.setFitHeight(90);
        iv.setFitWidth(90);
        Label lblStands = new Label("Cantidad de Stands por sección");
        Font font = Font.font("Arial Rounded MT Bold", 20);
        Font font2 = Font.font("Arial Rounded MT Bold", 14);
        Font font3 = Font.font("Arial Rounded MT", 12);
        lblStands.setFont(font);
        
        VBox vbListaStands = new VBox(18);
        vbListaStands.setAlignment(Pos.TOP_CENTER);
        vbListaStands.setStyle("-fx-background-color: white;");
        vbListaStands.setPrefWidth(296);
        vbListaStands.setMinHeight(296);
        Pane pane1 = new Pane();
        pane1.setPrefWidth(200);
        pane1.setPrefHeight(0);
        Pane pane2 = new Pane();
        pane2.setPrefWidth(200);
        pane2.setPrefHeight(0);
        vbListaStands.getChildren().add(pane1);
        
        ArrayList<OrganizacionStands> orgStands = new ArrayList<>();
        orgStands.add(AdministracionFeriasController.feriaEscogida.getSeccion1());
        orgStands.add(AdministracionFeriasController.feriaEscogida.getSeccion2());
        orgStands.add(AdministracionFeriasController.feriaEscogida.getSeccion3());
        orgStands.add(AdministracionFeriasController.feriaEscogida.getSeccion4());
        for(OrganizacionStands o: orgStands){
            HBox hbStand = new HBox(20);
            hbStand.setPrefWidth(296);
            hbStand.setPrefHeight(50);
            ImageView ivIconoStand = new ImageView(new Image("/imagenes/standOficial.png"));
            ivIconoStand.setFitHeight(40);
            ivIconoStand.setFitWidth(40);
            hbStand.setAlignment(Pos.CENTER);
            Label lblNombreStand = new Label("Sección #" + o.getNumSeccion() + ":   " + o.getCantStands());
            lblNombreStand.setPrefWidth(120);
            lblNombreStand.setPrefHeight(50);
            lblNombreStand.setFont(font2);
            lblNombreStand.setWrapText(true);
            lblNombreStand.setAlignment(Pos.CENTER);
            hbStand.getChildren().addAll(ivIconoStand,lblNombreStand);
            vbListaStands.getChildren().add(hbStand);
        }
        vbListaStands.getChildren().add(pane2);
        ScrollPane spListaStand = new ScrollPane(vbListaStands);
        spListaStand.setPrefHeight(300);
        spListaStand.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spListaStand.setPrefWidth(300);
        spListaStand.setMaxWidth(300);
        spListaStand.setMinWidth(300);
        spListaStand.setStyle("-fx-border-color: lavender;"); 
        vbListas.getChildren().addAll(iv,lblStands,spListaStand);
    }
    
}
