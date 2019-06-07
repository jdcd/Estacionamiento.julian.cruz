package co.com.ceiba.estacionamiento.infrastructure.entitys.copy;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author julian.cruz
 *
 */
@Entity
public class BillEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
	private int id;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private TicketEntity ticket;
	
	@Column(nullable = false)
	private LocalDateTime closeDate;
	
	@Column(nullable = false)
	private int finalPrice;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private PriceTableEntity priceTable;

	public BillEntity(TicketEntity ticket, PriceTableEntity costs, LocalDateTime closeDate) {
		this.ticket = ticket;
		this.priceTable = costs;
		this.closeDate = closeDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TicketEntity getTicket() {
		return ticket;
	}

	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public PriceTableEntity getPriceTable() {
		return priceTable;
	}

	public void setPriceTable(PriceTableEntity priceTable) {
		this.priceTable = priceTable;
	}

}

