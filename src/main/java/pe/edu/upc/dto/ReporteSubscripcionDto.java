package pe.edu.upc.dto;

public class ReporteSubscripcionDto {
	private int cantidad;
	private String nombre;

	public ReporteSubscripcionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReporteSubscripcionDto(int cantidad, String nombre) {
		super();
		this.cantidad = cantidad;
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
