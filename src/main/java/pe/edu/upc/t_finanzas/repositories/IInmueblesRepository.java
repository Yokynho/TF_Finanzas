package pe.edu.upc.t_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.t_finanzas.entities.Inmuebles;

@Repository
public interface IInmueblesRepository extends JpaRepository<Inmuebles, Integer> {

    @Query(value = "select AVG(precio_venta)\n" +
            "from inmuebles\n", nativeQuery = true)
    public double PrecioProm ();
}
