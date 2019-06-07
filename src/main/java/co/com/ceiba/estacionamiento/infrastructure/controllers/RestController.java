package co.com.ceiba.estacionamiento.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("/open")
	public String openParkingLot() {
		return "open";
	}
	
}
