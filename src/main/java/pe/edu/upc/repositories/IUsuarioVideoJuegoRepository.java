package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.UsuarioVideoJuego;

@Repository
public interface IUsuarioVideoJuegoRepository extends JpaRepository<UsuarioVideoJuego, Integer>
{
	
}
