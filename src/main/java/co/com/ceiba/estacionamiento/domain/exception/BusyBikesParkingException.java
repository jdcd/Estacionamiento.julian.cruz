package co.com.ceiba.estacionamiento.domain.exception;

public class BusyBikesParkingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The bike parking is bussy ";
	}
}