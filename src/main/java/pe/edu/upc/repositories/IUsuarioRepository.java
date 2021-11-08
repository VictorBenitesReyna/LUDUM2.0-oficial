package pe.edu.upc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("select count(c.username) from Usuario c where c.username=:username")
	public int nombresExistentes(@Param("username") String username);
	@Query("select count(c.idUsuario) from Usuario c where c.idUsuario=:idusuario")
	public int idExistentes(@Param("idusuario") int idUsuario);
	List<Usuario>findByUsername(String username);
	
	
}
