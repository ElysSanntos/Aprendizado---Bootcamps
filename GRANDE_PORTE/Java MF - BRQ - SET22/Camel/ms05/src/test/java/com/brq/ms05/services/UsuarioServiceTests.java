package com.brq.ms05.services;

import com.brq.ms05.exceptions.NaoAcheiException;
import com.brq.ms05.models.UsuarioModel;
import com.brq.ms05.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsuarioServiceTests {

    // temos que instanciar de fato este objeto pois queremos testar
    @Autowired
    private UsuarioService service;

    @MockBean
    private UsuarioRepository repository;

    @Test
    void getAllTest(){

        // dado que

        // quando
        final var usuarioModel = createUsuarioModelMock();
        final var listModel = Arrays.asList(usuarioModel);
        when(repository.findAll()).thenReturn(listModel);

        // então
        final var response = service.getAll();

        // verificar se está tudo ok

        assertThat(response.get(0).getNome())
                .isEqualTo(listModel.get(0).getNome());
        assertThat(response.get(0).getEmail())
                .isEqualTo(listModel.get(0).getEmail());
    }

    @Test
    void createWhenNameEqualsSAT5Test(){

        // dado que
        String nome = "SAT5";
        String nomeEsperado = "SAT5" + "BRQ";
        String id = "1";
        final var usuarioModelInput = createUsuarioModelMock(id, nome);

        // quando
        final var usuarioModelExpected = createUsuarioModelMock(id, nomeEsperado);
        when(repository.save(usuarioModelExpected)).thenReturn(usuarioModelExpected);

        // então (quando eu testo o método de interesse)
        final var response = service.create(usuarioModelInput);

        // validar resposta
        assertThat(usuarioModelInput.getId()).isEqualTo(usuarioModelExpected.getId());
        assertThat(usuarioModelInput.getNome()).isEqualTo(nomeEsperado);
        assertThat(response.getEmail())
                .isEqualTo(usuarioModelInput.getEmail());
    }

    @Test
    void createWhenNameNotEqualsSAT5Test(){

        // dado que
        String nome = "NotSAT5";
        String id = "1";

        final var usuarioModelInput = createUsuarioModelMock(id, nome);

        // quando
        when(repository.save(usuarioModelInput)).thenReturn(usuarioModelInput);

        // então
        final var response = service.create(usuarioModelInput);

        // validar teste

        assertThat(response.getNome())
                .isEqualTo(usuarioModelInput.getNome());

        assertThat(response.getId())
                .isEqualTo(usuarioModelInput.getId());

        assertThat(response.getEmail())
                .isEqualTo(usuarioModelInput.getEmail());
    }

    @Test
    void updateWhenFindUserTest(){
        // dado que
        String id = "1";
        String nome = "nome";
        String email = "email";
        String nomeExpected = "nome-alterado";
        String emailExpected = "email-alterado";
        final var usuarioModelExpected = createUsuarioModelMock(id, nomeExpected, emailExpected);
        final var usuarioModelInput = createUsuarioModelMock(id, nome, email);

        // quando
        when(repository.findById(id)).thenReturn(Optional.of(usuarioModelInput));
        when(repository.save(usuarioModelExpected)).thenReturn(usuarioModelExpected);

        // então
        final var response = service.update(id, usuarioModelExpected.toDTO());

        // validar o teste
        assertThat(response.getId()).isEqualTo(usuarioModelExpected.getId());
        assertThat(response.getNome()).isEqualTo(usuarioModelExpected.getNome());
        assertThat(response.getEmail()).isEqualTo(usuarioModelExpected.getEmail());

    }

    @Test
    void updateWhenNotFindUserTest(){

        // dado que
        String id = "1";
        String nome = "nome";
        String email = "email";

        final var usuarioModelInput = createUsuarioModelMock(id, nome, email);
        Optional<UsuarioModel> usuarioModelOptional = Optional.empty();

        // quando
        when(repository.findById(id)).thenReturn(usuarioModelOptional);

        // então
        final var dto = usuarioModelInput.toDTO();
        assertThrows( NaoAcheiException.class,
                () ->  service.update(id, dto) );
    }

    @Test
    void deleteWhenFindUserTest(){

        // dado que
        String id = "1";
        String nome = "nome";
        String email = "email";

        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var optional = Optional.of(usuarioModel);

        //quando
        when(repository.findById(id))
                .thenReturn(optional);

        // então
        service.delete(id);

        // verificar teste
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void deleteWhenNotFindUserTest(){
        // dado que
        Optional<UsuarioModel> optional = Optional.empty();
        String id = "1";

        // quando
        when(repository.findById(id)).thenReturn(optional);

        // então e validação
        assertThrows( NaoAcheiException.class, () -> service.delete(id) );
    }

    @Test
    void getOneWhenFindUserTest(){

        // dado que
        String id = "1";
        String nome = "nome";
        String email = "email";
        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var optional = Optional.of(usuarioModel);

        // quando
        when(repository.findById(id)).thenReturn(optional);

        // então

        final var response = service.getOne(id);

        // validar teste
        assertThat(response.getEmail()).isEqualTo(email);
        assertThat(response.getNome()).isEqualTo(nome);
        assertThat(response.getId()).isEqualTo(id);

    }

    @Test
    void getOneWhenNotFindUserTest(){

        // dado que
        Optional<UsuarioModel> optional = Optional.empty();
        String id = "1";

        // quando
        when(repository.findById(id)).thenReturn(optional);

        // então e validação
        assertThrows( NaoAcheiException.class, () -> service.getOne(id) );
    }

    @Test
    void findByNomeTest(){

        String nomeInput = "nome-busca";
        String id = "1";
        String nome = "nome";
        String email = "email";
        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var listModel = Arrays.asList(usuarioModel);

        // quando
        when(repository.findByNomeContains(nomeInput)).thenReturn(listModel);

        // então
        final var response = service.findByNome(nomeInput);

        // validar teste
        assertThat(response.get(0).getId()).isEqualTo(listModel.get(0).getId());
        assertThat(response.get(0).getNome()).isEqualTo(listModel.get(0).getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(listModel.get(0).getEmail());
    }

    @Test
    void findByAllAttrsTest(){
        String input = "busca";
        String id = "1";
        String nome = "nome";
        String email = "email";
        final var usuarioModel = createUsuarioModelMock(id, nome, email);
        final var listModel = Arrays.asList(usuarioModel);

        // quando
        when(repository.findByNomeContainsOrEmailContains(input, input)).thenReturn(listModel);

        // então
        final var response = service.findByAllAttrs(input);

        // validar teste
        assertThat(response.get(0).getId()).isEqualTo(listModel.get(0).getId());
        assertThat(response.get(0).getNome()).isEqualTo(listModel.get(0).getNome());
        assertThat(response.get(0).getEmail()).isEqualTo(listModel.get(0).getEmail());
    }

    private UsuarioModel createUsuarioModelMock(){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNome("nome");
        usuarioModel.setEmail("email");

        return usuarioModel;
    }

    private UsuarioModel createUsuarioModelMock(String id, String nome){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setEmail("email");

        return usuarioModel;
    }

    private UsuarioModel createUsuarioModelMock(String id, String nome, String email){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setEmail(email);

        return usuarioModel;
    }
}
