package med.voll.api.medicos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enderecos.Endereco;




@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)


private Long id;
private String nome;
private String email;
private String telefone;
private String crm;
private boolean ativo;

@Enumerated(EnumType.STRING)
private Especialidade especialidade;

@Embedded
private Endereco endereco;


public Medico (DadosCadastroMedico dados) {
  this.ativo = true;
  this.nome = dados.nome ();
  this.crm = dados.crm ();
  this.email = dados.email ();
  this.telefone = dados.telefone ();
  this.especialidade = dados.especialidade ();
  this.endereco = new Endereco (dados.endereco ());
}

public Medico atualizarInformacoes (DadosAtualizarMedico dados) {

  /*IMPORTANTE: Preciso validar se os campos for diferente de Null,
  para que a variavel não seja atualizada para NULL.*/
  if(dados.nome () !=null) {
    this.nome = dados.nome ();
  }

  if(dados.telefone () !=null) {
    this.telefone = dados.telefone ();
  }

  /*Aqui, temos um objeto, assim precisamos criar um método para atualizar as informações*/
  if(dados.endereco () !=null) {
    this.endereco.atualizarInformacoes(dados.endereco ());
  }
  return null ;
}

public void excluir () {
this.ativo = false;

}

}
