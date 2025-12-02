package pe.edu.upc.t_finanzas.dtos;
import pe.edu.upc.t_finanzas.entities.Creditos;

import java.time.LocalDate;

public class IndicadoresFinancierosDTO {
    private int idIndicadoresFinancieros;
    private double van;
    private double tir;
    private double tcea;
    private double trea;
    private double duracion;
    private double duracion_modificada;
    private LocalDate fecha_calculo;
    private Creditos creditos;

    public int getIdIndicadoresFinancieros() {
        return idIndicadoresFinancieros;
    }

    public void setIdIndicadoresFinancieros(int idIndicadoresFinancieros) {
        this.idIndicadoresFinancieros = idIndicadoresFinancieros;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getTir() {
        return tir;
    }

    public void setTir(double tir) {
        this.tir = tir;
    }

    public double getTcea() {
        return tcea;
    }

    public void setTcea(double tcea) {
        this.tcea = tcea;
    }

    public double getTrea() {
        return trea;
    }

    public void setTrea(double trea) {
        this.trea = trea;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getDuracion_modificada() {
        return duracion_modificada;
    }

    public void setDuracion_modificada(double duracion_modificada) {
        this.duracion_modificada = duracion_modificada;
    }


    public LocalDate getFecha_calculo() {
        return fecha_calculo;
    }

    public void setFecha_calculo(LocalDate fecha_calculo) {
        this.fecha_calculo = fecha_calculo;
    }

    public Creditos getCreditos() {
        return creditos;
    }

    public void setCreditos(Creditos creditos) {
        this.creditos = creditos;
    }
}
