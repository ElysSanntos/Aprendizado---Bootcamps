package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


// comentário

/*
 * comentário
 * */

@RestController
public class UsuarioController {

// private UsuarioService usuService = new UsuarioService();
// @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo UsuarioService
@Autowired
//private UsuarioService usuService;
private IUsuarioService usuService;

/*
 * o @GetMapping permite associoar o verbo GET com a rota /usuarios
 * */
@GetMapping("usuarios")
public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){

  // usuService.mostrarMensagemService();

  var usuarios = usuService.getAllUsuarios();

  return ResponseEntity.ok().body(usuarios);
}

@GetMapping("v1/usuarios")
public ResponseEntity<List<UsuarioDTO>> getAllUsuariosV2(){

  // usuService.mostrarMensagemService();

  var usuarios = usuService.getAllUsuarios();

  return ResponseEntity.ok().body(usuarios);
}

@GetMapping("v2/usuarios")
public ResponseEntity<List<UsuarioDTO>> getAllUsuariosV3(){

  // usuService.mostrarMensagemService();

  var usuarios = usuService.getAllUsuarios();

  return ResponseEntity.ok().body(usuarios);
}

@PostMapping("usuarios")
public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuario){

  var usuarioResponse = usuService.create(usuario);

  return ResponseEntity.ok().body(usuarioResponse);

} // create

// /usuarios/1 -> o valor do id vai ser 1

@PatchMapping("usuarios/{id}")
public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioBody,
                                         @PathVariable int id ){

  var tiberio = usuService.update(id, usuarioBody);
  return ResponseEntity.ok().body(tiberio);
} // update()

@DeleteMapping("usuarios/{id}")
public ResponseEntity<String> delete(@PathVariable int id){

  var resp = usuService.delete(id);
  return ResponseEntity.ok().body(resp);
} // delete

// busca por apenas um usuário (pelo id)
@GetMapping("usuarios/{id}")
public ResponseEntity<UsuarioDTO> getOne(@PathVariable int id){

  var u = usuService.getOne(id);
  return ResponseEntity.ok().body(u);

} // getOne

// usuarios/nome/Fabrizio
@GetMapping("usuarios/nome/{nomeBusca}")
public ResponseEntity<List<UsuarioDTO>> fetchUsuariosByNome(@PathVariable String nomeBusca){
  // TODO: Não esquecer do ResponseEntity
  // TODO: fazer a busca usando o operador like
  var list = usuService.fetchUsuariosByNome(nomeBusca);
  return ResponseEntity.ok().body(list);

  // return ResponseEntity.ok().body(usuService.fetchUsuariosByNome(nomeBusca));
}

// usuarios/nome/Fabrizio
@GetMapping("usuarios/nome/{nomeBusca}/email/{emailBusca}")
public ResponseEntity<List<UsuarioDTO>> fetchUsuariosByNomeAndEmail(
  @PathVariable String nomeBusca,
  @PathVariable String emailBusca){
  // TODO: Não esquecer do ResponseEntity
  // TODO: fazer a busca usando o operador like

  // var nome = "Fabrizio";

  // List<UsuarioDTO> list = usuService.fetchUsuariosByNomeAndEmail(nomeBusca, emailBusca);
  var list = usuService.fetchUsuariosByNomeAndEmail(nomeBusca, emailBusca);

  return ResponseEntity.ok().body(list);
}

} // UsuarioController