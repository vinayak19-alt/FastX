package com.hexaware.fastx.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendMail(String to, String subject, String text) {
		// TODO Auto-generated method stub
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(text);
		mail.setFrom("vinayaksharma5555@gmail.com");
		
		javaMailSender.send(mail);
	}

}
