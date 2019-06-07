package co.com.ceiba.estacionamiento.infrastructure.model.service;

import org.springframework.stereotype.Repository;
import co.com.ceiba.estacionamiento.infrastructure.model.entitys.Ticket;

@Repository
public interface ITicket {
	public Ticket findById(int id);
	public int save(Ticket ticket);
	
}
