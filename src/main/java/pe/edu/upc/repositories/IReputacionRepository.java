package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Reputacion;

@Repository
public interface IReputacionRepository extends JpaRepository<Reputacion, Integer> 
{
	@Query("select count(l.estadoReputacion) from Reputacion l where l.estadoReputacion=:repu")
	public int buscarProducto(@Param("repu") String reputacion);
	
}
