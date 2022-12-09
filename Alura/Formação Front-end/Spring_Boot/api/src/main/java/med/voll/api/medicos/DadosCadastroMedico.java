package med.voll.api.medicos;

import med.voll.api.enderecos.DadosEndereco;

public record DadosCadastroMedico(String nome, String crm,
                                  Especialidade especialidade,
                                  DadosEndereco endereco) {
}
