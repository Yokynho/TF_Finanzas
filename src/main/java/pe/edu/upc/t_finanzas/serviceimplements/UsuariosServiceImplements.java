package pe.edu.upc.t_finanzas.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.t_finanzas.entities.Usuarios;
import pe.edu.upc.t_finanzas.repositories.IUsuariosRepository;
import pe.edu.upc.t_finanzas.serviceinterfaces.IUsuariosService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class UsuariosServiceImplements implements IUsuariosService {
    @Autowired
    private IUsuariosRepository uR;


    @Override
    public List<Usuarios> list() {
        return uR.findAll();
    }

    public int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }


    @Override
    public void insert(Usuarios u) {
        int edad= calcularEdad(u.getFecha_nacimiento());

        u.setAplicaBonoIntegrador(edad > 60 || u.getIngreso_mensual() <= 4746);

        uR.save(u);
    }

    @Override
    public Usuarios listId(int id) {
        return uR.findById(id).orElse(new Usuarios());
    }

    @Override
    public void update(Usuarios u) {

        int edad= calcularEdad(u.getFecha_nacimiento());

        u.setAplicaBonoIntegrador(edad > 60 || u.getIngreso_mensual() <= 4746);
        uR.save(u);

    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public int obtenerId(String username) {
        return uR.obtenerId(username);
    }

    @Override
    public List<Usuarios> obtenerUsuariosPorUsername(String username) {
        return uR.obtenerUsuariosPorUsername(username);
    }

    @Override
    public int TotalUsuarios() {
        return uR.TotalUsuarios();
    }
}
