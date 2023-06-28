package com.serasa.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.serasa.projeto.modelo.Especialidade;
import com.serasa.projeto.repositorio.RepositEspecialidade;

@Controller
public class EspecialidadeControle {

	@Autowired
	private RepositEspecialidade repositEspecialidade;
	
	@GetMapping
	public List<Especialidade> listar() {
		return repositEspecialidade.findAll();
	}
}
