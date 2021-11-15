package pe.edu.upc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Emparejamiento;

@Repository
public interface IEmparejamientoRepository extends JpaRepository<Emparejamiento, Integer>{
	
	@Query("select count(e.idEmparejamiento) from Emparejamiento e where e.idEmparejamiento=:id")
	public int EmparejamientosExistentes(@Param("id") int id);
	
	public List<Emparejamiento> findByPartidaIdPartida(int idP);
	
	public List<Emparejamiento> findByPartidaEstadoPartida(boolean estadoPartida);
	
	public List<Emparejamiento> findByPartidaIdPartidaAndPartidaEstadoPartida(int idP,boolean estadoPartida); 
}
