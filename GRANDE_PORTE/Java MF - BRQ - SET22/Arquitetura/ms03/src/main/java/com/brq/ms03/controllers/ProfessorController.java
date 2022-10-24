package com.brq.ms03.controllers;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ResController
public class ProfessorController {

	@Autowired
	private ProfessorService profService;

	@GetMapping("/professor")
	public List<ProfessorDTO> getAllProfs() {

		profService.mostrarMsgService();

		return profService.getAllProfs();
	}

	@PostMapping("/professor")
	public ProfessorDTO create(@Valid @RequestBody ProfessorDTO professorDTO) {

		return profService.verboPost(professorDTO);
	}

	@PatchMapping("/professor/{id}")
	public ProfessorDTO update(@RequestBody ProfessorDTO professorBody,
	                           @PathVariable int id) {

		return profService.verboUpdate(id, professorBody);
	}

	@DeleteMapping("/professor/{id}")
	public ProfessorDTO getOne(@PathVariable int id) {

		return profService.verboGetOne(id);
	}

}
