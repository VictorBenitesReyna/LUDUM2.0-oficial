package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Role;

public interface IRoleService {
	public boolean insert(Role role);

	List<Role> list();

}
