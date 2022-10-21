package com.brq.ms01.models;

import com.brq.ms01.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informa a estrategia a ser utilizada para criar o ID
	@Column(name = "id_user" )
	private int id;

	@Column(name = "nome_user")
	private String nome;

	@Column(name = "email_user")
	private String email;

	@Column(name = "telefone_user")
	private String telefone;

	public UsuarioDTO toDTO(){
		ModelMapper mapper = new ModelMapper();

		return mapper.map(this, UsuarioDTO.class);
	}



}
