package co.com.ceiba.estacionamiento.dominio.entidades;

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
