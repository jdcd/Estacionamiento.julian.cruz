package co.com.ceiba.estacionamiento.domain.entidades;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.junit.Test;

public class BillTest {

	
	@Test
	public void calcCostInHoursCar() {
		//---------------------Arrange----------------------
		
		//-------Table of Price
		int hourBikePrice = 500;
		int hourCarPrice = 1000;
		int dayBikePrice = 1000;
		int dayCarPrice = 2000;
		int displacementPlusPrice = 2000;
		int bikesDisplacementLimit = 500;
		
		//Vehicle
		int garageNumber = 1;
		String plate = "ASD877";
		
		PriceTable priceTable = new PriceTable(hourBikePrice, hourCarPrice, dayBikePrice, dayCarPrice, displacementPlusPrice, bikesDisplacementLimit);
		
		Vehicle car = new Vehicle(plate, VehicleType.CAR);
		LocalDateTime ticketStartDate = LocalDateTime.of(2019,5,12,5,30,45,35);
		Ticket ticket = new Ticket(car,ticketStartDate,garageNumber);
		Bill newBill = new Bill(ticket, priceTable, LocalDateTime.of(2019,5,12,10,33,45,35));
		
		//Act
		int price = newBill.calcPrice();
		
		//Assert
		assertEquals(5*1000, price);
	}
	
	
	public void calcCostDay() {
		//Arrange
		Vehicle car = new Vehicle("ASD876", VehicleType.CAR);
		LocalDateTime ticketStartDate = LocalDateTime.of(2019,5,12,5,30,45,35);
		Ticket ticket = new Ticket(car,ticketStartDate,4);
		PriceTable price = new PriceTable(500, 1000, 100, 2000, 200, 100);
		Bill newBill = new Bill(ticket, price, LocalDateTime.of(2019,5,12,33,45,35));
		
		//Act
//		long hours = newBill.getServiceTime();
		
		//Assert
		//assertEquals(24, hours);
	}
	
	

}
