package com.hexaware.fastx.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.repositories.UserRepository;
import com.hexaware.fastx.service.IUserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	private UserRepository userRepository;
	private LoginDetailsRepository loginDetailsRepository;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, LoginDetailsRepository loginDetailsRepository) {
		super();
		this.userRepository = userRepository;
		this.loginDetailsRepository=loginDetailsRepository;
	}


	@Override
	public UserDTO addUser(User user) throws EntityNotFoundException {
		// TODO Auto-generated method stub
//		User user = mapper.map(userDTO, User.class);
		LoginDetails loginDetails = this.loginDetailsRepository.findByUsername(user.getUsername());
		if(loginDetails == null) {
			logger.error("User does not exist in Login details");
			throw new EntityNotFoundException("User", "Login Details");
		}
		user.setLoginDetails(loginDetails);
		User savedUser = this.userRepository.save(user);
		UserDTO savedUserDTO = mapper.map(savedUser, UserDTO.class);
		return savedUserDTO;
	}


	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		logger.info("Loooking for userID: " + userId);
		this.userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User", "System"));
		this.userRepository.deleteById(userId);
	}


	@Override
	public UserDTO getUserById(Long userId) {
		// TODO Auto-generated method stub
		User user = this.userRepository.findById(userId).get();
		UserDTO dto = mapper.map(user, UserDTO.class);
		return dto;
	}

}
