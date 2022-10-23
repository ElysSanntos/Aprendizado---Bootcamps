package com.brq.ms03.dtos;

import com.brq.ms03.models.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

	private int id;
	private String nome;
	private String cpf;
	private Double salario;
	private String telefone;

	//Método para converter objeto Model para Objeto DTO
	public ProfessorModel toModel() {
		ModelMapper mapper = new ModelMapper();

		ProfessorModel model = mapper.map(this, ProfessorModel.class);

		return model;
	}
}
