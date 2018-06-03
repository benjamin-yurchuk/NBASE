package com.nbase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String HOST = "jdbc:mysql://db4free.net:3306/nbaseadmin";
    private static final String USERNAME = "nbaseadmin";
    private static final String PASSWORD = "rootroot123";


    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

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

    /** Перевіка користувача і присвоєння цифри: admin = 1, manager = 2, waiter = 3 **/

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

    public void addUser(String textFieldFirstName, String textFieldLastName, String textFieldShortName, String textFieldLogin, String passwordField, String roleUser) {

        String inputQuery = "INSERT INTO Users (firstname, lastname, shortname, login, password, users_role) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(inputQuery);

            preparedStatement.setString(1, textFieldFirstName);
            preparedStatement.setString(2, textFieldLastName);
            preparedStatement.setString(3, textFieldShortName);
            preparedStatement.setString(4, textFieldLogin);
            preparedStatement.setString(5, passwordField);
            preparedStatement.setString(6, roleUser);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Видаляє юзера з таблици USER **/

    public void deleteUser(String login) {

        String DELETE = "DELETE FROM Users WHERE login = '"+login+"' " ;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(DELETE);
            System.out.println("Users with this login '" + login + "' was deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** повертає зєднання з Базою **/
    public Connection getConnection() {
        return connection;
    }

}