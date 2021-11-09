package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.UsuarioVideoJuego;
import pe.edu.upc.repositories.IUsuarioVideoJuegoRepository;
import pe.edu.upc.serviceinterfaces.IUsuarioVideoJuegoService;



@Service
public class IUsuarioVideoJuegoServiceImpl implements IUsuarioVideoJuegoService
{
	@Autowired
	private IUsuarioVideoJuegoRepository uvA;

	@Override
	@Transactional
	public boolean insert(UsuarioVideoJuego usuariovideojuego) 
	{
		UsuarioVideoJuego objUsuarioVideoJuego = uvA.save(usuariovideojuego);
		if(objUsuarioVideoJuego == null)
		{
		return false;
		}
		else
		{
		return true;	
		}
	}

	@Override
	public List<UsuarioVideoJuego> list() {
		// TODO Auto-generated method stub
		return uvA.findAll();
	}

	@Override
	public Object listId(int codigovideojuego) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
