package pe.edu.upc.t_finanzas.dtos;

import jakarta.persistence.Column;

public class InmueblesDTO {
    private int idInmuebles;
    private String descripcion;
    private String direccion;
    private String distrito;
    private String provincia;
    private double precio_venta;
    private String moneda;
    private double area_construida;
    private int n_habitaciones;
    private int n_banios;
    private String estado;
    private String tipoVivienda;
    private Boolean aplicaBonoTP;
    private boolean aplicaBonoBP;
    private Boolean viviendaSostenible;
    private String programa;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdInmuebles() {
        return idInmuebles;
    }

    public void setIdInmuebles(int idInmuebles) {
        this.idInmuebles = idInmuebles;
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
