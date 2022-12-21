package med.voll.api.controllers;


import jakarta.validation.Valid;
import med.voll.api.medicos.DadosCadastroMedico;
import med.voll.api.medicos.DadosListarMedico;
import med.voll.api.medicos.Medico;
import med.voll.api.medicos.MedicoRepository;
import med.voll.api.pacientes.DadosCadastroPaciente;
import med.voll.api.pacientes.Paciente;
import med.voll.api.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("medicos")
public class MedicoController {

@Autowired
private MedicoRepository repository;

@PostMapping
@Transactional
public Medico cadastrar (@RequestBody @Valid DadosCadastroMedico dados) {

  return repository.save (new Medico (dados));


}

@GetMapping
public Page<DadosListarMedico> listarMedicos(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){

  return repository.findAll(paginacao).map(DadosListarMedico::new);

}

@RestController
@RequestMapping ("pacientes")
public class PacienteController {

  @Autowired
  private PacienteRepository repository;

  @PostMapping
  @Transactional
  public Paciente cadastrar (@RequestBody @Valid DadosCadastroPaciente dados) {
    return repository.save (new Paciente (dados));

  }




}
}
