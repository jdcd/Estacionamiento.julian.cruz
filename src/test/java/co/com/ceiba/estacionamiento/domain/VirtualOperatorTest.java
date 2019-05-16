package co.com.ceiba.estacionamiento.domain;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import co.com.ceiba.estacionamiento.domain.entidades.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;
import co.com.ceiba.estacionamiento.domain.entidades.VehicleType;
import co.com.ceiba.estacionamiento.domain.exception.BusyGarageException;
import co.com.ceiba.estacionamiento.domain.exception.UnknownVehicleClassException;

public class VirtualOperatorTest {

	
	@Test
	public void admitVehicleTestSunday_A_Plate_WithPark_Space() throws UnknownVehicleClassException {
		//Arrange
		Vehicle superBike = new Vehicle("ABC1234", VehicleType.BIKE, 500);
		LocalDateTime sunday12 = LocalDateTime.of(2019,5,12,5,30,45,35);
		ParkingLot myParking = new ParkingLot(2, 2);
		TicketPersistensePort port = null;
		VirtualOperator donChepe = new VirtualOperator(myParking, port);
		
		
		//Act
		boolean access = donChepe.admitVehicle(superBike, sunday12);
		
		
		//Assert
		assertEquals(false, access);
	}
	
	
	@Test
	public void admitVehicleTestMonday_A_Plate_WithPark_Space() throws UnknownVehicleClassException {
		//Arrange
		Vehicle superBike = new Vehicle("ABC1234", VehicleType.BIKE, 500);
		LocalDateTime sunday12 = LocalDateTime.of(2019,5,13,5,30,45,35);
		ParkingLot myParking = new ParkingLot(2, 2);
		TicketPersistensePort port = null;
		VirtualOperator donChepe = new VirtualOperator(myParking, port);
		
		//Act
		boolean access = donChepe.admitVehicle(superBike, sunday12);
		
		//Assert
		assertEquals(false, access);
	}
	
	//No Monday, No Sunday
	@Test
	public void admitVehicleTestInvalidDay_A_Plate_WithPark_Space() throws UnknownVehicleClassException {
		//Arrange
		Vehicle superBike = new Vehicle("ABC1234", VehicleType.BIKE, 500);
		LocalDateTime we8 = LocalDateTime.of(2019,5,8,5,30,45,35);
		ParkingLot myParking = new ParkingLot(2, 2);
		TicketPersistensePort port = null;
		VirtualOperator donChepe = new VirtualOperator(myParking, port);
		
		//Act
		boolean access = donChepe.admitVehicle(superBike, we8);
		
		//Assert
		assertEquals(false, access);
	}
	
	@Test
	public void admitVehicleTest_FullParking() throws UnknownVehicleClassException {
		//Arrange
		Vehicle bagoneta = new Vehicle("ZBC123", VehicleType.CAR);
		Vehicle pichirilo = new Vehicle("JHU543", VehicleType.CAR);
		Vehicle la_nave = new Vehicle("FTR431", VehicleType.CAR);
		LocalDateTime we8 = LocalDateTime.of(2019,5,8,5,30,45,35);
		ParkingLot myParking = new ParkingLot(2, 2);
		TicketPersistensePort port = null;
		VirtualOperator donChepe = new VirtualOperator(myParking, port);
		int myCarGarage,myBikeGarage;
		
		
		//Act
		try {
			myCarGarage = donChepe.locateVehicle(pichirilo);
			myBikeGarage = donChepe.locateVehicle(bagoneta);
		} catch (BusyGarageException e) {
			e.printStackTrace();
		}
		boolean access = donChepe.admitVehicle(la_nave, we8);
		//Assert
		assertEquals(true, access);
	}

}
