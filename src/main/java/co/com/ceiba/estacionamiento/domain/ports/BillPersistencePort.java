package co.com.ceiba.estacionamiento.domain.ports;

import java.io.IOException;

import co.com.ceiba.estacionamiento.domain.entidades.Bill;

public interface BillPersistencePort {
	public int savePersistentBill(Bill currentBill) throws IOException;
}
