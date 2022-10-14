package com.brq.ms01.services;

import com.brq.ms01.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brq.ms01.models.UsuarioModel;
import java.util.List;


import java.util.ArrayList;

/*
 * A camada Service é responsável por armazenar as regras de negócio da aplicação
 * */
@Service
public class UsuarioService {

	// ESTE ARRAYLIST É DIDÁTICO, POIS ESTÁ SIMULANDO UM BANCO DE DADOS
	private ArrayList<UsuarioModel> usuarios = new ArrayList<>();
	private int counter = 1;

	@Autowired
	private UsuarioRepository usuRepository;


	public void mostrarMensagemService(){
		System.out.println("Mensagem do serviço");
	}

	public List<UsuarioModel> getAllUsuarios(){

		/*A repository vai executar : Select * from usuarios;*/
		List<UsuarioModel> list = usuRepository.findAll();

		return list;
		//return usuarios;
	}

	public UsuarioModel create(UsuarioModel usuario){

		usuario.setId( counter );
		usuarios.add(usuario);
		counter++;

		// return "POST Usuários";
		return usuario;
	}

	public UsuarioModel update(int id, UsuarioModel usuarioBody){
		// como achar o usuário a ser alterado?
		for ( int i = 0; i <  usuarios.size(); i++ ){
			if (usuarios.get(i).getId() == id){
				// achamos o usuário a ser alterado
				usuarios.get(i).setNome( usuarioBody.getNome() );
				usuarios.get(i).setEmail( usuarioBody.getEmail() );

				return usuarios.get(i);
			} // if
		}// for

		return null;
	}

	public String delete(int id){
		// FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
		for (int i = 0; i < usuarios.size(); i++){
			// se achar o usuário, então delete do arraylist
			if (usuarios.get(i).getId() == id){
				usuarios.remove(i);
				return "Usuário delatado com sucesso!";
			} // if
		} // for
		return "Usuário não encontrado";
	}

	public UsuarioModel getOne(int id){
		for (int i = 0; i < usuarios.size(); i++){
			if (usuarios.get(i).getId() == id){
				return usuarios.get(i);
			} // if
		} // for
		return null;
	}
}