package com.atosalves.model;

import com.atosalves.model.exceptions.DinheiroInsuficienteExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passageiro extends Usuario {

	private GerenciadorDePagamento gerenciadorDePagamento;

	public Passageiro() {
		this.gerenciadorDePagamento = new GerenciadorDePagamento(0f);
	}

	public void depositar(float valor) {
		gerenciadorDePagamento.depositar(valor);
	}

	public void pagarCorrida(float valor) throws DinheiroInsuficienteExceptions {
		gerenciadorDePagamento.pagarCorrida(valor);
	}
}
