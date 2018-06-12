package com.nbase.controler.waiter;

import java.net.URL;
import java.util.ResourceBundle;

import com.nbase.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WaiterWorkSpaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnExit;

    Loader loader = new Loader();
    @FXML
    void initialize() {
        btnExit.setOnAction(event -> {
            loader.layoutMenuLink(btnExit, "/fxml/waiter/PlaceMenu.fxml");
        });
    }
}
