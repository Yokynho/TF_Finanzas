package pe.edu.upc.t_finanzas.serviceinterfaces;

import pe.edu.upc.t_finanzas.entities.Inmuebles;

import java.util.List;

public interface IInmueblesService {
    public List<Inmuebles> list();
    public  void insert(Inmuebles i);
    public Inmuebles listId(int id);
    public void update(Inmuebles i);
    public void  delete(int id);
    public double PrecioProm ();
}
