package com.nbase.controler;

import java.net.URL;
import java.util.ResourceBundle;

import com.nbase.DataBase;
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
    private Button EditUsers;

    @FXML
    private Button DeleteUsers;

    DataBase dataBase = new DataBase();

    @FXML
    void initialize() {
        Loader loader = new Loader();

        ButtonAddUser.setOnAction( event -> {
            loader.layoutMenuLink(ButtonSetUpUser, "/fxml/adminMenuAddUser.fxml");
        });

        ButtonSetUpUser.setOnAction( event -> {
            loader.layoutMenuLink(ButtonSetUpUser, "/fxml/adminMenuShowUser.fxml");
        });

        DeleteUsers.setOnAction(event ->
            dataBase.deleteUser("benjamin")
        );


    }
}


