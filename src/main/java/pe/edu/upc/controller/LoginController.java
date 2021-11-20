package pe.edu.upc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterfaces.IUploadFileService;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Controller
public class LoginController {
	@Autowired
	private IUsuarioService uService;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String irLogin() {
		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String irLogout() {
		return "redirect:/login";
	}

	@GetMapping("/login/new")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "register";

	}

	@PostMapping("/login/save")
	public String saveUsuario(@ModelAttribute @Validated Usuario usuario, BindingResult result, Model model,
			SessionStatus status, @RequestParam("file") MultipartFile foto, RedirectAttributes flash) throws Exception {
		if (result.hasErrors()) {
			return "register";
		} else {
			if (!foto.isEmpty()) {

				if (usuario.getIdUsuario() > 0 && usuario.getPhotoProduct() != null
						&& usuario.getPhotoProduct().length() > 0) {

					uploadFileService.delete(usuario.getPhotoProduct());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(foto);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				usuario.setPhotoProduct(uniqueFilename);
			}
			int rpta = uService.insert(usuario);

			if (rpta == -1) {
				model.addAttribute("mensaje", "Ya existe");
				return "register";
			} else {

				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
				return "redirect:/login";
			}

		}

	}

}
