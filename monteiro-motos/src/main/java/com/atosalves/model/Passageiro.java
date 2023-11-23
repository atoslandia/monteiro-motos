package com.atosalves.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passageiro extends Usuario {

	private GerenciadorDePagamento gerenciadorDePagamento;

	public Passageiro(String nome, String sobrenome, LocalDate dataNascimento, String email, String senha) {
		super(nome, sobrenome, dataNascimento, email, senha);
		this.gerenciadorDePagamento = new GerenciadorDePagamento(0f);
	}

	public void depositar(float valor) {
		gerenciadorDePagamento.depositar(valor);
	}

	public void pagarCorrida(float valor) {
		gerenciadorDePagamento.pagarCorrida(valor);
	}
}
