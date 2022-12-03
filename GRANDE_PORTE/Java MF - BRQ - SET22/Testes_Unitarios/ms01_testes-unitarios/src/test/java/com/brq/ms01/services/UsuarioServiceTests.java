package com.brq.ms01.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
 class UsuarioServiceTests {

	// Primeiro instanciamos a classe que desejamos testar

	@Autowired // Para injetetar a classe UsuarioService na classe UsuarioServiceTests
	private UsuarioService usuarioService;

	// MOKAR a camada repository

	@MockBean
	private UsuarioRepository usuarioRepository;

	@Test
	void getAllUsuariosTest() {

		// Instanciamos a List Mock da Repository
		List<UsuarioModel> listMock = new ArrayList<>();

		// Agora podemos usar a instancia da camada Model que é utilizada no mock da
		// repository
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setId(1);
		usuarioModel.setNome("Teste");
		usuarioModel.setTelefone("Meu telefone");

		// Vou pegar o objeto que foi mokado e add a list

		listMock.add(usuarioModel);

		/**
		 * Qdo(when) o metodo findAll() da camada repository,
		 * for acionado então(thenReturn) será retornado a listMock
		 **/

		when(usuarioRepository.findAll())
		.thenReturn(listMock);

		// Executar o método de desejo de teste

		List<UsuarioDTO> resultadoAtual = usuarioService.getAllUsuarios();

		/*E agora?
		 * Como eu posso afirmar que o teste estará correto?
		 * Primeiro: Qual o retorno da classe UsuarioService? Uma lista de DTO
		 * */
		//List<UsuarioDTO> resultadoEsperado = new ArrayList<>();


		 assertThat(resultadoAtual.get(0).getNome() )
         .isEqualTo("Teste");
		 assertThat(resultadoAtual.get(0).getTelefone())
         .isEqualTo("Meu telefone");
		 assertThat(resultadoAtual.get(0).getId())
         .isEqualTo(1);
	}
	
	 	@Test
	    void getAllUsuarios2Test(){

	        // o primeiro passo é simular (mockar) os objetos que preciso
	        List<UsuarioModel> listMock = new ArrayList<>();

	        String nome = "Teste";
	        int id = 1;

	        UsuarioModel usuarioModel = new UsuarioModel();
	        usuarioModel.setId(id);
	        usuarioModel.setNome(nome);
	        usuarioModel.setTelefone("Meu telefone");

	        listMock.add(usuarioModel);

	        // quando o metodo findAll() da camada repository for acionado, retorno a lista listMock
	        when ( usuarioRepository.findAll() )
	                .thenReturn( listMock );

	        // executar o método de desejo de teste
	        List<UsuarioDTO> resultadoAtual = usuarioService.getAllUsuarios2();

	        assertThat(resultadoAtual.get(0).getNome() )
	                .isEqualTo(nome + "JAVA");
	        assertThat(resultadoAtual.get(0).getTelefone())
	                .isEqualTo(usuarioModel.getTelefone());
	        assertThat(resultadoAtual.get(0).getId())
	                .isEqualTo(id * 2);

	    }
}
