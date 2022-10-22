package com.brq.ms01.dtos;

import com.brq.ms01.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private int id;

	@NotEmpty(message = "Não pode enviar o nome em branco")
	@NotNull(message = "Preenchimento obrigatório")
	private String nome;
	private String email;
	private String telefone;


	//Método para converter objeto Model para Objeto DTO
	public UsuarioModel toModel(){
		ModelMapper mapper = new ModelMapper();

		UsuarioModel model = mapper.map(this, UsuarioModel.class);

		return model;
	}
}
