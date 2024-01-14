module ec.edu.espol.proyectop03g04 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyectop03g04 to javafx.fxml;
    exports ec.edu.espol.proyectop03g04;
}
