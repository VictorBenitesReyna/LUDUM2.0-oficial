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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Reputacion;
import pe.edu.upc.serviceinterfaces.IReputacionService;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/reputaciones")
public class ReputacionController 
{
	@Autowired
	private IReputacionService rService;
	@Autowired
	private IUsuarioService uService;

	@GetMapping("/new")
	public String newReputacion(Model model) 
	{
		model.addAttribute("reputacion", new Reputacion());
		
		model.addAttribute("listaUsuarios", uService.list());
		
		model.addAttribute("reputacion", new Reputacion());
		return "reputacion/reputacion";
	}

	@GetMapping("/list")
	public String listReputacion(Model model) 
	{
		try {
			model.addAttribute("reputacion", new Reputacion());
			model.addAttribute("listaReputacion", rService.list());
		}
		catch (Exception e) 
		{
			model.addAttribute("error", e.getMessage());
		}
		return "reputacion/listReputacion";
	}

	@RequestMapping("/save")
	public String insertReputacion(@ModelAttribute @Valid Reputacion objReputacion, BindingResult binRes, Model model,
			SessionStatus status) throws ParseException 
	{
		if (binRes.hasErrors()) 
		{
			model.addAttribute("listaReputacion", rService.list());
			return "reputacion/reputacion";
		}
		boolean flag = rService.insert(objReputacion);
		if (flag) {
			return "redirect:/reputaciones/list";
		} else {
			model.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/reputaciones/new";
		}
	}

	@RequestMapping("/list")
	public String listReputacion(Map<String, Object> model) 
	{
		model.put("listaReputacion", rService.list());
		return "reputacion/listReputacion";

	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Reputacion rep) 
	{
		rService.listarId(rep.getIdReputacion());
		return "reputacion/listReputacion";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) {

		Reputacion objReputacion = rService.listarId(id);
		if (objReputacion == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³ un error");
			return "redirect:/reputaciones/list";
		} else {
			model.addAttribute("listaUsuarios", uService.list());
			model.addAttribute("reputacion", objReputacion);
			return "reputacion/reputacion";
		}
	}
}
