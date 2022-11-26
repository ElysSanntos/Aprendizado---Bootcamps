//package com.brq.ms05.services;
//
//import com.brq.ms05.dtos.UsuarioDTO;
//import com.brq.ms05.models.UsuarioModel;
//import com.brq.ms05.repositories.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UsuarioService2 implements IUsuarioService {
//
//    @Autowired
//    private UsuarioRepository repository;
//
//    public List<UsuarioDTO> getAll(){
//        final var models= repository.findAll();
//
//        List<UsuarioDTO> dtos = new ArrayList<>();
//
//        for(UsuarioModel item: models){
//            dtos.add(item.toDTO());
//        }
//        return dtos;
//    }
//
//    public UsuarioDTO create(UsuarioModel model){
//        final var obj = repository.save(model);
//
//        return obj.toDTO();
//    }
//
//    public UsuarioDTO update(String id, UsuarioDTO dto){
//
//        var usuario = repository.findById(id)
//                .orElseThrow( () -> new RuntimeException("Objeto não encontrado"));
//
//        usuario.setEmail(dto.getEmail());
//        usuario.setNome(dto.getNome());
//
//        usuario = repository.save(usuario);
//
//        return usuario.toDTO();
//    }
//
//}