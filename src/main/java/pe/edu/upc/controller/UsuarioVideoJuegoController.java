package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.UsuarioVideoJuego;
import pe.edu.upc.serviceinterfaces.IUsuarioService;
import pe.edu.upc.serviceinterfaces.IUsuarioVideoJuegoService;
import pe.edu.upc.serviceinterfaces.IVideoJuegoService;

@Controller
@RequestMapping("/usuariovideojuegos") // llamado principal para los html
public class UsuarioVideoJuegoController {
	@Autowired
	private IUsuarioVideoJuegoService uvaS;

	@Autowired
	private IUsuarioService uS;

	@Autowired
	private IVideoJuegoService vJ;

	@GetMapping("/new")
	public String newUsuarioVideoJuego(Model model) // model llama con el signo del dolar
	{
		model.addAttribute("usuariovideojuego", new UsuarioVideoJuego());
		model.addAttribute("listaUsuarios", uS.list());
		model.addAttribute("listaVideoJuego", vJ.list());
		model.addAttribute("usuariovideojuego", new UsuarioVideoJuego());
		return "usuariovideojuego/usuariovideojuego"; // ira despues en el template
	}

	@GetMapping("/list")
	public String listUsuarioVideoJuego(Model model) {
		try {
			model.addAttribute("usuariovideojuego", new UsuarioVideoJuego());
			model.addAttribute("listaUsuarioVideoJuego", uvaS.list());
		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());
		}
		return "usuariovideojuego/listUsuarioVideoJuego"; // este list se llamara como mi html
	}

	@RequestMapping("/save")
	public String insertUsuarioVideoJuego(@ModelAttribute @Valid UsuarioVideoJuego objusuariovideojuego,
			BindingResult binRes, Model model, SessionStatus status) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaUsuarioVideoJuego", uvaS.list());
			return "usuariovideojuego/usuariovideojuego";
		}
		boolean flag = uvaS.insert(objusuariovideojuego);
		if (flag) {
			return "redirect:/usuariovideojuegos/list";
		} else {
			model.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/usuariovideojuegos/new";
		}
	}

	@RequestMapping("/list")
	public String listUsuarioVideoJuego(Map<String, Object> model) {
		model.put("listaUsuarioVideoJuego", uvaS.list());
		return "usuariovideojuego/listUsuarioVideoJuego";

	}

}
