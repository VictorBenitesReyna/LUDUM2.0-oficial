package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partida")
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPartida;
	
	@Column(name = "estadoPartida", nullable = false)
	private boolean estadoPartida;
	
	@Column(name = "estadoSinError", nullable = false)
	private boolean estadoSinError;
	
	
	@Column(name = "tiempoDuracionPartida", nullable = false)
	private Date tiempoDuracionPartida;

	public Partida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partida(int idPartida, boolean estadoPartida, boolean estadoSinError, Date tiempoDuracionPartida) {
		super();
		this.idPartida = idPartida;
		this.estadoPartida = estadoPartida;
		this.estadoSinError = estadoSinError;
		this.tiempoDuracionPartida = tiempoDuracionPartida;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public boolean isEstadoPartida() {
		return estadoPartida;
	}

	public void setEstadoPartida(boolean estadoPartida) {
		this.estadoPartida = estadoPartida;
	}

	public boolean isEstadoSinError() {
		return estadoSinError;
	}

	public void setEstadoSinError(boolean estadoSinError) {
		this.estadoSinError = estadoSinError;
	}

	public Date getTiempoDuracionPartida() {
		return tiempoDuracionPartida;
	}

	public void setTiempoDuracionPartida(Date tiempoDuracionPartida) {
		this.tiempoDuracionPartida = tiempoDuracionPartida;
	}

	

	
	
	
}
