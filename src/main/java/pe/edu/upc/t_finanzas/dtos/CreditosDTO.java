package pe.edu.upc.t_finanzas.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.t_finanzas.entities.EntidadesFinancieras;
import pe.edu.upc.t_finanzas.entities.Inmuebles;
import pe.edu.upc.t_finanzas.entities.Usuarios;

import java.time.LocalDate;

public class CreditosDTO {
    private int idCreditos;
    private double cuota_inicial;
    private double monto_financiar;
    private int plazo;
    private String tipo_taza;
    private double valor_taza;
    private String capitalizacion;
    private String tipo_periodo_gracia;
    private int periodo_gracia;
    private LocalDate fecha_desembolso;
    private String estado;

    private Usuarios usuario;

    private Inmuebles inmuebles;

    private EntidadesFinancieras entidades;

    public int getIdCreditos() {
        return idCreditos;
    }

    public void setIdCreditos(int idCreditos) {
        this.idCreditos = idCreditos;
    }

    public double getCuota_inicial() {
        return cuota_inicial;
    }

    public void setCuota_inicial(double cuota_inicial) {
        this.cuota_inicial = cuota_inicial;
    }

    public double getMonto_financiar() {
        return monto_financiar;
    }

    public void setMonto_financiar(double monto_financiar) {
        this.monto_financiar = monto_financiar;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getTipo_taza() {
        return tipo_taza;
    }

    public void setTipo_taza(String tipo_taza) {
        this.tipo_taza = tipo_taza;
    }

    public double getValor_taza() {
        return valor_taza;
    }

    public void setValor_taza(double valor_taza) {
        this.valor_taza = valor_taza;
    }

    public String getCapitalizacion() {
        return capitalizacion;
    }

    public void setCapitalizacion(String capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public String getTipo_periodo_gracia() {
        return tipo_periodo_gracia;
    }

    public void setTipo_periodo_gracia(String tipo_periodo_gracia) {
        this.tipo_periodo_gracia = tipo_periodo_gracia;
    }

    public int getPeriodo_gracia() {
        return periodo_gracia;
    }

    public void setPeriodo_gracia(int periodo_gracia) {
        this.periodo_gracia = periodo_gracia;
    }

    public LocalDate getFecha_desembolso() {
        return fecha_desembolso;
    }

    public void setFecha_desembolso(LocalDate fecha_desembolso) {
        this.fecha_desembolso = fecha_desembolso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Inmuebles getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(Inmuebles inmuebles) {
        this.inmuebles = inmuebles;
    }

    public EntidadesFinancieras getEntidades() {
        return entidades;
    }

    public void setEntidades(EntidadesFinancieras entidades) {
        this.entidades = entidades;
    }
}
