package com.tcs.ProjetoBancoSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tcs.ProjetoBancoSpring.services.exception.InvestimentoException;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconta;
    @OneToOne
    @JoinColumn(name = "iduser", referencedColumnName = "id", unique = true)
    @JsonIgnoreProperties("conta")
    private User fkIdUser;
    private long conta;
    private long agencia;
    private double saldo;

    public Conta() {
    }

    public Conta(User fkIdUser, long conta, long agencia, double saldo) {
        this.fkIdUser = fkIdUser;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Long getIdconta() {
        return idconta;
    }

    public void setIdconta(Long idconta) {
        this.idconta = idconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public User getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(User fkIdUser) {
        this.fkIdUser = fkIdUser;

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
                ", conta=" + conta  +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", idOrigemUsuario=" + fkIdUser.getId() +
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

    public void validarSaldoParaInvestimento(double valor) {
        if (this.getSaldo() < valor) {
            throw new InvestimentoException("Não possui saldo suficiente para realizar o investimento!");
        }
    }
}
