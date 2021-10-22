package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {
	
	@Query("select count(c.nombreUsuario) from Usuario c where c.nombreUsuario=:name")
	public int nombresExistentes(@Param("name") String nombre);

}
