package med.voll.api.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enderecos.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(
        @NotBlank String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank String telefone,
        @NotBlank
        @Pattern (regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
          //("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3-$4")
        String cpf,
        @NotNull @Valid DadosEndereco endereco
) {
}