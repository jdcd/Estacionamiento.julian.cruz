package co.com.ceiba.estacionamiento.domain.entidades;

import java.util.Calendar;


/**
 * @author julian.cruz
 *
 */
public class Ticket {
	private int id;
	private Vehicle vehicle;
	private Calendar startedDate;
	private int currentGarage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Calendar getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Calendar startedDate) {
		this.startedDate = startedDate;
	}

	public int getCurrentGarage() {
		return currentGarage;
	}

	public void setCurrentGarage(int currentGarage) {
		this.currentGarage = currentGarage;
	}

	public Ticket() {
		super();
	}
	
}
