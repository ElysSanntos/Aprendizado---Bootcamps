package com.brq.ms01.dtos;

import com.brq.ms01.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private int id;
	private String nome;
	private String email;
	//private String telefone;


	//Método para converter objeto Model para Objeto DTO
	public UsuarioModel toModel(){
		ModelMapper mapper = new ModelMapper();

		UsuarioModel model = mapper.map(this , UsuarioModel.class);

		return model;
	}
}
