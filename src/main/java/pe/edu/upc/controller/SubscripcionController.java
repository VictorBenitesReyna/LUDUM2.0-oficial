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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.serviceinterfaces.ISubscripcionService;
import pe.edu.upc.serviceinterfaces.ITipoPagoService;
import pe.edu.upc.serviceinterfaces.ITipoSubscripcionService;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/subscripciones")
public class SubscripcionController 
{
	@Autowired
	private ISubscripcionService subService;
	
	@Autowired
	private IUsuarioService uService;
	
	@Autowired
	private ITipoPagoService tpService;
	
	@Autowired
	private ITipoSubscripcionService tsubService;
	
	
	@GetMapping("/new")
	public String newSubscripcion(Model model)
	{
		model.addAttribute("subscripcion", new Subscripcion());
		
		model.addAttribute("listaUsuarios", uService.list());
		model.addAttribute("listaTipoPago", tpService.list());
		model.addAttribute("listaTipoSubscripcion", tsubService.list());
		
		model.addAttribute("subscripcion",new Subscripcion());
		
		return "subscripcion/subscripcion";
		
	}
	@GetMapping("/list")
	public String listSubscripcion(Model model)
	{
		try
		{
			model.addAttribute("subscripcion", new Subscripcion());
			model.addAttribute("listaSubscripcion", subService.list());
			model.addAttribute("listaTipoSubscripcion", tsubService.list());
			model.addAttribute("tiposubscripcion",new TipoSubscripcion());
		}
		catch (Exception e)
		{
			model.addAttribute("error", e.getMessage());
		}
		return "subscripcion/listSubscripcion";
	}
	
	@RequestMapping("/buscar")
	public String buscarPorTipoSubscripcion(@ModelAttribute("tiposubscripcion") @Valid TipoSubscripcion objTs, BindingResult binRes, Model model,
			SessionStatus status)
	{
		try
		{
			model.addAttribute("subscripcion", new Subscripcion());
			model.addAttribute("listaTipoSubscripcion", tsubService.list());
			model.addAttribute("listaSubscripcion", subService.findByTipoSubscripcionIdTipoSubscripcion(objTs.getIdTipoSubscripcion()));
			model.addAttribute("tiposubscripcion",new TipoSubscripcion());
		}
		catch (Exception e)
		{
			model.addAttribute("error", e.getMessage());
		}
		
		return "subscripcion/listSubscripcion";
	}
	@RequestMapping("/save")
	public String insertSubscripcion(@ModelAttribute @Valid Subscripcion objSubscripcion, BindingResult binRes, Model model,
			SessionStatus status) throws ParseException 
	{
		if (binRes.hasErrors()) 
		{
			model.addAttribute("listaSubscripcion", subService.list());
			model.addAttribute("listaUsuarios", uService.list());
			model.addAttribute("listaTipoPago", tpService.list());
			model.addAttribute("listaTipoSubscripcion", tsubService.list());
			return "subscripcion/subscripcion";
		}
		boolean flag = subService.insert(objSubscripcion);
		if (flag) {
			return "redirect:/subscripciones/list";
		} else {
			model.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/subscripciones/new";
		}
	}
	@RequestMapping("/list")
	public String listSubscripciones(Map<String, Object> model) 
	{
		model.put("listaSubscripcion", subService.list());
		return "subscripciones/listSubscripcion";

	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Subscripcion sub) 
	{
		subService.listarID(sub.getIdSubscripcion());
		return "subscripcion/listSubscripcion";
	}
	
	@RequestMapping("/delete")
	public String deleteSubscripcion(Model model, @RequestParam(value = "id") Integer id) 
	{
		subService.delete(id);
		model.addAttribute("subscripcion", new Subscripcion());
		model.addAttribute("listaSubscripcion", subService.list());
		model.addAttribute("listaTipoSubscripcion", tsubService.list());
		model.addAttribute("tiposubscripcion",new TipoSubscripcion());
		
		return "subscripcion/listSubscripcion";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	{
		Subscripcion objPro = subService.listarID(id);
		
		model.addAttribute("listaUsuarios", uService.list());
		model.addAttribute("listaTipoPago", tpService.list());
		model.addAttribute("listaTipoSubscripcion", tsubService.list());
		
		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³ un error");
			return "redirect:/subscripciones/list";
		
		} else {
			model.addAttribute("subscripcion", objPro);
			return "subscripcion/subscripcion";
		}
	}
	
}





























