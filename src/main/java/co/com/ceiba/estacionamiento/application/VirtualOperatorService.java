package co.com.ceiba.estacionamiento.application;

import java.io.IOException;
import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.BillPersistencePort;
import co.com.ceiba.estacionamiento.domain.VirtualOperator;
import co.com.ceiba.estacionamiento.domain.entidades.Bill;
import co.com.ceiba.estacionamiento.domain.entidades.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entidades.PriceTable;
import co.com.ceiba.estacionamiento.domain.entidades.Ticket;
import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;
import co.com.ceiba.estacionamiento.domain.entidades.VehicleType;
import co.com.ceiba.estacionamiento.domain.exception.BusyBikesParkingException;
import co.com.ceiba.estacionamiento.domain.exception.BusyCarsParkingException;

public class VirtualOperatorService {
	
	private VirtualOperator watchman;
	private BillPersistencePort persistentBill;
	
	public VirtualOperatorService(VirtualOperator watchman, ParkingLot myParking) {
		super();
		this.watchman = watchman;
	}

	public Ticket parkingNewVehicle(Vehicle newVehicle, LocalDateTime startDate) throws IOException {
		//Al dominio
		if(!this.watchman.admitVehicle(newVehicle, startDate)) { 
			if(VehicleType.BIKE.equals(newVehicle.getType())) {
				throw new BusyBikesParkingException();
			}else {
				throw new BusyCarsParkingException();
			}
		}
		int garageNumber = this.watchman.locateVehicle(newVehicle);
		Ticket newTicket = new Ticket(newVehicle, startDate, garageNumber);
		newTicket.setId(watchman.makeServiceTicket(newTicket));
		return newTicket;
	}
	
	public Bill goOutVehicle(Ticket ticket, PriceTable priceTable, LocalDateTime closeDate) throws IOException{
		Bill currentBill = new Bill(ticket, priceTable, closeDate);
		currentBill.calcPrice(); //All Magic is here
		currentBill.setId(this.persistentBill.savePersistentBill(currentBill));
		return currentBill;
	}
}
