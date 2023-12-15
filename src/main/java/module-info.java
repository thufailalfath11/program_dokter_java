module com.example.pbotubes {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.kesehatan.pbotubes;
    opens com.kesehatan.pbotubes to javafx.fxml;
}