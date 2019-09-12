package com.tcs.ProjetoBancoSpring.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
    @Id
    @GeneratedValue
    private long idconta;
    private long conta;

    public Conta() {
    }

    private long agencia;

    public Conta(long idconta, long conta, long agencia) {
        this.idconta = idconta;
        this.conta = conta;
        this.agencia = agencia;
    }

    public long getIdconta() {
        return idconta;
    }

    public void setIdconta(long idconta) {
        this.idconta = idconta;
    }

    public long getConta() {
        return conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }

    public long getAgencia() {
        return agencia;
    }

    public void setAgencia(long agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "idconta=" + idconta +
                ", conta=" + conta +
                ", agencia=" + agencia +
                '}';
    }


}
