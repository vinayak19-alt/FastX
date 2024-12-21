package com.hexaware.fastx.service;

import java.util.List;

import com.hexaware.fastx.dto.BusDTO;
import com.hexaware.fastx.model.Bus;

public interface IBusService {
	
	public BusDTO addBus(Bus bus, String username) throws Exception;
	
//	public List<Object[]> getBookingsByOperatorId(Long operatorId);
	
	public List<BusDTO> getBusForOperator(String username);
}
