package co.com.ceiba.estacionamiento.dominio.entidades;

public class Garage {
	private VehicleType tipo;
	private boolean disponibilidad;
	private Vehicle ocupante;
	
	public Garage() {}
		
	public void ocuparCelda(Vehicle ocupante) {
		this.ocupante = ocupante;
		this.disponibilidad = false;
	}
	
	public void liberarCelda() {
		this.ocupante = null;
		this.disponibilidad = true;
	}
}
