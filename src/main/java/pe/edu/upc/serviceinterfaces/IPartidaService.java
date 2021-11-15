package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Partida;

public interface IPartidaService {
	public Integer insert(Partida partida);
	List<Partida> list();
	public void revisarPartidas();
	List<Partida> listByEstadoPartida(boolean EstadoPartida);
}
