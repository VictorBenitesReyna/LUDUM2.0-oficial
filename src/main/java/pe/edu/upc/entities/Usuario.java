package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Usuario no puede contener un caracter especial") //restricciones
	@Pattern(regexp = "[^0-9]+", message = "El nombre del Usuario no puede contener un número")
	@Column(name = "nombreUsuario",length=35,nullable = false)
	private String nombreUsuario;
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El Apellido del Usuario no puede contener un caracter especial")
	@Pattern(regexp = "[^0-9]+", message = "El Apellido del Usuario no puede contener un número")
	@Column(name = "apellidoUsuario", nullable = false, length = 20)
	private String apellidoUsuario;
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	@Column(name = "nickname", nullable = false, length = 20)
	private String nickname;
	
	
	public Usuario(int idUsuario,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Usuario no puede contener un caracter especial") @Pattern(regexp = "[^0-9]+", message = "El nombre del Usuario no puede contener un número") String nombreUsuario,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El Apellido del Usuario no puede contener un caracter especial") @Pattern(regexp = "[^0-9]+", message = "El Apellido del Usuario no puede contener un número") String apellidoUsuario,
			String password, String nickname) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.password = password;
		this.nickname = nickname;
	}
	public Usuario() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
