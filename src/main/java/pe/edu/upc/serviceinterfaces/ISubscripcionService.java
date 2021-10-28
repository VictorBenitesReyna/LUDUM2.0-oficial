package pe.edu.upc.serviceinterfaces;

import java.util.List;


import pe.edu.upc.entities.Subscripcion;

public interface ISubscripcionService
{
	
	public boolean insert(Subscripcion subscripcion);
	List<Subscripcion> list();
	Subscripcion listarID(int idSubscripcion);

}
