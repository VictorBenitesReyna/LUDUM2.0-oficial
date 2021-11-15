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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Emparejamiento;
import pe.edu.upc.entities.Partida;
import pe.edu.upc.serviceinterfaces.IEmparejamientoService;
import pe.edu.upc.serviceinterfaces.IPartidaService;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/emparejamientos")
public class EmparejamientoController {
	
	@Autowired
	private IEmparejamientoService eS;
	
	@Autowired
	private IUsuarioService uS;
	
	@Autowired
	private IPartidaService pS;
	
	@GetMapping("/new")
	public String newEmparejamiento(Model model) {
		model.addAttribute("emparejamiento", new Emparejamiento());
		model.addAttribute("listaUsuarios", uS.list());
		model.addAttribute("listapartidas", pS.listByEstadoPartida(true));
		model.addAttribute("emparejamiento", new Emparejamiento());
		return "emparejamiento/emparejamiento";

	}
	
	@GetMapping("/list")
	public String listEmparejamientos(Model model) 
	{
		try {
			model.addAttribute("emparejamiento", new Emparejamiento());
			model.addAttribute("listaEmparejamientos", eS.listarPorEstadoPartida(true));
			model.addAttribute("listaPartida", pS.listByEstadoPartida(true));
			model.addAttribute("partida", new Partida());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "emparejamiento/listEmparejamientos";
	}
	
	@RequestMapping("/buscar")
	public String buscarPorIdPartida(@ModelAttribute("partida") @Valid Partida objP, BindingResult binRes, Model model,
			SessionStatus status) {
		
		try {
			model.addAttribute("emparejamiento", new Emparejamiento());
			model.addAttribute("listaPartida", pS.listByEstadoPartida(true));
			model.addAttribute("listaEmparejamientos", eS.listarPorIdPartidaAndEstadoPartida(objP.getIdPartida(), true));
			model.addAttribute("partida", new Partida());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		
		return "emparejamiento/listEmparejamientos";
	}
	
	@RequestMapping("/save")
	public String insertEmparejamiento(@ModelAttribute @Valid Emparejamiento objEmp, BindingResult binRes, Model model, RedirectAttributes flash, SessionStatus status)
		throws ParseException {
		if(binRes.hasErrors()) {
			model.addAttribute("listaUsuarios", uS.list());
			model.addAttribute("listaPartidas", pS.listByEstadoPartida(true));
			return "emparejamiento/emparejamiento";
		}else {
			boolean flag = eS.insert(objEmp);
			if(flag) {
				return "redirect:/emparejamientos/list";
			}else {
				model.addAttribute("mensaje", "ocurrio un error");
				return "redirect:/emparejamientos/new";
			}
		}	
	}
	
	@RequestMapping("/list")
	public String listEmparejamientos(Map<String, Object> model) {
		model.put("listaEmparejamientos", eS.listarPorEstadoPartida(true));
		return "emparejamiento/listEmparejamientos";
	}
	
	@RequestMapping("listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Emparejamiento epm) {
		eS.listarId(epm.getIdEmparejamiento());
		return "emparejamiento/listEmparejamientos";
	}
}
