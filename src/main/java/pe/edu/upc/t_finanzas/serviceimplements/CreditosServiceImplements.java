package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.Creditos;
import pe.edu.upc.t_finanzas.repositories.ICreditosRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.ICreditosService;

import java.util.List;

@Service
public class CreditosServiceImplements implements ICreditosService {
    @Autowired
    private ICreditosRepository cR;
    @Override
    public List<Creditos> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Creditos c) {
        cR.save(c);
    }

    @Override
    public Creditos listId(int id) {
        return cR.findById(id).orElse(new Creditos());
    }

    @Override
    public void update(Creditos c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Creditos> obtenerCreditosPorUsername(String username) {
        return cR.obtenerCreditosPorUsername(username);
    }
}
