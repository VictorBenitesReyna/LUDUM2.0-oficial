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

import pe.edu.upc.serviceinterfaces.ITipoPagoService;
import pe.edu.upc.entities.TipoPago;

@Controller
@RequestMapping("/tipopagos")

public class TipoPagoController 
{
	@Autowired
	private ITipoPagoService tpService;
	
	@GetMapping("/new")
	public String newTipoPago(Model model)
	{
		model.addAttribute("tipopago",new TipoPago());
		return "tipopago/tipopago";
	}
	
	@GetMapping("/list")
	public String listTipoPagos(Model model)
	{
		try {
			model.addAttribute("tipopago", new TipoPago());
			model.addAttribute("listaTipoPagos", tpService.list()); 
			// el mismo nombre de listatipopagos ira en listTipoPagos
			 // al listar
		} catch (Exception e)
		{
			model.addAttribute("error",e.getMessage());
		}
		return "tipopago/listTipoPagos";
	}
	@PostMapping("/save")
	public String saveTipoPago(@Validated TipoPago tipopago, BindingResult result, Model model, SessionStatus status)
	throws Exception
	{
		if (result.hasErrors())
		{
			return "tipopago/tipopago";
		} else {
			int rpta = tpService.insert(tipopago);
			if(rpta > 0) 
			{
				model.addAttribute("mensaje", "Ya existe");
				return "tipopago/tipopago";
			} 
			else 
			{
				model.addAttribute("mensaje","Se guardo correctamente");
				status.setComplete();
			}
		}
		
		model.addAttribute("tipopago",new TipoPago());
		return "redirect:/tipopagos/list";
	}
}








