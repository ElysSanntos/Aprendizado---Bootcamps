package med.voll.api.medicos;


import jakarta.validation.constraints.NotNull;
import med.voll.api.enderecos.DadosAtualizarEndereco;

public record DadosAtualizarMedico(
  @NotNull
  Long id,
  String telefone,
  String nome,
  DadosAtualizarEndereco endereco) {
}
