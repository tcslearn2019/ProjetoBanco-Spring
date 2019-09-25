package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransferencias;
    private double valor;
    private Date dataTransferencia;

    @ManyToOne
    @JoinColumn(name = "conta_origem_fk")
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino_fk")
    private Conta contaDestino;

    public Transferencias(){
    }

    public Transferencias(double valor, Date dataTransferencia, Conta contaOrigem, Conta contaDestino) {
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public long getIdTransferencias() {
        return idTransferencias;
    }

    public void setIdTransferencias(long idTransferencias) {
        this.idTransferencias = idTransferencias;
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

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }
}
