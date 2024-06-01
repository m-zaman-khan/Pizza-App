package com.example.pizzadelivery;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("bg-1");
        borderPane.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene( borderPane,700, 450);
        Label Pizza = new Label("Pizza Order 2017");
        Pizza.setTextFill(Color.web("red"));
        Pizza.setBorder(new Border(new BorderStroke(Color.valueOf("green"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        stage.setTitle("Pizza Order 2017!");
        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30);
        Pizza.setFont(font);


        GridPane gridpaneTop = new GridPane();
        gridpaneTop.setHgap(15);
        Image image = new Image("C:\\Users\\Zaman Khan\\Desktop\\PizzaDelivery\\saahil-khatkhate-kfDsMDyX1K0-unsplash.jpg",100,100,false,false);
        gridpaneTop.getChildren().add(new ImageView(image));
        gridpaneTop.add(Pizza,10,0);
        gridpaneTop.setBorder(new Border(new BorderStroke(Color.valueOf("green"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        borderPane.setTop(gridpaneTop);




        GridPane gridPaneLeft = new GridPane();
        gridPaneLeft.setPadding(new Insets(5,5,5,5));
        gridPaneLeft.setHgap(15);
        gridPaneLeft.setVgap(15);
        Text t = new Text("Select Pizza Size : ");
        ToggleGroup group = new ToggleGroup();
        gridPaneLeft.add(t,1,1);

        RadioButton small = new RadioButton("Small - 9$");
        small.setToggleGroup(group);
        gridPaneLeft.add(small,1,2);

        RadioButton medium = new RadioButton("Medium - 11$");
        medium.setToggleGroup(group);
        gridPaneLeft.add(medium,1,3);

        RadioButton large = new RadioButton("Large - 14$");
        large.setToggleGroup(group);
        gridPaneLeft.add(large,1,4);
        gridPaneLeft.setBorder(new Border(new BorderStroke(Color.valueOf("green"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        borderPane.setLeft(gridPaneLeft);


        GridPane gridPaneRight = new GridPane();
        gridPaneRight.setPadding(new Insets(5,5,5,5));
        gridPaneRight.setHgap(15);
        gridPaneRight.setVgap(15);
        Text t1 = new Text("Select any Topping : ");
        gridPaneRight.add(t1,1,1);

        CheckBox salami = new CheckBox("Salami - 2$");
        gridPaneRight.add(salami,1,2);

        CheckBox cheese = new CheckBox("Cheese - 2$");
        gridPaneRight.add(cheese,1,3);

        CheckBox tomato = new CheckBox("Tomato - 2$");
        gridPaneRight.add(tomato,1,4);
        gridPaneRight.setBorder(new Border(new BorderStroke(Color.valueOf("green"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        borderPane.setRight(gridPaneRight);

        GridPane gridPaneCenter = new GridPane();
        gridPaneCenter.setPadding(new Insets(10,10,10,10));
        gridPaneCenter.setHgap(15);
        gridPaneCenter.setVgap(15);
        Text t2 = new Text("You Selected : ");
        gridPaneCenter.add(t2,1,1);
        Label l= new Label();


        Label t3= new Label("Total price : ");
        AtomicInteger price = new AtomicInteger();
        EventHandler<ActionEvent> e = actionEvent -> {
            price.set(0);
            if(small.isSelected()){
            l.setText("Pizza size : Small");
            l.setTextFill(Color.web("red"));
            price.set(9);
            t3.setText("Total price : "+price.get());
        }  if(medium.isSelected()){
            l.setText("Pizza size : Medium");
                l.setTextFill(Color.web("green"));
                price.set(11);
                t3.setText("Total price : "+price.get());
        } if(large.isSelected()){
            l.setText("Pizza size : Large");
                l.setTextFill(Color.web("purple"));
                price.set(14);
                t3.setText("Total price : "+price.get());
        }
            gridPaneCenter.add(l,1,3);
        };

       AtomicInteger s = new AtomicInteger();
        Text tt = new Text("Topping Choosen : ");
        Text t4 = new Text();
        Text t5 = new Text();
        Text t6 = new Text();



        EventHandler<ActionEvent> e1 = actionEvent -> {
//            s.set(0);
            if(salami.isSelected()){
               s.getAndIncrement();
               tt.setText("Topping Choosen : "+s.get());
               t4.setText(salami.getText());
               price.set(price.get()+2);
                t3.setText("Total price : "+price.get());
            }
            else if(!salami.isSelected()) {
                price.set(price.get()-2);
                t3.setText("Total price : "+price.get());
                t4.setText("");
                  s.set(s.get() - 1);
                  tt.setText("Topping Choosen : " + s.get());
            }
            };

            EventHandler<ActionEvent> e2 = actionEvent -> {
             if(cheese.isSelected()){
                s.getAndIncrement();
                tt.setText("Topping Choosen : "+s.get());
                t5.setText(cheese.getText());
                price.set(price.get()+2);
                t3.setText("Total price : "+price.get());}
             else {
                 price.set(price.get()-2);
                 t3.setText("Total price : "+price.get());
                 t5.setText("");
                 s.set(s.get() - 1);
                 tt.setText("Topping Choosen : " + s.get());

             }};
        EventHandler<ActionEvent> e3 = actionEvent -> {
             if(tomato.isSelected()){
             s.getAndIncrement();
                tt.setText("Topping Choosen : "+s.get());
                t6.setText(tomato.getText());
                price.set(price.get()+2);
                t3.setText("Total price : "+price.get());
            }     else {
                 price.set(price.get()-2);
                 t3.setText("Total price : "+price.get());
                 t6.setText("");
                 s.set(s.get() - 1);
                 tt.setText("Topping Choosen : " + s.get());
             }};



        gridPaneCenter.add(l,1,3);
        gridPaneCenter.add(tt,1,5);
        gridPaneCenter.add(t4,1,6);
        gridPaneCenter.add(t5,1,7);
        gridPaneCenter.add(t6,1,8);
        gridPaneCenter.setBorder(new Border(new BorderStroke(Color.valueOf("green"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));

        borderPane.setCenter(gridPaneCenter);

        GridPane gridPaneBottom = new GridPane();
        gridPaneBottom.add(t3,0,0);
        gridPaneBottom.setBorder(new Border(new BorderStroke(Color.valueOf("green"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));

        borderPane.setBottom(gridPaneBottom);



        salami.setOnAction(e1);
        cheese.setOnAction(e2);
        tomato.setOnAction(e3);

        small.setOnAction(e);
        medium.setOnAction(e);
        large.setOnAction(e);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}