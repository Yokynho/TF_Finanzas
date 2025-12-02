package pe.edu.upc.t_finanzas.dtos;
import pe.edu.upc.t_finanzas.entities.Creditos;

import java.time.LocalDate;

public class BonosDTO {
    private int idBonos;
    private String tipo_bono;
    private double monto_bono;
    private LocalDate fecha_aplicacion;
    private Creditos creditos;

    public int getIdBonos() {
        return idBonos;
    }

    public void setIdBonos(int idBonos) {
        this.idBonos = idBonos;
    }

    public String getTipo_bono() {
        return tipo_bono;
    }

    public void setTipo_bono(String tipo_bono) {
        this.tipo_bono = tipo_bono;
    }

    public double getMonto_bono() {
        return monto_bono;
    }

    public void setMonto_bono(double monto_bono) {
        this.monto_bono = monto_bono;
    }

    public LocalDate getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(LocalDate fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public Creditos getCreditos() {
        return creditos;
    }

    public void setCreditos(Creditos creditos) {
        this.creditos = creditos;
    }
}
