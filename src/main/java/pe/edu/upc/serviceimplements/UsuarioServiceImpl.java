package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Usuario;

import pe.edu.upc.repositories.IUsuario;

import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService 
{
	@Autowired
	private IUsuario uR;
	@Override
	public Integer insert(Usuario usuario) 
	{
		int rpta=uR.nombresExistentes(usuario.getNombreUsuario());
		if(rpta==0) 
		{
			uR.save(usuario);
		}
		return rpta;
	}

	@Override
	public List<Usuario> list() 
	{
		return uR.findAll();
	}

}
