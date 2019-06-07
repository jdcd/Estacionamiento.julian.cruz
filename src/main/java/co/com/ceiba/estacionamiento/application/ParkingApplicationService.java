package co.com.ceiba.estacionamiento.application;

import java.io.IOException;
import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.entidades.Bill;
import co.com.ceiba.estacionamiento.domain.entidades.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entidades.PriceTable;
import co.com.ceiba.estacionamiento.domain.entidades.Ticket;
import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;
import co.com.ceiba.estacionamiento.domain.entidades.VirtualOperator;
import co.com.ceiba.estacionamiento.domain.ports.BillPersistencePort;
import co.com.ceiba.estacionamiento.domain.ports.TicketPersistensePort;

public class ParkingApplicationService {
	
	private VirtualOperator watchMan;
	private ParkingLot myParking;
	
	public ParkingApplicationService(int carsCapacity, int bikesCapacity, PriceTable priceTable, TicketPersistensePort ticketBook, BillPersistencePort billBook) {
		myParking = new ParkingLot(carsCapacity, bikesCapacity, priceTable);
		this.watchMan= new VirtualOperator(myParking, ticketBook, billBook);
	}	
	
	public Ticket parkingNewVehicle(Vehicle newVehicle, LocalDateTime startDate) throws IOException {
		return watchMan.parkingNewVehicle(newVehicle, startDate);
	}
	
	public Bill getOutVehicle(Ticket ticket, LocalDateTime closeDate) throws IOException {
		return watchMan.goOutVehicle(ticket, closeDate);
	}
	
}
