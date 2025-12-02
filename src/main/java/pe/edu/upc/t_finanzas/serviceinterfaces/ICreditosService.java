package pe.edu.upc.t_finanzas.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.t_finanzas.entities.Creditos;

import java.util.List;

public interface ICreditosService {
    public List<Creditos> list();
    public  void insert(Creditos c);
    public Creditos listId(int id);
    public void update(Creditos c);
    public void  delete(int id);

    public List<Creditos> obtenerCreditosPorUsername(@Param("username") String username);

}
