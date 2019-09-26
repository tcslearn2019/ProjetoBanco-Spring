package com.tcs.ProjetoBancoSpring.entities;

import javax.persistence.*;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    @OneToOne
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private User fkIdUser;
    private String dataEmprestimo;
    private Double juros;
    private Double valorEmprestimo;
    private Double valorPagar;
    private Boolean pago;
    private String dataPagamento;


    public Emprestimo(){

    }

    public Emprestimo(User fkIdUser, String dataEmprestimo, Double juros, Double valorEmprestimo, Boolean pago) {
        this.fkIdUser = fkIdUser;
        this.dataEmprestimo = dataEmprestimo;
        this.juros = juros;
        this.valorEmprestimo = valorEmprestimo;
        this.valorPagar = valorEmprestimo;
        this.pago = pago;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public User getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(User fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", fkIdUser=" + fkIdUser +
                ", dataEmprestimo=" + dataEmprestimo +
                ", juros=" + juros +
                ", valorEmprestimo=" + valorEmprestimo +
                '}';
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
