package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.VideoJuego;

@Repository
public interface IVideoJuegoRepository extends JpaRepository<VideoJuego, Integer> 
{
	
	@Query("select count(c.plataforma) from VideoJuego c where c.plataforma=:plataforma")
	public int plataformasExistentes(@Param("plataforma") String plataforma);
	public VideoJuego findByPlataforma(String plataforma);
}
