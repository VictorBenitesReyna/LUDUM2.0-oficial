package pe.edu.upc.serviceimplements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Role;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.repositories.IUsuarioRepository;
import pe.edu.upc.serviceinterfaces.IUsuarioService;


@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioRepository uR;
	@Override
	public Integer insert(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		Role role = new Role();
		role.setAuthoriry("ROLE_USER");
		usuario.setRoles(new ArrayList<Role>());
		usuario.getRoles().add(role);
		Usuario usuarioRpta= new Usuario();
		int rpta=uR.nombresExistentes(usuario.getUsername());
		if(rpta==0) {
			usuarioRpta=uR.save(usuario);
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
		boolean flag =  false;
		try {
			uR.save(usuario);
			flag = true;
		} catch(Exception ex) {
			System.out.println("Ocurrió un error");
		}
		return flag;
	}

	// modificar 
	@Override
	
	@Transactional(readOnly = true)  
	public Usuario listarId(int idUsuario) 
 	       
	{
		Optional<Usuario> op = uR.findById(idUsuario);
		return op.isPresent() ? op.get() : new Usuario();
	}
     
	// hasta aca 
	
	@Override
	public Optional<Usuario> listId(int idUsuario) {
		// TODO Auto-generated method stub
		return uR.findById(idUsuario);
	}

}