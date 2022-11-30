package com.brq.ms01.services;

import com.brq.ms01.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    void mostrarMensagemService();
    List<UsuarioDTO> getAllUsuarios();
    List<UsuarioDTO> getAllUsuarios2();
    UsuarioDTO create(UsuarioDTO usuario);
    UsuarioDTO update(int id, UsuarioDTO usuarioBody);
    String delete(int id);
    UsuarioDTO getOne(int id);
    List<UsuarioDTO> fetchUsuariosByNome(String nomeBusca);
    List<UsuarioDTO> fetchUsuariosByNomeAndEmail(String nomeBusca, String emailBusca);
    List<UsuarioDTO> fetchUsuariosByNomeAndEmailAndEndereco(String nomeBusca, String emailBusca, String ruaBusca);
}