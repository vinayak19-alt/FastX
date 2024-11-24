package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.BusOperatorDTO;
import com.hexaware.fastx.model.BusOperator;

public interface IBusOperatorService {
	
	public BusOperatorDTO addBusOperator(BusOperator busOperator);
	
	public void deleteOperator(Long id);

}
