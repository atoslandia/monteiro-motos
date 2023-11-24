package com.atosalves.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mototaxista extends Usuario {

	private int avaliacao;

	public Mototaxista(String nome, String sobrenome, LocalDate dataNascimento, String email, String senha) {
		super(nome, sobrenome, dataNascimento, email, senha);
		this.avaliacao = 0;
	}
}
