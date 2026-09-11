package com.harish.developer.app.v1.service;

import java.util.List;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.knuddels.jtokkit.api.EncodingType;

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
	
	public List<String> chunkTexts()
	{
		TextReader textReader = new TextReader("classpath:static/texts.txt");
		List<Document> ls= textReader.get();
		
		TokenTextSplitter splitter = TokenTextSplitter.builder()
					                                  .withChunkSize(100)
					                                  .withMaxNumChunks(20)
					                                  .withEncodingType(EncodingType.O200K_BASE)
					                                  .build();
		List<Document> str= splitter.split(ls);
		List<String> chunkedTexts = str.stream()
		                             .map(Document::getText)
		                             .toList();
		return chunkedTexts;
	}
	
}
