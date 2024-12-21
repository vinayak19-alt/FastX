package com.hexaware.fastx.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(BusOperatorServiceImpl.class);
	
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
			logger.error("Bus operator might not exist");
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

	@Override
	public List<BusOperatorDTO> getAllOperators() {
		// TODO Auto-generated method stub
		List<BusOperator> operators = this.busOperatorRepository.findAll();
		List<BusOperatorDTO> operatorDTOs = new ArrayList<>();
		operators.forEach((o)->{
			operatorDTOs.add(mapper.map(o, BusOperatorDTO.class));
		});
		return operatorDTOs;
	}

	@Override
	public BusOperatorDTO updateBusOperator(Long id, BusOperator updatedBusOperator) throws Exception {
		// TODO Auto-generated method stub
		BusOperator operator = this.busOperatorRepository.findById(id).get();
		if(operator == null) {
			throw new Exception("Bus Operator not found");
		}
		operator.setOperatorName(updatedBusOperator.getOperatorName());
		operator.setAge(updatedBusOperator.getAge());
		operator.setPhone(updatedBusOperator.getPhone());
		BusOperator savedOperator = this.busOperatorRepository.save(operator);
		BusOperatorDTO savedOperatorDTO = mapper.map(operator, BusOperatorDTO.class);
		return savedOperatorDTO;
	}

	@Override
	public BusOperatorDTO findById(Long id) {
		// TODO Auto-generated method stub
		BusOperator operator = this.busOperatorRepository.findById(id).get();
		BusOperatorDTO dto = mapper.map(operator, BusOperatorDTO.class);
		return dto;
	}

}
