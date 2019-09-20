package com.tcs.ProjetoBancoSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String cpf;
    private String pwd;
    private String email;
    private String tel;
    @OneToOne(mappedBy = "fkIdUser")
    @JsonIgnoreProperties("fkIdUser")
    private Conta conta;

    public User() {

    }

    public User(String fname, String lname, String cpf, String pwd, String email, String tel) {
        this.fname = fname;
        this.lname = lname;
        this.cpf = cpf;
        this.pwd = pwd;
        this.email = email;
        this.tel = tel;
    }
    public User(Long id, String fname, String lname, String cpf, String pwd, String email, String tel) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.cpf = cpf;
        this.pwd = pwd;
        this.email = email;
        this.tel = tel;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", cpf='" + cpf + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
