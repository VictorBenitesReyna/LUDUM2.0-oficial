package pe.edu.upc.serviceimplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.ReporteSubscripcionDto;
import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.repositories.ISubscripcionRepository;
import pe.edu.upc.repositories.ITipoSubscripcionRepository;
import pe.edu.upc.serviceinterfaces.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService {
	@Autowired
	private ISubscripcionRepository sR;
	@Autowired
	private ITipoSubscripcionRepository tsR;

	@Override
	public List<ReporteSubscripcionDto> obtenerReporteTipoSubs() {
		List<ReporteSubscripcionDto> reporteSuscripciones = new ArrayList<ReporteSubscripcionDto>();
		List<TipoSubscripcion> tipoSubscripciones = tsR.findAll();
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		for (int i = 0; i < tipoSubscripciones.size(); i++) {
			subscripciones = sR
					.findByTipoSubscripcionIdTipoSubscripcion(tipoSubscripciones.get(i).getIdTipoSubscripcion());
			reporteSuscripciones.add(new ReporteSubscripcionDto(subscripciones.size(),
					tipoSubscripciones.get(i).getNombreTipoSubscripcion()));
		}

		return reporteSuscripciones;
	}

	@Override
	public ReporteSubscripcionDto mayorTipoSubscripcion() {
		ReporteSubscripcionDto reporteSuscripcion = new ReporteSubscripcionDto();
		List<TipoSubscripcion> tipoSubscripciones = tsR.findAll();
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		int max = 0;
		for (int i = 0; i < tipoSubscripciones.size(); i++) {
			subscripciones = sR
					.findByTipoSubscripcionIdTipoSubscripcion(tipoSubscripciones.get(i).getIdTipoSubscripcion());

			if (subscripciones.size() >= max) {
				reporteSuscripcion = new ReporteSubscripcionDto(subscripciones.size(),
						tipoSubscripciones.get(i).getNombreTipoSubscripcion());
				max=subscripciones.size();
			}
		}

		return reporteSuscripcion;
	}

}
