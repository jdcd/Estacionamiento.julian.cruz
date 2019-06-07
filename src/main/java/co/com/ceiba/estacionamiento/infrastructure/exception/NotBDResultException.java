package co.com.ceiba.estacionamiento.infrastructure.exception;

public class NotBDResultException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Empty BD result Exception";
		
	}
}
