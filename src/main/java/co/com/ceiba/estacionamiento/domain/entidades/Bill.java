package co.com.ceiba.estacionamiento.domain.entidades;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.h2.engine.Session.TimeoutValue;

/**
 * @author julian.cruz
 *
 */
public class Bill {
	private Ticket ticket;
	private LocalDateTime closeDate;
	private int finalPrice;
	private PriceTable priceTable;
	private int id;

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

	public int calcPrice() {
		long timeOfService = getServiceTime();
		if (VehicleType.CAR.equals(this.ticket.getVehicle().getType())) {
			this.finalPrice = calcCarsTotalPrice(timeOfService);
			return this.finalPrice;
		} else {
			this.finalPrice = calcCarsTotalPrice(timeOfService);
			return calcBikeTotalPrice(timeOfService);
		}
	}

	private int calcBikeTotalPrice(long hoursOfService) {
		if (hoursOfService < 9) { // Only hours
			return (int) (this.priceTable.getHourBikePrice() * hoursOfService);
		} else if (hoursOfService >= 9 && hoursOfService <= 24) { // One day
			return  priceTable.getDayBikePrice();
		} else { //Days + hours
			Map<String,Integer> daysAndHours = convertToPayFormatTime(hoursOfService);
			int price = ( daysAndHours.get("Days") * this.priceTable.getDayBikePrice() ) +
					( daysAndHours.get("Hours") * this.priceTable.getHourBikePrice() );
			if (this.ticket.getVehicle().getDisplacement() > priceTable.getBikesDisplacementLimit()) {
				return price + this.priceTable.getDisplacementPlusPrice();
			} else {
				return  price;
			}
		}
	}

	private int calcCarsTotalPrice(long hoursOfService) {
		long price = 0;
		if (hoursOfService < 9) { // Only hours
			return (int) ( this.priceTable.getHourCarPrice() * hoursOfService);
		} else if (hoursOfService >= 9 && hoursOfService <= 24) { // One day
			return priceTable.getDayCarPrice();
		} else { //Days + hours
			price += 40;
		}
		return (int) price;
	}

	private long getServiceTime() {
		long endTime = this.closeDate.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
		long starTime = this.ticket.getStartedDate().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
		return TimeUnit.MILLISECONDS.toHours(endTime - starTime);
	}

	private Map<String, Integer> convertToPayFormatTime(long hoursOfService) {
		HashMap<String, Integer> daysAndHours = new HashMap<>();
		int days = (int) (hoursOfService / 24);
		int hours = (int) (hoursOfService % 24);
		if (hours > 8) {
			days++;
			hours = 0;
		}
		daysAndHours.put("Days", days);
		daysAndHours.put("Hours", hours);
		return daysAndHours;
	}

}
