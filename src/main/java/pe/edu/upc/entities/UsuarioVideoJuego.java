package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usuariovideojuego")

public class UsuarioVideoJuego 

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoUV;
	
	@Column(name = "numeroequipo",nullable = false)
	private int numeroequipo;
	
	@Column(name = "nickname", nullable = false, length = 20)
	private String nickname;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigovideojuego", nullable = false)
	private VideoJuego videojuego;
	
	
	public UsuarioVideoJuego() 
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public UsuarioVideoJuego(int codigoUV, int numeroequipo, String nickname, Usuario usuario, VideoJuego videojuego) {
		super();
		this.codigoUV = codigoUV;
		this.numeroequipo = numeroequipo;
		this.nickname = nickname;
		this.usuario = usuario;
		this.videojuego = videojuego;
	}


	public int getCodigoUV() {
		return codigoUV;
	}


	public void setCodigoUV(int codigoUV) {
		this.codigoUV = codigoUV;
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public VideoJuego getVideojuego() {
		return videojuego;
	}


	public void setVideojuego(VideoJuego videojuego) {
		this.videojuego = videojuego;
	}
	
	
}



