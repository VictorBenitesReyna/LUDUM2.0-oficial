package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.repositories.ITipoSubscripcionRepository;
import pe.edu.upc.serviceinterfaces.ITipoSubscripcionService;

@Service
public class TipoSubscripcionServiceImpl implements ITipoSubscripcionService
{
	@Autowired
	private ITipoSubscripcionRepository uTSUB;

	@Override
	public Integer insert(TipoSubscripcion tiposubscripcion) 
	{
		int rpta = uTSUB.nombresTipoSubscripcionesExistentes(tiposubscripcion.getNombreTipoSubscripcion());
		if (rpta==0)
		{
			uTSUB.save(tiposubscripcion);
		}
		return rpta;
	}

	@Override
	public List<TipoSubscripcion> list() 
	{
		
		return uTSUB.findAll();
	}
	
}
