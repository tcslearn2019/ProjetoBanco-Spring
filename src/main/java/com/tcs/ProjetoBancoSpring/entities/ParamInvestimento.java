package com.tcs.ProjetoBancoSpring.entities;

public class ParamInvestimento {
    private Double juros;
    private String nome;
    private Long idinv;
    private Double valor;
    private Long iduser;

    public ParamInvestimento(){
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }


    @Override
    public String toString() {
        return "ParamInvestimento{" +
                "juros=" + juros +
                ", nome='" + nome + '\'' +
                ", idinv=" + idinv +
                ", valor=" + valor +
                ", iduser=" + iduser +
                '}';
    }

}
