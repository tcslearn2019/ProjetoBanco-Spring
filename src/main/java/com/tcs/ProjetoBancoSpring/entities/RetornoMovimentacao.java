package com.tcs.ProjetoBancoSpring.entities;

public class RetornoMovimentacao {
    private Long agenciaOrigem;
    private Long agenciaDestino;
    private Long contaOrigem;
    private Long contaDestino;
    private Double valor;
    private String dataTransferencia;

    public RetornoMovimentacao(){

    }

    public RetornoMovimentacao(Long agenciaOrigem, Long agenciaDestino, Long contaOrigem, Long contaDestino, double valor, String dataTransferencia) {
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

    public Long getAgenciaOrigem() {
        return agenciaOrigem;
    }

    public void setAgenciaOrigem(Long agenciaOrigem) {
        this.agenciaOrigem = agenciaOrigem;
    }

    public Long getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(Long agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public Long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(String dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }





}
