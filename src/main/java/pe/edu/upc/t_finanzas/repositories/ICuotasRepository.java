package pe.edu.upc.t_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.t_finanzas.entities.Cuotas;

@Repository
public interface ICuotasRepository extends JpaRepository<Cuotas, Integer> {



}
