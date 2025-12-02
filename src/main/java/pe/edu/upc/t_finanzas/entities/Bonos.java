package pe.edu.upc.t_finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Bonos")
public class Bonos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBonos;
    @Column(name = "tipo_bono", nullable = false)
    private String tipo_bono;
    @Column(name = "monto_bono", nullable = false)
    private double monto_bono;
    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDate fecha_aplicacion;

    @ManyToOne
    @JoinColumn(name = "idCreditos")
    private Creditos creditos;

    public Bonos() {
    }

    public Bonos(int idBonos, String tipo_bono, double monto_bono, LocalDate fecha_aplicacion, Creditos creditos) {
        this.idBonos = idBonos;
        this.tipo_bono = tipo_bono;
        this.monto_bono = monto_bono;
        this.fecha_aplicacion = fecha_aplicacion;
        this.creditos = creditos;
    }

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
