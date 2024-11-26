package com.hexaware.fastx.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.BadRequestException;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.Admin;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.LoginDetails.Role;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.payload.JWTAuthResponse;
import com.hexaware.fastx.payload.LoginDTO;
import com.hexaware.fastx.payload.LoginUserDTO;
import com.hexaware.fastx.payload.RegisterDTO;
import com.hexaware.fastx.repositories.AdminRepository;
import com.hexaware.fastx.repositories.BusOperatorRepository;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.repositories.UserRepository;
import com.hexaware.fastx.security.JwtTokenProvider;
import com.hexaware.fastx.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService{
	
	private AuthenticationManager authenticationManager;
	private LoginDetailsRepository loginDetailsRepository;
	private AdminRepository adminRepository;
	private UserRepository userRepository;
	private BusOperatorRepository busOperatorRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	
	Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, LoginDetailsRepository loginDetailsRepository,
			AdminRepository adminRepository, UserRepository userRepository, BusOperatorRepository busOperatorRepository,
			PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		super();
		this.authenticationManager = authenticationManager;
		this.loginDetailsRepository = loginDetailsRepository;
		this.adminRepository = adminRepository;
		this.userRepository = userRepository;
		this.busOperatorRepository = busOperatorRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public JWTAuthResponse login(LoginDTO dto) {
		// TODO Auto-generated method stub
		System.out.println(("object received"+dto));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		System.out.println("Token generated : "+token);
		
		User user = this.userRepository.findByUsername(dto.getUsername());
		Admin admin = this.adminRepository.findByUsername(dto.getUsername());
		BusOperator busOperator = this.busOperatorRepository.findByUsername(dto.getUsername());
		
		if(user == null && admin == null && busOperator == null) {
			throw new BadRequestException(HttpStatus.NOT_FOUND, "User not found");
		}
		
		LoginUserDTO loginUserDTO = new LoginUserDTO();
		if(user != null) {
			loginUserDTO.setUsername(user.getUsername());
			loginUserDTO.setRole("ROLE_USER");
		}else if(admin != null) {
			loginUserDTO.setUsername(admin.getUsername());
			loginUserDTO.setRole("ROLE_ADMIN");
		}else if(busOperator != null) {
			loginUserDTO.setUsername(busOperator.getUsername());
			loginUserDTO.setRole("ROLE_OPERATOR");
		}
		
//		Set<Role> roleUser = user.getRoles();
//		for(Role roleTemp:roleUser)
//		{
//			if(roleTemp.getName().equalsIgnoreCase("ROLE_ADMIN"))
//				role = "ROLE_ADMIN";
//		}
//		userDto.setRole(role);
		return new JWTAuthResponse(token,loginUserDTO);
	}

	@Override
	public String register(RegisterDTO dto) {
		// TODO Auto-generated method stub
		if(userRepository.existsByUsername(dto.getUsername())) {
			logger.error("Username already exists");
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exists in User");
		}
		if(adminRepository.existsByUsername(dto.getUsername())) {
			logger.error("Username already exists");
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exists in Admin");
		}
		if(busOperatorRepository.existsByUsername(dto.getUsername())) {
			logger.error("Username already exists");
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exists in Operator");
		}
		
		// Check if email already exists in User repository (only for user registration)
	    if (dto.getRole().toString().equalsIgnoreCase("user") && userRepository.existsByEmail(dto.getEmail()))
	        throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exists in User");

	    // Create LoginDetails object
	    LoginDetails loginDetails = new LoginDetails(dto.getUsername(), passwordEncoder.encode(dto.getPassword()), dto.getRole());
	    loginDetailsRepository.save(loginDetails);
	    
	    return "User Registered Successfully";
	}

}
