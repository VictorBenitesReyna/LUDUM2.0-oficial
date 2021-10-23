package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
@Entity
@Table(name = "reputacion")
public class Reputacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReputacion;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El estado de la reputacion no puede contener un caracter")
	@Pattern(regexp = "[^0-9]+", message = "El estado de la reputacion no puede contener un número")
	@Column(name = "estado_Reputacion", nullable = false, length = 20)
	private String estadoReputacion;
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El puntaje no puede contener un caracter")
	@Pattern(regexp = "[^a-z]+", message = "El puntaje no puede contener una letra")
	@Column(name = "Puntos", nullable = false)
	private int puntos;
	@OneToOne
	@JoinColumn(name = "codigoUsuario", nullable = false)
	private Usuario usuario;
	public Reputacion(int idReputacion,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El estado de la reputacion no puede contener un caracter") @Pattern(regexp = "[^0-9]+", message = "El estado de la reputacion no puede contener un número") String estadoReputacion,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El puntaje no puede contener un caracter") @Pattern(regexp = "[^a-z]+", message = "El puntaje no puede contener una letra") int puntos,
			Usuario usuario) {
		super();
		this.idReputacion = idReputacion;
		this.estadoReputacion = estadoReputacion;
		this.puntos = puntos;
		this.usuario = usuario;
	}
	public Reputacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdReputacion() {
		return idReputacion;
	}
	public void setIdReputacion(int idReputacion) {
		this.idReputacion = idReputacion;
	}
	public String getEstadoReputacion() {
		return estadoReputacion;
	}
	public void setEstadoReputacion(String estadoReputacion) {
		this.estadoReputacion = estadoReputacion;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
