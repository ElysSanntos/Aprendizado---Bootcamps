package com.brq.ms04.beans;


import com.brq.ms04.dtos.CotacaoUSDDTO;
import com.brq.ms04.models.USDBRLModel;
import com.brq.ms04.repositories.USDBRLRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class USDBRLBean {

	@Autowired
	private USDBRLRepository repository;

	public USDBRLModel save(String messageIn) {

		// converter a string de entrada em objeto java
		final var objectMapper = new ObjectMapper();

		try{
			final var dto = objectMapper
					                .readValue(messageIn, CotacaoUSDDTO.class);

			return repository.save(dto.getUSDBRL().toModel());
		}
		catch (Exception e){
			throw new RuntimeException("Erro ao converter mensagem");
		}
	}
}