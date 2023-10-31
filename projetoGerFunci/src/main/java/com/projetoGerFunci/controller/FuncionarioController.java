package com.projetoGerFunci.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerFunci.entities.Funcionario;
import com.projetoGerFunci.service.FuncionarioServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	private final FuncionarioServices funcionarioServices;

	@Autowired
	public FuncionarioController(FuncionarioServices funcionarioServices) {
		this.funcionarioServices = funcionarioServices;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long id){
		Funcionario funcionario = funcionarioServices.buscaFuncionarioId(id);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionarioControl(){
		List<Funcionario> Funcionarios = funcionarioServices.buscaTodosFuncionarios();
		return ResponseEntity.ok(Funcionarios);
	}

	@PostMapping
	public ResponseEntity<Funcionario> salvaFuncionariosControl(@RequestBody @Valid Funcionario funcionario){
		Funcionario salvaFuncionario = funcionarioServices.salvaFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> alteraFuncionarioControlId(@PathVariable Long id,@RequestBody @Valid Funcionario funcionario ){
		Funcionario alteraFuncionario = funcionarioServices.alterarFuncionario(id, funcionario);
		if(alteraFuncionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> apagaFuncionarioControl(@PathVariable Long id){
		boolean apagar = funcionarioServices.apagarFuncionario(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {	
			return ResponseEntity.notFound().build();
		}
	}
}
