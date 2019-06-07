package co.com.ceiba.estacionamiento.infrastructure.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import co.com.ceiba.estacionamiento.infrastructure.exception.NotBDResultException;
import co.com.ceiba.estacionamiento.infrastructure.model.entitys.PriceTable;

public class PriceTableService implements IPriceTable{
	
	@Autowired
	private IPriceTable priceTableRepository;
	
	
	@Override
	public PriceTable findById(int id) {
		PriceTable result = priceTableRepository.findById(id);
		if(result != null) {
			return result;
		} else {
			throw new NotBDResultException();
		}
	}
}
