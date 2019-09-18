package com.tcs.ProjetoBancoSpring.entities;

public class ParamTransf {
    public long getAgencia() {
        return Agencia;
    }

    public void setAgencia(long agencia) {
        Agencia = agencia;
    }

    public long getConta() {
        return Conta;
    }

    public void setConta(long conta) {
        Conta = conta;
    }

    public long getValor() {
        return Valor;
    }

    public void setValor(long valor) {
        Valor = valor;
    }

    public ParamTransf(long agencia, long conta, long valor) {
        Agencia = agencia;
        Conta = conta;
        Valor = valor;
    }

    public ParamTransf(){}

    private long Agencia;
    private long Conta;
    private long Valor;
}
