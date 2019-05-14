package co.com.ceiba.estacionamiento.domain.entidades;

public class Garage {
	private boolean free;
	private int number;
	private Vehicle occupnat;
	
	public Garage(boolean free, int number) {
		super();
		this.free = free;
		this.number = number;
	}

	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	public int fillGarage(Vehicle occupnat) {
		this.free = false;
		this.occupnat = occupnat;
		return this.number;
	}
	
	public void liberateGarage() {
		this.free = true;
		this.occupnat = null;
	}

	public boolean isFree() {
		return free;
	}

	public int getNumber() {
		return number;
	}
	
	
	
	
}
