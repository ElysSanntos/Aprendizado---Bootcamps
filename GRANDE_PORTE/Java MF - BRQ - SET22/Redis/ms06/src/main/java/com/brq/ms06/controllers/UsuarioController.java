package com.brq.ms06.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ms06.DTOs.UsuarioDTO;
import com.brq.ms06.services.UsuarioService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(
        value = "API de Usuários"
)
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;



    @ApiOperation(
            value = "retorna todos os usuários",
            notes = "retorna todos os usuários do Mongo"
    )
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        return  ResponseEntity.ok().body( this.service.getAll() );
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body( service.create(dto.toModel())  );
    }

    @PatchMapping (value = "{id}")
    public ResponseEntity<UsuarioDTO> update(
            @PathVariable String id,
            @Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String id){
        return ResponseEntity.ok().body( service.getOne(id) );
    }


}