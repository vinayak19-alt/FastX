package com.hexaware.fastx.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.dto.BusOperatorDTO;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.repositories.BusOperatorRepository;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.service.IBusOperatorService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusOperatorServiceImpl implements IBusOperatorService{
	
	private BusOperatorRepository busOperatorRepository;
	private LoginDetailsRepository loginDetailsRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public BusOperatorServiceImpl(BusOperatorRepository busOperatorRepository, LoginDetailsRepository loginDetailsRepository) {
		super();
		this.busOperatorRepository = busOperatorRepository;
		this.loginDetailsRepository = loginDetailsRepository;
	}

	@Override
	public BusOperatorDTO addBusOperator(BusOperator busOperator) {
		// TODO Auto-generated method stub
		LoginDetails loginDetails = this.loginDetailsRepository.findByUsername(busOperator.getUsername());
		if(loginDetails == null) {
			throw new EntityNotFoundException("Bus Operator", "Login Details");
		}
		busOperator.setLoginDetails(loginDetails);
		BusOperator savedOperator = this.busOperatorRepository.save(busOperator);
		BusOperatorDTO savedOperatorDTO = mapper.map(savedOperator, BusOperatorDTO.class);
		return savedOperatorDTO;
	}

	@Override
	public void deleteOperator(Long id) {
		// TODO Auto-generated method stub
		BusOperator operator = this.busOperatorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("BusOperator", "System"));
		this.busOperatorRepository.deleteById(id);
	}

}
