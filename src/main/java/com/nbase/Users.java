package com.nbase;

public class Users {

    private String firstname;
    private String lastname;
    private String shortname;
    private String login;
    private String password;
    private String usersRole;

    public Users(){

    }

    public Users(String username, String password) {
        this.login = username;
        this.password = password;
    }

    public Users(String firstname, String lastname, String shortname, String login, String password, String usersRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.shortname = shortname;
        this.login = login;
        this.password = password;
        this.usersRole = usersRole;
    }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getShortname() { return shortname; }

    public void setShortname(String shortname) { this.shortname = shortname; }

    public String getLogin() { return login; }

    public void setLogin(String username) { this.login = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUserRole() { return usersRole; }

    public void setUserRole(String userRole) { this.usersRole = userRole; }

}