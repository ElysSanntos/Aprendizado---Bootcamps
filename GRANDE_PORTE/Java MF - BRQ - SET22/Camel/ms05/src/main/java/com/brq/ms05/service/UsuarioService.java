package com.brq.ms05.services;

import com.brq.ms05.dtos.UsuarioDTO;
import com.brq.ms05.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

@Autowired
private UsuarioRepository repository;

public List<UsuarioDTO> getAll () {
  //        List<UsuarioDTO> dtos = new ArrayList<>();
//
//        for(UsuarioModel item: models){
//            dtos.add(item.toDTO());
//        }
//        return dtos;

  //final var models= repository.findAll();

  // stream é mais performático
  return repository.findAll ()
    .stream ()
    .map (x->x.toDTO ())
    .collect (Collectors
    .toList ());
}
}