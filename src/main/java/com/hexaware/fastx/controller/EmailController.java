package com.hexaware.fastx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.serviceimpl.EmailServiceImpl;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailServiceImpl emailService;
	
	@PostMapping("/send")
	public String sendMail(@RequestParam String to,
						   @RequestParam String subject, 
						   @RequestParam String text) {
		emailService.sendMail(to, subject, text);
		return "Mail sent successfully";
	}
	
}
