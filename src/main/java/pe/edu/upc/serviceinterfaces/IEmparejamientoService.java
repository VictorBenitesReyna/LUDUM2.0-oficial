package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Emparejamiento;

public interface IEmparejamientoService {
	
	public boolean insert(Emparejamiento emparejamiento);
	List<Emparejamiento> list();
	
	Emparejamiento listarId(int idEmparejamiento);
	
	Emparejamiento listId(int idEmparejamiento);
	
	public List<Emparejamiento> findByPartidaIdPartida(int idP);
	
	public List<Emparejamiento> listarPorEstadoPartida(boolean estadoPartida);
	
	public List<Emparejamiento> listarPorIdPartidaAndEstadoPartida(int idP,boolean estadoPartida);
}
