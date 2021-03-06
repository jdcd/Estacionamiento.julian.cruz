package co.com.ceiba.estacionamiento.domain.entidades;

public class Vehicle {
	private String plate;
	private VehicleType type;
	private int displacement;
	
	public Vehicle(String plate, VehicleType type, int displacement) {
		super();
		this.plate = plate;
		this.type = type;
		this.displacement = displacement;
	}
	
	public Vehicle(String plate, VehicleType type) {
		super();
		this.plate = plate;
		this.type = type;
	}
	
	public String getPlate() {
		return plate;
	}
	public VehicleType getType() {
		return type;
	}
	public int getDisplacement() {
		return displacement;
	}

	
	
	
}
