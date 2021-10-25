package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.TipoPago;

public interface ITipoPagoService 
{

	public Integer insert(TipoPago tipopago);
	List<TipoPago> list();
   	
}

