package pe.edu.upc.t_finanzas.dtos;
import pe.edu.upc.t_finanzas.entities.Usuarios;

public class RolesDTO {
    private int idRoles;
    private String tipo;
    private Usuarios usuario;

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
