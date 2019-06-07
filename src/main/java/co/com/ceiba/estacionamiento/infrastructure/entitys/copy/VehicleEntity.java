package co.com.ceiba.estacionamiento.infrastructure.entitys.copy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleEntity {
	@Id
	@Column(nullable = false)
	private String plate;
	
	@Column(nullable = false)
	private VehicleType type;
	
	@Column(nullable = true)
	private int displacement;
	
	public VehicleEntity(String plate, VehicleType type, int displacement) {
		this.plate = plate;
		this.type = type;
		this.displacement = displacement;
	}
	
	public VehicleEntity(String plate, VehicleType type) {
		super();
		this.plate = plate;
		this.type = type;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
}
