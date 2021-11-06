package pe.edu.upc.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Role;
import pe.edu.upc.serviceinterfaces.IRoleService;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private IRoleService rolService;
	@Autowired
	private IUsuarioService uService;
	
	@GetMapping("/new")
	public String newRol(Model model) {
		model.addAttribute("rol", new Role());
		model.addAttribute("listaUsuarios", uService.list());
		return "rol/rol";
	}

	@GetMapping("/list")
	public String listRol(Model model) {
		try {
			model.addAttribute("listaRoles", rolService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rol/listRoles";
	}

	@RequestMapping("/save")
	public String insertRol(@ModelAttribute @Valid Role objRol, BindingResult binRes, Model model,
			SessionStatus status) throws ParseException 
	{
		if (binRes.hasErrors()) 
		{
			model.addAttribute("listaRoles", rolService.list());
			return "rol/rol";
		}
		boolean flag = rolService.insert(objRol);
		if (flag) {
			return "redirect:/roles/list";
		} else {
			model.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/roles/new";
		}
	}


	

}
