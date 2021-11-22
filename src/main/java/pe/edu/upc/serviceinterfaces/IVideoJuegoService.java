package pe.edu.upc.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.VideoJuego;

public interface IVideoJuegoService {
	public Integer insert(VideoJuego VideoJuego);
	List<VideoJuego> list();
	VideoJuego listId(int codigovideojuego);
}