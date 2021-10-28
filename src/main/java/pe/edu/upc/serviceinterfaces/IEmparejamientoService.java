package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Emparejamiento;

public interface IEmparejamientoService {
	
	public boolean insert(Emparejamiento emparejamiento);
	
	List<Emparejamiento> list();
	
	Emparejamiento listarId(int idEmparejamiento);
}
