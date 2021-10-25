package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "videojuego")

public class VideoJuego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigovideojuego;
	
	@Column(name = "numeroequipo",nullable = false)
	private int numeroequipo;
	
	@Column(name = "nickname", nullable = false, length = 20)
	private String nickname;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Videojuego no puede contener un caracter especial")
	@Column(name = "plataforma", nullable = false, length = 20)
	private String plataforma;

	

	public VideoJuego() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VideoJuego(int codigovideojuego, int numeroequipo, String nickname,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Videojuego no puede contener un caracter especial") String plataforma) {
		super();
		this.codigovideojuego = codigovideojuego;
		this.numeroequipo = numeroequipo;
		this.nickname = nickname;
		this.plataforma = plataforma;
	}


	public int getCodigovideojuego() {
		return codigovideojuego;
	}



	public void setCodigovideojuego(int codigovideojuego) {
		this.codigovideojuego = codigovideojuego;
	}



	public int getNumeroequipo() {
		return numeroequipo;
	}



	public void setNumeroequipo(int numeroequipo) {
		this.numeroequipo = numeroequipo;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getPlataforma() {
		return plataforma;
	}



	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


}