package com.nbase.controler.admin;

import com.nbase.DataBase;
import com.nbase.Loader;
import com.nbase.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.Optional;

public class AdminMenuSetUpControler {

    @FXML
    private Button BtnExit;

    @FXML
    private Button ButtonAddUser;

    @FXML
    private Button ButtonSetUpUser;

    @FXML
    private TableView<Users> tableUser;

    @FXML
    private Button BtnEditUsers;

    @FXML
    private Button BtnDeleteUsers;


    private DataBase dataBase = new DataBase();


    @FXML
    void initialize() {
        Loader loader = new Loader();
        CreateTable();
        FillData();

        ButtonAddUser.setOnAction(event -> {
            loader.layoutMenuLink(ButtonSetUpUser, "/fxml/admin/adminMenuAddUser.fxml");
        });


        BtnExit.setOnAction(event -> {
            loader.layoutMenuLink(BtnExit, "/fxml/signIn.fxml");
        });
        BtnDeleteUsers.setOnAction(event -> {
            //треба пофиксити цю тему
            delButtonClicked();
//            if (){
//
//                delButtonClicked();
//            } else{
//
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Error Dialog");
//                alert.setHeaderText("Помилка");
//                alert.setContentText("Виберіть користувача");
//
//                alert.showAndWait();
//            }
        });


    }


    private void delButtonClicked() {
        ObservableList<Users> productSelected , allProduct ;

        allProduct = tableUser.getItems();
        productSelected = tableUser.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setWidth(300);
        alert.setHeaderText("Підтвердіть");
        alert.setContentText("Ви впевнені що хочете видалит " + productSelected.get(0).getFirstname() +" "+ productSelected.get(0).getLastname());

        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setTitle("Information Dialog");
                al.setHeaderText(null);
                al.setContentText("Користувач " + productSelected.get(0).getFirstname() +" "+ productSelected.get(0).getLastname() + " був видалений");

                dataBase.deleteUser(productSelected.get(0).getLogin());
                productSelected.forEach(allProduct::remove);

                al.showAndWait();
            }if(result.get() == ButtonType.CANCEL){
                alert.close();
            }


    }


    /// треба вставити в таблицю всіх Юзерів
    private void CreateTable() {

        TableColumn<Users , String> name_column = new TableColumn<>("First Name");
        name_column.setMinWidth(50);
        name_column.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Users , String> lastname_column = new TableColumn<>("Last Name");
        lastname_column.setMinWidth(50);
        lastname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        TableColumn<Users , String> shortname_column = new TableColumn<>("ShortName");
        shortname_column.setMinWidth(50);
        shortname_column.setCellValueFactory(new PropertyValueFactory<>("shortname"));

        TableColumn<Users , String> login_column = new TableColumn<>("Login");
        login_column.setMinWidth(50);
        login_column.setCellValueFactory(new PropertyValueFactory<>("login"));

        TableColumn<Users , String> password_column = new TableColumn<>("Password");
        password_column.setMinWidth(50);
        password_column.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<Users , String> role_column = new TableColumn<>("Users Role");
        role_column.setMinWidth(50);
        role_column.setCellValueFactory(new PropertyValueFactory<>("users_role"));

        // тут є проблема з додаванням ролевої колонки тому це в майбутнбому треба пофіксити

        tableUser.getColumns().addAll(name_column,lastname_column,shortname_column,login_column,password_column);

    }
    private void FillData(){
        tableUser.setItems(getUsersDataForFillToTable());
    }

    private ObservableList<Users> getUsersDataForFillToTable() {

        //from data to list
        ObservableList<Users> list = FXCollections.observableArrayList();
        String Select = "SELECT * FROM Users";
        ResultSet result;

        try {
            PreparedStatement ps = dataBase.getConnection().prepareStatement(Select);

            result = ps.executeQuery();

                while (result.next()){
                    String firstname = result.getString("firstname");
                    String lastname = result.getString("lastname");
                    String shortname = result.getString("shortname");
                    String login = result.getString("login");
                    String password = result.getString("password");
                    String users_role = result.getString("users_role");



                    list.add(new Users(firstname,lastname,shortname,login,password,users_role));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}




