package pe.edu.upc.t_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.t_finanzas.entities.Roles;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer> {



}
