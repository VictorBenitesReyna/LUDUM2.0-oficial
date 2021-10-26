package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "subscripcion")

public class Subscripcion

{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubscripcion;
	
}