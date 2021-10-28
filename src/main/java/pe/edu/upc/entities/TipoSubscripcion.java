package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tiposubscripcion")

public class TipoSubscripcion 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoSubscripcion;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del tipo de subscripcion no puede contener un caracter especial") //restricciones
	@Pattern(regexp = "[^0-9]+", message = "El nombre del tipo subscripcion no puede contener un número")
	@Column(name = "nombreTipoSubscripcion",length=35,nullable = false)
	private String nombreTipoSubscripcion;

	public TipoSubscripcion(int idTipoSubscripcion,
			@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del tipo de subscripcion no puede contener un caracter especial") 
	        @Pattern(regexp = "[^0-9]+", message = "El nombre del tipo subscripcion no puede contener un número") String nombreTipoSubscripcion) 
	{
		super();
		this.idTipoSubscripcion = idTipoSubscripcion;
		this.nombreTipoSubscripcion = nombreTipoSubscripcion;
	}

	public TipoSubscripcion() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoSubscripcion() {
		return idTipoSubscripcion;
	}

	public void setIdTipoSubscripcion(int idTipoSubscripcion) {
		this.idTipoSubscripcion = idTipoSubscripcion;
	}

	public String getNombreTipoSubscripcion() {
		return nombreTipoSubscripcion;
	}

	public void setNombreTipoSubscripcion(String nombreTipoSubscripcion) {
		this.nombreTipoSubscripcion = nombreTipoSubscripcion;
	}
	
}