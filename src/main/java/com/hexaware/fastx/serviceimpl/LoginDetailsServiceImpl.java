package com.hexaware.fastx.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.dto.LoginDetailsDTO;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.service.ILoginDetailsService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginDetailsServiceImpl implements ILoginDetailsService {
	
	private LoginDetailsRepository loginDetailsRepository;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	public LoginDetailsServiceImpl(LoginDetailsRepository loginDetailsRepository) {
		super();
		this.loginDetailsRepository = loginDetailsRepository;
	}



	@Override
	public LoginDetails registerUser(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		LoginDetails savedLogin = this.loginDetailsRepository.save(loginDetails);
//		LoginDetailsDTO loginDTO = mapper.map(savedLogin, LoginDetailsDTO.class);
		
		return savedLogin;
	}



	@Override
	public boolean getAccount(String username) {
		// TODO Auto-generated method stub
		LoginDetails loginDetails = loginDetailsRepository.findByUsername(username);
		if(loginDetails == null) {
			throw new EntityNotFoundException(username, "Login Details");
		}
		return true;
	}
	
	
}
