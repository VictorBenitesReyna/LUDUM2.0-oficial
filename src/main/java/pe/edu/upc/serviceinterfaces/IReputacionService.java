package pe.edu.upc.serviceinterfaces;

import java.util.List;


import pe.edu.upc.entities.Reputacion;



public interface IReputacionService {
	
	public boolean insert(Reputacion reputacion);
	List<Reputacion> list();
	Reputacion listarId(int idReputacion);
	
}
