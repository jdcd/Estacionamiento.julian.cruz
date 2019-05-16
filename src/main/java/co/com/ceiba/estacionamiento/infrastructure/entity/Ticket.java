package co.com.ceiba.estacionamiento.infrastructure.entity;

import java.time.LocalDateTime;

/**
 * @author julian.cruz
 *
 */
public class Ticket {
	private int id;
	private Vehicle vehicle;
	private LocalDateTime startedDate;
	private int currentGarage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Ticket(Vehicle vehicle, LocalDateTime startedDate, int currentGarage) {
		super();
		this.vehicle = vehicle;
		this.startedDate = startedDate;
		this.currentGarage = currentGarage;
	}

	public LocalDateTime getStartedDate() {
		return startedDate;
	}

	public int getCurrentGarage() {
		return currentGarage;
	}

	public void setCurrentGarage(int currentGarage) {
		this.currentGarage = currentGarage;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	
	
}
