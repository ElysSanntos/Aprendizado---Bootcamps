package com.brq.ms06.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brq.ms06.models.UsuarioModel;

@Repository
public interface UsuarioRepository 
	extends CrudRepository<UsuarioModel, String> {
	
}
