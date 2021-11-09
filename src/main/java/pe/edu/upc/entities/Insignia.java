package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "insignia")
public class Insignia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoInsignia;

	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El estado de la reputacion no puede contener un caracter")
	@Pattern(regexp = "[^0-9]+", message = "El estado de la reputacion no puede contener un número")
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "codigovideojuego", nullable = false)
	private VideoJuego codigovideojuego;

	
	public Insignia() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Insignia(int codigoInsignia,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El estado de la reputacion no puede contener un caracter") @Pattern(regexp = "[^0-9]+", message = "El estado de la reputacion no puede contener un número") String nombre, VideoJuego codigovideojuego) {
		super();
		this.codigoInsignia = codigoInsignia;
		this.nombre = nombre;
		this.codigovideojuego = codigovideojuego;
	}


	public int getCodigoInsignia() {
		return codigoInsignia;
	}


	public void setCodigoInsignia(int codigoInsignia) {
		this.codigoInsignia = codigoInsignia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public VideoJuego getVideojuego() {
		return codigovideojuego;
	}


	public void setVideojuego(VideoJuego codigovideojuego) {
		this.codigovideojuego = codigovideojuego;
	}

	
	
}
