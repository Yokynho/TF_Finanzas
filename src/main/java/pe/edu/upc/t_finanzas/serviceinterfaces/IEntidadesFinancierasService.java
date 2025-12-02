package pe.edu.upc.t_finanzas.serviceinterfaces;

import pe.edu.upc.t_finanzas.entities.EntidadesFinancieras;

import java.util.List;

public interface IEntidadesFinancierasService {
    public List<EntidadesFinancieras> list();
    public  void insert(EntidadesFinancieras i);
    public EntidadesFinancieras listId(int id);
    public void update(EntidadesFinancieras i);
    public void  delete(int id);
}
