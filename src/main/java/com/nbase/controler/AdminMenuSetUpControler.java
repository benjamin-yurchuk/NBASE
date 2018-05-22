package com.nbase.controler;

import java.net.URL;
import java.util.ResourceBundle;

import com.nbase.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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

        Loader loader = new Loader();

        ButtonAddUser.setOnAction( event -> {
            loader.layoutMenuLink(ButtonSetUpUser, "/fxml/adminMenuAddUser.fxml");
        });

        ButtonShowUser.setOnAction( event -> {
            loader.layoutMenuLink(ButtonSetUpUser, "/fxml/adminMenuShowUser.fxml");
        });
    }
}
