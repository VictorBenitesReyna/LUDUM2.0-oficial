package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.VideoJuego;
import pe.edu.upc.serviceinterfaces.IVideoJuegoService;


@Controller
@RequestMapping("/videojuegos")
public class VideoJuegoController {
    @Autowired
    private IVideoJuegoService vService;

    @GetMapping("/new")
    public String newVideoJuego(Model model) {
    model.addAttribute("videojuego", new VideoJuego());
    return "videojuego/videojuego";
    }

    @GetMapping("/list")
    public String listVideojuegos(Model model) {
        try {
            model.addAttribute("videojuego", new VideoJuego());
            model.addAttribute("listaVideojuegos", vService.list());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "videojuego/listVideoJuegos";
    }

    @PostMapping("/save")
    public String saveMarca(@ModelAttribute("videojuego") @Valid VideoJuego videojuego, BindingResult result, Model model, SessionStatus status)
            throws Exception {
        if (result.hasErrors()) {
            return "videojuego/videojuego";
        } else {
            int rpta = vService.insert(videojuego);
            if (rpta == -1) {
                model.addAttribute("mensaje", "Ya existe");
                return "videojuego/videojuego";
            } else {
                model.addAttribute("mensaje", "Se guardó correctamente");
                status.setComplete();
            }
        }
        model.addAttribute("videojuego", new VideoJuego());
        return "redirect:/videojuegos/list";
    }
}