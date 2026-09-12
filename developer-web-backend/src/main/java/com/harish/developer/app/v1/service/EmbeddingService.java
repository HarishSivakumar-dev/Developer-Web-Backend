package com.harish.developer.app.v1.service;

import java.util.List;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;
import com.knuddels.jtokkit.api.EncodingType;

@Component
public class EmbeddingService 
{
	
	private VectorStore vectorStore;
	
	public EmbeddingService(VectorStore vectorStore) 
	{
		this.vectorStore = vectorStore;
	}

	public List<Document> chunkTexts()
	{
		TextReader textReader = new TextReader("classpath:/static/Harish_Sivakumar_College_Journey.txt");
		List<Document> ls= textReader.get();
		
		TokenTextSplitter splitter = TokenTextSplitter.builder()
					                                  .withChunkSize(100)
					                                  .withMaxNumChunks(1000)
					                                  .withEncodingType(EncodingType.O200K_BASE)
					                                  .build();
		List<Document> str= splitter.split(ls);
		List<Document> cleaned= str.stream()
				                   .map(r->{
				                	   String cnt= r.getText().replace("\u0000", "");
				                	   return Document.builder()
				                				  	  .text(cnt)
				                				      .metadata(r.getMetadata())
				                				      .build();
				                   })
				                   .toList();
		return cleaned;
	}
	public String loadVectorDbWithEmbeddings() 
	{
		List<Document> docs= chunkTexts();
		vectorStore.add(docs);
		
		return "done";
	}
	
}
