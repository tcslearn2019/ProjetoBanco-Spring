package com.tcs.ProjetoBancoSpring.entities;

public class ParamEmprestimo {
    private Long idOrigem;
    private Double valor;

    public Long getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(Long idOrigem) {
        this.idOrigem = idOrigem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ParamEmprestimo(){

    }
}
