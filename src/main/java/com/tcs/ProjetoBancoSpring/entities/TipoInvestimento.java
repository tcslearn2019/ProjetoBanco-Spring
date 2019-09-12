package com.tcs.ProjetoBancoSpring.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoInvestimento {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long idinv;
    private String nome;
    private double juros;

    public TipoInvestimento() {
    }

    public TipoInvestimento(String nome, double juros) {
        this.nome = nome;
        this.juros = juros;
    }

    public long getIdinv() {
        return idinv;
    }

    public void setIdinv(long idinv) {
        this.idinv = idinv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    @Override
    public String toString() {
        return "TipoIvestimento{" +
                "idinv=" + idinv +
                ", nome='" + nome + '\'' +
                ", juros=" + juros +
                '}';
    }
}
