package com.harish.developer.app.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harish.developer.app.v1.dtos.ChatDto;
import com.harish.developer.app.v1.service.ChatService;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController
{
	@Autowired
	private ChatService chatService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestBody ChatDto dto) 
	{
		String res=chatService.sendMesage(dto.getMessage());
		return ResponseEntity.ok(res);
	}

}
