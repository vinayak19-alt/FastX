package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.LoginDetailsDTO;
import com.hexaware.fastx.model.LoginDetails;

public interface ILoginDetailsService {

	public LoginDetails registerUser(LoginDetails loginDetails);
	
	public boolean getAccount(String username);
	
}
