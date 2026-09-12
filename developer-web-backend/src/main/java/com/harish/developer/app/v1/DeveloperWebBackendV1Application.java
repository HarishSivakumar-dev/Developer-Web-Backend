package com.harish.developer.app.v1;

import org.springframework.ai.model.google.genai.autoconfigure.chat.GoogleGenAiChatAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	    exclude = GoogleGenAiChatAutoConfiguration.class
	)
public class DeveloperWebBackendV1Application {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperWebBackendV1Application.class, args);
	}

}
