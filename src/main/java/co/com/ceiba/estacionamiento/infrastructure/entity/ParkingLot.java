package co.com.ceiba.estacionamiento.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="Profesor")
public class ParkingLot {
	
	@
	private int parckingId;
	private int carsCapacity;   
	private int bikesCapacity;
	
	private List<Garage> carsSpace;
	private List<Garage> bikesSpace;
	
	
	
	public ParkingLot(int carsCapacity, int bikesCapacity) {
		this.carsCapacity = carsCapacity;
		this.bikesCapacity = bikesCapacity;
		configParkLot();
	}

	public int getCarsCapacity() {
		return carsCapacity;
	}
	
	public int getBikesCapacity() {
		return bikesCapacity;
	}

	public List<Garage> getCarsSpace() {
		return carsSpace;
	}

	public List<Garage> getBikesSpace() {
		return bikesSpace;
	}
	
}
