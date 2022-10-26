package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
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
	private UsuarioService usuService;


	/*
	 * o @GetMapping permite associoar o verbo GET com a rota /usuarios
	 * */
	@GetMapping("usuarios")
	public List<UsuarioDTO> getAllUsuarios() {

		// ISSO É VERDADEIRO?????
		/*
		 * EM JAVA, NÃÃÃÃÃÃÃOOOO SE COMPARA STRING COM OPERADOR ==
		 * */
//        if ("aaa" == "aaa"){
//
//        }
//        if ("aaa".equalsIgnoreCase("aaa")){
//
//        }
		usuService.mostrarMensagemService();
		//return usuarios;
//        ArrayList<UsuarioModel> usuarios = usuService.getAllUsuarios();
//          MANIPULAR AQUI
//        return usuarios;

		//return usuService.getAllUsuarios();
		return usuService.getAllUsuarios();
	}

	@PostMapping("usuarios")
	public UsuarioDTO create(@Valid @RequestBody UsuarioDTO usuario) {
//        UsuarioModel u = usuService.create(usuario);
//        return u;
		return usuService.create(usuario);

	}

	// /usuarios/1 -> o valor do id vai ser 1

	@PatchMapping("usuarios/{id}")
	public UsuarioDTO update(@RequestBody UsuarioDTO usuarioBody,
	                           @PathVariable int id) {
		//        UsuarioModel u = usuService.update(id, usuarioBody);
		//        return u;
		return usuService.update(id, usuarioBody);
	}

	@DeleteMapping("usuarios/{id}")
	public String delete(@PathVariable int id) {

//        String response = usuService.delete(id);
//        return response;

		return usuService.delete(id);
	}

	// busca por apenas um usuário (pelo id)
	@GetMapping("usuarios/{id}")
	public UsuarioDTO getOne(@PathVariable int id) {

//        UsuarioModel u = usuService.getOne(id);
//        return u;

		return usuService.getOne(id);

	}

}