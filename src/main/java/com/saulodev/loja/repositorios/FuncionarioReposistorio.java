package com.saulodev.loja.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saulodev.loja.modelos.Funcionario;

public interface FuncionarioReposistorio extends JpaRepository<Funcionario, Long> {
	
}
