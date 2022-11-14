package com.brq.ms01.models;

import com.brq.ms01.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

/*
 * @Data, que faz o papel dos Getters, Setters e toString()
 * @Entity "diz" que a classe UsuarioModel vai ser mapeada com uma tabela no banco de dados
 * @Table especifica o nome da tabela que esta classe vai mapear
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

	// UUID -> é um conjunto de letras e números para identificar unicamente um registro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id;

	@Column(name = "nome_user")
	private String nome;

	@Column(name = "email_user")
	private String email;

	@Column(name = "telefone_user")
	private String telefone;

	// no mappedBy guardamos a variável JAVA que mapeia esta entidade (UsuarioModel)
	@OneToMany(mappedBy = "usuario")
	private List<FinanciamentoModel> financiamentos;

	@OneToOne(mappedBy = "usuario")
	private EnderecoModel endereco;

	@ManyToMany
	@JoinTable(
			name = "usuario_consorcio",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "consorcio_id"))

	private List<ConsorcioModel> consorcios;

	public UsuarioDTO toDTO() {
		ModelMapper mapper = new ModelMapper();

		return mapper.map(this, UsuarioDTO.class);
	}
}