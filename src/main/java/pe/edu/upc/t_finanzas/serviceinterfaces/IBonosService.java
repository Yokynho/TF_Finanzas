package pe.edu.upc.t_finanzas.serviceinterfaces;

import pe.edu.upc.t_finanzas.entities.Bonos;

import java.util.List;

public interface IBonosService {
    public List<Bonos> list();
    public  void insert(Bonos b);
    public Bonos listId(int id);
    public void update(Bonos b);
    public void  delete(int id);
}
