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





public Endereco (DadosEndereco dados) {

  this.logradouro = dados.logradouro ();
  this.bairro = dados.bairro ();
  this.CEP = dados.CEP ();
  this.complemento = dados.complemento ();
  this.numero = dados.numero ();
  this.UF = dados.UF ();
  this.cidade = dados.cidade ();






}
}
