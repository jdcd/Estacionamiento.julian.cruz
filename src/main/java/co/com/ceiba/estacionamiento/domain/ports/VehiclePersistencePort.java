package co.com.ceiba.estacionamiento.domain.ports;

import java.io.IOException;

import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;

public interface VehiclePersistencePort {
	public String savePersistentVehicle(Vehicle newVehicle) throws IOException;
	public Vehicle findVehicleById(String vehiclePlate) throws IOException;
}
