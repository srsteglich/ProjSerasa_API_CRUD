package com.serasa.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.projeto.modelo.Clinica;
import com.serasa.projeto.repositorio.RepositorioClinica;
  
@RestController
public class Controler {
	
	@Autowired
	private RepositorioClinica repositorioClinica;
		    
	@GetMapping("ola")
	@ResponseBody
	public String olaSerasa() {
		return " Olá, Serasa.... Sou Sérgio R. Steglich ";
	}
	
	  
	@GetMapping("clinicas")
	@ResponseBody
	public List<Clinica> listar() {	
		
		return repositorioClinica.findAll();
	}
	
	
//	@PostMapping
//	@ResponseStatus(value = HttpStatus.CREATED)
//	public void adicionar(@RequestBody Clinica clinica) {
//		
//		repositorioClinica.save(clinica);
//	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)	
	public Clinica adicionar(@RequestBody Clinica clinica)   {
		return repositorioClinica.save(clinica);
	}
				  
	@DeleteMapping("/{clinicaId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long clinicaId) {
		repositorioClinica.deleteById(clinicaId);
	}
	
	
	@GetMapping("/{clinicaId}")
	public ResponseEntity<Clinica> buscar(@PathVariable Long clinicaId) {
		
		Optional<Clinica> clinica = repositorioClinica.findById(clinicaId);		
		if (clinica.isPresent()) {
			return ResponseEntity.ok(clinica.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{clinicaId}")
	public ResponseEntity<Clinica> atualizar(@PathVariable Long clinicaId, @RequestBody Clinica clinica) {
		
		Optional<Clinica> clinicaAtual = repositorioClinica.findById(clinicaId);
		if (clinicaAtual.isPresent()) {
			
			// copia os dados da clinica para outra, menos id
			BeanUtils.copyProperties(clinica, clinicaAtual.get(),"id");
			
			Clinica clinicaAtualizada = repositorioClinica.save(clinicaAtual.get());
			return ResponseEntity.ok(clinicaAtualizada);

		}
		return ResponseEntity.notFound().build();
	}
	
}
