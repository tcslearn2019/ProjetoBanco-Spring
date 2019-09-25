package com.tcs.ProjetoBancoSpring.entities;

import java.util.Date;

public class RetornoMovimentacao {
    private long agenciaOrigem;
    private long agenciaDestino;
    private long contaOrigem;
    private long contaDestino;
    private double valor;
    private Date dataTransferencia;

    public RetornoMovimentacao(){

    }

    public RetornoMovimentacao(long agenciaOrigem, long agenciaDestino, long contaOrigem, long contaDestino, double valor, Date dataTransferencia) {
        this.agenciaOrigem = agenciaOrigem;
        this.agenciaDestino = agenciaDestino;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
    }

    public RetornoMovimentacao(Transferencias transferencias) {
        this.agenciaOrigem = transferencias.getContaOrigem().getAgencia();
        this.agenciaDestino = transferencias.getContaDestino().getAgencia();
        this.contaOrigem = transferencias.getContaOrigem().getConta();
        this.contaDestino = transferencias.getContaDestino().getConta();
        this.valor = transferencias.getValor();
        this.dataTransferencia = transferencias.getDataTransferencia();
    }

    public long getAgenciaOrigem() {
        return agenciaOrigem;
    }

    public void setAgenciaOrigem(long agenciaOrigem) {
        this.agenciaOrigem = agenciaOrigem;
    }

    public long getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(long agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }





}
