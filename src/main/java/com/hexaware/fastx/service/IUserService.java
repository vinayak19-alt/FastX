package com.hexaware.fastx.service;

import java.util.List;

import com.hexaware.fastx.dto.BookingsDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.User;

public interface IUserService {

	UserDTO addUser(User user);
	
	void deleteUser(Long userId);
	
	UserDTO getUserById(Long userId);
	
}
