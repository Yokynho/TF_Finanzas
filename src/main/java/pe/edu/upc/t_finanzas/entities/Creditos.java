package pe.edu.upc.t_finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Creditos")
public class Creditos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCreditos;
    @Column(name = "cuota_inicial", nullable = false)
    private double cuota_inicial;
    @Column(name = "monto_financiar", nullable = false)
    private double monto_financiar;
    @Column(name = "plazo", nullable = false)
    private int plazo;
    @Column(name = "tipo_taza", nullable = false)
    private String tipo_taza;
    @Column(name = "valor_taza", nullable = false)
    private double valor_taza;
    @Column(name = "capitalizacion",nullable = false)
    private String capitalizacion;
    @Column(name = "tipo_periodo_gracia", nullable = false)
    private String tipo_periodo_gracia;
    @Column(name = "periodo_gracia", nullable = false)
    private int periodo_gracia;
    @Column(name = "fecha_desembolso", nullable = false)
    private LocalDate fecha_desembolso;
    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idUsuarios")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "idInmuebles")
    private Inmuebles inmuebles;

    @ManyToOne
    @JoinColumn(name = "idEntidadFinanciera")
    private EntidadesFinancieras entidades;

    public Creditos() {
    }

    public Creditos(int idCreditos, double cuota_inicial, double monto_financiar, int plazo, String tipo_taza, double valor_taza, String capitalizacion, String tipo_periodo_gracia, int periodo_gracia, LocalDate fecha_desembolso, String estado, Usuarios usuario, Inmuebles inmuebles, EntidadesFinancieras entidades) {
        this.idCreditos = idCreditos;
        this.cuota_inicial = cuota_inicial;
        this.monto_financiar = monto_financiar;
        this.plazo = plazo;
        this.tipo_taza = tipo_taza;
        this.valor_taza = valor_taza;
        this.capitalizacion = capitalizacion;
        this.tipo_periodo_gracia = tipo_periodo_gracia;
        this.periodo_gracia = periodo_gracia;
        this.fecha_desembolso = fecha_desembolso;
        this.estado = estado;
        this.usuario = usuario;
        this.inmuebles = inmuebles;
        this.entidades = entidades;
    }

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
