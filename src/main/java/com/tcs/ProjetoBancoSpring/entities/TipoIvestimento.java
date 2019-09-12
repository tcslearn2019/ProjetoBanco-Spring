package com.tcs.ProjetoBancoSpring.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoIvestimento {
    @Id
    @GeneratedValue
    private long idinv;
    private String nome;
    private double juros;

    public TipoIvestimento() {
    }

    public TipoIvestimento(long idinv, String nome, double juros) {
        this.idinv = idinv;
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
