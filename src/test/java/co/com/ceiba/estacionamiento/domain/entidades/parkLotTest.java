package co.com.ceiba.estacionamiento.domain.entidades;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.domain.entidades.Garage;
import co.com.ceiba.estacionamiento.domain.entidades.ParkingLot;

public class parkLotTest {

	@Test
	public void configParkLotTest() {
		//Arrange
		ParkingLot myParking;
		Garage[] carsSpace = {new Garage(true, 1),new Garage(true, 2)};
		Garage[] bikesSpace = {new Garage(true, 1),new Garage(true, 2)}; 
		
		//Act
		myParking = new ParkingLot(2, 2);
		
		//Assert
//		assertEquals(1, myParking.getBikesSpace()[0].getNumber());
//		assertEquals(2, myParking.getBikesSpace()[myParking.getBikesSpace().length -1].getNumber());
		
//		assertEquals(1, myParking.getCarsSpace()[0].getNumber());
//		assertEquals(2, myParking.getCarsSpace()[myParking.getCarsSpace().length -1].getNumber());
		
	}

}
