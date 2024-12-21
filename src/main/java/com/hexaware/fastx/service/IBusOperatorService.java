package com.hexaware.fastx.service;

import java.util.List;

import com.hexaware.fastx.dto.BusOperatorDTO;
import com.hexaware.fastx.model.BusOperator;

public interface IBusOperatorService {
	
	public BusOperatorDTO addBusOperator(BusOperator busOperator);
	
	public void deleteOperator(Long id);
	
	public List<BusOperatorDTO> getAllOperators();
	
	public BusOperatorDTO updateBusOperator(Long id, BusOperator updatedBusOperator) throws Exception;
	
	public BusOperatorDTO findById(Long id);

}
