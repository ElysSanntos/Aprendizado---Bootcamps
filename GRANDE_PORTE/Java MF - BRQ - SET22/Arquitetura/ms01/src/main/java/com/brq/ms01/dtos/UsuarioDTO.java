package com.brq.ms01.dtos;

import com.brq.ms01.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private int id;

	@NotEmpty(message = "Não pode enviar o nome em branco")
	@NotNull(message = "Preenchimento obrigatório")
	@Length(min = 3,max = 40,message = "A qtde de caracteres deve estar no range de 3 a 50")
	private String nome;
	private String email;
	@Pattern( regexp ="^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$" ,message = "Telefone inválido")
	private String telefone;


	//Método para converter objeto Model para Objeto DTO
	public UsuarioModel toModel(){
		ModelMapper mapper = new ModelMapper();

		UsuarioModel model = mapper.map(this, UsuarioModel.class);

		return model;
	}
}
