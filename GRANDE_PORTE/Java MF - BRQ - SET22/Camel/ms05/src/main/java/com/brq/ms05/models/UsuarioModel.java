package com.brq.ms05.models;

import com.brq.ms05.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class UsuarioModel {

@Id
private String id;
private String nome;
private String email;

public UsuarioDTO toDTO(){

  final var mapper = new ModelMapper ();

  return  mapper.map (this, UsuarioDTO.class);
}

}