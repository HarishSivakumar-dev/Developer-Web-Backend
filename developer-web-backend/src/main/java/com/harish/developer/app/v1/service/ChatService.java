package com.harish.developer.app.v1.service;

import java.util.List;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class ChatService
{
	private final ChatModel chatModel;
	private final VectorStore vectorStore;
	
	public ChatService(ChatModel chatModel, VectorStore vectorStore) 
	{
		this.chatModel = chatModel;
		this.vectorStore = vectorStore;
	}
	
	public String sendMesage(String message) 
	{
		SearchRequest search= SearchRequest.builder()
				                           .topK(15)
				                           .query(message)
				                           .build();
		
		List<Document> docs= vectorStore.similaritySearch(search);
		for(Document doc : docs)
		{
			System.out.println("Document Text: " + doc.getText());
		}
		
		StringBuilder sb= new StringBuilder();
		
		for(Document doc: docs)
		{
			sb.append(doc.getText()).append("\n");
		}
		
		String context= sb.toString();
		String promptMessage= """
								Answer the question based on the context below, if the question is not from the context, answer based on your knowledge , and for any responses, dont mention "based on the given context" and ensure the response is not long :
								
								Context:
								%s
								
								Question:
								%s
								""".formatted(context, message);
				
		Prompt prompt = Prompt.builder()
				  			  .content(promptMessage)
				  			  .build();

		
		ChatResponse res=chatModel.call(prompt);
		
		return res.getResult().getOutput().getText();
	}
	
	
	
}
