package com.projetoGerFunci.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String rg;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cargo;
	
	@NotNull
	private double salario;
	
	
	
	

}
