package com.harish.developer.app.v1.config;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.genai.Client;

@Configuration
public class GeminiConfig 
{
	@Value("${gemini.api.key}")
	private String apiKey;
	
	@Bean
	public ChatModel chatModel() 
	{
		Client client = Client.builder()
							  .apiKey(apiKey)
							  .build();
		
		GoogleGenAiChatOptions options = GoogleGenAiChatOptions.builder()
															   .temperature(0.7)
											  				   .model("gemini-3.6-flash")
											  				   .build();
		return GoogleGenAiChatModel.builder()
								    .options(options)
								    .genAiClient(client)
								    .build();
	}

}
