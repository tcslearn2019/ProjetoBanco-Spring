package com.tcs.ProjetoBancoSpring.entities;

public class ParamEmprestimo {
    private String idOrigem;
    private String valor;

    public String getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(String idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ParamEmprestimo(){

    }

    public ParamEmprestimo(String idOrigem, String valor) {
        this.idOrigem = idOrigem;
        this.valor = valor;
    }



}
