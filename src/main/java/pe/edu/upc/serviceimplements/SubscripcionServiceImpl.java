package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = true)  
	public 	Subscripcion listarID(int idSubscripcion)
	{
		Subscripcion op = rSUBSCRIP.findById(idSubscripcion).get();
		return op != null ? op : new Subscripcion();
	}

	@Override
	public void delete(int idSubscripcion) 
	{
		rSUBSCRIP.deleteById(idSubscripcion);	
	}

	@Override
	public Subscripcion listId(int idSubscripcion) 
	{
		return rSUBSCRIP.findById(idSubscripcion).get();
	}

	@Override
	public List<Subscripcion> findByTipoSubscripcionIdTipoSubscripcion(int id) {
		// TODO Auto-generated method stub
		return rSUBSCRIP.findByTipoSubscripcionIdTipoSubscripcion(id);
	}
	
	@Override
	public List<Subscripcion> findByTipoPagoIdTipoPago(int id) {
		// TODO Auto-generated method stub
		return rSUBSCRIP.findByTipoPagoIdTipoPago(id);
	}
}
