package com.nbase.controler.waiter;

import java.net.URL;
import java.util.ResourceBundle;

import com.nbase.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PalceMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button palce1;

    @FXML
    private Button BtnMenu;

    @FXML
    private Button BtnExit;

    Loader loader = new Loader();

    @FXML
    void initialize() {
        BtnExit.setOnAction(event -> {
            loader.layoutMenuLink(BtnExit, "/fxml/signIn.fxml");
        });
        BtnMenu.setOnAction(event -> {
            loader.layoutMenuLink(BtnMenu, "/fxml/waiter/EditorPlaceMenu.fxml");
        });
    }
}
