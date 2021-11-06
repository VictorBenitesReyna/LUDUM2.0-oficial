package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "subscripcion")

public class Subscripcion

{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubscripcion;
	
	@OneToOne
	@JoinColumn(name = "codigoUsuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigoTipoPago", nullable = false)
	private TipoPago tipoPago;
	
	@ManyToOne
	@JoinColumn(name = "codigoTipoSubscripcion", nullable = false)
	private TipoSubscripcion tipoSubscripcion;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaActivacion", nullable = false)
	private Date fechaActivacion;
	
	@Column(name = "estadoPago", nullable = false)
	private boolean estadoPago; // pendiente o cancelado
	
	@Positive
	@Column(name = "precio", nullable = false)
	private double precio; 
	
	// TIEMPO
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "No puede contener letras especiales")
	@Column(name = "tiempoDuracion", nullable = false, length = 30)
	private String tiempoDuracion;

	public Subscripcion(int idSubscripcion, Usuario usuario, TipoPago tipoPago, TipoSubscripcion tipoSubscripcion,
			Date fechaActivacion, boolean estadoPago, @Positive double precio,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "No puede contener letras especiales") String tiempoDuracion) {
		super();
		this.idSubscripcion = idSubscripcion;
		this.usuario = usuario;
		this.tipoPago = tipoPago;
		this.tipoSubscripcion = tipoSubscripcion;
		this.fechaActivacion = fechaActivacion;
		this.estadoPago = estadoPago;
		this.precio = precio;
		this.tiempoDuracion = tiempoDuracion;
	}

	public Subscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSubscripcion() {
		return idSubscripcion;
	}

	public void setIdSubscripcion(int idSubscripcion) {
		this.idSubscripcion = idSubscripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public TipoSubscripcion getTipoSubscripcion() {
		return tipoSubscripcion;
	}

	public void setTipoSubscripcion(TipoSubscripcion tipoSubscripcion) {
		this.tipoSubscripcion = tipoSubscripcion;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public boolean isEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(boolean estadoPago) {
		this.estadoPago = estadoPago;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTiempoDuracion() {
		return tiempoDuracion;
	}

	public void setTiempoDuracion(String tiempoDuracion) {
		this.tiempoDuracion = tiempoDuracion;
	}

}
