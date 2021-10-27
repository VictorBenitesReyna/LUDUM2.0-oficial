package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoPago;

import pe.edu.upc.repositories.ITipoPago;

import pe.edu.upc.serviceinterfaces.ITipoPagoService;

@Service
public class TipoPagoServiceImpl implements ITipoPagoService
{
	@Autowired
	private ITipoPago pagR;
	@Override
	public Integer insert(TipoPago tipopago) 
	{
		int rpta=pagR.nombresTipoPagosExistentes(tipopago.getNombreTipoPago());
		if(rpta==0)
		{
		pagR.save(tipopago);
		}
		return rpta;
	}

	@Override
	public List<TipoPago> list() 
	{
		
		return pagR.findAll();
	}

	@Override
	public void delete(int idTipoPago) {
		pagR.deleteById(idTipoPago);
		
	}

}
