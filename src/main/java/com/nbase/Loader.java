package com.nbase;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Loader {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    public void layoutMenuLink(Button buttonHide, String link) {

        buttonHide.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(link));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent, width, height));
        stage.show();
    }

    public void Show(String link) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(link));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent, width, height));
        stage.show();
    }
}
