package com.brq.ms05.services;

import com.brq.ms05.dtos.UsuarioDTO;
import com.brq.ms05.enums.CanaisEntradaEnum;
import com.brq.ms05.enums.MensagensExceptionEnum;
import com.brq.ms05.exceptions.NaoAcheiException;
import com.brq.ms05.models.UsuarioModel;
import com.brq.ms05.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> getAll(){

        return repository.findAll()
                .stream()
                .map( UsuarioModel::toDTO )
                .collect(Collectors.toList());
    }

    public UsuarioDTO create(UsuarioModel model){

        if (model.getNome().equalsIgnoreCase(CanaisEntradaEnum.C3.getCodigo()) ){
            log.info("Canal C3");
            model.setNome(model.getNome() + "BRQ");
        }

        final var obj = repository.save(model);

        return obj.toDTO();
    }

    public UsuarioDTO update(String id, UsuarioDTO dto){

        var usuario = repository.findById(id)
                .orElseThrow( () -> new NaoAcheiException(
                        MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem())
                );

        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());

        usuario = repository.save(usuario);

        return usuario.toDTO();
    }

    public void delete(String id){

        final var usuario = repository.findById(id)
                .orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()) );

        repository.deleteById(usuario.getId());
    }

    public UsuarioDTO getOne(String id){

        final var usuario = repository.findById(id)
                .orElseThrow( () -> new NaoAcheiException(MensagensExceptionEnum.USUARIO_NAO_ENCONTRADO.getMensagem()) );

        return usuario.toDTO();
    }

    public List<UsuarioDTO> findByNome(String nome){

        final var dtos = repository.findByNomeContains(nome);

        return dtos.stream()
                .map( UsuarioModel::toDTO )
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> findByAllAttrs(String input){
        final var dtos = repository.findByNomeContainsOrEmailContains(input, input);

        return dtos.stream()
                .map( UsuarioModel::toDTO )
                .collect(Collectors.toList());
    }
}
