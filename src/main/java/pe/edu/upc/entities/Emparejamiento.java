package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emparejamiento")
public class Emparejamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmparejamiento;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idPartida", nullable = false)
	private Partida partida;

	public Emparejamiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emparejamiento(int idEmparejamiento, Usuario usuario, Partida partida) {
		super();
		this.idEmparejamiento = idEmparejamiento;
		this.usuario = usuario;
		this.partida = partida;
	}

	public int getIdEmparejamiento() {
		return idEmparejamiento;
	}

	public void setIdEmparejamiento(int idEmparejamiento) {
		this.idEmparejamiento = idEmparejamiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
	
}
