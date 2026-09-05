package com.harish.developer.app.v1.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatService
{
	private final ChatModel chatModel;
	
	public ChatService(ChatModel chatModel) 
	{
		this.chatModel = chatModel;
	}
	
	public String sendMesage(String message) 
	{
		Prompt prompt = Prompt.builder()
							  .content(message)
							  .build();
		
		ChatResponse res=chatModel.call(prompt);
		
		return res.getResult().toString();
	}
	
}
