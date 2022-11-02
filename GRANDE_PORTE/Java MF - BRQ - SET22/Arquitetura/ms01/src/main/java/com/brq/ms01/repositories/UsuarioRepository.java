package com.brq.ms01.repositories;
import com.brq.ms01.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * O primeiro argumento do JpaRepository é a classe modelo para mapear uma tabela
 * e a classe Java
 *
 * O segundo argumento é o tipo de dado da chave primária
 * */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	//    SELECT * FROM usuarios u
	//    where u.nome_user = '';
	List<UsuarioModel> findByNome(String nome);

	List<UsuarioModel> findByNomeContains(String nome);

	// JPQL
	// SELECT * FROM usuarios u where u.nome_user like ?
	@Query(value ="SELECT u FROM UsuarioModel u WHERE u.nome like %:nomeBusca%")
	List<UsuarioModel> fetchByNomeLike(@Param("nomeBusca") String nome);

	@Query(value = "SELECT * FROM usuarios u where u.nome_user like %:nomeBusca%", nativeQuery = true)
	List<UsuarioModel> fetchByNomeLikeNativeQuery(@Param("nomeBusca") String nome);

	List<UsuarioModel> findByNomeContainsAndEmailContains(String nome, String email);

	List<UsuarioModel> findByNomeContainsAndEmailContainsAndEnderecoRuaContains(String nome, String email, String rua);

	UsuarioModel findFirstByNomeContains(String nome);
}