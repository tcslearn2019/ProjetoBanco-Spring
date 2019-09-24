package com.tcs.ProjetoBancoSpring.entities;

import com.tcs.ProjetoBancoSpring.services.exception.InvestimentoException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idinvenstimento;
    private Date data;
    @ManyToOne
    @JoinColumn(name="idconta", referencedColumnName = "idconta")
    private Conta fkIdConta;
    @OneToOne
    @JoinColumn(name = "idTipInv", referencedColumnName = "idinv")
    private TipoInvestimento fkIdTipoInvestimento;
    private double valor;
    private double valorTemp;
    private Date dataResgate;
    private boolean ativo;

    public Investimento() {
    }

    public Investimento(Date data,Conta fkIdConta,TipoInvestimento fkIdTipoInvestimento,double valor, double valorTemp, boolean ativo) {
        this.data = data;
        this.fkIdConta = fkIdConta;
        this.fkIdTipoInvestimento = fkIdTipoInvestimento;
        this.valor = valor;
        this.valorTemp = valorTemp;
        this.ativo = ativo;
    }

    public long getIdinvenstimento() {
        return idinvenstimento;
    }

    public void setIdinvenstimento(long idinvenstimento) {
        this.idinvenstimento = idinvenstimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getFkIdConta() { return fkIdConta; }

    public void setFkIdConta(Conta fkIdConta) { this.fkIdConta = fkIdConta; }

    public TipoInvestimento getFkIdTipoInvestimento() { return fkIdTipoInvestimento; }

    public void setFkIdTipoInvestimento(TipoInvestimento fkIdTipoInvestimento) { this.fkIdTipoInvestimento = fkIdTipoInvestimento; }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorTemp() {
        return valorTemp;
    }

    public void setValorTemp(double valorTemp) {
        this.valorTemp = valorTemp;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(Date dataResgate) {
        this.dataResgate = dataResgate;
    }

    @Override
    public String toString() {
        return "Investimento{" +
                "idinvenstimento=" + idinvenstimento +
                ", data=" + data +
                ", fkIdConta=" + fkIdConta +
                ", fkIdTipoInvestimento=" + fkIdTipoInvestimento +
                ", valor=" + valor +
                ", valorTemp=" + valorTemp +
                ", ativo=" + ativo +
                '}';
    }

    public void validateRefound(Double valorRefound) {
        if (this.getValorTemp() < valorRefound) {
            throw new InvestimentoException("Não possui saldo suficiente para receber o valor do investimento!");
        }
    }
}
