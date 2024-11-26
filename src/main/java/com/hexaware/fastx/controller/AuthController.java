package com.hexaware.fastx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.AdminDTO;
import com.hexaware.fastx.dto.BusOperatorDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.Admin;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.payload.JWTAuthResponse;
import com.hexaware.fastx.payload.LoginDTO;
import com.hexaware.fastx.payload.RegisterDTO;
import com.hexaware.fastx.service.IAuthService;
import com.hexaware.fastx.serviceimpl.AdminService;
import com.hexaware.fastx.serviceimpl.BusOperatorServiceImpl;
import com.hexaware.fastx.serviceimpl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authenticate")
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("*")
public class AuthController {
	private IAuthService authService;
	private UserServiceImpl userServiceImpl;
	private BusOperatorServiceImpl busOperatorServiceImpl;
	private AdminService adminService;
	
	@Autowired
	public AuthController(IAuthService authService, UserServiceImpl userServiceImpl, BusOperatorServiceImpl busOperatorServiceImpl, AdminService adminService) {
		this.authService = authService;
		this.userServiceImpl = userServiceImpl;
		this.busOperatorServiceImpl = busOperatorServiceImpl;
		this.adminService=adminService;
	}
	@PostMapping(value = {"/login","/signin"})
	public ResponseEntity<JWTAuthResponse> login(@Valid @RequestBody LoginDTO dto)
	{
		JWTAuthResponse token = authService.login(dto);
		/*JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);*/
 
		return ResponseEntity.ok(token);
	}
	

	@PostMapping(value = {"/register","/signup"})
	public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO dto)
	{
		String value = authService.register(dto);
		return new ResponseEntity<>(value, HttpStatus.CREATED);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user){
		return ResponseEntity.ok(this.userServiceImpl.addUser(user));
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody Admin admin){
		return ResponseEntity.ok(this.adminService.addAdmin(admin));
	}
	
	@PostMapping("/addBusOperator")
	public ResponseEntity<BusOperatorDTO> addBusOperator(@RequestBody BusOperator busOperator){
		return ResponseEntity.ok(this.busOperatorServiceImpl.addBusOperator(busOperator));
	}
}