package med.voll.api.pacientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enderecos.Endereco;

@Getter
@EqualsAndHashCode (of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Paciente")
@Table (name = "pacientes")
public class Paciente {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
    }

public void atualizarInformacoes(DadosAtualizarPaciente dados) {
  if (dados.nome() != null)
    this.nome = dados.nome();

  if (dados.telefone() != null)
    this.telefone = dados.telefone();

  if (dados.endereco() != null)
    endereco.atualizarInformacoes(dados.endereco());
}

public void inativar() {
  this.ativo = false;
}

}