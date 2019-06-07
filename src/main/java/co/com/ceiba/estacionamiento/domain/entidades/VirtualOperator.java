package co.com.ceiba.estacionamiento.domain.entidades;

import java.io.IOException;
import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.exception.BusyGarageException;
import co.com.ceiba.estacionamiento.domain.exception.BusyParkingException;
import co.com.ceiba.estacionamiento.domain.exception.UnknownVehicleClassException;
import co.com.ceiba.estacionamiento.domain.ports.BillPersistencePort;
import co.com.ceiba.estacionamiento.domain.ports.TicketPersistensePort;

public class VirtualOperator {

	private final ParkingLot currentParkingLot;
	private TicketPersistensePort ticketBook;
	private BillPersistencePort billBook;
	
	public VirtualOperator(ParkingLot currentParkingLot, TicketPersistensePort persistentTicket, BillPersistencePort persistentBill) {
		this.currentParkingLot = currentParkingLot;
		this.ticketBook = persistentTicket;
		this.billBook = persistentBill;
	}

	public Ticket parkingNewVehicle(Vehicle newVehicle, LocalDateTime startDate) throws IOException {
		if (!isSpaceAvailable(newVehicle)) {
			throw new BusyParkingException();
		}
		if (!isValidPlateToday(newVehicle, startDate)) {
			throw new BusyParkingException();
		}

		int garageNumber = this.locateVehicle(newVehicle);
		Ticket newTicket = new Ticket(newVehicle, startDate, garageNumber);
		newTicket.setId(this.makeServiceTicket(newTicket));
		return newTicket;
	}

	public Bill goOutVehicle(Ticket ticket, LocalDateTime closeDate) throws IOException{
		Bill currentBill = new Bill(ticket, this.currentParkingLot.getPriceTable(), closeDate);
		currentBill.calcPrice(); //All Magic is here
		currentBill.setId(billBook.savePersistentBill(currentBill));
		return currentBill;
	}
	
	private int locateVehicle(Vehicle newVehicle) {

		if (VehicleType.BIKE.equals(newVehicle.getType()))
			return parkingBike(newVehicle);

		if (VehicleType.CAR.equals(newVehicle.getType())) {
			return parkingCar(newVehicle);
		}

		throw new UnknownVehicleClassException(newVehicle.getPlate());

	}

	private int makeServiceTicket(Ticket newTicket) throws IOException {
		return this.ticketBook.savePersistentTicket(newTicket);
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
				.orElseThrow( BusyGarageException::new );
		return garage.fillGarage(newVehicle);
	}

	private int parkingCar(Vehicle newVehicle) {
		Garage garage = this.currentParkingLot.getCarsSpace().stream().filter(Garage::isFree).findFirst()
				.orElseThrow(BusyGarageException::new);
		return garage.fillGarage(newVehicle);
	}

	private long getBikeSpaceCount() {
		return this.currentParkingLot.getBikesSpace().stream().filter(Garage::isFree).count();
	}

	private long getCarSpaceCount() {
		return this.currentParkingLot.getCarsSpace().stream().filter(Garage::isFree).count();
	}

}
