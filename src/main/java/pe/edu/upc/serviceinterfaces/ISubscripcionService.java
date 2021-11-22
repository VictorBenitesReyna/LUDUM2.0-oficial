package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Subscripcion;

public interface ISubscripcionService
{
	
	public boolean insert(Subscripcion subscripcion);
	List<Subscripcion> list();
	
	public void delete(int idSubscripcion);
	
	Subscripcion listarID(int idSubscripcion);
	
	Subscripcion listId(int idSubscripcion);
	public List<Subscripcion> findByTipoSubscripcionIdTipoSubscripcion(int id);
	public List<Subscripcion> findByTipoPagoIdTipoPago(int id);
	

}
