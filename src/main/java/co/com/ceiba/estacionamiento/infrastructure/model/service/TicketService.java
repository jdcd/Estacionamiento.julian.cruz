package co.com.ceiba.estacionamiento.infrastructure.model.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.infrastructure.exception.NotBDResultException;
import co.com.ceiba.estacionamiento.infrastructure.model.entitys.Ticket;

public class TicketService implements ITicket{

	
	@Autowired
	private ITicket ticketRepository;
	
	@Override
	public Ticket findById(int id) {
		Ticket result = ticketRepository.findById(id);
		if(result != null) {
			return result;
		}else {
			throw new NotBDResultException();
		}
	}

	@Override
	public int save(Ticket ticket) throws IOException {
		int result = ticketRepository.save(ticket);
		if (result != 0) {
			return result;
		}else {
			throw new IOException();
		}
	}

}
