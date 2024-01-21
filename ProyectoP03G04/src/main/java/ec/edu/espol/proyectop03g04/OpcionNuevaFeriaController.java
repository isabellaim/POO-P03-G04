/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectop03g04;


import excepciones.*;
import modelo.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.time.LocalDate;
import java.util.regex.PatternSyntaxException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class OpcionNuevaFeriaController implements Initializable {

    @FXML
    private HBox hbHeading;
    @FXML
    private Button btnRegresar;
    @FXML
    private ImageView imgHeader2;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private TextField tfLugar;
    @FXML
    private TextField tfHorario;
    @FXML
    private TextField tfCantidadStands1;
    @FXML
    private TextField tfCantidadStands2;
    @FXML
    private TextField tfCantidadStands3;
    @FXML
    private TextField tfCantidadStands4;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private ImageView imageView8;
    @FXML
    private ImageView imageView9;
    @FXML
    private ImageView imageView10;
    @FXML
    private DatePicker dpFechaFin;
    @FXML
    private DatePicker dpFechaInicio;
    @FXML
    private BorderPane bpOpcionNuevaFeria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img1 = new Image("/imagenes/rueda-de-la-fortuna.png");
        imgHeader2.setImage(img1);
        imageView1.setImage(new Image("/imagenes/nombre.png"));
        imageView2.setImage(new Image("/imagenes/descripcion.png"));
        imageView3.setImage(new Image("/imagenes/lugar.png"));
        imageView4.setImage(new Image("/imagenes/fechaIni.png"));
        imageView5.setImage(new Image("/imagenes/fechaFin.png"));
        imageView6.setImage(new Image("/imagenes/horario.png"));
        imageView7.setImage(new Image("/imagenes/stand.png"));
        imageView8.setImage(new Image("/imagenes/stand.png"));
        imageView9.setImage(new Image("/imagenes/stand.png"));
        imageView10.setImage(new Image("/imagenes/stand.png"));
        
    }    

    @FXML
    private void clickRegresar() {
        try{
            App.setRoot("administracionFerias");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickGuardar() {
        String nombre = null;
        String descripcion = null;
        String lugar = null;
        LocalDate fechaIni = null;
        LocalDate fechaFin = null;
        String horario = null;
        int cantidadStands1 = 0;
        int cantidadStands2 = 0;
        int cantidadStands3 = 0;
        int cantidadStands4 = 0;
        try{
            nombre = recuperarString(tfNombre);
            descripcion = recuperarString(tfDescripcion);
            lugar = recuperarString(tfLugar);
            horario = recuperarString(tfHorario);
            validarHorario(horario);
            fechaIni = validateDatePicker(dpFechaInicio);
            fechaFin = validateDatePicker(dpFechaFin);
              
            this.validarSiFechaEstaDespues(fechaIni, fechaFin);
                       
            cantidadStands1 = Integer.parseInt(tfCantidadStands1.getText());
            validarCantStands(cantidadStands1);
            cantidadStands2 = Integer.parseInt(tfCantidadStands2.getText());
            validarCantStands(cantidadStands2);
            cantidadStands3 = Integer.parseInt(tfCantidadStands3.getText());
            validarCantStands(cantidadStands3);
            cantidadStands4 = Integer.parseInt(tfCantidadStands4.getText());
            validarCantStands(cantidadStands4);
            
            AdministracionFeriasController.ferias.add(new Feria(nombre,fechaIni,fechaFin,lugar,descripcion,horario,cantidadStands1,cantidadStands2,cantidadStands3,cantidadStands4));
            App.setRoot("administracionFerias");
                
        } catch(NumberFormatException nfe){
            mostrarAlerta("Por favor coloque números en la cantidad de Stands.");
        } catch(FechaNoPuedeSerDespues fecha){
            mostrarAlerta("La fecha de inicio no puede ser después de la fecha de fin.");
        } catch (FechaVacia fv) {
            mostrarAlerta("Por favor coloque fechas válidas.");
        } catch(StringVacio sv){
            mostrarAlerta(sv.getMessage());
        } catch(IOException e){
            e.printStackTrace();
        } catch (Exception e){
            mostrarAlerta("Error");
        }
    }
    
    private static String recuperarString(TextField tf) throws StringVacio{
        String str = tf.getText();
        if (str.equals("")){
            throw new StringVacio("Por favor coloque información válida.");
        }
        return str;
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
                App.setRoot("opcionNuevaFeria");
            } catch(IOException e){
                e.printStackTrace();
            }
        });
        alert.showAndWait();
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
    private void validarCantStands(int num) throws StringVacio{
        if(num==0){
            throw new StringVacio("Por favor escoja una cantidad de Stands diferente de 0.");
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
                throw new StringVacio();
            }
           count++;
        }
        
        if(num1>num2){
            throw new StringVacio();
        }
    }
}
