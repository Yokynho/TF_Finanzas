package pe.edu.upc.t_finanzas.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cuotas")
public class Cuotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuotas;

    @Column(name = "numero_cuota")
    private int numeroCuota;

    @Column(name = "tep")
    private double tep;

    @Column(name = "plazo_gracia")
    private String plazo_gracia;

    @Column(name = "saldo_inicial")
    private double saldo_inicial;

    @Column(name = "interes", nullable = false)
    private double interes;

    @Column(name = "cuota", nullable = false)
    private double cuota;

    @Column(name = "amortizacion")
    private double amortizacion;

    @Column(name = "seguros")
    private double seguros;

    @Column(name = "seguro_riesgo")
    private double seguro_riesgo;
    @Column(name = "comision_periodica")
    private double comision_periodica;
    @Column(name = "portes")
    private double portes;
    @Column(name = "gastos_admin")
    private double gastos_admin;

    @Column(name = "saldo_final")
    private double saldo_final;

    @Column(name = "flujo")
    private double flujo;

    @Column(name = "van")
    private double van;

    @Column(name = "tir")
    private double tir;
    @Column(name = "tcea")
    private double tcea;



    @ManyToOne
    @JoinColumn(name = "idCreditos")
    private Creditos creditos;

    public Cuotas() {
    }

    public Cuotas(int idCuotas, int numeroCuota, double tep, String plazo_gracia, double saldo_inicial, double interes, double cuota, double amortizacion, double seguros, double seguro_riesgo, double comision_periodica, double portes, double gastos_admin, double saldo_final, double flujo, double van, double tir, double tcea, Creditos creditos) {
        this.idCuotas = idCuotas;
        this.numeroCuota = numeroCuota;
        this.tep = tep;
        this.plazo_gracia = plazo_gracia;
        this.saldo_inicial = saldo_inicial;
        this.interes = interes;
        this.cuota = cuota;
        this.amortizacion = amortizacion;
        this.seguros = seguros;
        this.seguro_riesgo = seguro_riesgo;
        this.comision_periodica = comision_periodica;
        this.portes = portes;
        this.gastos_admin = gastos_admin;
        this.saldo_final = saldo_final;
        this.flujo = flujo;
        this.van = van;
        this.tir = tir;
        this.tcea = tcea;
        this.creditos = creditos;
    }

    public int getIdCuotas() {
        return idCuotas;
    }

    public void setIdCuotas(int idCuotas) {
        this.idCuotas = idCuotas;
    }

    public double getTcea() {
        return tcea;
    }

    public void setTcea(double tcea) {
        this.tcea = tcea;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getTep() {
        return tep;
    }

    public void setTep(double tep) {
        this.tep = tep;
    }

    public String getPlazo_gracia() {
        return plazo_gracia;
    }

    public void setPlazo_gracia(String plazo_gracia) {
        this.plazo_gracia = plazo_gracia;
    }

    public double getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public double getSeguros() {
        return seguros;
    }

    public void setSeguros(double seguros) {
        this.seguros = seguros;
    }

    public double getSeguro_riesgo() {
        return seguro_riesgo;
    }

    public void setSeguro_riesgo(double seguro_riesgo) {
        this.seguro_riesgo = seguro_riesgo;
    }

    public double getTir() {
        return tir;
    }

    public void setTir(double tir) {
        this.tir = tir;
    }

    public double getComision_periodica() {
        return comision_periodica;
    }

    public void setComision_periodica(double comision_periodica) {
        this.comision_periodica = comision_periodica;
    }

    public double getPortes() {
        return portes;
    }

    public void setPortes(double portes) {
        this.portes = portes;
    }

    public double getGastos_admin() {
        return gastos_admin;
    }

    public void setGastos_admin(double gastos_admin) {
        this.gastos_admin = gastos_admin;
    }

    public double getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(double saldo_final) {
        this.saldo_final = saldo_final;
    }

    public double getFlujo() {
        return flujo;
    }

    public void setFlujo(double flujo) {
        this.flujo = flujo;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public Creditos getCreditos() {
        return creditos;
    }

    public void setCreditos(Creditos creditos) {
        this.creditos = creditos;
    }


}
