package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Partida;
import pe.edu.upc.serviceinterfaces.IPartidaService;

@Controller
@RequestMapping("/partidas")
public class PartidaController {

	@Autowired
	private IPartidaService pS;

	@GetMapping("/new")
	public String newPartida(Model model) {
		Partida partida = new Partida();
		partida.setEstadoPartida(true);
		model.addAttribute("partida", partida);
		return "partida/partida";
	}

	@GetMapping("/list")
	public String listPartidas(Model model) {
		try {
			model.addAttribute("partida", new Partida());
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			boolean hasRoleAdmin = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
			if (hasRoleAdmin == true) {
				model.addAttribute("listapartidas", pS.list());
			} else {
				model.addAttribute("listapartidas", pS.listByEstadoPartida(true));
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "partida/listPartidas";
	}

	@PostMapping("/save")
	public String savePartida(@Valid Partida partida, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "partida/partida";
		} else {
			int rpta = pS.insert(partida);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Partida existente");
				return "partida/partida";
			} else {
				model.addAttribute("mensaje", "se guardo bien");
				status.setComplete();
			}
		}
		model.addAttribute("partida", new Partida());
		return "redirect:/partidas/list";
	}
}
