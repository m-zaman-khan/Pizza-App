module com.example.pizzadelivery {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pizzadelivery to javafx.fxml;
    exports com.example.pizzadelivery;
}