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
<<<<<<< HEAD
<<<<<<< HEAD
    @OneToOne(mappedBy = "fkIdUser")
    @JsonIgnoreProperties("fkIdUser")
    private Conta conta;
=======
    private String rg;
>>>>>>> origin/Guilherme
=======
    private String rg;
    private boolean administrador;
    @OneToOne(mappedBy = "fkIdUser")
    @JsonIgnoreProperties("fkIdUser")
    private Conta conta;
>>>>>>> origin/Guilherme

    public User() {

    }

    public User(String fname, String lname, String cpf, String pwd, String email, String tel, String rg, boolean administrador) {
        this.fname = fname;
        this.lname = lname;
        this.cpf = cpf;
        this.pwd = pwd;
        this.email = email;
        this.tel = tel;
        this.rg = rg;
        this.administrador = administrador;
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

<<<<<<< HEAD
<<<<<<< HEAD
=======
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

>>>>>>> origin/Guilherme
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
<<<<<<< HEAD
=======
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
>>>>>>> origin/Guilherme
=======
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
>>>>>>> origin/Guilherme
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
                ", rg='" + rg + '\'' +
                ", administrador=" + administrador +
                ", conta=" + conta +
                '}';
    }


}
