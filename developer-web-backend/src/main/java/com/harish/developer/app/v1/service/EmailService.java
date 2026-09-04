package com.harish.developer.app.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.harish.developer.app.v1.dtos.Recipient;
import com.harish.developer.app.v1.dtos.ReplyTo;
import com.harish.developer.app.v1.dtos.Sender;
import com.harish.developer.app.v1.model.SenderModel;

@Service
public class EmailService
{
	@Autowired
	private RestClient restClient;
	
	public String sendEmail(String name, String email, String message)
	{
		Sender sender = new Sender();
		sender.setName("Harish-Portfolio");
		sender.setEmail("harishss.2k07@gmail.com");
		
		Recipient recipient = new Recipient();
		recipient.setName("Harish");
		recipient.setEmail("harishss.2k07@gmail.com");
		
		ReplyTo replyTo = new ReplyTo();
		replyTo.setName(name);
		replyTo.setEmail(email);
		
		SenderModel senderModel = new SenderModel();
		senderModel.setSender(sender);
		senderModel.setTo(java.util.Arrays.asList(recipient));
		senderModel.setReplyTo(replyTo);
		senderModel.setSubject("New Contact Form Submission");
		senderModel.setTextContent("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);
		
		String response= restClient.post()
								   .uri("/smtp/email")
								   .body(senderModel)
								   .retrieve()
								   .body(String.class);
		
		System.out.println("Response from Brevo API: " + response);
		return "Email sent successfully";
	}

}
