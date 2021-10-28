package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.repositories.ISubscripcionRepository;
import pe.edu.upc.serviceinterfaces.ISubscripcionService;


@Service

public class SubscripcionServiceImpl implements ISubscripcionService
{
	@Autowired
	private ISubscripcionRepository rSUBSCRIP;

	@Override
	public boolean insert(Subscripcion subscripcion) 
	{
		Subscripcion objSubscripcion = rSUBSCRIP.save(subscripcion);
		if (objSubscripcion == null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	@Override
	public List<Subscripcion> list() 
	{
		return rSUBSCRIP.findAll();
	}

	@Override
	public Subscripcion listarID(int idSubscripcion) 
	{
		Optional<Subscripcion> op =rSUBSCRIP.findById(idSubscripcion);
		return op.isPresent() ? op.get() : new Subscripcion();
	}
}
