package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.TipoSubscripcion;

@Repository
public interface ITipoSubscripcion extends JpaRepository<TipoSubscripcion, Integer> 
{
	@Query("select count(c.nombreTipoSubscripcion) from TipoSubscripcion c where c.nombreTipoSubscripcion=:name")
	public int nombresTipoSubscripcionesExistentes(@Param("name") String nombre);
}
