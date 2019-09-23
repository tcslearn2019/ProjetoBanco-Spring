package com.tcs.ProjetoBancoSpring.entities;

public class ParamInvestimento {
    private String valor;
    private long idInvestimento;

    public ParamInvestimento(long idInvestimento, String valor) {
        this.idInvestimento = idInvestimento;
        this.valor = valor;
    }

    public long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
