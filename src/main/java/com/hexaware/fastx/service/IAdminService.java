package com.hexaware.fastx.service;

import java.util.List;

import com.hexaware.fastx.dto.AdminDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.Admin;
import com.hexaware.fastx.model.User;

public interface IAdminService {

	public AdminDTO addAdmin(Admin admin);
	
	public List<UserDTO> getAllUsers();
}
