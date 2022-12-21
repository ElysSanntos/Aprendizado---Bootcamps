package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.medicos.DadosListarMedico;
import med.voll.api.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

@Autowired
private PacienteRepository repository;


@PostMapping
@Transactional
public Paciente cadastrar (@RequestBody @Valid DadosCadastroPaciente dados) {
  return repository.save (new Paciente (dados));
}

@GetMapping
public Page<DadosListarPaciente> listarPacientes(@PageableDefault (sort = {"nome"}) Pageable paginacao){

  return repository.findAllByAtivoTrue(paginacao).map(DadosListarPaciente::new);

}
@PutMapping
@Transactional
public void atualizar(@RequestBody @Valid DadosAtualizarPaciente dados) {
  var paciente = repository.getReferenceById(dados.id());
  paciente.atualizarInformacoes(dados);
}

@DeleteMapping ("/{id}")
@Transactional
public void remover(@PathVariable Long id) {
  var paciente = repository.getReferenceById(id);
  paciente.inativar();
}
}
