 package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.dto.ReporteSubscripcionDto;

public interface IReporteService {
	
	List<String[]> obtenerReporteTipoSubs();
	List<String[]>  obtenerReporteTipoPago();
	List<String[]> mayorTipoSubscripcion();
	List<String[]> montoSubscripciones();	
	List<String[]> mayorTipoPago();
}
