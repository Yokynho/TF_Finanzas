package pe.edu.upc.t_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.t_finanzas.entities.Creditos;
import pe.edu.upc.t_finanzas.entities.Usuarios;

import java.util.List;

@Repository
public interface ICreditosRepository extends JpaRepository<Creditos,Integer> {
    @Query(value="select id_creditos, cuota_inicial, fecha_desembolso, monto_financiar, periodo_gracia,\n" +
            "plazo, valor_taza, capitalizacion, estado, tipo_periodo_gracia, tipo_taza, id_inmuebles,\n" +
            "id_entidad_financiera, cr.id_usuarios\n" +
            "from creditos cr\n" +
            "join usuarios u on cr.id_usuarios = u.id_usuarios\n" +
            "where u.username = :username", nativeQuery = true)
    public List<Creditos> obtenerCreditosPorUsername(@Param("username") String username);

}
