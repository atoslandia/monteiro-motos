package com.atosalves.model;

import java.time.LocalDate;

import com.atosalves.enums.TipoUsuario;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Usuario {

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

	@Override
	public String toString() {
		return "Nome: " + nome + "\nEmail: " + email;
	}

	public abstract TipoUsuario getTipo();

}
