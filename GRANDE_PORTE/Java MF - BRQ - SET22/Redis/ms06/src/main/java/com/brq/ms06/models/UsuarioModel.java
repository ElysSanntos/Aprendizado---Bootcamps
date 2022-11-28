package com.brq.ms06.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class UsuarioModel {

	@Id
	private String id;
	
	private String nome;
	private String email;
	
	
}
