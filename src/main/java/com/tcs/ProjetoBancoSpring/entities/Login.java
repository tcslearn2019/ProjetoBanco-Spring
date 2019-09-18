package com.tcs.ProjetoBancoSpring.entities;

public class Login {
    private String login;
    private String pwd;

    public Login(){

    }

    public Login(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
