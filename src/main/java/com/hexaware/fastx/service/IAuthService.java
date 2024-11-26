package com.hexaware.fastx.service;

import org.springframework.stereotype.Service;

import com.hexaware.fastx.payload.JWTAuthResponse;
import com.hexaware.fastx.payload.LoginDTO;
import com.hexaware.fastx.payload.RegisterDTO;

@Service
public interface IAuthService {
	
	JWTAuthResponse login(LoginDTO dto);
	String register(RegisterDTO dto);

}
