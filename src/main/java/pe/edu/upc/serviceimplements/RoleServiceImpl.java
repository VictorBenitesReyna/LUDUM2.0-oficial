package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Role;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.repositories.IRoleRepository;
import pe.edu.upc.serviceinterfaces.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public boolean insert(Role role) {
		Role rolerpta = roleRepository.save(role);
		if (rolerpta == null)
			return false;
		else
			return true;
	}
	@Override
	public List<Role> list() {
		return roleRepository.findAll();
	}

}
