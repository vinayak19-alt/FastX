package com.hexaware.fastx.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.customexceptions.ResourceNotAvailableException;
import com.hexaware.fastx.dto.BusDTO;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.repositories.BusOperatorRepository;
import com.hexaware.fastx.repositories.BusRepository;
import com.hexaware.fastx.service.IBusService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusServiceImpl implements IBusService{
	
	private BusRepository busRepository;
	private BusOperatorRepository busOperatorRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	public BusServiceImpl(BusRepository busRepository, BusOperatorRepository busOperatorRepository) {
		super();
		this.busRepository = busRepository;
		this.busOperatorRepository = busOperatorRepository;
	}

	@Override
	public BusDTO addBus(Bus bus, String username) throws Exception {
		// TODO Auto-generated method stub
		if(username == null || username.isEmpty()) {
			//throw an error
			throw new ResourceNotAvailableException("Username entered is empty");
		}
		BusOperator busOperator = this.busOperatorRepository.findByUsername(username);
		if(busOperator == null) {
			throw new EntityNotFoundException("Bus Operator", "System");
		}
		bus.setBusOperator(busOperator);
		Bus savedBus= this.busRepository.save(bus);
		BusDTO savedBusDTO = mapper.map(savedBus, BusDTO.class);
		return savedBusDTO;
	}

	@Override
	public List<BusDTO> getBusForOperator(String username) {
		// TODO Auto-generated method stub
		BusOperator operator = this.busOperatorRepository.findByUsername(username);
		Long id = operator.getOperatorId();
		List<Bus> busList = this.busRepository.findByOperatorId(id);
		List<BusDTO> busDTOList = new ArrayList<>();
		busList.forEach((b)->{
			busDTOList.add(mapper.map(b, BusDTO.class));
		});
		return busDTOList;
	}
	
//	@Override
//	public List<Object[]> getBookingsByOperatorId(Long operatorId) {
//		// TODO Auto-generated method stub
//		return this.busRepository.findBookingsByOperatorId(operatorId);
//	}


}
