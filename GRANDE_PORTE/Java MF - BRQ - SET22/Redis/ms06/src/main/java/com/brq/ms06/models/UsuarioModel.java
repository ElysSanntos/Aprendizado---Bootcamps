package com.brq.ms06.models;

import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.brq.ms06.DTOs.UsuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class UsuarioModel {

	@Id
	@Indexed
	private String id;
	@Indexed
	private String nome;
	@Indexed
	private String email;

	 public UsuarioDTO toDTO(){
	        final var mapper = new ModelMapper();
	        return mapper.map(this,UsuarioDTO.class);
	 }

}
