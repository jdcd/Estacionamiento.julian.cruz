package co.com.ceiba.estacionamiento.domain.exception;

public class BusyGarageException extends Exception {
	
	@Override
	public String getMessage() {
		return "The Parking is Bussy ";
		
	}
}
