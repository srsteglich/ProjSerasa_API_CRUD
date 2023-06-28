package com.serasa.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serasa.projeto.modelo.Clinica;

@Repository
public interface RepositorioClinica extends JpaRepository<Clinica, Long> {

}
