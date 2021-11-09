package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.UsuarioVideoJuego;

public interface IUsuarioVideoJuegoService 
{

	public boolean insert(UsuarioVideoJuego usuariovideojuego);
	
	List<UsuarioVideoJuego> list();

	public Object listId(int codigovideojuego);

	
}
