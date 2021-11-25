package pe.edu.upc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Insignia;

@Repository
public interface IInsigniaRepository extends JpaRepository<Insignia, Integer> {
	@Query("select count(l.nombre) from Insignia l where l.nombre=:insig")
	public int buscarNombre(@Param("insig") String nombre);

	public List<Insignia> findByCodigovideojuegoCodigovideojuego(int codigovideojuego);

	@Query(value = "Select v.plataforma, Count(i.codigo_insignia) "
			+ "From videojuego v join insignia i on v.codigovideojuego = i.codigovideojuego "
			+ "group by v.codigovideojuego "
			, nativeQuery = true)
	
	public List<String[]> cantidadLogrosXVideojuego();
}

