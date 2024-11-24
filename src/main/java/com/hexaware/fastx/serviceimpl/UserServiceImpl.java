package com.hexaware.fastx.serviceimpl;

import java.util.Date;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.hibernate.action.internal.EntityActionVetoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.dto.BookingsDTO;
import com.hexaware.fastx.dto.LoginDetailsDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.Payments;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.BookingRepository;
import com.hexaware.fastx.repositories.BusRepository;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.repositories.PaymentsRepository;
import com.hexaware.fastx.repositories.UserRepository;
import com.hexaware.fastx.service.IUserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	private UserRepository userRepository;
	private LoginDetailsRepository loginDetailsRepository;
	
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
		this.userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User", "System"));
		this.userRepository.deleteById(userId);
	}

}
