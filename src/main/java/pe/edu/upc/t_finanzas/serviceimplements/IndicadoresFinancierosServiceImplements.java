package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.IndicadoresFinancieros;
import pe.edu.upc.t_finanzas.repositories.IIndicadoresFinancierosRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.IIndicadoresFinancierosService;

import java.util.List;

@Service
public class IndicadoresFinancierosServiceImplements implements IIndicadoresFinancierosService {
    @Autowired
    private IIndicadoresFinancierosRepository fR;


    @Override
    public List<IndicadoresFinancieros> list() {
        return fR.findAll();
    }

    @Override
    public void insert(IndicadoresFinancieros i) {
        fR.save(i);
    }

    @Override
    public IndicadoresFinancieros listId(int id) {
        return fR.findById(id).orElse(new IndicadoresFinancieros());
    }

    @Override
    public void update(IndicadoresFinancieros i) {
        fR.save(i);

    }

    @Override
    public void delete(int id) {
        fR.deleteById(id);
    }
}
