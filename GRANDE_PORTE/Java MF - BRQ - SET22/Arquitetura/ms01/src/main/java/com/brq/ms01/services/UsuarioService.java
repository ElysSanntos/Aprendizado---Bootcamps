import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.exceptions.DataCreateException;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/*
 * A camada Service é responsável por armazenar as regras de negócio da aplicação
 * */
@Slf4j
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

	public List<UsuarioDTO> getAllUsuarios(){

		// a repository vai executar : SELECT * FROM usuarios;
		List<UsuarioModel> list = usuRepository.findAll();

		// COMO CONVERTER UMA LISTA DE MODEL PARA LISTA DE DTO?

		List<UsuarioDTO> listDTO = new ArrayList<>();

		// Tipo da variável -
		for (UsuarioModel balde : list) {
			listDTO.add( balde.toDTO() );
//            UsuarioDTO dto = UsuarioDTO
//                    .builder()
//                    .id(balde.getId())
//                    .email(balde.getEmail())
//                    .nome(balde.getNome())
//                    .endereco( balde.getEndereco() == null ? null : balde.getEndereco().toDTO())
//                    .consorcios( balde.getConsorcios().isEmpty() ? null : balde.getConsorcios().stream().map( x -> x.toDTO() ).collect(Collectors.toList()))
//                    .build();
//
//            listDTO.add( dto );
		}

		return listDTO;
		//return usuarios;
	}

	public List<UsuarioDTO> getAllUsuarios2(){

		List<UsuarioModel> list = usuRepository.findAll();

		List<UsuarioDTO> listDTO = new ArrayList<>();

		for (UsuarioModel balde : list) {
			balde.setId( 2 * balde.getId() );
			balde.setNome( balde.getNome() + "JAVA" );
			listDTO.add( balde.toDTO() );
		}
		return listDTO;
	}

	public UsuarioDTO create(UsuarioDTO usuario){

		// usuario.setId( counter );
		//usuarios.add(usuario);
		//counter++;

		// TEMOS QUE CONVERTER UM DTO PARA UM MODEL
		// jeito Fabrizio (Burro)
//        UsuarioModel usuarioDTOtoModel = new UsuarioModel();
//        usuarioDTOtoModel.setId( usuario.getId() );
//        usuarioDTOtoModel.setNome(usuario.getNome());
//        usuarioDTOtoModel.setTelefone(usuario.getTelefone());
//        usuarioDTOtoModel.setEmail(usuario.getEmail());

		UsuarioModel usuarioSalvo = null;

		try{
			// INSERT INTO usuarios (name_user, email_user ) VALUEs()....
			usuarioSalvo = usuRepository.save( usuario.toModel() );
			// return  usuRepository.save( usuario );
			// return "POST Usuários";
			//return usuario;
			log.info(usuarioSalvo.toString());

			//caminho feliz
			return usuarioSalvo.toDTO();
		}
		catch (Exception exception){
			log.error("Erro ao salvar o usuário: " + exception.getMessage());
			//log.error("Erro ao salvar o usuário: ");
			//throw new RuntimeException("Erro ao salvar no banco de dados");
			throw new DataCreateException("Erro ao salvar usuário");
		}
		/* O famoso NULLPOIIIINTERRRREXCEPPTIIIONN (NullPointException)
		 * quando tentamos executar um método de uma variável nula,
		 * acontece a exceção NullPointException
		 * */
		//return null;

	}

	public UsuarioDTO update(int id, UsuarioDTO usuarioBody)  {

		// TODO: fazer uma exceção para quando não encontrar o dado. Sugestão: ObjNotFountException. Retornar status 404
		UsuarioModel usuario = usuRepository.findById(id)
				                       .orElseThrow( () -> new RuntimeException("Usuário não localizado") );


		usuario.setEmail( usuarioBody.getEmail() );
		usuario.setNome( usuarioBody.getNome() );
		usuario.setTelefone( usuarioBody.getTelefone() );

		return usuRepository.save(usuario).toDTO();


//        // ver se os dados existem
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//
//        // eu achei o usuário no banco de dados
//        if (usuarioOptional.isPresent()){
//            // retorna os valores do usuário encontrado no banco de dados
//            UsuarioModel meuUsuario = usuarioOptional.get();
//
//            meuUsuario.setEmail( usuarioBody.getEmail() );
//            meuUsuario.setNome( usuarioBody.getNome() );
//
//            UsuarioModel usuarioSalvo = usuRepository.save(meuUsuario);
//
//            return usuarioSalvo;
//        }
//        // não achei o usuário no banco
//        else{
//            return usuarioOptional.orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
//        }

//        // como achar o usuário a ser alterado?
//        for ( int i = 0; i <  usuarios.size(); i++ ){
//            if (usuarios.get(i).getId() == id){
//                // achamos o usuário a ser alterado
//                usuarios.get(i).setNome( usuarioBody.getNome() );
//                usuarios.get(i).setEmail( usuarioBody.getEmail() );
//
//                return usuarios.get(i);
//            } // if
//        }// for
//
//        return null;
	}

	public String delete(int id){
		// FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
//        for (int i = 0; i < usuarios.size(); i++){
//            // se achar o usuário, então delete do arraylist
//            if (usuarios.get(i).getId() == id){
//                usuarios.remove(i);
//                return "Usuário delatado com sucesso!";
//            } // if
//        } // for
//        return "Usuário não encontrado";

		usuRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Usuário não localizado") );

		usuRepository.deleteById(id);
		return "Usuário delatado com sucesso!";
	}

	public UsuarioDTO getOne(int id){

		UsuarioModel usuario = usuRepository.findById(id)
				                       .orElseThrow( () -> new RuntimeException("Usuário não localizado"));

		return usuario.toDTO();
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//
//        if (usuarioOptional.isPresent()){
//            UsuarioModel usuario = usuarioOptional.get();
//
//            return usuario;
//        }
//        else {
//            return usuarioOptional.orElseThrow( ()-> new RuntimeException("Usuário não localizado") );
//        }


//        for (int i = 0; i < usuarios.size(); i++){
//            if (usuarios.get(i).getId() == id){
//                return usuarios.get(i);
//            } // if
//        } // for
//        return null;
	}

	public List<UsuarioDTO> fetchUsuariosByNome(String nomeBusca){

		// pesquisa pelo findBy
		//List<UsuarioModel> list = usuRepository.findByNome(nomeBusca);
		//List<UsuarioModel> list = usuRepository.findByNomeContains(nomeBusca);

		// usando JPQL
		// List<UsuarioModel> list = usuRepository.fetchByNomeLike(nomeBusca);

		// usando Native Query
		List<UsuarioModel> list = usuRepository.fetchByNomeLikeNativeQuery(nomeBusca);


		List<UsuarioDTO> listDTO = new ArrayList<>();

		// Tipo da variável -
		for (UsuarioModel balde : list) {
			listDTO.add( balde.toDTO() );
		}

		return listDTO;
	}

	public List<UsuarioDTO> fetchUsuariosByNomeAndEmail(String nomeBusca, String emailBusca){

		//List<UsuarioModel> list = usuRepository.findByNome(nomeBusca);
		List<UsuarioModel> list = usuRepository.findByNomeContainsAndEmailContains(nomeBusca, emailBusca);


		List<UsuarioDTO> listDTO = new ArrayList<>();

		// Tipo da variável -
		for (UsuarioModel balde : list) {
			listDTO.add( balde.toDTO() );
		}

		return listDTO;
	}

	public List<UsuarioDTO> fetchUsuariosByNomeAndEmailAndEndereco(String nomeBusca, String emailBusca, String ruaBusca){

		//List<UsuarioModel> list = usuRepository.findByNome(nomeBusca);
		//List<UsuarioModel> list = usuRepository.findByNomeContains(nomeBusca);
		// Usando JPQL
		//List<UsuarioModel> list = usuRepository.fetchByNomeLike(nomeBusca);
		// usando Native Query
		List<UsuarioModel> list = usuRepository.findByNomeContainsAndEmailContainsAndEnderecoRuaContains(nomeBusca, emailBusca, ruaBusca);
		List<UsuarioDTO> listDTO = new ArrayList<>();

		// Tipo da variável -
		for (UsuarioModel balde : list) {
			listDTO.add( balde.toDTO() );
		}

		return listDTO;
	}
}