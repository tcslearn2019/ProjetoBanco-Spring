package com.tcs.ProjetoBancoSpring.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long idconta;
    private long iduser;
    private long conta;
    private long agencia;
    private long saldo;

    public Conta() {
    }

    public Conta(long iduser, long conta, long agencia, long saldo) {
        this.iduser = iduser;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
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
