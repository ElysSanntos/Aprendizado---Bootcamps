package com.brq.ms03.models;

import com.brq.ms03.dtos.ProfessorDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "professor")
@Data
public class ProfessorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@CollectionTable(name = "id_prof")
	private int id;
	@Column(name = "nome_prof")
	private String nome;
	@Column(name = "cpf_prof")
	private String cpf;
	@Column(name = "salario_prof")
	private Double salario;
	@Column(name = "telefone_prof")
	private String telefone;

	public ProfessorDTO toDTO() {
		ModelMapper mapper = new ModelMapper();

		return mapper.map(this, ProfessorDTO.class);
	}

}
