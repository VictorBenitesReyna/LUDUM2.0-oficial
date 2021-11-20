package pe.edu.upc.dto;

public class ReporteTipoPagoDto {
	private int cantidad;
	private String nombre;

	public ReporteTipoPagoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReporteTipoPagoDto(int cantidad, String nombre) {
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
