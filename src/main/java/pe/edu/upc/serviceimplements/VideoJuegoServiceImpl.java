package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

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
		VideoJuego videojuegoRpta= new VideoJuego();
		int rpta= vR.findByIdVideojuego(videojuego.getCodigovideojuego());
		if(rpta == 0)
		{
			videojuegoRpta=vR.save(videojuego);
			return videojuegoRpta.getCodigovideojuego();
		}
		return -1;
	}

	@Override
	public List<VideoJuego> list() {
		// TODO Auto-generated method stub
		return vR.findAll();
	}

	@Override
	public VideoJuego listId(int codigovideojuego) {
		// TODO Auto-generated method stub
		return vR.findById(codigovideojuego).get();
	}

}
