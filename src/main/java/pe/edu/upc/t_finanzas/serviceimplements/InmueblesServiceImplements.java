package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.Inmuebles;
import pe.edu.upc.t_finanzas.repositories.IInmueblesRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.IInmueblesService;

import java.util.List;

@Service
public class InmueblesServiceImplements implements IInmueblesService {
    @Autowired
    private IInmueblesRepository iR;


    @Override
    public List<Inmuebles> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Inmuebles i) {
        if (i.getTipoVivienda().equalsIgnoreCase("VIS Priorizada en Lote Unifamiliar") ||
                i.getTipoVivienda().equalsIgnoreCase("VIS Priorizada en Edificio Multifamiliar / Conjunto Residencial / Quinta") ||
                i.getTipoVivienda().equalsIgnoreCase("VIS en Lote Unifamiliar") ||
                i.getTipoVivienda().equalsIgnoreCase("VIS en Edificio Multifamiliar / Conjunto Residencial / Quinta")) {

            i.setAplicaBonoTP(true);
            i.setPrograma("Techo Propio");
        } else {
            i.setAplicaBonoTP(false);
            i.setPrograma("MiVivienda");
        }
        i.setAplicaBonoBP(true);


        iR.save(i);
    }

    @Override
    public Inmuebles listId(int id) {
        return iR.findById(id).orElse(new Inmuebles());
    }

    @Override
    public void update(Inmuebles i) {
        if (i.getTipoVivienda().equalsIgnoreCase("VIS Priorizada en Lote Unifamiliar") ||
                i.getTipoVivienda().equalsIgnoreCase("VIS Priorizada en Edificio Multifamiliar / Conjunto Residencial / Quinta") ||
                i.getTipoVivienda().equalsIgnoreCase("VIS en Lote Unifamiliar") ||
                i.getTipoVivienda().equalsIgnoreCase("VIS en Edificio Multifamiliar / Conjunto Residencial / Quinta")) {

            i.setAplicaBonoTP(true);
            i.setPrograma("Techo Propio");
        } else {
            i.setAplicaBonoTP(false);
            i.setPrograma("MiVivienda");
        }
        i.setAplicaBonoBP(true);

        iR.save(i);

    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public double PrecioProm() {
        return iR.PrecioProm();
    }
}
