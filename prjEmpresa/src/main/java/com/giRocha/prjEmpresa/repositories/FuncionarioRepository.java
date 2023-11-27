package com.giRocha.prjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giRocha.prjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
