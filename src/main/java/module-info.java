module com.example.alexfan20077347jb {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.alexfan20077347jb to javafx.fxml;
    exports com.example.alexfan20077347jb;
    exports com.example.alexfan20077347jb.models;
    opens com.example.alexfan20077347jb.models to javafx.fxml;
    exports com.example.alexfan20077347jb.Controllers;
    opens com.example.alexfan20077347jb.Controllers to javafx.fxml;

}