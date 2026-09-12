package com.harish.developer.app.v1.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PgVectorConfig
{
	@Bean
	public VectorStore vectorStore(EmbeddingModel model, JdbcTemplate jdbcTemplate)
	{
		PgVectorStore config = PgVectorStore.builder(jdbcTemplate, model)
											.initializeSchema(true)
										  	.vectorTableName("Harish_Embeddings")
										  	.build();	
		
		return config;
	}

}
