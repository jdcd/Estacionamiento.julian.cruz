package co.com.ceiba.estacionamiento.domain;

import co.com.ceiba.estacionamiento.domain.entidades.Ticket;
import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;

public interface IParkLotServices {
	public Ticket registerVehicle(Vehicle newClient);  
	public boolean checkCarGarageDisponibility();
	public boolean checkBikeGarageDisponibility();
	public boolean closeParkingService(Ticket input);


}

