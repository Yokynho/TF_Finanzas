package pe.edu.upc.t_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.t_finanzas.entities.Usuarios;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {

    public Usuarios findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Usuarios u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (tipo, id_usuarios) VALUES (:rol, :id_usuarios)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("id_usuarios") Long id_usuarios);


    @Query(value = "select (id_usuarios)as number\n" +
            "from usuarios\n" +
            "where username = :username",nativeQuery = true)
    public int obtenerId(@Param("username") String username);

    @Query(value="select *\n" +
            "from usuarios\n" +
            "where username = :username", nativeQuery = true)
    public List<Usuarios> obtenerUsuariosPorUsername(@Param("username") String username);

    @Query(value = "select count(u.id_usuarios)\n" +
            "from usuarios u\n" +
            "join roles r on u.id_usuarios = r.id_usuarios\n" +
            "where tipo = 'USUARIO'\n", nativeQuery = true)
    public int TotalUsuarios();
}
