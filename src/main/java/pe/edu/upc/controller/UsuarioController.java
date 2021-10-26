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

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterfaces.IUsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private IUsuarioService uService;
	
	@GetMapping("/new")
	public String newUsuario(Model model) 
	{
		model.addAttribute("usuario", new Usuario());
		return "usuario/usuario";
	}
	@GetMapping("/list")
	public String listUsuarios(Model model) 
	{
		try {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "usuario/listUsuarios";
	}
	@PostMapping("/save")
	public String saveUsuario(@Validated Usuario usuario, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "usuario/usuario";
		} else {
			int rpta = uService.insert(usuario);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "usuario/usuario";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("usuario", new Usuario());
		return "redirect:/usuarios/list";
	}
}
