module com.example.assignment1aj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.assignment1aj to javafx.fxml;
    exports com.example.assignment1aj;
}