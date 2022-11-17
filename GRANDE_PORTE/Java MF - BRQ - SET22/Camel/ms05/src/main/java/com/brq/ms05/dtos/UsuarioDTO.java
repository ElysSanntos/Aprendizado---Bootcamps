package com.brq.ms05.dtos;

import com.brq.ms05.models.UsuarioModel;
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


private String id;
@NotNull (message = "O campo nome, não pode ser Nulo.")
@NotEmpty (message = "O nome do campo, não pode ser vazio")
private String nome;
@NotNull (message = "O campo, não pode ser Nulo")
@NotEmpty (message = "O campo, não pode ser vazio")
private String email;


public UsuarioModel toModel () {

  final var mapper = new ModelMapper ();

  return mapper.map (this, UsuarioModel.class);

}

}
