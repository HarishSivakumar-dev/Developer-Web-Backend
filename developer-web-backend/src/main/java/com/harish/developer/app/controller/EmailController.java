package com.harish.developer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harish.developer.app.dtos.EmailRequest;
import com.harish.developer.app.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController
{
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest)
	{
		emailService.sendEmail(emailRequest.getName(), emailRequest.getEmail(), emailRequest.getMessage());
		return ResponseEntity.ok("Email sent successfully!");
	}

}
