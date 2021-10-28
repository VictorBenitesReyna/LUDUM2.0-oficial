package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Partida;
import pe.edu.upc.repositories.IPartidaRepository;
import pe.edu.upc.serviceinterfaces.IPartidaService;

@Service
public class PartidaServiceImpl implements IPartidaService{

	@Autowired
	private IPartidaRepository pS;
	
	@Override
	public Integer insert(Partida partida) {
		pS.save(partida);
		return 1;
	}

	@Override
	public List<Partida> list() {
		return pS.findAll();
	}

}
