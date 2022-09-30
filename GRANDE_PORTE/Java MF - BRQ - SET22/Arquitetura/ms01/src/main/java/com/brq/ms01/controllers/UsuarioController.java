package com.brq.ms01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    // Commenter de linha
    //tentando commitar
    /* Commenter de bloco*/

    //Permite associar o verbo GET com a rota /usuarios
    @GetMapping("usuarios")
    public String getAllUsers(){

        return "Primeiro endpoint  - GET Usuários";
    }
}
