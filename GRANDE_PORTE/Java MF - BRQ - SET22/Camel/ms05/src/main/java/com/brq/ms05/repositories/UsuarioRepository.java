package com.brq.ms05.repositories;

import com.brq.ms05.models.UsuarioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository
       extends MongoRepository<UsuarioModel, String > {
}
