package co.com.ceiba.estacionamiento.domain.entidades;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	private int carsCapacity;   
	private int bikesCapacity;
	
	private List<Garage> carsSpace;
	private List<Garage> bikesSpace;
	
	
	
	public ParkingLot(int carsCapacity, int bikesCapacity) {
		this.carsCapacity = carsCapacity;
		this.bikesCapacity = bikesCapacity;
		configParkLot();
	}

	private void configParkLot() {
		
		carsSpace = new ArrayList<>();
		bikesSpace = new ArrayList<>();
		
		for (int i=1; i <= carsCapacity ; i++) {
			carsSpace.add(new Garage(true, i));
		}
		
		for (int j=1; j <= bikesCapacity ; j++) {
			carsSpace.add(new Garage(true, j));
		}
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
