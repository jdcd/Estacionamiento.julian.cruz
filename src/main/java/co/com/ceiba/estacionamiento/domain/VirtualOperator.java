package co.com.ceiba.estacionamiento.domain;


import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.entidades.ParkLot;
import co.com.ceiba.estacionamiento.domain.entidades.Vehicle;
import co.com.ceiba.estacionamiento.domain.entidades.VehicleType;
import co.com.ceiba.estacionamiento.domain.exception.BusyGarageException;

public class VirtualOperator {
	
	private ParkLot currentParkLot;
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	public void recibirParqueadero(ParkLot currentParkLot) {
		this.currentParkLot = currentParkLot;
	}
	
	
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	public boolean admitVehicle(Vehicle newVehicle, LocalDateTime startDate) {
		
		if(!isSpaceAvailable(newVehicle)) {
			System.out.println("Parking Full, Sorry " + newVehicle.getType() + " # " + newVehicle.getPlate());
			return false;
		}
		
		if(!isValidPlateToday(newVehicle, startDate)) {
			System.out.println("no esta autorizado a ingresar. " + newVehicle.getType() + " # " + newVehicle.getPlate());
			return false;
		}
		System.out.println("Autorizado "  + newVehicle.getPlate()  );
		return true;
	}
	
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	public int locateVehicle(Vehicle newVehicle) throws BusyGarageException {
		if(VehicleType.BIKE.equals(newVehicle.getType())) //its a bike
			return parkingBike(newVehicle);
		
		if(VehicleType.CAR.equals(newVehicle.getType())){
			return parkingCar(newVehicle);
		}
		
		throw new BusyGarageException();
		
	}
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	private int parkingBike(Vehicle newVehicle) throws BusyGarageException {
			for(int i= 1; i <= this.currentParkLot.getBikesSpace().length; i++) {
				if(this.currentParkLot.getBikesSpace()[i].isFree()) {
					System.out.println("Welcome " + newVehicle.getType() + " # "
							+ newVehicle.getPlate() + "Your Garage is number " + this.currentParkLot.getBikesSpace()[i]);
					return this.currentParkLot.getBikesSpace()[i].fillGarage(newVehicle);
				}
			}
		throw new BusyGarageException();
	}
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	private int parkingCar(Vehicle newVehicle) throws BusyGarageException {
			for(int i= 1; i <= this.currentParkLot.getCarsSpace().length; i++) {
				if(this.currentParkLot.getCarsSpace()[i-1].isFree()) {
					return this.currentParkLot.getCarsSpace()[i-1].fillGarage(newVehicle);
				}
			}
		throw new BusyGarageException();
	}
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	private boolean isValidPlateToday(Vehicle newVehicle, LocalDateTime startDate) {

		if (newVehicle.getPlate().charAt(0) == 'A' || newVehicle.getPlate().charAt(0) == 'a') { //Sunday or Monday
			return (("MONDAY".equals(startDate.getDayOfWeek().toString()) || "SUNDAY".equals(startDate.getDayOfWeek().toString())));	
		}
		System.out.println("Hoy es: " + startDate.getDayOfWeek().toString());
		System.out.println("La placa es : " + newVehicle.getPlate().charAt(0));
		return true;
	}
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	private boolean isSpaceAvailable(Vehicle newVehicle) {
		if(newVehicle.getType().equals(VehicleType.CAR)){
			return getCarSpaceCount() > 0;
		}else if(newVehicle.getType().equals(VehicleType.BIKE)) {
			return getBikeSpaceCount() > 0;
		}else {
			// Lanzar Excepcion de tipo desconocido
			return false;
		}
	}
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	private int getCarSpaceCount() {
		int countFreeGarages = 0;
		for(int i= 1; i <= this.currentParkLot.getCarsSpace().length; i++) {
			if (this.currentParkLot.getCarsSpace()[i-1].isFree()) {
				countFreeGarages++;
			}
		}
		return countFreeGarages;
	}
	
	/**
     * Returns the Garage number, and set garage to Busy.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
	private int getBikeSpaceCount() {
		int countFreeGarages = 0;
		for(int i= 1; i <= this.currentParkLot.getBikesSpace().length; i++) {
			if (this.currentParkLot.getBikesSpace()[i-1].isFree()) {
				countFreeGarages++;
			}
		}
		return countFreeGarages;
	}
 
}
