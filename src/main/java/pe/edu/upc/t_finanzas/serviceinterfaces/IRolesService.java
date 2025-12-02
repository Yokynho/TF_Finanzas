package pe.edu.upc.t_finanzas.serviceinterfaces;

import pe.edu.upc.t_finanzas.entities.Roles;

import java.util.List;

public interface IRolesService {
    public List<Roles> list();

    public void insert(Roles roles);

    public Roles listId(int id);

    public void update(Roles roles);

    public void delete(int id);
}
