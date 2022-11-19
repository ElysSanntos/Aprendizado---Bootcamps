package com.brq.ms05.services;

import com.brq.ms05.dtos.UsuarioDTO;
import com.brq.ms05.exceptions.NaoAcheiException;
import com.brq.ms05.models.UsuarioModel;
import com.brq.ms05.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

@Autowired
private UsuarioRepository repository;

public List<UsuarioDTO> getAll(){
  //        List<UsuarioDTO> dtos = new ArrayList<>();
//
//        for(UsuarioModel item: models){
//            dtos.add(item.toDTO());
//        }
//        return dtos;

  //final var models= repository.findAll();

  // stream é mais performático - converter List<Model> para List<DTO>
  return repository.findAll()
    .stream()
    .map( x -> x.toDTO() )
    .collect(Collectors.toList());
}

public UsuarioDTO create(UsuarioModel model){
  final var obj = repository.save(model);

  return obj.toDTO();
}

public UsuarioDTO update(String id, UsuarioDTO dto){

  var usuario = repository.findById(id)
    .orElseThrow( () -> new RuntimeException("Objeto não encontrado"));

  usuario.setEmail(dto.getEmail());
  usuario.setNome(dto.getNome());

  usuario = repository.save(usuario);

  return usuario.toDTO();
}

public void delete(String id){

  final var usuario = repository.findById(id)
    .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

  repository.deleteById(usuario.getId());
}

public UsuarioDTO getOne(String id){

  final var usuario = repository.findById(id)
    .orElseThrow( () -> new NaoAcheiException("Usuário não localizado") );

  return usuario.toDTO();
}

public List<UsuarioDTO> findByNome(String nome){
  final var dtos = repository.findByNomeContains(nome);
  //final var dtos = repository.findByNome(nome);

  return dtos.stream()
    .map( el -> el.toDTO() )
    .collect(Collectors.toList());
}

public List<UsuarioDTO> findByAllAttrs(String input){
  final var dtos = repository.findByNomeContainsOrEmailContains(input, input);

  return dtos.stream()
    .map( el -> el.toDTO() )
    .collect(Collectors.toList());
}
}