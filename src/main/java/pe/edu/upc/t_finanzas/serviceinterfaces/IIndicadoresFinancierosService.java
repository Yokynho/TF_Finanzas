package pe.edu.upc.t_finanzas.serviceinterfaces;

import pe.edu.upc.t_finanzas.entities.IndicadoresFinancieros;

import java.util.List;

public interface IIndicadoresFinancierosService {
    public List<IndicadoresFinancieros> list();
    public  void insert(IndicadoresFinancieros i);
    public IndicadoresFinancieros listId(int id);
    public void update(IndicadoresFinancieros i);
    public void  delete(int id);
}
