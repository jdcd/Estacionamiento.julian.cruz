package co.com.ceiba.estacionamiento.infrastructure.model.entitys;

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
public class Bill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
	private int id;
	
	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private Ticket ticket;
	
	@Column(nullable = false)
	private LocalDateTime closeDate;
	
	@Column(nullable = false)
	private int finalPrice;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private PriceTable priceTable;

	public Bill(Ticket ticket, PriceTable costs, LocalDateTime closeDate) {
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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
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

	public PriceTable getPriceTable() {
		return priceTable;
	}

	public void setPriceTable(PriceTable priceTable) {
		this.priceTable = priceTable;
	}

}

