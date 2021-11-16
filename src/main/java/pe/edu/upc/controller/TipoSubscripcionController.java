package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.serviceinterfaces.ITipoSubscripcionService;
import pe.edu.upc.entities.TipoSubscripcion;

@Controller
@RequestMapping("/tiposubscripciones")

public class TipoSubscripcionController {
	@Autowired
	private ITipoSubscripcionService tsubService;

	@GetMapping("/new")

	public String newTipoSubscripcion(Model model) {
		model.addAttribute("tiposubscripcion", new TipoSubscripcion());
		return "tiposubscripcion/tiposubscripcion";
	}

	@GetMapping("/list")
	public String listTipoSubscripciones(Model model) {
		try {
			model.addAttribute("tiposubscripcion", new TipoSubscripcion());
			model.addAttribute("listaTipoSubscripciones", tsubService.list());
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
		}
		return "tiposubscripcion/listTipoSubscripciones";
	}

	@PostMapping("/save")
	public String saveTipoSubscripcion(@Validated TipoSubscripcion tiposubscripcion, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "tiposubscripcion/tiposubscripcion";
		} else {
			int rpta = tsubService.insert(tiposubscripcion);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "tiposubscripcion/tiposubscripcion";
			} else {
				model.addAttribute("mensaje", "Se guardo correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("tiposubscripcion", new TipoSubscripcion());
		return "redirect:/tiposubscripciones/list";
	}

	@GetMapping("/reports")
	public String listReports() {
		return "reportes/report";
	}
}
