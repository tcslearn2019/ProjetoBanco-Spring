package com.tcs.ProjetoBancoSpring.entities;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Conta {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long idconta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduser", referencedColumnName = "id", unique = true)
    private User fk_iduser;
    private long conta;
    private long agencia;
    private long saldo;

    public Conta() {
    }

    public Conta(User fk_iduser, long conta, long agencia, long saldo) {
        this.fk_iduser = fk_iduser;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public User getIduser() {
        return fk_iduser;
    }

    public void setIduser(User iduser) {
        this.fk_iduser = iduser;
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

    public long getIdAgencia() {
        return agencia;
    }

    public void setIdAgencia(long agencia) {
        this.agencia = agencia;
    }

    public long getConta() {
        return conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }


    @Override
    public String toString() {
        return "Conta{" +
                "idconta=" + idconta +
                ", conta=" + conta  +
                ", agencia=" +
                '}';
    }


}
