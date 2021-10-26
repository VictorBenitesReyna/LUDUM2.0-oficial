package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tipopago")

public class TipoPago 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoPago;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "Los tipos de pago no puede contener un caracter especial") //restricciones
	@Pattern(regexp = "[^0-9]+", message = "Los tipos de pago no puede contener un número")
	@Column(name = "nombreTipoPago",length=35,nullable = false)
	private String nombreTipoPago;

	public TipoPago(int idTipoPago,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "Los tipos de pago no puede contener un caracter especial") @Pattern(regexp = "[^0-9]+", message = "Los tipos de pago no puede contener un número") String nombreTipoPago) 
	{
		super();
		this.idTipoPago = idTipoPago;
		this.nombreTipoPago = nombreTipoPago;
	}

	public TipoPago() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(int idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getNombreTipoPago() {
		return nombreTipoPago;
	}

	public void setNombreTipoPago(String nombreTipoPago) {
		this.nombreTipoPago = nombreTipoPago;
	}
	
}
