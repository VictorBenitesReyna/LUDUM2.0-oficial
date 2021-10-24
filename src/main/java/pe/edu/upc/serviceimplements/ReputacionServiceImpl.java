package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Reputacion;
import pe.edu.upc.repositories.IReputacion;
import pe.edu.upc.serviceinterfaces.IReputacionService;
@Service
public class ReputacionServiceImpl implements IReputacionService {
	@Autowired
	private IReputacion rR;
	@Override
	public boolean insert(Reputacion reputacion) {
		Reputacion objProduct = rR.save(reputacion);
		if (objProduct == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Reputacion> list() {
		return rR.findAll();
	}

	@Override
	public Reputacion listarId(int idReputacion) {
		Optional<Reputacion> op = rR.findById(idReputacion);
		return op.isPresent() ? op.get() : new Reputacion();
	}

}