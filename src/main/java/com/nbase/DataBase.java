package com.nbase;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

public class DataBase {

    private static final String HOST = "jdbc:mysql://db4free.net:3306/nbaseadmin";
    private static final String USERNAME = "nbaseadmin";
    private static final String PASSWORD = "rootroot123";


    Connection connection;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    Users users = new Users();

    /** Метод підключення до Бази даних **/

    public DataBase() {

        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /** Перевіка користувача і присвоєння цифри: Admin = 1, Manager = 2, Waiter = 3 **/

    public int checkUserRole(PasswordField passwordField) {

        String usersRoleAdmin = "admin";
        String usersRoleWaiter = "waiter";

        int usersRole = 0;

        int okUser = 0;
        int good = 0;

        String outputQuery = "SELECT * FROM Users";

        try {
            resultSet = (statement.executeQuery(outputQuery));

            while (good == 0) {

                while (resultSet.next()) {

                    users.setPassword(resultSet.getString("password"));
                    users.setUserRole(resultSet.getString("users_role"));


                    if (passwordField.getText().equals(users.getPassword()) && usersRoleAdmin.equals(users.getUserRole())) {
                        usersRole = 1;
                        okUser++;
                        good++;
                        break;
                    }if (passwordField.getText().equals(users.getPassword()) && usersRoleWaiter.equals(users.getUserRole())) {
                        usersRole = 3;
                        okUser++;
                        good++;
                        break;
                    }
                }

                if (okUser == 0) {
                    good++;
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return usersRole;
    }

    /** Добавляє юзера в таблицю USER **/

    public void addUser(TextField textFieldFirstName, TextField textFieldLastName, TextField textFieldShortName, TextField textFieldLogin, PasswordField passwordField, String roleUser) {

        String inputQuery = "INSERT INTO Users (firstname, lastname, shortname, login, password, users_role) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(inputQuery);

            preparedStatement.setString(1, textFieldFirstName.getText());
            preparedStatement.setString(2, textFieldLastName.getText());
            preparedStatement.setString(3, textFieldShortName.getText());
            preparedStatement.setString(4, textFieldLogin.getText());
            preparedStatement.setString(5, passwordField.getText());
            preparedStatement.setString(6, roleUser);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}