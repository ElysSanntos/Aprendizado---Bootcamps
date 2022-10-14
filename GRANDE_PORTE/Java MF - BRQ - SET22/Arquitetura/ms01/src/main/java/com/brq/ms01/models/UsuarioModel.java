package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Data gera em tempo de execução os getters-setters-toString*/
@Data
/*Construtor com argumentos*/
@AllArgsConstructor
/*Construtor vazio*/
@NoArgsConstructor
/*@Entity diz que a classe UsuarioModel vai ser mapeada como uma tabela java realacional*/
@Entity
/*@Table especifica o nome da tabela que esta classe vai mapear*/
@Table(name = "usuarios")
public class UsuarioModel {

	/*O meu usuário deve ter um id, nome e email - Eu quero criar um ArrayList de Usuários*/
	@Id
	@Column(name = "id_user" )
	private int id;
	@Column(name = "name_user")
	private String nome;
	@Column(name = "email_user")
	private String email;



}
