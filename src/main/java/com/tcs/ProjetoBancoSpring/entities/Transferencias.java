package com.tcs.ProjetoBancoSpring.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transferencias {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long idemprestimo;
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


    public long getIdemprestimo() {
        return idemprestimo;
    }

    public void setIdemprestimo(long idemprestimo) {
        this.idemprestimo = idemprestimo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }


}
