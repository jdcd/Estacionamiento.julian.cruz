package co.com.ceiba.estacionamiento.domain.exception;

public class BusyGarageException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The Garage is Bussy ";
		
	}
}
