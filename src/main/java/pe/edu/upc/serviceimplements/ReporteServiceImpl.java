package pe.edu.upc.serviceimplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.ReporteSubscripcionDto;
import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.repositories.ISubscripcionRepository;
import pe.edu.upc.repositories.ITipoPagoRepository;
import pe.edu.upc.repositories.ITipoSubscripcionRepository;
import pe.edu.upc.serviceinterfaces.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService {
	@Autowired
	private ISubscripcionRepository sR;
	@Autowired
	private ITipoSubscripcionRepository tsR;
	@Autowired
	private ITipoPagoRepository tpR;

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
				max = subscripciones.size();
			}
		}

		return reporteSuscripcion;
	}

	@Override
	public List<ReporteSubscripcionDto> obtenerReporteTipoPago() {
		List<ReporteSubscripcionDto> reporteSuscripciones = new ArrayList<ReporteSubscripcionDto>();
		List<TipoPago> tipoPago = tpR.findAll();
		;
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		for (int i = 0; i < tipoPago.size(); i++) {
			subscripciones = sR.findByTipoPagoIdTipoPago(tipoPago.get(i).getIdTipoPago());
			reporteSuscripciones
					.add(new ReporteSubscripcionDto(subscripciones.size(), tipoPago.get(i).getNombreTipoPago()));
		}

		return reporteSuscripciones;

	}

	@Override
	public int cantidadSubscripciones() {

		return sR.findAll().size();
	}

	@Override
	public double montoSubscripciones() {
		double monto = 0;
		List<Subscripcion> subscripciones = sR.findAll();
		for (int i = 0; i < subscripciones.size(); i++) 
		{
			monto += subscripciones.get(i).getPrecio(); // se recorre con el punto get list
		}
		return monto;
	}

}
