package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Emparejamiento;

@Repository
public interface IEmparejamientoRepository extends JpaRepository<Emparejamiento, Integer>{
	
	@Query("select count(e.idEmparejamiento) from Emparejamiento e where e.idEmparejamiento=:id")
	public int EmparejamientosExistentes(@Param("id") int id);

}
