package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.VideoJuego;
import pe.edu.upc.repositories.IVideoJuegoRepository;
import pe.edu.upc.serviceinterfaces.IVideoJuegoService;

@Service
public class VideoJuegoServiceImpl implements IVideoJuegoService {
	@Autowired
	private IVideoJuegoRepository vR;
	@Override
	public Integer insert(VideoJuego videojuego) {
		int rpta = vR.plataformasExistentes(videojuego.getPlataforma());
		if (rpta == 0) {
			vR.save(videojuego);
		}
		return rpta;

	}

	@Override
	public List<VideoJuego> list() {
		// TODO Auto-generated method stub
		return vR.findAll();
	}
	

}
