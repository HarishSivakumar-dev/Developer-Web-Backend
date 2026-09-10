package com.harish.developer.app.v1.service;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmbeddingService 
{
	@Autowired
	private EmbeddingModel model;
	
	public float[] getEmbedding(String input) 
	{
		// Call the embedding model to get the embedding for the input text
		float[] embedding = model.embed(input);
		return embedding;
	}
	
}
