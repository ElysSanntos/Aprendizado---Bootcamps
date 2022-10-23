package com.brq.ms03.services;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository profRepository;

	public void mostrarMsgService() {
		System.out.println("Mensagem do serviço");
	}

	public List<ProfessorDTO> getAllProfs() {

		List<ProfessorModel> listDeProfessores = profRepository.findAll();
		List<ProfessorDTO> listProfsDTO = new ArrayList<>();

		for (ProfessorModel balde : listDeProfessores) {
			listProfsDTO.add(balde.toDTO());

		}


		return listProfsDTO;
	}

	public ProfessorDTO verboPost(ProfessorDTO cadastraProf) {

		ProfessorModel professorSalvo = profRepository.save(cadastraProf.toModel());
		return professorSalvo.toDTO();

	}

	public ProfessorDTO verboUpdate(int id, ProfessorDTO alteraProfessor) {

		Optional<ProfessorModel> professorOptional = profRepository.findById(id);
		if (professorOptional.isPresent()) {

			ProfessorModel prof = professorOptional.get();
			prof.setCpf(alteraProfessor.getCpf());
			prof.setId(alteraProfessor.getId());
			prof.setNome(alteraProfessor.getNome());
			prof.setSalario(alteraProfessor.getSalario());
			prof.setTelefone(alteraProfessor.getTelefone());

			ProfessorModel professorSalvo = profRepository.save(prof);

			return professorSalvo.toDTO();
		} else {
			return professorOptional
					       .orElseThrow(
							       () -> new RuntimeException("Professor não cadastrado!"))
					       .toDTO();
		}

	}

	public String verboDelete(int id) {
		profRepository.deleteById(id);
		return "Professor deletado com sucesso!";
	}

	public ProfessorDTO verboGetOne(int id) {
		Optional<ProfessorModel> profOptional = profRepository.findById(id);

		if (profOptional.isPresent()) {
			ProfessorModel profOne = profOptional.get();

			return profOne.toDTO();
		} else {
			return profOptional
					       .orElseThrow(
							       () -> new RuntimeException("Professor informado não foi localizado!")
					       ).toDTO();
		}
	}
}


