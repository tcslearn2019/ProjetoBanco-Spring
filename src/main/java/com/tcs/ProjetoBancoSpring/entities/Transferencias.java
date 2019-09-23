package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmprestimo;
    private long idContaOrigem;
    private long idContaDestino;
    private long valor;

    public Transferencias(){

    }

    public Transferencias(long idContaOrigem, long idContaDestino, long valor) {
        this.idContaOrigem = idContaOrigem;
        this.idContaDestino = idContaDestino;
        this.valor = valor;
    }

    public long getIdContaOrigem() {
        return idContaOrigem;
    }

    public void setIdContaOrigem(long idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }

    public long getIdContaDestino() {
        return idContaDestino;
    }

    public void setIdContaDestino(long idContaDestino) {
        this.idContaDestino = idContaDestino;
    }


    public long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }


}
