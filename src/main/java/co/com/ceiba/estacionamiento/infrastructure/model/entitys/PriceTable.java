package co.com.ceiba.estacionamiento.infrastructure.model.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PriceTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
	private int id;
		
	@Column(nullable = false)
	private int hourCarPrice;
	
	@Column(nullable = false)
	private int hourBikePrice;
	
	@Column(nullable = false)
	private int dayBikePrice;
	
	@Column(nullable = false)
	private int dayCarPrice;
	
	@Column(nullable = false)
	private int displacementPlusPrice;
	
	@Column(nullable = false)
	private int bikesDisplacementLimit;
	
	public PriceTable(int id, int hourBikePrice, int hourCarPrice, int dayBikePrice, int dayCarPrice, int displacementPlusPrice,
			int bikesDisplacementLimit) {
		this.id = id;
		this.hourBikePrice = hourBikePrice;
		this.hourCarPrice = hourCarPrice;
		this.dayBikePrice = dayBikePrice;
		this.dayCarPrice = dayCarPrice;
		this.displacementPlusPrice = displacementPlusPrice;
		this.bikesDisplacementLimit = bikesDisplacementLimit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHourCarPrice() {
		return hourCarPrice;
	}

	public void setHourCarPrice(int hourCarPrice) {
		this.hourCarPrice = hourCarPrice;
	}

	public int getHourBikePrice() {
		return hourBikePrice;
	}

	public void setHourBikePrice(int hourBikePrice) {
		this.hourBikePrice = hourBikePrice;
	}

	public int getDayBikePrice() {
		return dayBikePrice;
	}

	public void setDayBikePrice(int dayBikePrice) {
		this.dayBikePrice = dayBikePrice;
	}

	public int getDayCarPrice() {
		return dayCarPrice;
	}

	public void setDayCarPrice(int dayCarPrice) {
		this.dayCarPrice = dayCarPrice;
	}

	public int getDisplacementPlusPrice() {
		return displacementPlusPrice;
	}

	public void setDisplacementPlusPrice(int displacementPlusPrice) {
		this.displacementPlusPrice = displacementPlusPrice;
	}

	public int getBikesDisplacementLimit() {
		return bikesDisplacementLimit;
	}

	public void setBikesDisplacementLimit(int bikesDisplacementLimit) {
		this.bikesDisplacementLimit = bikesDisplacementLimit;
	}
	
}
