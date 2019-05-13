package co.com.ceiba.estacionamiento;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.entidades.Bill;
import co.com.ceiba.estacionamiento.dominio.entidades.Ticket;
import co.com.ceiba.estacionamiento.dominio.entidades.Vehicle;
import co.com.ceiba.estacionamiento.dominio.entidades.VehicleType;

public class BillTest {

	@Test
	public void test() {
		LocalDateTime start = LocalDateTime.of(2019,5,12,11,10); 
		LocalDateTime end = LocalDateTime.now();
	}

}
