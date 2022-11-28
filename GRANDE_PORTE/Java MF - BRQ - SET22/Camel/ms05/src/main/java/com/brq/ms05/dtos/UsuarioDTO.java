package com.brq.ms05.dtos;

import com.brq.ms05.models.UsuarioModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(notes = "nome do usuário", example = "Fabrizio", required = true)
    @NotNull(message = "o campo nome não pode ser nulo")
    @NotEmpty(message = "o campo nome não pode ser vazio")
    private String nome;

    @ApiModelProperty(notes = "email do usuário", example = "fa@gmail.com", required = true)
    @NotNull(message = "o campo email não pode ser nulo")
    @NotEmpty(message = "o campo email não pode ser vazio")
    private String email;

    public UsuarioModel toModel(){
        final var mapper = new ModelMapper();
        return mapper.map(this, UsuarioModel.class);
    }
}
