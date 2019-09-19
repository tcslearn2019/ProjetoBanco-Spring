package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransferencias;
    private long idContaOrigem;
    private long idContaDestino;
    private long valor;
    private Date dataTransferencia;

    public Transferencias(){

    }

    public Transferencias(long idContaOrigem, long idContaDestino, long valor, Date dataTransferencia) {
        this.idContaOrigem = idContaOrigem;
        this.idContaDestino = idContaDestino;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
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


    public long getIdTransferencias() {
        return idTransferencias;
    }

    public void setIdTransferencias(long idTransferencias) {
        this.idTransferencias = idTransferencias;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }


}
