package pe.edu.upc.serviceimplements;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Partida;
import pe.edu.upc.repositories.IPartidaRepository;
import pe.edu.upc.serviceinterfaces.IPartidaService;

@Service
public class PartidaServiceImpl implements IPartidaService {

	@Autowired
	private IPartidaRepository pS;

	@Override
	public Integer insert(Partida partida) {
		partida.setTiempoDuracionPartida(new Date());
		int rpta = pS.partidasExistentes(partida.getIdPartida());
		if (rpta == 0) {
			pS.save(partida);
		}
		return rpta;
	}

	@Override
	public List<Partida> list() {
		revisarPartidas();
		return pS.findAll();
	}

	@Override
	public void revisarPartidas() {
        Date hoy = new Date();
		List<Partida> lista = pS.findAll();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(getDateDiff(lista.get(i).getTiempoDuracionPartida(), hoy, TimeUnit.MINUTES));
			if(getDateDiff(lista.get(i).getTiempoDuracionPartida(), hoy, TimeUnit.MINUTES)>=1)
			{
				lista.get(i).setEstadoPartida(false);
				pS.save(lista.get(i));
			}

		}

	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public List<Partida> listByEstadoPartida(boolean EstadoPartida) {
		revisarPartidas();
		return pS.findByEstadoPartida(EstadoPartida);
	}
}
