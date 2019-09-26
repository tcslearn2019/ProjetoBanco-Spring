package com.tcs.ProjetoBancoSpring.entities;

public class ParamInvestimento {
    private double juros;
    private String nome;
    private long idinv;
    private double valor;
    private long iduser;

    public ParamInvestimento(){

    }

    public ParamInvestimento(double juros, long idinv, String nome, double valor) {
        this.juros = juros;
        this.idinv = idinv;
        this.nome = nome;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }


    @Override
    public String toString() {
        return "ParamInvestimento{" +
                "juros=" + juros +
                ", nome='" + nome + '\'' +
                ", idinv=" + idinv +
                ", valor=" + valor +
                ", iduser=" + iduser +
                '}';
    }

}
