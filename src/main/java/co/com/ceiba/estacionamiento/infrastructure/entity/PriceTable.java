package co.com.ceiba.estacionamiento.infrastructure.entity;

public class PriceTable {
	
	private int hourBikePrice;
	private int hourCarPrice;
	private int dayBikePrice;
	private int dayCarPrice;
	private int displacementPlusPrice;
	private int bikesDisplacementLimit;
	
	public PriceTable(int hourBikePrice, int hourCarPrice, int dayBikePrice, int dayCarPrice, int displacementPlusPrice,
			int bikesDisplacementLimit) {
		super();
		this.hourBikePrice = hourBikePrice;
		this.hourCarPrice = hourCarPrice;
		this.dayBikePrice = dayBikePrice;
		this.dayCarPrice = dayCarPrice;
		this.displacementPlusPrice = displacementPlusPrice;
		this.bikesDisplacementLimit = bikesDisplacementLimit;
	}

	public int getHourBikePrice() {
		return hourBikePrice;
	}

	public int getHourCarPrice() {
		return hourCarPrice;
	}

	public int getDayBikePrice() {
		return dayBikePrice;
	}

	public int getDayCarPrice() {
		return dayCarPrice;
	}

	public int getDisplacementPlusPrice() {
		return displacementPlusPrice;
	}

	public int getBikesDisplacementLimit() {
		return bikesDisplacementLimit;
	}
	
	
	
	
	
	
	
}
