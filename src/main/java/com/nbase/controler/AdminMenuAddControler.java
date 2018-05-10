package com.nbase.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.nbase.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminMenuAddControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonAddUser;

    @FXML
    private Button ButtonDeleteUser;

    @FXML
    private Button ButtonChangeUser;

    @FXML
    private Button ButtonShowUser;

    @FXML
    private TextField NameOfUserField;

    @FXML
    private TextField LastNameOfUserField;

    @FXML
    private TextField LoginOfUserField;

    @FXML
    private PasswordField PasswordOfUserField;

    @FXML
    private TextField ShortNameOfUserField;

    @FXML
    private ChoiceBox<String> RoleOfUserField;

    @FXML
    private Button InsertNewUserToDataBase;

    @FXML
    void initialize() {

        InsertNewUserToDataBase.setOnAction(event ->
            addNewUser()
        );

        RoleOfUserField.getItems().addAll("Адміністратор", "Менеджер", "Офіціант");
        RoleOfUserField.getSelectionModel().select(2);

    }

    private void addNewUser() {
        DataBase dataBase = new DataBase();

        String role = "";

        if (RoleOfUserField.getValue().equals("Адміністратор")) {
            role = "admin";
        }if (RoleOfUserField.getValue().equals("Менеджер")) {
            role = "manager";
        }if (RoleOfUserField.getValue().equals("Офіціант")) {
            role = "waiter";
        }

        dataBase.addUser(NameOfUserField, LastNameOfUserField, ShortNameOfUserField, LoginOfUserField, PasswordOfUserField, role);
        System.out.println("User added");

    }

    private void ConfirmWindow(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/adminMenuAddUser.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.showAndWait();
    }



}