package com.atosalves.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Mototaxista extends Usuario {

	private int avaliacao;

	public Mototaxista(String nome, String sobrenome, LocalDate dataNascimento, String email, String senha, int avaliacao) {
		super(nome, sobrenome, dataNascimento, email, senha);
		this.avaliacao = avaliacao;
	}
}
