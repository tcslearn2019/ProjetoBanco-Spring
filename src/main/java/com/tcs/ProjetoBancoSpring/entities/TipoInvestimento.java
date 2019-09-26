package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoInvestimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idinv;
    private String nome;
    private Double juros;
    private Boolean ativo;

    public TipoInvestimento() {
    }

    public TipoInvestimento(String nome, Double juros, Boolean ativo) {
        this.nome = nome;
        this.juros = juros;
        this.ativo = ativo;
    }

    public Long getIdinv() {
        return idinv;
    }

    public void setIdinv(Long idinv) {
        this.idinv = idinv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "TipoInvestimento{" +
                "idinv=" + idinv +
                ", nome='" + nome + '\'' +
                ", juros=" + juros +
                ", ativo=" + ativo +
                '}';
    }
}
