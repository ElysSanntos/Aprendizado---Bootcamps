package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data gera em tempo de execução os getters-setters-toString*/
@Data
/*Construtor com argumentos*/
@AllArgsConstructor
/*Construtor vazio*/
@NoArgsConstructor
public class UsuarioModel {

	/*O meu usuário deve ter um id, nome e email - Eu quero criar um ArrayList de Usuários*/
	private int id;
	private String nome;
	private String email;



}
