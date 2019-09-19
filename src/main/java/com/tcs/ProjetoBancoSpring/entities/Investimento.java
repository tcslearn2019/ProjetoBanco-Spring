package com.tcs.ProjetoBancoSpring.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idinvenstimento;
    private Date data;
    @JoinColumn(name="idConta", referencedColumnName = "idconta")
    private Conta fkIdConta;
    private double valor;
    private long idusuario;
    private long idtipoinv;

    public Investimento() {
    }

    public Investimento(Date data, double valor, long idusuario, long idtipoinv) {
        this.idinvenstimento = idinvenstimento;
        this.data = data;
        this.valor = valor;
        this.idusuario = idusuario;
        this.idtipoinv = idtipoinv;
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

    public Conta getFkIdConta() {
        return fkIdConta;
    }

    public void setFkIdConta(Conta fkIdConta) {
        this.fkIdConta = fkIdConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public long getIdtipoinv() {
        return idtipoinv;
    }

    public void setIdtipoinv(long idtipoinv) {
        this.idtipoinv = idtipoinv;
    }


    @Override
    public String toString() {
        return "Investimento{" +
                "idinvenstimento=" + idinvenstimento +
                ", data=" + data +
                ", valor=" + valor +
                ", idusuario=" + idusuario +
                ", idtipoinv=" + idtipoinv +
                '}';
    }

}
