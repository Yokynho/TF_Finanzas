package pe.edu.upc.t_finanzas.dtos;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.t_finanzas.entities.Creditos;

import java.time.LocalDate;

public class CuotasDTO {
    private int idCuotas;

    private int numeroCuota;

    private double tep;

    private String plazo_gracia;

    private double saldo_inicial;

    private double interes;

    private double cuota;

    private double amortizacion;

    private double seguros;

    private double seguro_riesgo;
    private double comision_periodica;
    private double portes;
    private double gastos_admin;

    private double saldo_final;

    private double flujo;

    private double van;

    private double tir;

    private double tcea;

    private Creditos creditos;


    public int getIdCuotas() {
        return idCuotas;
    }

    public void setIdCuotas(int idCuotas) {
        this.idCuotas = idCuotas;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public double getTcea() {
        return tcea;
    }

    public void setTcea(double tcea) {
        this.tcea = tcea;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
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

    public double getTir() {
        return tir;
    }

    public void setTir(double tir) {
        this.tir = tir;
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

    public Creditos getCreditos() {
        return creditos;
    }

    public void setCreditos(Creditos creditos) {
        this.creditos = creditos;
    }
}
