package pe.edu.upc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterfaces.IUploadFileService;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private IUsuarioService uService;

	@Autowired
	private IUploadFileService uploadFileService;

	/*
	 * @Autowired private IRoleService rService;
	 */

	@GetMapping("/new")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/usuario";
	}

	@GetMapping("/list")
	public String listUsuarios(Model model) {
		try {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "usuario/listUsuarios";
	}

	@PostMapping("/save")
	public String saveUsuario(@ModelAttribute @Validated Usuario usuario, BindingResult result, Model model,
			SessionStatus status, @RequestParam("file") MultipartFile foto, RedirectAttributes flash) throws Exception {
		if (result.hasErrors()) {
			return "usuario/usuario";
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
			if (usuario.getIdUsuario() == 0) {
				int rpta = uService.insert(usuario);

				if (rpta == -1) {
					model.addAttribute("mensaje", "Ya existe");
					return "usuario/usuario";
				} else {

					model.addAttribute("mensaje", "Se guardó correctamente");
					status.setComplete();
				}
			} else {
				
				boolean rpta = uService.modificar(usuario);

				if (rpta == false) {
					model.addAttribute("mensaje", "Error al modificar");
					return "usuario/usuario";
				} else {

					model.addAttribute("mensaje", "Se guardó correctamente");
					status.setComplete();
				}
			}
		}
		model.addAttribute("usuario", new Usuario());
		if (usuario.getIdUsuario() == 0) {
			return "login";
		} else {
			model.addAttribute("mensaje", "Registro Exitoso");
			return "redirect:/usuarios/list";
		}

	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/view/{id}")
	public String view(@PathVariable(value = "id") int id, Map<String, Object> model, RedirectAttributes flash) {

		Usuario usuario = uService.listarId(id);

		if (usuario == null) {
			flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
			return "usuario/listUsuarios";
		}

		model.put("usuario", usuario);
		model.put("titulo", "Detalle del usuario: " + usuario.getUsername());

		return "usuario/ver";
	}

	@RequestMapping("/list")
	public String listUsuarios(Map<String, Object> model) {
		model.put("listaUsuarios", uService.list());
		return "usuario/listUsuarios";

	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Usuario usuario) {
		uService.listarId(usuario.getIdUsuario());
		return "usuario/listUsuarios";

	}

	// modificar
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) {

		Usuario objPro = uService.listarId(id);

		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³ un error");
			return "redirect:/usuarios/list";
		} else {
			model.addAttribute("usuario", objPro);
			return "usuario/usuario";
		}
	}
	
	@RequestMapping("/buscar")
	public String finbyCategory(Map<String, Object> model, @ModelAttribute Usuario usuario)
			throws  ParseException {
		List<Usuario> listaUsuarios;
		usuario.setUsername(usuario.getUsername());
		listaUsuarios = uService.findByUsername(usuario.getUsername());
		if(listaUsuarios.isEmpty()) {
			listaUsuarios = uService.list();
		}
		if(listaUsuarios.isEmpty()) {
			model.put("mensaje", "No se encontraron coincidencias");
		}
		model.put("listaUsuarios", listaUsuarios);
		model.put("usuario", new Usuario());
		return "usuario/listUsuarios" ;
		
	}

}
