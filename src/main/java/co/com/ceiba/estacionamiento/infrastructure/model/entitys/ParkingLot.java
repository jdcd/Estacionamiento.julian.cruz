package co.com.ceiba.estacionamiento.infrastructure.model.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class ParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private int carsCapacity;
	
	@Column(nullable = false)
	private int bikesCapacity;
	
	@ManyToMany
	@JoinColumn(referencedColumnName="number")
	private List<Garage> carsSpace;
	
	@ManyToMany
	@JoinColumn(referencedColumnName="number")
	private List<Garage> bikesSpace;
	
	public ParkingLot(int id, int carsCapacity, int bikesCapacity) {
		this.carsCapacity = carsCapacity;
		this.id = id;
		this.bikesCapacity = bikesCapacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarsCapacity() {
		return carsCapacity;
	}

	public void setCarsCapacity(int carsCapacity) {
		this.carsCapacity = carsCapacity;
	}

	public int getBikesCapacity() {
		return bikesCapacity;
	}

	public void setBikesCapacity(int bikesCapacity) {
		this.bikesCapacity = bikesCapacity;
	}

	public List<Garage> getCarsSpace() {
		return carsSpace;
	}

	public void setCarsSpace(List<Garage> carsSpace) {
		this.carsSpace = carsSpace;
	}

	public List<Garage> getBikesSpace() {
		return bikesSpace;
	}

	public void setBikesSpace(List<Garage> bikesSpace) {
		this.bikesSpace = bikesSpace;
	}

		
}
