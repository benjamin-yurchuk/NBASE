package com.nbase.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import com.nbase.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignInControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button oneButtonSignIn;

    @FXML
    private Button twoButtonSignIn;

    @FXML
    private Button threeButtonSignIn;

    @FXML
    private Button fourButtonSignIn;

    @FXML
    private Button fiveButtonSignIn;

    @FXML
    private Button sixButtonSignIn;

    @FXML
    private Button sevenButtonSignIn;

    @FXML
    private Button eightButtonSignIn;

    @FXML
    private Button nineButtonSignIn;

    @FXML
    private PasswordField passwordFieldsignIn;

    @FXML
    private Button loginButtonSignIn;

    @FXML
    private Button zeroButtonSignIn;

    @FXML
    private Button cleanButtonSignIn;

    @FXML
    private Label wrongPasswordSignIn;

    @FXML
    void initialize() {

        AtomicReference<String> textSignIn = new AtomicReference<>("");

        oneButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "1");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        twoButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "2");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        threeButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "3");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        fourButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "4");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        fiveButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "5");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        sixButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "6");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        sevenButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "7");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        eightButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "8");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        nineButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "9");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        zeroButtonSignIn.setOnAction( event -> {
            textSignIn.set(textSignIn.get() + "0");
            passwordFieldsignIn.setText(textSignIn.get());
        });

        cleanButtonSignIn.setOnAction( event -> {
            textSignIn.set("");
            passwordFieldsignIn.setText(textSignIn.get());
            wrongPasswordSignIn.setText("");
        });

        loginButtonSignIn.setOnAction( event -> {
            authSignIn();
        });

    }

    //Виклик методу перевірки з DataBase та направлення на меню
    private void authSignIn() {

        int k;

        DataBase dataBase = new DataBase();
        k = dataBase.checkUserRole(passwordFieldsignIn);

        if (k == 1) {
            loginButtonSignIn.getScene().getWindow().hide();

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
        }if (k == 3) {
            loginButtonSignIn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/waiterMenu.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();
        }if (k == 0) {
            wrongPasswordSignIn.setText("Неправильний пароль");
        }if (passwordFieldsignIn.getText().equals("")) {
            wrongPasswordSignIn.setText("Введіть пароль");
        }
    }


}


