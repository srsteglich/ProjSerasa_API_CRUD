package com.serasa.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serasa.projeto.modelo.Especialidade;

@Repository
public interface RepositEspecialidade extends JpaRepository<Especialidade, Long>  {

}
