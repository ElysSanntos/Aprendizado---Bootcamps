package com.brq.ms01.repositories;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* O primeiro argumento do JpaRepository é a classe para mapear uma tabela
* e a classe Java
*
* O segundo arguemnto é o tipo de dado da chave primária*/

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel, Integer> {
}
