package com.harish.developer.app.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harish.developer.app.v1.dtos.ChatDto;
import com.harish.developer.app.v1.service.ChatService;
import com.harish.developer.app.v1.service.EmbeddingService;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController
{
	@Autowired
	private ChatService chatService;
	@Autowired
	private EmbeddingService embeddingService;
	
	@PostMapping("/send")
	@CrossOrigin(origins = "http://localhost:5173")
	public ResponseEntity<String> sendMessage(@RequestBody ChatDto dto) 
	{
		String res=chatService.sendMesage(dto.getMessage());
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/dump")
	public ResponseEntity<String> dumpEmbeddings() 
	{
		String res= embeddingService.loadVectorDbWithEmbeddings();
		return ResponseEntity.ok(res);
	}

}
