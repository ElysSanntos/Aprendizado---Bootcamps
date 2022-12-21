package med.voll.api.medicos;

public record DadosListarMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
  public DadosListarMedico(Medico medico){

    this(medico.getId (),medico.getNome (), medico.getCrm (),medico.getEmail (), medico.getEspecialidade ());
  }
}
