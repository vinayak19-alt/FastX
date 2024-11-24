package com.hexaware.fastx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.LoginDetailsDTO;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.serviceimpl.LoginDetailsServiceImpl;

@RestController
@RequestMapping("/registerapi/v1/")
public class LoginDetailsController {

	private LoginDetailsServiceImpl loginDetailsServiceImpl;

	@Autowired
	public LoginDetailsController(LoginDetailsServiceImpl loginDetailsServiceImpl) {
		super();
		this.loginDetailsServiceImpl = loginDetailsServiceImpl;
	}
	
	@PostMapping("/registeruser")
	public ResponseEntity<LoginDetails> registerUser(@RequestBody LoginDetails loginDetails){
		return ResponseEntity.ok(this.loginDetailsServiceImpl.registerUser(loginDetails));
	}
	
	@GetMapping("/getAccount/{username}")
	public ResponseEntity<Boolean> getAccount(@PathVariable("username") String username){
		return ResponseEntity.ok(this.loginDetailsServiceImpl.getAccount(username));
	}
}
