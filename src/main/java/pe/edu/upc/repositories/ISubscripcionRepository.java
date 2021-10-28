package pe.edu.upc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Subscripcion;

public interface ISubscripcionRepository extends JpaRepository<Subscripcion, Integer> 
{
	@Query("select count(l.idSubscripcion) from Subscripcion l where l.idSubscripcion=:subs")
	public int buscarSubscripcionActiva(@Param("subs") int subscripcion);
}
