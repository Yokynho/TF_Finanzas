package pe.edu.upc.t_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EntidadesFinancieras")
public class EntidadesFinancieras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntidadFinanciera;

    @Column(name = "nombre_entidad", nullable = false)
    private String nombre_entidad;
    @Column(name = "tasa_base", nullable = false)
    private double tasa_base;
    @Column(name = "tipo_tasa", nullable = false)
    private String tipo_tasa;
    @Column(name = "plazo_maximo", nullable = false)
    private int plazo_maximo;
    @Column(name = "moneda", nullable = false)
    private String moneda;
    @Column(name = "contacto", nullable = false)
    private String contacto;
    @Column(name = "tipo_entidad", nullable = false)
    private String tipo_entidad;

    @Column(name = "periodoGraciaMax", nullable = false)
    private int periodoGraciaMax;

    @Column(name = "cuota_inicial_minima", nullable = false)
    private double cuota_inicial_minima;

    public EntidadesFinancieras() {
    }

    public EntidadesFinancieras(int idEntidadFinanciera, String nombre_entidad, double tasa_base, String tipo_tasa, int plazo_maximo, String moneda, String contacto, String tipo_entidad, int periodoGraciaMax, double cuota_inicial_minima) {
        this.idEntidadFinanciera = idEntidadFinanciera;
        this.nombre_entidad = nombre_entidad;
        this.tasa_base = tasa_base;
        this.tipo_tasa = tipo_tasa;
        this.plazo_maximo = plazo_maximo;
        this.moneda = moneda;
        this.contacto = contacto;
        this.tipo_entidad = tipo_entidad;
        this.periodoGraciaMax = periodoGraciaMax;
        this.cuota_inicial_minima = cuota_inicial_minima;
    }

    public int getIdEntidadFinanciera() {
        return idEntidadFinanciera;
    }

    public void setIdEntidadFinanciera(int idEntidadFinanciera) {
        this.idEntidadFinanciera = idEntidadFinanciera;
    }

    public String getNombre_entidad() {
        return nombre_entidad;
    }

    public void setNombre_entidad(String nombre_entidad) {
        this.nombre_entidad = nombre_entidad;
    }

    public double getTasa_base() {
        return tasa_base;
    }

    public void setTasa_base(double tasa_base) {
        this.tasa_base = tasa_base;
    }

    public String getTipo_tasa() {
        return tipo_tasa;
    }

    public void setTipo_tasa(String tipo_tasa) {
        this.tipo_tasa = tipo_tasa;
    }

    public int getPlazo_maximo() {
        return plazo_maximo;
    }

    public void setPlazo_maximo(int plazo_maximo) {
        this.plazo_maximo = plazo_maximo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTipo_entidad() {
        return tipo_entidad;
    }

    public void setTipo_entidad(String tipo_entidad) {
        this.tipo_entidad = tipo_entidad;
    }

    public int getPeriodoGraciaMax() {
        return periodoGraciaMax;
    }

    public void setPeriodoGraciaMax(int periodoGraciaMax) {
        this.periodoGraciaMax = periodoGraciaMax;
    }

    public double getCuota_inicial_minima() {
        return cuota_inicial_minima;
    }

    public void setCuota_inicial_minima(double cuota_inicial_minima) {
        this.cuota_inicial_minima = cuota_inicial_minima;
    }
}
