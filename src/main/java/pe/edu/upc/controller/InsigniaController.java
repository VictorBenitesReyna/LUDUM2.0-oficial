package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Insignia;
import pe.edu.upc.entities.VideoJuego;
import pe.edu.upc.serviceinterfaces.IInsigniaService;
import pe.edu.upc.serviceinterfaces.IVideoJuegoService;

@Controller
@RequestMapping("/insignias")
public class InsigniaController {
	@Autowired
	private IInsigniaService iService;
	@Autowired
	private IVideoJuegoService vService;

	@GetMapping("/new")
	public String newInsignia(Model model) {
		model.addAttribute("insignia", new Insignia());
		model.addAttribute("listaVideojuegos", vService.list());
		model.addAttribute("insignia", new Insignia());
		return "insignia/insignia";
	}

	@GetMapping("/list")
	public String listInsignia(Model model) {
		try {
			model.addAttribute("insignia", new Insignia());
			model.addAttribute("listaInsignia", iService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "insignia/listInsignia";
	}

	@RequestMapping("/save")
	public String insertInsignia(@ModelAttribute @Valid Insignia objInsignia, BindingResult binRes, Model model,
			SessionStatus status) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaInsignia", iService.list());
			return "insignia/insignia";
		}
		boolean flag = iService.insert(objInsignia);
		if (flag) {
			return "redirect:/insignias/list";
		} else {
			model.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/insignias/new";
		}
	}
	@GetMapping(value = "/view/{codigovideojuego}")
	public String view(@PathVariable(value = "codigovideojuego") int codigovideojuego, Map<String, Object> model, RedirectAttributes flash) {

		VideoJuego videojuego = vService.listId(codigovideojuego).get();

		
		if (videojuego == null) {
			flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
			return "videojuego/listVideoJuegos";
		}
		List<Insignia> listainsignias=iService.listByVideojuego(codigovideojuego);
		if (listainsignias == null) {
			flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
			return "videojuego/listVideoJuegos";
		}
		model.put("listaInsignia", listainsignias);
		return "insignia/listInsignia";
	}

	@RequestMapping("/list")
	public String listInsignia(Map<String, Object> model) {
		model.put("listaInsignia", iService.list());
		return "insignia/listInsignia";

	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Insignia insig) {
		iService.listarId(insig.getCodigoInsignia());
		return "insignia/listInsignia";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) {

		Insignia objInsignia = iService.listarId(id);
		if (objInsignia == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³ un error");
			return "redirect:/insignias/list";
		} else {
			model.addAttribute("listaVideojuegos", vService.list());
			model.addAttribute("insignia", objInsignia);
			return "insignia/insignia";
		}
	}
}
