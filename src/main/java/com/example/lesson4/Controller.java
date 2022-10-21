package com.example.lesson4;


import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private ImageView Exit, max_img,min_img;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;


    @FXML
    private AnchorPane slider;

    @FXML
    private BorderPane Pane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        slider.setTranslateX(-176);



        min_img.setOnMouseClicked(MouseEvent ->{
            ((Stage)((ImageView)MouseEvent.getSource()).getScene().getWindow()).setIconified(true);
        });
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });


        max_img. setOnMouseClicked(event ->{
            Stage stage = (Stage) Pane.getScene().getWindow();
            if (stage.isMaximized()){
                stage.setMaximized(false);
            }else{
                stage.setMaximized(true);
            }
        });


        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });
    }

}