package co.com.ceiba.estacionamiento.infrastructure.model.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Garage {
	
	@Id
    @Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private boolean free;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="plate")
	private Vehicle occupant;
	
	
	public Garage(boolean free, int number) {
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


	public Vehicle getOccupant() {
		return occupant;
	}


	public void setOccupant(Vehicle occupant) {
		this.occupant = occupant;
	}
	
}
