package co.com.ceiba.estacionamiento.infrastructure.entity;

public class Garage {
	private boolean free;
	private int number;
	private Vehicle occupant;
	
	public Garage(boolean free, int number) {
		super();
		this.free = free;
		this.number = number;
	}

	public int fillGarage(Vehicle occupnat) {
		this.free = false;
		this.occupant = occupnat;
		return this.number;
	}
	
	public void liberateGarage() {
		this.free = true;
		this.occupant = null;
	}

	public boolean isFree() {
		return free;
	}

	public int getNumber() {
		return number;
	}
	
	public Vehicle getOccupant() {
		return occupant;
	}
	
}
