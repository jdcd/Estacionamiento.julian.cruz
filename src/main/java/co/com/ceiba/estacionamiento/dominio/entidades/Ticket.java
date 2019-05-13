package co.com.ceiba.estacionamiento.dominio.entidades;

import java.util.Calendar;


public class Ticket {
	private int id;
	private Vehicle vehicle;
	private Calendar startedDate;
	
	public int getId() {
		return id;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public Calendar getStartedDate() {
		return startedDate;
	}

	public Ticket(int id, Vehicle vehicle, Calendar startedDate) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.startedDate = startedDate;
	}
	
	
	
}
