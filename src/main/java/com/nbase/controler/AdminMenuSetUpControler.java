package com.nbase.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMenuSetUpControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonAddUser;

    @FXML
    private Button ButtonSetUpUser;

    @FXML
    private Button ButtonShowUser;

    @FXML
    private Button InsertNewUserToDataBase;

    @FXML
    private Button InsertNewUserToDataBase1;

    @FXML
    void initialize() {

        MenuLink menuLink = new MenuLink();

        ButtonAddUser.setOnAction( event -> {
            menuLink.layoutMenuLink(ButtonSetUpUser, "/fxml/adminMenuAddUser.fxml");
        });

        ButtonShowUser.setOnAction( event -> {
            menuLink.layoutMenuLink(ButtonSetUpUser, "/fxml/adminMenuShowUser.fxml");
        });






    }
}
