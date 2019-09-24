package com.tcs.ProjetoBancoSpring.entities;

public class ParamInvestimento {
    private double juros;
    private String nome;
    private Long idinv;
    private double valor;
    private Long iduser;

    public ParamInvestimento(){
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public Long getIdinv() {
        return idinv;
    }

    public void setIdinv(Long idinv) {
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

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
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
