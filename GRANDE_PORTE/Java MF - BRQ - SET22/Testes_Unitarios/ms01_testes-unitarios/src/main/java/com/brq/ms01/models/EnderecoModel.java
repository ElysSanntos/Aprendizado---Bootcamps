package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class EnderecoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer id;

	@Column(name = "rua_endereco")
	private String rua;

	@Column(name = "numero_endereco")
	private String numero;

	@Column(name = "cep_endereco")
	private String cep;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioModel usuario;
}