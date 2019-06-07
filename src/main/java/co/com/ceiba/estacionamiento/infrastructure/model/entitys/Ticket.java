package co.com.ceiba.estacionamiento.infrastructure.model.entitys;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author julian.cruz
 *
 */

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="plate")
	private Vehicle vehicle;
	
	@Column(nullable = false)
	private LocalDateTime startedDate;
	
	@Column(nullable = false)
	private int currentGarage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ticket(int id, Vehicle vehicle, LocalDateTime startedDate, int currentGarage) {
		this.id = id;
		this.vehicle = vehicle;
		this.startedDate = startedDate;
		this.currentGarage = currentGarage;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDateTime getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(LocalDateTime startedDate) {
		this.startedDate = startedDate;
	}

	public int getCurrentGarage() {
		return currentGarage;
	}

	public void setCurrentGarage(int currentGarage) {
		this.currentGarage = currentGarage;
	}

}
