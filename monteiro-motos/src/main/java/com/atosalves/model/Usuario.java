package com.atosalves.model;


import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

	private String nome;
	private LocalDate dataNascimento;

	@Include
	private String email;

	private String senha;

	public Usuario(String nome, LocalDate dataNascimento, String email, String senha) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}


}
