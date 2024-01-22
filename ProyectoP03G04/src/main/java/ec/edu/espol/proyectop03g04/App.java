package ec.edu.espol.proyectop03g04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Auspiciante;
import modelo.AuspicianteEnFeria;
import modelo.Emprendedor;
import modelo.EmprendedorEnFeria;
import modelo.Feria;
import modelo.R;
import modelo.RedSocial;
import modelo.SC;
import modelo.Stand;
import modelo.Utilitaria;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menuPrincipal"), 1280, 720);
        //scene.getStylesheets().add(getClass().getResource("src/main/resources/styles/menuPrincipal.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        
        // Información de carga feria 1
        Feria feria1 = new Feria("Feria Verde",LocalDate.of(2024, 2, 6),LocalDate.of(2024, 2, 15),"Guayaquil","Destaca la sostenibilidad y la ecología","09h00-16h00",6,4,7,5);
        AdministracionFeriasController.ferias.add(feria1);
        
        // Información de carga feria 2
        Feria feria2 = new Feria("Feria de Sabores",LocalDate.of(2023, 12, 4),LocalDate.of(2023, 12, 10),"Samborondón","Celebra la diversidad culinaria y la creativad","08h00-14h00",4,6,5,7);
        AdministracionFeriasController.ferias.add(feria2);
        
        // Información de carga 4 emprendedores y 2 auspiciantes
        ArrayList<RedSocial> reds1 = new ArrayList<>();
        ArrayList<RedSocial> reds2 = new ArrayList<>();
        ArrayList<RedSocial> reds3 = new ArrayList<>();
        ArrayList<RedSocial> reds4 = new ArrayList<>();
        ArrayList<RedSocial> reds5 = new ArrayList<>();
        ArrayList<RedSocial> reds6 = new ArrayList<>();
        
        reds1.add(new RedSocial("ArteDelSabor_",R.INSTAGRAM));
        reds1.add(new RedSocial("GourmetFusionWorld",R.YOUTUBE));
        reds2.add(new RedSocial("VidaEcoPro",R.FACEBOOK));
        reds2.add(new RedSocial("GreenLifeInnovate",R.LINKEDIN));
        reds2.add(new RedSocial("EcoVidaTweets",R.TWITTER));
        reds3.add(new RedSocial("LuminArtistry",R.TIKTOK));
        reds3.add(new RedSocial("ArteIluminado",R.INSTAGRAM));
        reds4.add(new RedSocial("GreenCultureHub",R.LINKEDIN));
        reds4.add(new RedSocial("VerdeCultural",R.YOUTUBE));
        reds4.add(new RedSocial("VerdeCultura5",R.TWITTER));
        reds5.add(new RedSocial("VidaSaludablePlus",R.FACEBOOK));
        reds5.add(new RedSocial("WellnessPlusHub",R.PINTEREST));
        reds6.add(new RedSocial("EstiloTrend",R.TIKTOK));
        reds6.add(new RedSocial("EstiloModerno",R.INSTAGRAM));
        reds6.add(new RedSocial("FashionStyleJourney",R.YOUTUBE));
        
        ArrayList<SC> sectores5 = new ArrayList<>();
        sectores5.add(SC.SALUD);
        
        ArrayList<SC> sectores6 = new ArrayList<>();
        sectores6.add(SC.VESTIMENTA);
        sectores6.add(SC.EDUCACION);

        Emprendedor emprendedor1 = new Emprendedor("1712345678","SaborArte","Ana García","0987654321","ana@saborarte.com","Calle Principal #123"," www.saborarte.com",reds1,"Productos gourmet y experiencias únicas");
        Stand stand1 = feria1.getSeccion1().getStandsPorSeccion().get(0);
        stand1.setFechaAsig(LocalDate.of(2024,1,16));
        stand1.setReservado(true);
        stand1.setDueno(emprendedor1);
        Stand stand2 = feria2.getSeccion1().getStandsPorSeccion().get(1);
        stand2.setFechaAsig(LocalDate.of(2023,11,22));
        stand2.setReservado(true);
        stand2.setDueno(emprendedor1);
        AdministracionEmprendedoresController.emprendedores.add(emprendedor1);
        feria1.getEmprendedores().add(new EmprendedorEnFeria(emprendedor1,stand1,"Sección #1"));
        feria2.getEmprendedores().add(new EmprendedorEnFeria(emprendedor1,stand2,"Sección #1"));
        
        Emprendedor emprendedor2 = new Emprendedor("1809876543","EcoVida","Carlos Mendoza","0998765432","carlos@ecovida.ec","Av. Ecológica #456","www.ecovida.ec",reds2,"Productos orgánicos y talleres de reciclaje");
        Stand stand3 = feria1.getSeccion2().getStandsPorSeccion().get(2);
        stand3.setReservado(true);
        stand3.setFechaAsig(LocalDate.of(2024,1,10));
        stand3.setDueno(emprendedor2);
        Stand stand4 = feria2.getSeccion2().getStandsPorSeccion().get(4);
        stand4.setReservado(true);
        stand4.setDueno(emprendedor2);
        stand4.setFechaAsig(LocalDate.of(2023,11,30));
        AdministracionEmprendedoresController.emprendedores.add(emprendedor2);
        feria1.getEmprendedores().add(new EmprendedorEnFeria(emprendedor2,stand3,"Sección #2"));
        feria2.getEmprendedores().add(new EmprendedorEnFeria(emprendedor2,stand4,"Sección #2"));
        
        Emprendedor emprendedor3 = new Emprendedor("1923456789","IluminaArte","Marta Pérez","0976543210","mar@iluminaarte.com","Plaza Luminosa #789","www.iluminaarte.com",reds3,"Crea instalaciones de iluminación artística para restaurantes");
        Stand stand5 = feria1.getSeccion3().getStandsPorSeccion().get(3);
        stand5.setReservado(true);
        stand5.setDueno(emprendedor3);
        stand5.setFechaAsig(LocalDate.of(2024,1,13));
        Stand stand6 = feria2.getSeccion3().getStandsPorSeccion().get(0);
        stand6.setReservado(true);
        stand6.setDueno(emprendedor3);
        stand6.setFechaAsig(LocalDate.of(2023,12,1));
        AdministracionEmprendedoresController.emprendedores.add(emprendedor3);
        feria1.getEmprendedores().add(new EmprendedorEnFeria(emprendedor3,stand5,"Sección #3"));
        feria2.getEmprendedores().add(new EmprendedorEnFeria(emprendedor3,stand6,"Sección #3"));
    
        Emprendedor emprendedor4 = new Emprendedor("2012345678","CulturaVerde","Juan Rodríguez","0965432109","juan@cultuver.com","Calle Cultural #234","www.culturaverde.com",reds4,"Promueve la conciencia ambiental y ofrece eventos culturales");
        Stand stand7 = feria1.getSeccion4().getStandsPorSeccion().get(1);
        stand7.setReservado(true);
        stand7.setDueno(emprendedor4);
        stand7.setFechaAsig(LocalDate.of(2024,1,18));
        Stand stand8 = feria2.getSeccion4().getStandsPorSeccion().get(2);
        stand8.setReservado(true);
        stand8.setDueno(emprendedor4);
        stand8.setFechaAsig(LocalDate.of(2023,1,15));
        AdministracionEmprendedoresController.emprendedores.add(emprendedor4);
        feria1.getEmprendedores().add(new EmprendedorEnFeria(emprendedor4,stand7,"Sección #4"));
        feria2.getEmprendedores().add(new EmprendedorEnFeria(emprendedor4,stand8,"Sección #4"));

        Auspiciante auspiciante1 = new Auspiciante("2112345678","SaludPlus","Laura Herrera","0954321098","lau@saludplus.com", "Av. Saludable #567", "www.saludplus.com",reds5, sectores5);
        AuspicianteEnFeria ausF1 = new AuspicianteEnFeria(auspiciante1, "Degustaciones de productos orgánicos y clases de yoga al aire libre", false);
        AuspicianteEnFeria ausFeria1 = new AuspicianteEnFeria(auspiciante1, "Asesoramiento nutricional, sesiones de fitness en vivo y muestras gratuitas de productos saludables", true);
        Stand stand9 = feria2.getSeccion3().getStandsPorSeccion().get(2);
        stand9.setReservado(true);
        stand9.setDueno(auspiciante1);
        stand9.setFechaAsig(LocalDate.of(2023,11,27));
        ausFeria1.getStandsAsignados().add(stand9);
        feria1.getAuspiciantes().add(ausF1);
        feria2.getAuspiciantes().add(ausFeria1);
        AdministracionAuspiciantesController.auspiciantes.add(auspiciante1);
        
        Auspiciante auspiciante2 = new Auspiciante("2209876543","VestirEstilo","Pablo Gómez","0945678901","pablo@vestir.ec", "Moda Street #789", "www.vestirestilo.ec",reds5, sectores6);
        Stand stand10 = feria1.getSeccion1().getStandsPorSeccion().get(3);
        stand10.setReservado(true);
        stand10.setFechaAsig(LocalDate.of(2024,1,15));
        Stand stand11 = feria2.getSeccion2().getStandsPorSeccion().get(1);
        stand11.setReservado(true);
        stand11.setFechaAsig(LocalDate.of(2023,12,3));
        AuspicianteEnFeria ausF2 = new AuspicianteEnFeria(auspiciante2, "Descuentos exclusivos en tiendas y talleres interactivos", true);
        AuspicianteEnFeria ausFeria2 = new AuspicianteEnFeria(auspiciante2, "Desfiles de moda sostenible y cata de vinos", true);
        ausF2.getStandsAsignados().add(stand10);
        ausFeria2.getStandsAsignados().add(stand11);
        feria1.getAuspiciantes().add(ausF2);
        feria2.getAuspiciantes().add(ausFeria2);
        stand10.setDueno(auspiciante2);
        stand11.setDueno(auspiciante2);
        AdministracionAuspiciantesController.auspiciantes.add(auspiciante2);
        
        System.out.println(AdministracionFeriasController.ferias.size());
        System.out.println(AdministracionEmprendedoresController.emprendedores.size());
        System.out.println(AdministracionAuspiciantesController.auspiciantes.size());
        Utilitaria.saveListToFileFeria(AdministracionFeriasController.ferias);
        Utilitaria.saveListToFileEmprendedor(AdministracionEmprendedoresController.emprendedores);
        Utilitaria.saveListToFileAuspiciante(AdministracionAuspiciantesController.auspiciantes);

    }
    
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}