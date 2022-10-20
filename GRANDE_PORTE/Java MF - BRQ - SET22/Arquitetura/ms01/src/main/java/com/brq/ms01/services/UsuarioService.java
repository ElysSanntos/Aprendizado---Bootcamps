package com.brq.ms01.services;

import com.brq.ms01.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brq.ms01.models.UsuarioModel;
import java.util.List;


import java.util.ArrayList;
import java.util.Optional;

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


	public void mostrarMensagemService() {
		System.out.println("Mensagem do serviço");
	}

	public List<UsuarioModel> getAllUsuarios() {

		/*A repository vai executar : Select * from usuarios;*/
		List<UsuarioModel> list = usuRepository.findAll();

		return list;
		//return usuarios;
	}

	public UsuarioModel create(UsuarioModel usuario) {//POST

		//usuario.setId( counter );
		//usuarios.add(usuario);
		//counter++;


		/*Chamar a camada repository que vai fazer
		INSERT INTO db_curso_java.usuarios(nome_user, email_user)
		VALUES('Tarcisão do Asfalto', 'tda@patriota.com.br')
		* */
		UsuarioModel usuarioSalvo = usuRepository.save(usuario);

		// return "POST Usuários";
		//return usuario;
		return usuarioSalvo;
	}

	public UsuarioModel update(int id, UsuarioModel usuarioBody) {

		//Refatoração mais simples
		/*
		* UsuarioModel usuario = usuRepository.findByOd(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		* meuUsuario.setEmail(usuarioBody.getEmail());
		  meuUsuario.setNome(usuarioBody.getNome());
		  *
		  * return usuRepository.save(usuario);*/

		//Verificar se os dados existem
		Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);

		//Se eu achei o usuario no banco
		if (usuarioOptional.isPresent()) {
			//retorn os valores do usuario encontrado no banco de dados
			UsuarioModel meuUsuario = usuarioOptional.get();

			meuUsuario.setEmail(usuarioBody.getEmail());
			meuUsuario.setNome(usuarioBody.getNome());

			//Dar o update
			UsuarioModel usuarioSalvo = usuRepository.save(meuUsuario);

			return usuarioSalvo;
		}
		//Não achei o usuario no Banco
		//Lambida é um metodo sem nome
		else {
			return usuarioOptional.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		}
		// como achar o usuário a ser alterado?
//		for ( int i = 0; i <  usuarios.size(); i++ ){
//			if (usuarios.get(i).getId() == id){
//				// achamos o usuário a ser alterado
//				usuarios.get(i).setNome( usuarioBody.getNome() );
//				usuarios.get(i).setEmail( usuarioBody.getEmail() );
//
//				return usuarios.get(i);
//			}
//		}
//
//		return null;
	}

	public String delete(int id) {
		// FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
//		for (int i = 0; i < usuarios.size(); i++){
//			// se achar o usuário, então delete do arraylist
//			if (usuarios.get(i).getId() == id){
//				usuarios.remove(i);
//				return "Usuário delatado com sucesso!";
//			} // if
//		} // for
//		return "Usuário não encontrado";

		usuRepository.deleteById(id);
		return "Usuário deletado com sucesso!";
	}

	public UsuarioModel getOne(int id) {

		//Retornando em uma unica linha de código
		/*return usuarioOptional.findbyId(id)
				              .orElseThrow(
									  () -> new RuntimeException("Usuário não localizado"));*/

		Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);

		if (usuarioOptional.isPresent()) {
			UsuarioModel usuarioOne = usuarioOptional.get();

			return usuarioOne;
		}

//		for (int i = 0; i < usuarios.size(); i++){
//			if (usuarios.get(i).getId() == id){
//				return usuarios.get(i);
//			}

		//return null;
		else {
			return usuarioOptional.orElseThrow(() -> new RuntimeException("Usuário não localizado"));
		}
	}
}