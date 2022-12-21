package med.voll.api.enderecos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

private String logradouro;
private String bairro;
private String CEP;
private String complemento;
private String numero;
private String UF;
private String cidade;





public Endereco (DadosAtualizarEndereco dados) {

  this.logradouro = dados.logradouro ();
  this.bairro = dados.bairro ();
  this.CEP = dados.CEP ();
  this.complemento = dados.complemento ();
  this.numero = dados.numero ();
  this.UF = dados.UF ();
  this.cidade = dados.cidade ();


  }



public void atualizarInformacoes(DadosAtualizarEndereco dados) {
  if(dados.logradouro() != null) {
    this.logradouro = dados.logradouro();
  }
  if(dados.bairro() != null) {
    this.bairro = dados.bairro();
  }
  if(dados.CEP () != null) {
    this.CEP = dados.CEP ();
  }
  if(dados.UF() != null) {
    this.UF = dados.UF ();
  }
  if(dados.cidade() != null) {
    this.cidade = dados.cidade();
  }
  if(dados.numero() != null) {
    this.numero = dados.numero();
  }
  if(dados.complemento() != null) {
    this.complemento = dados.complemento();
  }
}
}
