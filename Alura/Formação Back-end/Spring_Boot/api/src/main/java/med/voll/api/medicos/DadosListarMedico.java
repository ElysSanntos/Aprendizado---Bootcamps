package med.voll.api.medicos;

public record DadosListarMedico(String nome, String email, String crm, Especialidade especialidade) {
  public DadosListarMedico(Medico medico){

    this(medico.getNome (), medico.getCrm (),medico.getEmail (), medico.getEspecialidade ());
  }
}
