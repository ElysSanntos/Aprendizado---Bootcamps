package med.voll.api.enderecos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarEndereco(
  @NotBlank
  String logradouro,
  @NotBlank
  String bairro,
  @NotBlank
  @Pattern (regexp = "\\d{8}")
  String CEP,
  @NotBlank
  String cidade,
  @NotBlank
  String UF,
  String complemento,
  String numero ) {
}
