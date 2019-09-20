package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmprestimo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduser", referencedColumnName = "id", unique = false)
    private User fkIdUser;
    private Date dataEmprestimo;
    private double juros;
    private double valorEmprestimo;
    private double valorPagar;


    public Emprestimo(){

    }

    public Emprestimo(User fkIdUser, Date dataEmprestimo, double juros, double valorEmprestimo) {
        this.fkIdUser = fkIdUser;
        this.dataEmprestimo = dataEmprestimo;
        this.juros = juros;
        this.valorEmprestimo = valorEmprestimo;
        this.valorPagar = valorEmprestimo;
    }

    public long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public User getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(User fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", fkIdUser=" + fkIdUser +
                ", dataEmprestimo=" + dataEmprestimo +
                ", juros=" + juros +
                ", valorEmprestimo=" + valorEmprestimo +
                '}';
    }


}
