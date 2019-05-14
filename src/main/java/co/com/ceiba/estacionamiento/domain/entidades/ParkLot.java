package co.com.ceiba.estacionamiento.domain.entidades;


public class ParkLot {
	
	private int carsCapacity;   
	private int bikesCapacity;
	
	private Garage[] carsSpace;
	private Garage[] bikesSpace;
	
	
	
	public ParkLot(int carsCapacity, int bikesCapacity) {
		super();
		this.carsCapacity = carsCapacity;
		this.bikesCapacity = bikesCapacity;
		configParkLot();
	}

	private void configParkLot() {
		carsSpace = new Garage[this.carsCapacity];
		bikesSpace = new Garage[this.bikesCapacity];
		
		for (int i=1; i <= carsCapacity ; i++) {
			carsSpace[i-1] = new Garage(true,i);
		}
		
		for (int j=1; j <= bikesCapacity ; j++) {
			bikesSpace[j-1] = new Garage(true,j);
		}
	}

	public int getCarsCapacity() {
		return carsCapacity;
	}
	
	public int getBikesCapacity() {
		return bikesCapacity;
	}

	public Garage[] getCarsSpace() {
		return carsSpace;
	}

	public Garage[] getBikesSpace() {
		return bikesSpace;
	}
	
	
	

	
}
