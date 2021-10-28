package pe.edu.upc.entities;

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
	
	@Column(name = "EstadoPartida", nullable = false, length = 20)
	private boolean EstadoPartida;
	
	@Column(name = "EstadoSinError", nullable = false, length = 20)
	private boolean EstadoSinError;

	public Partida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partida(int idPartida, boolean estadoPartida, boolean estadoSinError) {
		super();
		this.idPartida = idPartida;
		EstadoPartida = estadoPartida;
		EstadoSinError = estadoSinError;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public boolean isEstadoPartida() {
		return EstadoPartida;
	}

	public void setEstadoPartida(boolean estadoPartida) {
		EstadoPartida = estadoPartida;
	}

	public boolean isEstadoSinError() {
		return EstadoSinError;
	}

	public void setEstadoSinError(boolean estadoSinError) {
		EstadoSinError = estadoSinError;
	}
	
	
	
}
