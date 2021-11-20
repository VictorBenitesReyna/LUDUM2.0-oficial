package pe.edu.upc.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoPago;

public interface ISubscripcionRepository extends JpaRepository<Subscripcion, Integer> 
{
	@Query("select count(l.idSubscripcion) from Subscripcion l where l.idSubscripcion=:subs")
	public int buscarSubscripcionActiva(@Param("subs") int subscripcion);
	public List<Subscripcion> findByTipoSubscripcionIdTipoSubscripcion(int id);
	public List<Subscripcion> findByTipoPagoIdTipoPago(int id);
}
