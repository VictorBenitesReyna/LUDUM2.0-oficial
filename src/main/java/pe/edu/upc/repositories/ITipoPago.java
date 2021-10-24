package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.TipoPago;

@Repository
public interface ITipoPago extends JpaRepository<TipoPago, Integer> 
{
	@Query("select count(c.nombreTipoPago) from TipoPago c where c.nombreTipoPago=:name")
	public int nombresTipoPagosExistentes(@Param("name") String nombre);
}
