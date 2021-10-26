package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.repositories.ITipoSubscripcion;
import pe.edu.upc.serviceinterfaces.ITipoSubscripcionService;

@Service
public class TipoSubscripcionServiceImpl implements ITipoSubscripcionService
{
	@Autowired
	private ITipoSubscripcion uTSUB;

	@Override
	public Integer insert(TipoSubscripcion tiposubscripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoSubscripcion> list() 
	{
		
		return uTSUB.findAll();
	}
	
}
