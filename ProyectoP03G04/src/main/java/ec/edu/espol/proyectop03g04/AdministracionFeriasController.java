/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;
import excepciones.FechaVacia;
import modelo.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class AdministracionFeriasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static ArrayList<Feria> ferias = new ArrayList<>();
    @FXML
    private BorderPane bpAdminFerias;
    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private Button btnNuevaFeria;
    @FXML
    private Button btnVerDetalles;
    @FXML
    private Button btnEditarFeria;
    @FXML
    private Button btnVerStands;
    @FXML
    private Label lblFeriaEscogida;
    @FXML
    private VBox vbFerias;
    
    public static Feria feriaEscogida;
    public static String codigoFeria;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
        feriaEscogida = null;
        codigoFeria = null;
        this.cargarFerias();
    }    
    
    @FXML
    private void clickRegresar() {
        try{
            App.setRoot("menuPrincipal");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void verificarEditable(Feria feria) throws FechaVacia{
        if (feria.getFechaIni().isBefore(LocalDate.now())) {
            throw new FechaVacia("No se puede editar esta Feria porque la Fecha de Inicio ya pasó.");
        } else if (feria.getFechaIni().isEqual(LocalDate.now())) {
            System.out.println("No se puede editar esta Feria porque la Fecha de Inicio es hoy.");
        }
    }
    
    public void mostrarAlerta1(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(null);
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            vbFerias.getChildren().clear();
            cargarFerias();
        });
        alert.showAndWait();
    }
    
    private void cargarFerias(){
        // mostrarFerias
        ArrayList<HBox> hbs = new ArrayList<>();
        int index = 0;
        int numHBoxes = 0;
        if(ferias.size()%2==0){
            numHBoxes = ferias.size()/2;
            for(int i=1; i<=numHBoxes;i++){
                HBox hbFerias = new HBox(10);
                hbFerias.setPrefWidth(738);
                hbFerias.setPrefHeight(219);
                hbFerias.setMinWidth(738);
                hbFerias.setMinHeight(219);
                hbFerias.setMaxWidth(738);
                hbFerias.setMaxHeight(219);
                hbs.add(hbFerias);
                vbFerias.getChildren().add(hbFerias);
            }
        } else{
            int num = ferias.size() + 1;
            numHBoxes = num/2;
            for(int i=1; i<=numHBoxes;i++){
                HBox hbFerias = new HBox(10);
                hbFerias.setPrefWidth(738);
                hbFerias.setPrefHeight(219);
                hbFerias.setMinWidth(738);
                hbFerias.setMinHeight(219);
                hbFerias.setMaxWidth(738);
                hbFerias.setMaxHeight(219);
                hbs.add(hbFerias);
                vbFerias.getChildren().add(hbFerias);
            }
        }
        System.out.println(numHBoxes);
        
        for (Feria feria: ferias){
            Image img = new Image("/imagenes/carousel_5593709.png");
            ImageView iv = new ImageView(img);
            iv.setFitHeight(60);
            iv.setFitWidth(60);
            VBox vbFeria = new VBox();
            vbFeria.setAlignment(Pos.CENTER);
            vbFeria.setSpacing(6);
            vbFeria.setPrefHeight(219);
            vbFeria.setPrefWidth(364);
            Font fontb = Font.font("Arial Rounded MT Bold", 12);
            Font fontr = Font.font("Arial Rounded MT", 12);
            Button btnSeleccionar = new Button("Seleccionar");
            btnSeleccionar.setFont(fontb);
            btnSeleccionar.setStyle("-fx-background-color: indigo; -fx-text-fill: white;");
            Label codigo1 = new Label("Código:");
            Label nombre1 = new Label("Nombre:");
            Label fechaIni1 = new Label("Fecha de Inicio:");
            Label cantEmpre1 = new Label("Cantidad de Emprendedores:");
            Label cantAus1 = new Label("Cantidad de Auspiciantes:");
            Label codigo2 = new Label(feria.getCodigo());
            Label nombre2 = new Label(feria.getNombre());
            Label fechaIni2 = new Label(feria.getFechaIni().toString());
            Label cantEmpre2 = new Label("" + feria.getEmprendedores().size());
            Label cantAus2 = new Label("" + feria.getAuspiciantes().size());
            codigo1.setFont(fontb);
            nombre1.setFont(fontb);
            fechaIni1.setFont(fontb);
            cantEmpre1.setFont(fontb);
            cantAus1.setFont(fontb);
            codigo2.setFont(fontr);
            nombre2.setFont(fontr);
            fechaIni2.setFont(fontr);
            cantEmpre2.setFont(fontr);
            cantAus2.setFont(fontr);
            HBox codigo = new HBox();
            codigo.getChildren().addAll(codigo1,codigo2);
            codigo.setSpacing(5);
            codigo.setAlignment(Pos.CENTER);
            HBox nombre = new HBox();
            nombre.getChildren().addAll(nombre1,nombre2);
            nombre.setSpacing(5);
            nombre.setAlignment(Pos.CENTER);
            HBox fechaIni = new HBox();
            fechaIni.getChildren().addAll(fechaIni1,fechaIni2);
            fechaIni.setSpacing(5);
            fechaIni.setAlignment(Pos.CENTER);
            HBox cantEmpre = new HBox();
            cantEmpre.getChildren().addAll(cantEmpre1,cantEmpre2);
            cantEmpre.setSpacing(5);
            cantEmpre.setAlignment(Pos.CENTER);
            HBox cantAus = new HBox();
            cantAus.getChildren().addAll(cantAus1,cantAus2);
            cantAus.setSpacing(5);
            cantAus.setAlignment(Pos.CENTER);
            vbFeria.getChildren().addAll(iv,codigo,nombre,fechaIni,cantEmpre,cantAus, btnSeleccionar);
            Border border = new Border(new BorderStroke(javafx.scene.paint.Color.INDIGO, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));
            vbFeria.setBorder(border);
            
            HBox hb = hbs.get(index);
            hb.getChildren().add(vbFeria);
            if(hb.getChildren().size()>=2){
                index+=1;
            }
            
            btnNuevaFeria.setOnAction(e -> {
                try{
                    App.setRoot("opcionNuevaFeria");
                } catch(IOException a){
                    a.printStackTrace();
                }
            });
            btnSeleccionar.setOnAction(e -> {
                feriaEscogida=feria;
                lblFeriaEscogida.setText(feria.getNombre());
                btnVerDetalles.setDisable(false);
                btnEditarFeria.setDisable(false);
                btnVerStands.setDisable(false);
                btnVerStands.setOnAction(j -> {
                    codigoFeria = feria.getCodigo();
                    try{
                        App.setRoot("administracionStandsFeria");
                    } catch(IOException a){
                        a.printStackTrace();
                    }
                });
                btnVerDetalles.setOnAction(j -> {
                    try{
                        App.setRoot("opcionVerDetallesFeria");
                    } catch(IOException io){
                        io.printStackTrace();
                    }
                });
                btnEditarFeria.setOnAction(j -> {
                    try{
                        verificarEditable(feria);
                        App.setRoot("opcionEditarFeria");
                    } catch(FechaVacia fv){
                        mostrarAlerta1(fv.getMessage());
                    } catch(IOException io){
                        io.printStackTrace();
                    }
                });
            });
        }
    }
    
}
