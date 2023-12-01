package com.atosalves.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passageiro extends Usuario {

	private GerenciadorDePagamento gerenciadorDePagamento;

	// TODO r: APAGAR DEPOIS
	public Passageiro(String nome, LocalDate dataNascimento, String email, String senha) {
		super(nome, dataNascimento, email, senha);
	}

	public Passageiro(){
		this.gerenciadorDePagamento = new GerenciadorDePagamento(0f);
	}

	public void depositar(float valor) {
		gerenciadorDePagamento.depositar(valor);
	}

	public void pagarCorrida(float valor) {
		gerenciadorDePagamento.pagarCorrida(valor);
	}
}
