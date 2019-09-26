package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    @ManyToOne
    @JoinColumn(name = "idconta", referencedColumnName = "idconta")
    private Conta fkIdConta;
    @OneToOne
    @JoinColumn(name = "idTipInv", referencedColumnName = "idinv")
    private TipoInvestimento fkIdTipoInvestimento;
    private Double valor;
    private Double valorTemp;
    private String dataResgate;
    private Boolean ativo;

    public Investimento() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        this.data = dateFormat.format(new Date(System.currentTimeMillis()));
        this.ativo = true;
    }


    public Investimento(Long id, String data, Conta fkIdConta, TipoInvestimento fkIdTipoInvestimento, Double valor, Double valorTemp, String dataResgate, Boolean ativo) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorTemp() {
        return valorTemp;
    }

    public void setValorTemp(Double valorTemp) {
        this.valorTemp = valorTemp;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(String dataResgate) {
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
