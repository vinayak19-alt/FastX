package com.hexaware.fastx.serviceimpl;



import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.dto.AdminDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.Admin;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.AdminRepository;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.repositories.UserRepository;
import com.hexaware.fastx.service.IAdminService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService implements IAdminService{
	
	private AdminRepository adminRepository;
	private LoginDetailsRepository loginDetailsRepository;
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(AdminService.class);
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public AdminService(AdminRepository adminRepository, LoginDetailsRepository loginDetailsRepository, UserRepository userRepository) {
		super();
		this.adminRepository = adminRepository;
		this.loginDetailsRepository = loginDetailsRepository;
		this.userRepository = userRepository;
	}
	@Override
	public AdminDTO addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		LoginDetails loginDetails = this.loginDetailsRepository.findByUsername(admin.getUsername());
		if(loginDetails == null) {
			logger.error("Admin details are not there in login details");
			throw new EntityNotFoundException("Admin", "Login Details");
		}
		admin.setLoginDetails(loginDetails);
		Admin savedAdmin = this.adminRepository.save(admin);
		AdminDTO savedAdminDTO = mapper.map(savedAdmin, AdminDTO.class);
		return savedAdminDTO;
	}
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> usersDTO = new ArrayList<>();
		List<User> users = userRepository.findAll();
		logger.info("Getting all users");
		if(users.size() == 0) {
			logger.error("No users are there in the database");
			throw new EntityNotFoundException("Users not found in ", "System");
		}
		users.forEach((u) -> {
			usersDTO.add(mapper.map(u, UserDTO.class));
		});
		return usersDTO;
	}

}
