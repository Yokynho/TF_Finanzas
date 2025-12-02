package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.Bonos;
import pe.edu.upc.t_finanzas.repositories.IBonosRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.IBonosService;

import java.util.List;

@Service
public class BonosServiceImplements implements IBonosService {

    @Autowired
    private IBonosRepository bR;

    @Override
    public List<Bonos> list() {
        return bR.findAll();
    }

    @Override
    public void insert(Bonos b) {
        bR.save(b);
    }

    @Override
    public Bonos listId(int id) {
        return bR.findById(id).orElse(new Bonos());
    }

    @Override
    public void update(Bonos b) {
        bR.save(b);
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }
}
