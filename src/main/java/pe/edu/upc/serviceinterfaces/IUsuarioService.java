package pe.edu.upc.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioService 
{
	public Integer insert(Usuario usuario);
	List<Usuario> list();
	public boolean modificar(Usuario usuario);
	Usuario listarId(int idUsuario);
	Optional<Usuario> listId(int idUsuario);
}
