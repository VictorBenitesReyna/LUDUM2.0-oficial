package pe.edu.upc.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Partida;

@Repository
public interface IPartidaRepository extends JpaRepository<Partida, Integer>{
	
	@Query("select count(p.idPartida) from Partida p where p.idPartida=:id")
	public int partidasExistentes(@Param("id") int id);
	public List<Partida> findByEstadoPartida(boolean EstadoPartida);

}
