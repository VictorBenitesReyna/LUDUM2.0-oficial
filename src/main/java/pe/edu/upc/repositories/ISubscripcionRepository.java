package pe.edu.upc.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Subscripcion;
@Repository
public interface ISubscripcionRepository extends JpaRepository<Subscripcion, Integer> 
{
	@Query("select count(l.idSubscripcion) from Subscripcion l where l.idSubscripcion=:subs")
	public int buscarSubscripcionActiva(@Param("subs") int subscripcion);
	public List<Subscripcion> findByTipoSubscripcionIdTipoSubscripcion(int id);
	public List<Subscripcion> findByTipoPagoIdTipoPago(int id);
	
	@Query(value = "SELECT ts.nombre_tipo_subscripcion,Count(ts.id_tipo_subscripcion) "
			+ "From tiposubscripcion ts join subscripcion s on ts.id_tipo_subscripcion = s.codigo_tipo_subscripcion "
			+ "group by ts.id_tipo_subscripcion "
			, nativeQuery = true)
	public List<String[]> cantidadTipoSubscripcion();
	
	@Query(value = "SELECT tp.nombre_tipo_pago,Count(tp.id_tipo_pago) "
			+ "From tipopago tp join subscripcion s on tp.id_tipo_pago = s.codigo_tipo_pago "
			+ "group by tp.id_tipo_pago "
			, nativeQuery = true)
	public List<String[]> cantidadTipoPago();
	
	@Query(value = "SELECT tp.nombre_tipo_pago,Count(tp.id_tipo_pago) "
			+ "From tipopago tp join subscripcion s on tp.id_tipo_pago = s.codigo_tipo_pago "
			+ "group by tp.id_tipo_pago order by Count(tp.id_tipo_pago) DESC limit 1 " 
			, nativeQuery = true)
	public List<String[]> mayorTipoPago();
	
	@Query(value = "SELECT ts.nombre_tipo_subscripcion,Count(ts.id_tipo_subscripcion) "
			+ "From tiposubscripcion ts join subscripcion s on ts.id_tipo_subscripcion = s.codigo_tipo_subscripcion "
			+ "group by ts.id_tipo_subscripcion order by Count(ts.id_tipo_subscripcion) DESC limit 1 "
			, nativeQuery = true)
	public List<String[]> mayorTipoSubscripcion();
	
	@Query(value = "Select Count(s.id_subscripcion), SUM(s.precio) "
			+ "From subscripcion s "
			, nativeQuery = true)
	public List<String[]> montoSubscripcion();
}
