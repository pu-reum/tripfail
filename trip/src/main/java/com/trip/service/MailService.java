package com.trip.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String toEmail, String body) {
		
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		
		simpleMessage.setFrom("tripimfo123@gmail.com");
		simpleMessage.setTo(toEmail);
		simpleMessage.setSubject("회원가입 인증 번호 입니다.");
		simpleMessage.setText(body);
		
		javaMailSender.send(simpleMessage);
		
		System.out.println("Mail Sent Successfully...");
	}
	
	
}
