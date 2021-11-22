package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Emparejamiento;
import pe.edu.upc.repositories.IEmparejamientoRepository;
import pe.edu.upc.serviceinterfaces.IEmparejamientoService;

@Service
public class EmparejamientoServiceImpl implements IEmparejamientoService{

	@Autowired
	private IEmparejamientoRepository eR;
	
	@Override
	public boolean insert(Emparejamiento emparejamiento) {
		Emparejamiento objEmparejamiento = eR.save(emparejamiento);
		if(objEmparejamiento == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Emparejamiento> list() {
		// TODO Auto-generated method stub
		return eR.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Emparejamiento listarId(int idEmparejamiento) {
		Emparejamiento op = eR.findById(idEmparejamiento).get();
		return op != null ? op : new Emparejamiento();
	}

	@Override
	public Emparejamiento listId(int idEmparejamiento) {
		// TODO Auto-generated method stub
		return eR.findById(idEmparejamiento).get();
	}

	@Override
	public List<Emparejamiento> findByPartidaIdPartida(int idP) {
		// TODO Auto-generated method stub
		return eR.findByPartidaIdPartida(idP);
	}

	@Override
	public List<Emparejamiento> listarPorEstadoPartida(boolean estadoPartida) {
		// TODO Auto-generated method stub
		return eR.findByPartidaEstadoPartida(estadoPartida);
	}

	@Override
	public List<Emparejamiento> listarPorIdPartidaAndEstadoPartida(int idP, boolean estadoPartida) {
		// TODO Auto-generated method stub
		return eR.findByPartidaIdPartidaAndPartidaEstadoPartida(idP, estadoPartida);
	}

}
