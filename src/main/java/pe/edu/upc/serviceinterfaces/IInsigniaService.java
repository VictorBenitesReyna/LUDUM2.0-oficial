package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Insignia;



public interface IInsigniaService {
	
	public boolean insert(Insignia insignia);
	List<Insignia> list();
	Insignia listarId(int codigoInsignia);
	List<Insignia> listByVideojuego(int codigovideojuego);
	
	
}
