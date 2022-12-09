package med.voll.api.controllers;


import med.voll.api.medicos.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

@PostMapping
public void cadastrar(@RequestBody DadosCadastroMedico dados){

  System.out.println (dados);

}

}
