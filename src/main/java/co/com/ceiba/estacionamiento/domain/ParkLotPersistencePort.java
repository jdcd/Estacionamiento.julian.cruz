package co.com.ceiba.estacionamiento.domain;

import co.com.ceiba.estacionamiento.domain.entidades.ParkingLot;

public interface ParkLotPersistencePort {
	public int SavePersistentOarkLot(ParkingLot myParking);
	public ParkingLot getMyParking(int parkId);
}
