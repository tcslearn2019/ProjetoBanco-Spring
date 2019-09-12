package com.tcs.ProjetoBancoSpring.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Investimento {
    @Id
    @GeneratedValue
    private long idinvenstimento;
    private Date data;
    private double valor;
    private long idusuario;
    private long idtipoinv;

    public Investimento() {
    }

    public Investimento(long idinvenstimento, Date data, double valor, long idusuario, long idtipoinv) {
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
