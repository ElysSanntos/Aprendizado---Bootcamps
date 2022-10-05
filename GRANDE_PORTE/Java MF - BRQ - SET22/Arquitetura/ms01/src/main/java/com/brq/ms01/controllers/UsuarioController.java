package com.brq.ms01.controllers;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// comentário

/*
 * comentário
 * */

@RestController
public class UsuarioController {
    //Este ArrayList é para fins didáticos / aqui simula um BD
    public ArrayList<UsuarioModel> user = new ArrayList<>();

    /* o @GetMapping permite associoar o verbo GET com a rota /usuarios*/
    @GetMapping("usuarios")
    public ArrayList<UsuarioModel> getAllUsuarios() {



        UsuarioModel u = new UsuarioModel();
        u.setId(1);
        u.setNome("Manoel");
        u.setEmail("manoel@gmail.com");
        user.add(u);

        UsuarioModel u2 = new UsuarioModel();
        u2.setId(22);
        u2.setNome("Jair");
        u2.setEmail("melhorjairseacostumando@gmail.com");


        user.add(u2);

        return user;
    }
    @PostMapping("usuarios")
    public String create(){
        return "POST Usuários";
    }
}