package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.dto.ReporteSubscripcionDto;

public interface IReporteService {
	
	List<ReporteSubscripcionDto> obtenerReporteTipoSubs();
	ReporteSubscripcionDto mayorTipoSubscripcion();

}
