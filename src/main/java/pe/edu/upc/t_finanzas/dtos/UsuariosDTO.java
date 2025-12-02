package pe.edu.upc.t_finanzas.dtos;
import pe.edu.upc.t_finanzas.entities.Roles;

import java.time.LocalDate;
import java.util.List;

public class UsuariosDTO {

    private int idUsuarios;
    private String username;
    private String password;
    private Boolean enabled;
    private String nombres;
    private String apellidos;
    private int dni;
    private LocalDate fecha_nacimiento;
    private String estado_civil;
    private double ingreso_mensual;
    private int telefono;
    private String correo;
    private String direccion;
    private String distrito;
    private String provincia;
    private LocalDate fecha_registro;
    private Boolean aplicaBonoIntegrador;



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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAplicaBonoIntegrador() {
        return aplicaBonoIntegrador;
    }

    public void setAplicaBonoIntegrador(Boolean aplicaBonoIntegrador) {
        this.aplicaBonoIntegrador = aplicaBonoIntegrador;
    }
}
