package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Insignia;
import pe.edu.upc.repositories.IInsigniaRepository;
import pe.edu.upc.serviceinterfaces.IInsigniaService;
@Service
public class InsigniaServiceImpl implements IInsigniaService {
	@Autowired
	private IInsigniaRepository iR;
	@Override
	public boolean insert(Insignia insignia) {
		Insignia objProduct = iR.save(insignia);
		if (objProduct == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Insignia> list() {
		return iR.findAll();
	}

	@Override
	public Insignia listarId(int codigoInsignia) {
		Optional<Insignia> op = iR.findById(codigoInsignia);
		return op.isPresent() ? op.get() : new Insignia();
	}
	
	@Override
	public List<Insignia> listByVideojuego(int codigovideojuego) {
		return iR.findByCodigovideojuegoCodigovideojuego(codigovideojuego);
	}
	

}
