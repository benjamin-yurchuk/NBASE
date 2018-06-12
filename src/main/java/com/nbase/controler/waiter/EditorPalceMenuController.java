package com.nbase.controler.waiter;

import java.net.URL;
import java.util.ResourceBundle;

import com.nbase.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class EditorPalceMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnPlace1;

    @FXML
    private Button BtnMenu;

    @FXML
    private Button BtnExit;

    @FXML
    private AnchorPane btnEditTable;

    @FXML
    private AnchorPane ReportDiscont;

    @FXML
    private AnchorPane ZReport;

    @FXML
    private AnchorPane XReport;
    Loader loader = new Loader();

    @FXML
    void initialize() {
        BtnExit.setOnAction(event -> {
            loader.layoutMenuLink(BtnExit, "/fxml/signIn.fxml");
        });
        btnPlace1.setOnAction(event -> {
            loader.layoutMenuLink(btnPlace1, "/fxml/waiter/PlaceMenu.fxml");
        });
    }
}
