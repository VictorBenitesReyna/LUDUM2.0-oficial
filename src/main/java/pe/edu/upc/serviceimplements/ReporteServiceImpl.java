package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.repositories.IInsigniaRepository;
import pe.edu.upc.repositories.ISubscripcionRepository;
import pe.edu.upc.serviceinterfaces.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService {
	@Autowired
	private ISubscripcionRepository sR;
	@Autowired
	private IInsigniaRepository iR;

	@Override
	public List<String[]> obtenerReporteTipoSubs() {
		return sR.cantidadTipoSubscripcion();
	}

	@Override
	public List<String[]> mayorTipoSubscripcion() {
		return sR.mayorTipoSubscripcion();
	}

	@Override
	public List<String[]> obtenerReporteTipoPago() {
		return sR.cantidadTipoPago();
	} 	


	@Override
	public List<String[]> montoSubscripciones() {
		return sR.montoSubscripcion();
	}

	@Override
	public List<String[]> mayorTipoPago() {
		return sR.mayorTipoPago();
	}
	
	@Override
	public List<String[]> cantidadLogrosXvideojuego() {
		return iR.cantidadLogrosXVideojuego();
	}
}
