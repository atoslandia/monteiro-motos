package com.atosalves.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mototaxista extends Usuario {

	private int avaliacao;

	private float lucro;

	public Mototaxista() {}

	public Mototaxista(String nome, LocalDate dataNascimento, String email, String senha) {
		super(nome, dataNascimento, email, senha);
		this.avaliacao = 0;
	}
}
