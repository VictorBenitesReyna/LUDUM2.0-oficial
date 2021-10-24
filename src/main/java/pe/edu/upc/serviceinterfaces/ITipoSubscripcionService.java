package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.TipoSubscripcion;

public interface ITipoSubscripcionService 
{

	public Integer insert(TipoSubscripcion tiposubscripcion);
	List<TipoSubscripcion> list();
	
}
