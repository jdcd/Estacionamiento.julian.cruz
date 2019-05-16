package co.com.ceiba.estacionamiento.domain.exception;

public class UnknownVehicleClassException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unknownVehicleclass ;
	
	public UnknownVehicleClassException(String unknownVehicleclass) {
		super();
		this.unknownVehicleclass = unknownVehicleclass;
	}

	@Override
	public String getMessage() {
		return "type of vehicle unknown: " + unknownVehicleclass;
	}
}
