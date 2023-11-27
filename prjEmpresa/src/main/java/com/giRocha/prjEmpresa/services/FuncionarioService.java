package com.giRocha.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giRocha.prjEmpresa.entities.Funcionario;
import com.giRocha.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	// preparando as buscas por id
	public Funcionario findFuncionarioById(Long funcodigo) {
		Optional<Funcionario> Funcionario = funcionarioRepository.findById(funcodigo);
		return Funcionario.orElse(null);
	}
	
	// preparando a busca geral
	public List<Funcionario> findAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	// salvando o Jogo
	public Funcionario insertFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	// fazendo o update do jogo com o optional
	public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}
	
	// deletando o update do usuario com o optional
	public boolean deleteFuncionario(Long funcodigo) {
		Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(funcodigo);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(funcodigo);
			return true;
		} else {
			return false;
		}
	}
	
}
