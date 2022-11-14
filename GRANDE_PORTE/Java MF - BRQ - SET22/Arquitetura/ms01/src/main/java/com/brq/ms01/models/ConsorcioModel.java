package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consorcios")
public class ConsorcioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consorcio")
	private int id;

	@Column(name = "nome_consorcio")
	private String nome;

	@Column(name = "tipo_consorcio")
	private String tipo;

	@Column(name = "valor_consorcio")
	private Double valor;

	@ManyToMany(mappedBy = "consorcios")
	private List<UsuarioModel> usuarios;
}