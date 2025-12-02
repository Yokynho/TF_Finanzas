package pe.edu.upc.t_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Inmuebles")
public class Inmuebles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInmuebles;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "distrito", nullable = false)
    private String distrito;
    @Column(name = "provincia", nullable = false)
    private String provincia;
    @Column(name = "precio_venta", nullable = false)
    private double precio_venta;
    @Column(name = "moneda",  nullable = false)
    private String moneda;
    @Column(name = "area_construida", nullable = false)
    private double area_construida;
    @Column(name = "n_habitaciones", nullable = false)
    private int n_habitaciones;
    @Column(name = "n_banios", nullable = false)
    private int n_banios;
    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "aplicaBonoTP", nullable = false)
    private Boolean aplicaBonoTP;
    @Column(name = "aplicaBonoBP", nullable = false)
    private boolean aplicaBonoBP;

    @Column(name = "tipoVivienda", nullable = false)
    private String tipoVivienda; // "Unifamiliar", "Multifamiliar", "Departamento", "Vivienda Comunitaria"

    @Column(name = "viviendaSostenible")
    private Boolean viviendaSostenible;

    // Programa o línea de crédito (opcional)
    @Column(name = "programa", nullable = false)
    private String programa; // "Techo Propio", "MiVivienda", etc.

    public Inmuebles() {
    }

    public Inmuebles(int idInmuebles, String descripcion, String direccion, String distrito, String provincia, double precio_venta, String moneda, double area_construida, int n_habitaciones, int n_banios, String estado, boolean aplicaBonoTP, boolean aplicaBonoBP, String tipoVivienda, Boolean viviendaSostenible, String programa) {
        this.idInmuebles = idInmuebles;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.distrito = distrito;
        this.provincia = provincia;
        this.precio_venta = precio_venta;
        this.moneda = moneda;
        this.area_construida = area_construida;
        this.n_habitaciones = n_habitaciones;
        this.n_banios = n_banios;
        this.estado = estado;
        this.aplicaBonoTP = aplicaBonoTP;
        this.aplicaBonoBP = aplicaBonoBP;
        this.tipoVivienda = tipoVivienda;
        this.viviendaSostenible = viviendaSostenible;
        this.programa = programa;
    }

    public int getIdInmuebles() {
        return idInmuebles;
    }

    public void setIdInmuebles(int idInmuebles) {
        this.idInmuebles = idInmuebles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getArea_construida() {
        return area_construida;
    }

    public void setArea_construida(double area_construida) {
        this.area_construida = area_construida;
    }

    public int getN_habitaciones() {
        return n_habitaciones;
    }

    public void setN_habitaciones(int n_habitaciones) {
        this.n_habitaciones = n_habitaciones;
    }

    public int getN_banios() {
        return n_banios;
    }

    public void setN_banios(int n_banios) {
        this.n_banios = n_banios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getAplicaBonoTP() {
        return aplicaBonoTP;
    }

    public void setAplicaBonoTP(Boolean aplicaBonoTP) {
        this.aplicaBonoTP = aplicaBonoTP;
    }

    public boolean isAplicaBonoBP() {
        return aplicaBonoBP;
    }

    public void setAplicaBonoBP(boolean aplicaBonoBP) {
        this.aplicaBonoBP = aplicaBonoBP;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public Boolean getViviendaSostenible() {
        return viviendaSostenible;
    }

    public void setViviendaSostenible(Boolean viviendaSostenible) {
        this.viviendaSostenible = viviendaSostenible;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
