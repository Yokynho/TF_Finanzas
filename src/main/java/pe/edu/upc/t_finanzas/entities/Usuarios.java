package pe.edu.upc.t_finanzas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Usuarios")

public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarios;
    @Column(length = 30, unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false, length =300)
    private String password;
    private Boolean enabled;
    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;
    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;
    @Column(name = "dni", nullable = false)
    private int dni;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fecha_nacimiento;
    @Column(name = "estado_civil", length = 20, nullable = false)
    private String estado_civil;
    @Column(name = "ingreso_mensual", nullable = false)
    private double ingreso_mensual;
    @Column(name = "telefono", length = 15, nullable = false)
    private int telefono;
    @Column(name = "correo", length = 30, nullable = false)
    private String correo;
    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;
    @Column(name = "distrito", length = 30, nullable = false)
    private String distrito;
    @Column(name = "provincia", length = 30, nullable = false)
    private String provincia;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fecha_registro;

    @Column(name = "aplicaBonoIntegrador", nullable = false)
    private Boolean aplicaBonoIntegrador;

    //@JsonIgnore
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "idUsuarios")
    @JsonIgnore
    //@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Roles> roles;

    public Usuarios() {
    }

    public Usuarios(int idUsuarios, String username, String password, Boolean enabled, String nombres, String apellidos, int dni, LocalDate fecha_nacimiento, String estado_civil, double ingreso_mensual, int telefono, String correo, String direccion, String distrito, String provincia, LocalDate fecha_registro, Boolean aplicaBonoIntegrador, List<Roles> roles) {
        this.idUsuarios = idUsuarios;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado_civil = estado_civil;
        this.ingreso_mensual = ingreso_mensual;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.distrito = distrito;
        this.provincia = provincia;
        this.fecha_registro = fecha_registro;
        this.aplicaBonoIntegrador = aplicaBonoIntegrador;
        this.roles = roles;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public Boolean getAplicaBonoIntegrador() {
        return aplicaBonoIntegrador;
    }

    public void setAplicaBonoIntegrador(Boolean aplicaBonoIntegrador) {
        this.aplicaBonoIntegrador = aplicaBonoIntegrador;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public double getIngreso_mensual() {
        return ingreso_mensual;
    }

    public void setIngreso_mensual(double ingreso_mensual) {
        this.ingreso_mensual = ingreso_mensual;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
