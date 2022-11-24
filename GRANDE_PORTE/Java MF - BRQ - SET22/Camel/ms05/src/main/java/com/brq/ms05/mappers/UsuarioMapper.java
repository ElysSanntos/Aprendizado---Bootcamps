package com.brq.ms05.mappers;

import com.brq.ms05.dtos.UsuarioDTO;
import com.brq.ms05.models.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO convertModelToDTO(UsuarioModel m){
        final var mapper = new ModelMapper();
        return mapper.map(m,UsuarioDTO.class);
    }
}