package pe.edu.upc.t_finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "IndicadoresFinancieros")
public class IndicadoresFinancieros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIndicadoresFinancieros;
    @Column(name = "van", nullable = false)
    private double van;
    @Column(name = "tir", nullable = false)
    private double tir;
    @Column(name = "tcea", nullable = false)
    private double tcea;
    @Column(name = "trea", nullable = false)
    private double trea;
    @Column(name = "duracion", nullable = false)
    private double duracion;
    @Column(name = "duracion_modificada", nullable = false)
    private double duracion_modificada;

    @Column(name = "fecha_calculo", nullable = false)
    private LocalDate fecha_calculo;

    @ManyToOne
    @JoinColumn(name = "idCreditos")
    private Creditos creditos;

    public IndicadoresFinancieros() {
    }

    public IndicadoresFinancieros(int idIndicadoresFinancieros, double van, double tir, double tcea, double trea, double duracion, double duracion_modificada, LocalDate fecha_calculo, Creditos creditos) {
        this.idIndicadoresFinancieros = idIndicadoresFinancieros;
        this.van = van;
        this.tir = tir;
        this.tcea = tcea;
        this.trea = trea;
        this.duracion = duracion;
        this.duracion_modificada = duracion_modificada;
        this.fecha_calculo = fecha_calculo;
        this.creditos = creditos;
    }

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
