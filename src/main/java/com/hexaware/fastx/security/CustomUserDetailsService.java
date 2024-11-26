package com.hexaware.fastx.security;
 
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.AdminRepository;
import com.hexaware.fastx.repositories.BusOperatorRepository;
import com.hexaware.fastx.repositories.LoginDetailsRepository;
import com.hexaware.fastx.repositories.UserRepository;
 
@Service
 
public class CustomUserDetailsService implements UserDetailsService {
 
	private LoginDetailsRepository loginDetailsRepository;
	private UserRepository userRepository;
	private AdminRepository adminRepository;
	private BusOperatorRepository busOperatorRepository;
	
	// Constructor DI
	public CustomUserDetailsService(LoginDetailsRepository loginDetailsRepository, UserRepository userRepository,
			AdminRepository adminRepository, BusOperatorRepository busOperatorRepository) {
		super();
		this.loginDetailsRepository = loginDetailsRepository;
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
		this.busOperatorRepository = busOperatorRepository;
	}
	
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		LoginDetails loginDetails = loginDetailsRepository.findByUsername(username);
		
		if(loginDetails == null) {
			throw new UsernameNotFoundException("User with username: " + username + " not present in the system");
		}
 
//		Set<GrantedAuthority> authorities = loginDetails.getRole().stream()
//				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		Object entity;
		Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("ROLE_" + loginDetails.getRole().name()));
		
		switch(loginDetails.getRole()) {
			case User:
				entity = userRepository.findByLoginDetails(loginDetails)
				.orElseThrow(() -> new UsernameNotFoundException("User details not found"));
				break;
			
			case Admin:
				entity = adminRepository.findByLoginDetails(loginDetails)
				.orElseThrow(() -> new UsernameNotFoundException("Admin Details not found"));
				break;
				
			case Operator:
				entity = busOperatorRepository.findByLoginDetails(loginDetails)
				.orElseThrow(() -> new UsernameNotFoundException("Bus Operator not found"));
				break;
				
			default:
                throw new IllegalArgumentException("Unsupported role: " + loginDetails.getRole());
				
		}
 
		return new org.springframework.security.core.userdetails.User(loginDetails.getUsername(), loginDetails.getPassword(), authorities);
	}
	
}