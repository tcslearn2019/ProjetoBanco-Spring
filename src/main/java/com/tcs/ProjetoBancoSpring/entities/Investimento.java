package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "idconta", referencedColumnName = "idconta")
    private Conta fkIdConta;
    @OneToOne
    @JoinColumn(name = "idTipInv", referencedColumnName = "idinv")
    private TipoInvestimento fkIdTipoInvestimento;
    private double valor;
    private double valorTemp;
    private Date dataResgate;
    private boolean ativo;

    public Investimento() {
        this.data = new Date(System.currentTimeMillis());
        this.ativo = true;
    }


    public Investimento(Long id, Date data, Conta fkIdConta, TipoInvestimento fkIdTipoInvestimento, double valor, double valorTemp, Date dataResgate, boolean ativo) {
        this.id = id;
        this.data = data;
        this.fkIdConta = fkIdConta;
        this.fkIdTipoInvestimento = fkIdTipoInvestimento;
        this.valor = valor;
        this.valorTemp = valorTemp;
        this.dataResgate = dataResgate;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getFkIdConta() {
        return fkIdConta;
    }

    public void setFkIdConta(Conta fkIdConta) {
        this.fkIdConta = fkIdConta;
    }

    public TipoInvestimento getFkIdTipoInvestimento() {
        return fkIdTipoInvestimento;
    }

    public void setFkIdTipoInvestimento(TipoInvestimento fkIdTipoInvestimento) {
        this.fkIdTipoInvestimento = fkIdTipoInvestimento;
    }

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
                "id=" + id +
                ", data=" + data +
                ", fkIdConta=" + fkIdConta +
                ", fkIdTipoInvestimento=" + fkIdTipoInvestimento +
                ", valor=" + valor +
                ", valorTemp=" + valorTemp +
                ", ativo=" + ativo +
                '}';
    }


}
