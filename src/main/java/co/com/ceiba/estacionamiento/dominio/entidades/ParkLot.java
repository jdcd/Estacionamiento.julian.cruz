package co.com.ceiba.estacionamiento.dominio.entidades;

import java.util.List;

public class ParkLot {
	
	private short carsCapacity;   
	private short bikesCapacity;
	
	private List<Garage> carsSpace;
	private List<Garage> bikesSpace;
	
	public short getCarsCapacity() {
		return carsCapacity;
	}
	
	public void setCarsCapacity(short carsCapacity) {
		this.carsCapacity = carsCapacity;
	}
	
	public short getBikesCapacity() {
		return bikesCapacity;
	}
	
	public void setBikesCapacity(short bikesCapacity) {
		this.bikesCapacity = bikesCapacity;
	}

	public List<Garage> getCarsSpace() {
		return carsSpace;
	}

	public List<Garage> getBikesSpace() {
		return bikesSpace;
	}
	
	
	
	
	
	
	
}
