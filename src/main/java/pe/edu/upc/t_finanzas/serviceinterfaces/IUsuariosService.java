package pe.edu.upc.t_finanzas.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.t_finanzas.entities.Usuarios;

import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> list();
    public  void insert(Usuarios u);
    public Usuarios listId(int id);
    public void update(Usuarios u);
    public void  delete(int id);



    public int obtenerId(@Param("username") String username);
    public List<Usuarios> obtenerUsuariosPorUsername(@Param("username") String username);
    public int TotalUsuarios();
}
