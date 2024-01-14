module ec.edu.espol.proyectop03g04 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectop03g04 to javafx.fxml;
    exports ec.edu.espol.proyectop03g04;
}
