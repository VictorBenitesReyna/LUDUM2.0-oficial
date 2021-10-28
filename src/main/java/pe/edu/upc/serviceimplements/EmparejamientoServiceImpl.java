package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

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
		Optional<Emparejamiento> op = eR.findById(idEmparejamiento);
		return op.isPresent() ? op.get() : new Emparejamiento();
	}

}
