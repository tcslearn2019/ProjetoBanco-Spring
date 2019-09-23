package com.tcs.ProjetoBancoSpring.entities;

public class ParamTransf {
    private String agencia;
    private String conta;
    private String valor;
    private String idOrigem;

    public ParamTransf(String agencia, String conta, String valor, String idOrigem) {
        this.agencia = agencia;
        this.conta = conta;
        this.valor = valor;
        this.idOrigem = idOrigem;
    }

    public ParamTransf(){}

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(String idOrigem) {
        this.idOrigem = idOrigem;
    }

}
