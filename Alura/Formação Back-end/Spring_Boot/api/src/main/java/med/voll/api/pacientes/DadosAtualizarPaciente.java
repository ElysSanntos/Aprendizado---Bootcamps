package med.voll.api.pacientes;

import jakarta.validation.Valid;
import med.voll.api.enderecos.DadosAtualizarEndereco;

public record DadosAtualizarPaciente(
    Long id,
    String nome,
    String telefone,
    @Valid DadosAtualizarEndereco endereco
) {
}