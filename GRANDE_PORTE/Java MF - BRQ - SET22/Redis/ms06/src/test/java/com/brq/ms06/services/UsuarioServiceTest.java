package com.brq.ms06.services;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;

import lombok.experimental.var;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {

	//INSTANCIAR O OBJETO QUE QUEREMOS TESTAR

	@Autowired
	private UsuarioService usuarioService;

	//MOKAR OS OUTROS OBJETOS NECESSÁRIOS PARA O TESTE UNITÁRIO

	@MockBean
	private UsuarioRepository repository;

	@Test
	void getAllTest() {
		// DADO QUE (queremos todos os usuários, não temos variaveis.)

		// QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)


		// ENTÃO (execução do teste: chamar o método a ser testado)

		// VERIFICAR (verificar o resultado do passo anterior)

	}



}
