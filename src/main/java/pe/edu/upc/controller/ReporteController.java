package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import pe.edu.upc.serviceinterfaces.IReporteService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	@Autowired
	private IReporteService rS;
 
	@GetMapping("/tiposubscripcion")
	public String mostrarReporteTipoSubs(Model model) {
		model.addAttribute("reportes", rS.obtenerReporteTipoSubs());
		return "reportes/reportTipoSubscripcion";
	}
	
	@GetMapping("/mayortiposubscripcion")
	public String mostrarMayorReporteTipoSubs(Model model) {
		model.addAttribute("reportes", rS.mayorTipoSubscripcion());
		return "reportes/reportMayorTipoSubscripcion";
	}


	@GetMapping("/tipoPago")
	public String mostrarReporteTipoPago(Model model) {
		model.addAttribute("reportes", rS.obtenerReporteTipoPago());
		return "reportes/reportTipoPago";
	}
	
	@GetMapping("/cantidadyMonto")
	public String mostrarReporteCantidadyMonto(Model model)
	{
		model.addAttribute("reportes",rS.montoSubscripciones());
		return "reportes/reporteCantidadyMonto"; // copiamos este nombre y o ponemos en la carpeta de html
		
	}
	@GetMapping("/mayorTipoPago")
	public String mostrarReporteMayorPago(Model model) {
		model.addAttribute("reportes", rS.mayorTipoPago());
		return "reportes/reportMayorTipoPago";
	}
	@GetMapping("/cantidadLogros")
	public String cantidadLogros(Model model) {
		model.addAttribute("reportes", rS.cantidadLogrosXvideojuego());
		return "reportes/reportLogros";
	}
}
