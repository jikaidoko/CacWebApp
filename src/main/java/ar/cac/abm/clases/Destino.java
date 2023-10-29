package ar.cac.abm.clases;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Destino {
 
	private int id;
	private String destino;
	private double precio;
	
	
	
	
	
	public Destino(int id,String destino, double precio) {
		this.id = id;
		this.destino = destino;
		this.precio = precio;
		
		
	}
	public Destino(String destino, double d) {
		
		this.destino = destino;
		this.precio = d;
		
		
	}
	public String toString() {
		
		return this.id + " " + this.destino + " " + this.precio;
	}
	
		
}
