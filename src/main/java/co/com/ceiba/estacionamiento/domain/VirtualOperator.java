package co.com.ceiba.estacionamiento.domain;


import java.time.LocalDateTime;
import co.com.ceiba.estacionamiento.dominio.entidades.ParkLot;
import co.com.ceiba.estacionamiento.dominio.entidades.Ticket;
import co.com.ceiba.estacionamiento.dominio.entidades.Vehicle;
import co.com.ceiba.estacionamiento.dominio.entidades.VehicleType;

public class VirtualOperator {
	
	private ParkLot currentParkLot;
	
	public void recibirParqueadero(ParkLot currentParkLot) {
		this.currentParkLot = currentParkLot;
	}
	
	
	
	public boolean admitVehicle(Vehicle newVehicle) {
		
		if(!isSpaceAvailable(newVehicle))
			return false;
		
		if(!isValidPlateToday(newVehicle))
			return false;
		
		return true;
	}
	
	
	
	public Ticket locateVehicle() {
		return null;
	}
	
	
	
	private boolean isValidPlateToday(Vehicle newVehicle) {
		LocalDateTime startDate = LocalDateTime.now();
		if ((startDate.getDayOfWeek().equals("Monday") || startDate.getDayOfWeek().equals("Sunday"))) { //Sunday or Monday
			return newVehicle.getPlate().charAt(0) == 'A';	
		}
		return true;
	}
	
	
	private boolean isSpaceAvailable(Vehicle newVehicle) {
		if(newVehicle.getType().equals(VehicleType.CAR)){
			return this.currentParkLot.getCarsSpace().size() < this.currentParkLot.getCarsCapacity();
		}else if(newVehicle.getType().equals(VehicleType.BIKE)) {
			return this.currentParkLot.getBikesSpace().size() < this.currentParkLot.getBikesCapacity();
		}else {
			return false;
		}
	}
 
}
