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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private int id;

	@NotEmpty(message = "Valor em branco")
	@NotNull(message = "Preenchimento Obrigatório")
	@Length(min=3, max= 50, message = "O número de caracteres deve ser entre 3 e 50")
	private String nome;

	@NotNull(message = "Preenchimento Obrigatório")
	private String email;

	@Pattern(regexp = "^\\([1-9]{2}\\) [9]{0,1}[2-9]{1}[0-9]{3}\\-[0-9]{4}$", message = "Telefone inválido")
	private String telefone;

	private List<FinanciamentoDTO>  financiamentos;

	public UsuarioModel toModel(){

		ModelMapper mapper = new ModelMapper();

		UsuarioModel model = mapper.map(this , UsuarioModel.class );

		return model;
	}
}