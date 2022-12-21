package med.voll.api.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enderecos.DadosAtualizarEndereco;

public record DadosCadastroMedico(

                                  @NotBlank
                                  String nome,
                                  @NotBlank
                                  @Pattern (regexp = "\\d{4,6}")
                                  String crm,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  String telefone,
                                  @NotNull
                                  Especialidade especialidade,
                                  @NotNull
                                  @Valid DadosAtualizarEndereco endereco) {
}
