package com.brq.ms01.controllers;

import com.brq.ms01.models.UsuarioModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// comentário de linha

/*
 * comentário de bloco
 * */

@RestController
public class UsuarioController {
    //Este ArrayList é para fins didáticos / aqui simula um BD
    private ArrayList<UsuarioModel> users = new ArrayList<>();

    //simular um auto increment
    private int counter = 1;


    /* o @GetMapping permite associoar o verbo GET com a rota /usuarios*/
    @GetMapping("usuarios")//essa variavel é da URL (localhost:8080/usuarios)
    public ArrayList<UsuarioModel> getAllUsuarios() {

        return users;
    }

    @PostMapping("usuarios")//essa variavel é da URL (localhost:8080/usuarios)
    /* @RequestBody ==> pega o que está vindo do body lá no postman e transforma/converte em um objeto
       do tipo UsuarioModel */
    public UsuarioModel create(@RequestBody UsuarioModel user) {
        user.setId(counter);
        System.out.println(user);//exibe no console o que recebemos do post
        users.add(user); // add o objeto no array list
        counter++;
        return user;
    }

    //Métdo Path
    @PatchMapping("usuarios/{id}")
    //@RequestBody --> pega os dados do body converte para a variavel user do tipo UsuarioModel
    //@PathVariable -> pega o id/ valor associado na rota  que está na URL e associar a int id
    public UsuarioModel update(@RequestBody UsuarioModel user, @PathVariable int id) {

        //Como localizar o user a ser alterado?
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                //Localizamos o user a ser alterado
                users.get(i).setNome(user.getNome());
                users.get(i).setEmail(user.getEmail());

                return users.get(i);
            }
        }
        //caso o id passado seja inexistente é retornado null
        return null;


    }

    @DeleteMapping("usuarios/{id}")
    public String delete(@PathVariable int id) {

        //ForEach ou balde
        //for (UsuarioModel variavelLocal: users)
        //Tipo do objeto nome da variavel local que vai assumir cada possição do arrayList:
        // onde está o array list
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return "Usuario deletado com sucesso!";
            }


        }
        return "User não encontrado.";
    }

    @GetMapping("usuarios/{id}")//essa variavel é da URL (localhost:8080/usuarios)
    public UsuarioModel getOne(@PathVariable int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {

                return users.get(i);

            }

        }
        return null;
    }
}