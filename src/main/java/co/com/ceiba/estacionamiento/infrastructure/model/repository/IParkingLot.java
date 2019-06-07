package co.com.ceiba.estacionamiento.infrastructure.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.infrastructure.model.entitys.ParkingLot;

@Repository
public interface IParkingLot extends CrudRepository<ParkingLot, Integer>{

}
