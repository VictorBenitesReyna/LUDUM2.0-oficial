package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioService {
	public Integer insert(Usuario usuario);
	List<Usuario> list();
}
