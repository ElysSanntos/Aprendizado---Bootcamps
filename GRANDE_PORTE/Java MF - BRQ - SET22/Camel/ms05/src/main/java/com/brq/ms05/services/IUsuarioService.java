package com.brq.ms05.services;

import com.brq.ms05.dtos.UsuarioDTO;
import com.brq.ms05.models.UsuarioModel;

import java.util.List;

public interface IUsuarioService {

List<UsuarioDTO> getAll();

UsuarioDTO create(UsuarioModel model);

UsuarioDTO update(String id, UsuarioDTO dto);

void delete(String id);

UsuarioDTO getOne(String id);

List<UsuarioDTO> findByNome(String nome);

List<UsuarioDTO> findByAllAttrs(String input);
}