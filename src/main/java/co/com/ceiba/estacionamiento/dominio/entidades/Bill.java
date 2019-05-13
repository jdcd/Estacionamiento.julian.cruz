package co.com.ceiba.estacionamiento.dominio.entidades;


import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Bill {
	private Ticket ticket;
	private Calendar closeDate;
	private int price;
	private PriceTable costs;
	
	
	
	public Bill(Ticket ticket, PriceTable costs, Calendar closeDate ) {
		super();
		this.ticket = ticket;
		this.costs = costs;
		this.closeDate = closeDate;
	}

	public float calcPrice() {
		long timeOfService = getServiceTime();
		return timeOfService; 
	}
	
	
	private long getServiceTime() {
		
		long diff = closeDate.getTimeInMillis() - ticket.getStartedDate().getTimeInMillis();
		return TimeUnit.MILLISECONDS.toHours(diff);

	}
	
}
