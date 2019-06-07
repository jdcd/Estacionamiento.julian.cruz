package co.com.ceiba.estacionamiento.domain.ports;

import java.io.IOException;

import co.com.ceiba.estacionamiento.domain.entidades.Ticket;

public interface TicketPersistensePort {
	public int savePersistentTicket(Ticket newTicket) throws IOException;
	public Ticket findTicketById(int ticketId) throws IOException;
	
}
