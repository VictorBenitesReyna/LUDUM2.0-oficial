package pe.edu.upc.serviceimplements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Role;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.repositories.IRoleRepository;
import pe.edu.upc.repositories.IUsuarioRepository;
import pe.edu.upc.serviceinterfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioRepository uR;
	
	@Autowired IRoleRepository  rR;

	@Override
	public Integer insert(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		Role role = new Role();
		role.setAuthoriry("ROLE_USER");
		usuario.setRoles(new ArrayList<Role>());
		Usuario usuarioRpta = new Usuario();
		int rpta = uR.nombresExistentes(usuario.getUsername());
		if (rpta == 0) {
			usuarioRpta = uR.save(usuario);
			usuarioRpta.getRoles().add(role);
			usuarioRpta.getRoles().get(0).setUsuario(usuarioRpta);
			usuarioRpta = uR.save(usuario);
			return usuarioRpta.getIdUsuario();
		}
		return -1;
	}

	@Override
	public List<Usuario> list() {
		return uR.findAll();
	}

	@Override
	public boolean modificar(Usuario usuario) {
		boolean flag = false;
		try {
			Usuario usuarioGuardado = uR.findById(usuario.getIdUsuario()).get();
			if (usuario.getPhotoProduct() == null)
				usuario.setPhotoProduct(usuarioGuardado.getPhotoProduct());
			if (usuario.getRoles() == null)
				usuario.setRoles(usuarioGuardado.getRoles());
			if (!usuarioGuardado.getPassword().equals(passwordEncoder.encode(usuario.getPassword()))) {
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			}

			uR.save(usuario);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Ocurrió un error");
		}
		return flag;
	}

	// modificar
	@Override

	@Transactional(readOnly = true)
	public Usuario listarId(int idUsuario)

	{
		Usuario op = uR.findById(idUsuario).get();
		return op != null ? op : new Usuario();
	}

	// hasta aca

	@Override
	public Usuario listId(int idUsuario) {
		// TODO Auto-generated method stub
		return uR.findById(idUsuario).get();
	}

	@Override
	public List<Usuario> findByUsername(String username) {
		// TODO Auto-generated method stub
		return uR.findByUsername(username);
		
	}

	@Override
	public List<Usuario> listSinUsuario() {
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario= uR.findByUsername(currentUserName).get(0);
		List<Usuario> usuarios = uR.findAll();
		List<Usuario> usuariosSinusuario = new ArrayList<Usuario>();
		for(int i = 0 ; i < usuarios.size();i++)
		{
			if(!usuarios.get(i).equals(usuario))
			{
				usuariosSinusuario.add(usuarios.get(i));
			}
		}
		return usuariosSinusuario;
	}

}