package co.com.ceiba.estacionamiento.infrastructure.model.adapter;

import java.io.IOException;
import java.util.Optional;

import co.com.ceiba.estacionamiento.domain.entidades.Bill;
import co.com.ceiba.estacionamiento.domain.ports.BillPersistencePort;

public class BillAdapter implements  BillPersistencePort{

	@Override
	public int savePersistentBill(Bill currentBill) throws IOException {
		
		return 0;
	}


}
