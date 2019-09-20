package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduser", referencedColumnName = "id", unique = true)
    private User fkIdUser;
    private long conta;
    private long agencia;
    private long saldo;

    public Conta() {
    }

    public Conta(User fkIdUser, long conta, long agencia, long saldo) {
        this.fkIdUser = fkIdUser;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public User getIduser() {
        return fkIdUser;
    }

    public void setIduser(User iduser) {
        this.fkIdUser = iduser;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public Long getIdconta() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return idconta == conta.idconta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idconta);
    }
}
