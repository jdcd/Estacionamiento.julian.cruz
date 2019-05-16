package co.com.ceiba.estacionamiento.domain;

import java.io.IOException;
import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.entidades.Garage;
import co.com.ceiba.estacionamiento.domain.entidades.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entidades.Ticket;
import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;
import co.com.ceiba.estacionamiento.domain.entidades.VehicleType;
import co.com.ceiba.estacionamiento.domain.exception.BusyGarageException;
import co.com.ceiba.estacionamiento.domain.exception.UnknownVehicleClassException;

public class VirtualOperator {

	private final ParkingLot currentParkingLot;
	private final TicketPersistensePort persistentTicket;

	public VirtualOperator(ParkingLot currentParkingLot, TicketPersistensePort persistentTicket) {
		this.currentParkingLot = currentParkingLot;
		this.persistentTicket = persistentTicket;
	}

	public boolean admitVehicle(Vehicle newVehicle, LocalDateTime startDate) {
		return (isSpaceAvailable(newVehicle) && isValidPlateToday(newVehicle, startDate));
	}

	public int locateVehicle(Vehicle newVehicle) {

		if (VehicleType.BIKE.equals(newVehicle.getType()))
			return parkingBike(newVehicle);

		if (VehicleType.CAR.equals(newVehicle.getType())) {
			return parkingCar(newVehicle);
		}

		throw new UnknownVehicleClassException(newVehicle.getPlate());

	}

	public int makeServiceTicket(Ticket newTicket) throws IOException {
		return persistentTicket.savePersistentTicket(newTicket);
	}

	private boolean isValidPlateToday(Vehicle newVehicle, LocalDateTime startDate) {

		if (newVehicle.getPlate().charAt(0) == 'A' || newVehicle.getPlate().charAt(0) == 'a') { // Sunday or Monday
			return ("MONDAY".equals(startDate.getDayOfWeek().toString())
					|| "SUNDAY".equals(startDate.getDayOfWeek().toString()));
		}
		return true;
	}

	private boolean isSpaceAvailable(Vehicle newVehicle) {
		if (newVehicle.getType().equals(VehicleType.CAR)) {
			return getCarSpaceCount() > 0;
		} else if (newVehicle.getType().equals(VehicleType.BIKE)) {
			return getBikeSpaceCount() > 0;
		} else {
			throw new UnknownVehicleClassException(newVehicle.getPlate());
		}
	}

	private int parkingBike(Vehicle newVehicle) {
		Garage garage = this.currentParkingLot.getBikesSpace().stream().filter(Garage::isFree).findFirst()
				.orElseThrow(() -> new BusyGarageException());
		return garage.fillGarage(newVehicle);
	}

	private int parkingCar(Vehicle newVehicle) {
		Garage garage = this.currentParkingLot.getCarsSpace().stream().filter(Garage::isFree).findFirst()
				.orElseThrow(() -> new BusyGarageException());
		return garage.fillGarage(newVehicle);
	}

	private long getBikeSpaceCount() {
		return this.currentParkingLot.getBikesSpace().stream().filter(Garage::isFree).count();
	}

	private long getCarSpaceCount() {
		return this.currentParkingLot.getCarsSpace().stream().filter(Garage::isFree).count();
	}

}
