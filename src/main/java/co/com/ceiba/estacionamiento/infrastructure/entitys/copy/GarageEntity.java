package co.com.ceiba.estacionamiento.infrastructure.entitys.copy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GarageEntity {
	
	@Id
    @Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private boolean free;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="plate")
	private VehicleEntity occupant;
	
	
	public GarageEntity(boolean free, int number) {
		super();
		this.free = free;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public boolean isFree() {
		return free;
	}


	public void setFree(boolean free) {
		this.free = free;
	}


	public VehicleEntity getOccupant() {
		return occupant;
	}


	public void setOccupant(VehicleEntity occupant) {
		this.occupant = occupant;
	}
	
}
